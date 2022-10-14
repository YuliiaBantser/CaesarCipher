import java.nio.file.Path;

public class Main {
    static final String ENCODE = "encode";
    static final String DECODE = "decode";
    static final String BRUTEFORCE = "bruteForce";

    public static void main(String[] args) {

        if (args[0].equalsIgnoreCase(ENCODE)) {
            int key = Integer.parseInt(args[2]);
            ReaderWriter.encodeFile(String.valueOf(Path.of(args[1])), key);
        }
        if (args[0].equalsIgnoreCase(DECODE)) {
            int key = Integer.parseInt(args[2]);
            ReaderWriter.decodeFile(String.valueOf(Path.of(args[1])), key);
        }
        if (args[0].equalsIgnoreCase(BRUTEFORCE)) {
            ReaderWriter.decodeFileWithAnalyzer(String.valueOf(Path.of(args[1])));
        }
    }
}
