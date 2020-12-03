package code;

import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.stream.Stream;

public class Main {

    public static final File CODE_DIR = new File("src\\code");
    public static final File PARENT_DIR = CODE_DIR.getParentFile();
    public static final File INPUT_FILE = new File(PARENT_DIR, "input\\input.txt");
    public static final File TEST_FILE = new File(PARENT_DIR, "input\\test.txt");
    public static final File OUTPUT_FILE = new File(PARENT_DIR, "output\\output.txt");

    public static void main(String[] args) {
        StringBuilder readSb = new StringBuilder();
        try (Stream<String> stream = Files.lines( Paths.get(INPUT_FILE.getAbsolutePath()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> readSb.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        String srcCode = readSb.toString();
        readSb.setLength(0);
        try (Stream<String> stream = Files.lines( Paths.get(TEST_FILE.getAbsolutePath()), StandardCharsets.UTF_8)) {
            stream.forEach(s -> readSb.append(s).append("\n"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        String testStr = readSb.toString();

        LexicalAnalyzer lexicalAnalyzer = new LexicalAnalyzer();
        ArrayList<Token> tokenList = lexicalAnalyzer.process(srcCode);
        ArrayList<String> delimiterList = lexicalAnalyzer.getDelimiterList();
        StringBuilder outputSb = new StringBuilder();
        for (int i = 0; i < tokenList.size(); i++) {
            outputSb.append(tokenList.get(i).tokenType);
            if (i < delimiterList.size())
                outputSb.append(delimiterList.get(i));
        }

        Path outputPath = OUTPUT_FILE.toPath();
        try (BufferedWriter writer = Files.newBufferedWriter(outputPath, StandardCharsets.UTF_8)) {
            writer.write(outputSb.toString());
        } catch(IOException ex){
            ex.printStackTrace();
        }

        /*
        String outputStr = outputSb.toString();
        for (int i = 0; i < outputStr.length(); i++) {
            System.out.println("EQUAL at " + i + ": " + (outputStr.charAt(i) == testStr.charAt(i)));
        }
        System.out.println("INPUT:\n" + srcCode);
        System.out.println("OUTPUT:\n" + outputSb.toString() + "\n");
        System.out.println("CORRECT:\n" + testStr + "\n");
        */
    }
}
