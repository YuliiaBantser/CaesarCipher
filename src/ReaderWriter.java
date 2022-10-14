import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ReaderWriter {
    private static final String TXT = ".txt";

    public static String readText(String filePath) {
        String text;
        try {
            text = String.join("\n", Files.readAllLines(Path.of(String.valueOf(filePath))));
        } catch (IOException e) {
            System.out.println("Problems with reading the file.");
            throw new RuntimeException(e);
        }
        return text;
    }

    public static void writeText(String filePath, String text) {
        try {
            Files.writeString(Path.of(filePath), text);
            System.out.println("Done.");
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            throw new RuntimeException(e);
        }
    }

    public static String addSuffixToFileName(String fileName, String suffix) {
        return fileName.substring(0, fileName.lastIndexOf(TXT)) + suffix + TXT;
    }

    public static void encodeFile(String filePath, int key) {
        String text = readText(filePath);
        Path outFilePath = Paths.get(addSuffixToFileName(filePath, "_encoded"), "");
        String encodedText = String.valueOf(EncoderDecoderWithKey.encodeFile(text, key));
        writeText(String.valueOf(outFilePath), encodedText);
    }

    public static void decodeFile(String filePath, int key) {
        String text = readText(filePath);
        Path outFilePath = Paths.get(addSuffixToFileName(filePath, "_decoded"), "");
        String decodedText = String.valueOf(EncoderDecoderWithKey.decodeFile(text, key));
        writeText(String.valueOf(outFilePath), decodedText);
    }

    public static void decodeFileWithAnalyzer(String filePath) {
        String text = readText(filePath);
        String decodedText = String.valueOf(StatisticalAnalyzer.bruteForce(text));
        Path outFilePath = Paths.get(addSuffixToFileName(filePath, "_decoded"), "");
        writeText(String.valueOf(outFilePath), decodedText);
    }
}
