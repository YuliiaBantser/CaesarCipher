public class EncoderDecoderWithKey {
    static StringBuilder encodeFile(String text, int key) {
        StringBuilder result = new StringBuilder();
        for (char character : text.toCharArray()) {
            if (Character.isLetter(character) && Character.isLowerCase(character)) {
                int originalAlphabetPosition = character - 'a';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('a' + newAlphabetPosition);
                result.append(newCharacter);
            } else if (Character.isLetter(character) && Character.isUpperCase(character)) {
                int originalAlphabetPosition = character - 'A';
                int newAlphabetPosition = (originalAlphabetPosition + key) % 26;
                char newCharacter = (char) ('A' + newAlphabetPosition);
                result.append(newCharacter);
            } else {
                result.append(character);
            }
        }
        return new StringBuilder(result);
    }

    public static StringBuilder decodeFile(String text, int key) {
        return encodeFile(text, 26 - key % 26);
    }
}
