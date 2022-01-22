package main;

import checker.Checker;
import common.Constants;
import fileio.input.InputData;
import fileio.input.InputLoader;
import fileio.output.ChildList;
import fileio.output.OutputData;
import fileio.output.OutputLoader;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

/**
 * Class used to run the code
 */
public final class Main {

    private Main() {
        // Constructor
    }
    /**
     * This method is used to call the checker which calculates the score
     *
     * @param args the arguments used to call the main method
     */
    public static void main(final String[] args) throws IOException {

        File inputDirectory = new File(Constants.TESTS_PATH);
        File outputDirectory = new File(Constants.RESULT_PATH);
        Path resultPath = Paths.get(Constants.RESULT_PATH);

        delete(outputDirectory.listFiles());

        if (!Files.exists(resultPath)) {
            Files.createDirectories(resultPath);
        }

        delete(outputDirectory.listFiles());
        for (File file : Objects.requireNonNull(inputDirectory.listFiles())) {
            String filepath = Constants.OUTPUT_PATH + file.getName().substring(Constants.FOUR);
            File out = new File(filepath);
            boolean isCreated = out.createNewFile();
            if (isCreated) {
                game(file.getAbsolutePath(), filepath);
            }
        }

        Checker.calculateScore();
    }

    /**
     * Method to start the simulation
     * @param filePath1 input file path
     * @param filePath2 output file path
     * @throws IOException IO Exception
     */
    public static void game(final String filePath1, final String filePath2) throws IOException {

        InputLoader inputLoader = new InputLoader(filePath1);
        InputData inputData = inputLoader.readData();

        Simulation simulate = new Simulation(inputData);
        simulate.allRounds();

        List<ChildList> childrenList = simulate.getListOfSimulations();

        OutputData outputData = new OutputData(childrenList);
        OutputLoader outputLoader = new OutputLoader(filePath2, outputData);
        outputLoader.writeData();

    }

    /**
     * Method to delete files in out directory
     * @param directory directory path
     */
    public static void delete(final File[] directory) {
        if (directory != null) {
            for (File file : directory) {
                if (!file.delete()) {
                    System.out.println("Didn't delete");
                }
            }
        }
    }
}
