package uy.edu.um.CsvReader;

import java.io.*;
import java.nio.file.Paths;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class bufferReader {
    public static String preprocessCSV(String originalCSVFile) throws IOException {
        String fileName = Paths.get(originalCSVFile).getFileName().toString();
        String processedCSVFile = "CSV/processed_" + fileName;

        Pattern pattern = Pattern.compile("\"([^\"]*)\"");

        try (BufferedReader br = new BufferedReader(new FileReader(originalCSVFile));
             BufferedWriter bw = new BufferedWriter(new FileWriter(processedCSVFile))) {

            String line;
            boolean isFirstLine = true;
            while ((line = br.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (group.contains(";")) {
                        line = line.replace(group, group.replace(";", "<SEMICOLON>"));
                    }
                    if (group.contains("\"\"")) {
                        line = line.replace(group, group.replace("\"\"", "<DOUBLE_QUOTES>"));
                    }
                }
                // Remove the double quotes around each field in the header
                if (isFirstLine) {
                    line = line.replace("\"", "");
                    isFirstLine = false;
                }
                bw.write(line);
                bw.newLine();
            }
        }

        return processedCSVFile;
    }
}