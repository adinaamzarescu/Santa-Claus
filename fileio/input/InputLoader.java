package fileio.input;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public final class InputLoader {
    /**
     * json path
     */
    private final String inputPath;

    /**
     * Constructor
     * @param inputPath inputPath
     */
    public InputLoader(final String inputPath) {
        this.inputPath = inputPath;
    }

    /**
     * read InputData Object from json file
     *
     * @return InputData object
     */
    public InputData readData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.readValue(new File(inputPath), InputData.class);
        } catch (IOException e) {
            System.out.println("Error parsing file - " + e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
}
