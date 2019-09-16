import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class FileIOController {

    private static FileReader inReader, outReader;
    private static FileWriter inWriter, outWriter;

    private static Scanner inScanner, outScanner;

    private static String inPath, outPath;

    public static void initialize(String in, String out) {
        inPath = in;
        outPath = out;
    }

    public static String readInput() throws IOException {
        try {
            inReader = new FileReader(inPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (inReader != null) {
            inScanner = new Scanner(inReader);
        }
        StringBuilder text = new StringBuilder();
        while (inScanner.hasNextLine()) {
            text.append(inScanner.nextLine());
            text.append("\n");
        }
        inReader.close();
        return text.toString();
    }

    public static String readOutput() throws IOException {
        try {
            outReader = new FileReader(outPath);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        if (outReader != null) {
            outScanner = new Scanner(outReader);
        }
        StringBuilder text = new StringBuilder();
        while (outScanner.hasNextLine()) {
            text.append(outScanner.nextLine());
            text.append("\n");
        }
        outReader.close();
        return text.toString();
    }

    public static void writeInput(String text) throws IOException {
        try {
            inWriter = new FileWriter(inPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (text != null) {
            inWriter.write(text);
        }
        inWriter.close();
    }

    public static void writeOutput(String text) throws IOException {
        try {
            outWriter = new FileWriter(outPath);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if (text != null) {
            outWriter.write(text);
        }
        outWriter.close();
    }
}
