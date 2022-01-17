package fileio.output;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;

import java.io.File;
import java.io.IOException;

public final class OutputLoader {

    private final String outputPath;
    private final OutputData outputData;

    /**
     * Constructor
     * @param outputPath output path
     * @param outputData output data
     */
    public OutputLoader(final String outputPath, final OutputData outputData) {
        this.outputPath = outputPath;
        this.outputData = outputData;
    }

    /**
     * Method to write data
     */
    public void writeData() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            ObjectWriter objectWriter = objectMapper.writerWithDefaultPrettyPrinter();
            objectWriter.writeValue(new File(outputPath), outputData);
        } catch (IOException e) {
            System.out.println("Could not create output file" + e.getMessage());
            e.printStackTrace();
        }
    }
}
