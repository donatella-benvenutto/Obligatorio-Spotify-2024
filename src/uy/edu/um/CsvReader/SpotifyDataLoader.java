package uy.edu.um.CsvReader;
import com.opencsv.CSVReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import uy.edu.um.adt.linkedlist.*;
import java.util.function.Consumer;
public class SpotifyDataLoader {
    public void processCsvInChunks(String csvFilePath, int chunkSize, Consumer<List<Song>> chunkProcessor) {
        try (CSVReader reader = new CSVReader(new FileReader(csvFilePath))) {
            String[] nextLine;
            List<Song> chunk = new ArrayList<>();

            while ((nextLine = reader.readNext()) != null) {
                Song song = new Song(nextLine);
                chunk.add(song);

                if (chunk.size() >= chunkSize) {
                    chunkProcessor.accept(chunk);
                    chunk.clear();
                }
            }

            if (!chunk.isEmpty()) {
                chunkProcessor.accept(chunk);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
