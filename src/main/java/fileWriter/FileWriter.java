package fileWriter;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;

/**
 *
 * @author aysenurdeniz
 */
public class FileWriter {

    public FileWriter() {
    }

    public void file_print(String response, String fileName) {
        try {
            File file = new File(fileName);
            if (!file.exists()) {
                file.createNewFile();
            }
            java.io.FileWriter fileWriter = new java.io.FileWriter(file, false);
            BufferedWriter bWriter = new BufferedWriter(fileWriter);
            bWriter.write(response);
            bWriter.close();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}
