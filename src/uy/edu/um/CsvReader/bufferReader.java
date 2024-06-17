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
            while ((line = br.readLine()) != null) {
                // Replace all occurrences of (;;) at the end of a row with a comma (;)
                if (line.endsWith(";;")) {
                    line = line.substring(0, line.length() - 3) + ";";
                }

                Matcher matcher = pattern.matcher(line);
                StringBuilder newLine = new StringBuilder();
                int lastMatchEnd = 0;

                while (matcher.find()) {
                    String group = matcher.group(1);
                    if (group.contains(";;")) {
                        group = group.replace(";;", ";");
                    }
                    if (group.contains(",")) {
                        group = group.replace("\",\"", ",");
                    }

                    // Append the text between matches to newLine
                    newLine.append(line, lastMatchEnd, matcher.start());
                    // Append the modified group to newLine
                    newLine.append("\"").append(group).append("\"");

                    lastMatchEnd = matcher.end();
                }

                // Append any remaining part of the line after the last match
                newLine.append(line.substring(lastMatchEnd));

                // Replace all occurrences of ("\",\"") with (",") unless it is the first column
                String[] columns = newLine.toString().split("\",\"");
                newLine = new StringBuilder();
                if (!columns[1].startsWith("\"")) {
                    columns[0] = columns[0].concat(columns[1]);
                    for (int i = 1; i < columns.length-1; i++){
                        columns[i] = columns[i+1];
                    }
                    columns[columns.length]=null;
                }
                for (int i = 0; i < columns.length; i++) {
                    if (i > 0 && i < columns.length - 1) {
                        columns[i] = columns[i].replace(",", "&");
                        columns[i] = columns[i].replace(";", "&&");
                        columns[i] = columns[i].replace("\"", "");
                    } else if (i == 0) {
                        columns[0] = columns[0].replace(",\"", "\",");
                        columns[0] = columns[0].replace(";", "&&");
                        columns[0] = columns[0].replace("\"\"", "\"");
                        columns[0] = columns[0].substring(0, columns[0].length() - 1);
                        while(columns[0].replace(",\"","").contains(",")) {
                            columns[0] = columns[0]
                                    .substring(0, columns[0].lastIndexOf(","))
                                    .concat("&")
                                    .concat(columns[0].substring(columns[0].lastIndexOf(",") + 1, columns[0].length()));
                        }
                    } else if (i == columns.length - 1) {
                        columns[i] = columns[i].replace("\"", "");
                        columns[i] = columns[i].replace(";", "");
                        columns[i] = columns[i].concat("\"");
                        columns[i] = columns[i].concat(";");
                    }
                    newLine.append(columns[i]);
                    if (i < columns.length - 1) {
                        newLine.append("\",\"");
                    }
                }
                bw.write(newLine.toString());
                bw.newLine();
            }
        }

        return processedCSVFile;
    }
}