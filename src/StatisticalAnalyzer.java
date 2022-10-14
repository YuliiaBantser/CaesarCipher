public class StatisticalAnalyzer {
    static final String ALPHABET = "abcdefghijklmnopqrstuvwxyz";

    public static int[] countLetters(String text) {
        int[] letters = new int[ALPHABET.length()];
        for (int i = 0; i < text.length(); i++) {
            char character = Character.toLowerCase(text.charAt(i));
            int index = ALPHABET.indexOf(character);
            if (index != -1) {
                letters[index]++;
            }
        }
        return letters;
    }

    public static StringBuilder bruteForce(String text) {
        double[] englishLettersProbabilities = {0.073, 0.009, 0.030, 0.044, 0.130, 0.028, 0.016, 0.035, 0.074,
                0.002, 0.003, 0.035, 0.025, 0.078, 0.074, 0.027, 0.003,
                0.077, 0.063, 0.093, 0.027, 0.013, 0.016, 0.005, 0.019, 0.001};
        String[] lettersInText = new String[ALPHABET.length()];
        double[] resultLetters = new double[ALPHABET.length()];
        for (int i = 1; i <= 26; i++) {
            String resultString = String.valueOf(EncoderDecoderWithKey.decodeFile(text, i));
            lettersInText[i - 1] = resultString;
            int[] textProbabilities = countLetters(resultString);
            double[] countedResults = new double[ALPHABET.length()];
            for (int j = 0; j < 26; j++) {
                double x = textProbabilities[j];
                double y = englishLettersProbabilities[j];
                countedResults[j] = Math.abs(x - y) / y;
            }
            for (int k = 0; k < 26; k++) {
                resultLetters[i - 1] += countedResults[k];
            }
        }
        double currentValueOfLetter = resultLetters[0];
        int key = 0;
        for (int z = 0; z < 26; z++) {
            if (currentValueOfLetter > resultLetters[z]) {
                currentValueOfLetter = resultLetters[z];
                key = z;
            }
        }
        System.out.println("The key is: " + (key + 1));
        return new StringBuilder(lettersInText[key]);
    }
}