public class Utils {

    public static final String ENGLISH_ALPHABET = "abcdefghijklmnopqrstuvwxyz";
    public static final String RUSSIAN_ALPHABET = "абвгдеёжзийклмнопрстуфхцчшщъыьэюя";
    public static final int RUSSIAN_COUNT = 33;
    public static final int ENGLISH_COUNT = 26;

    public static String cleanTextEng(String text) {
        if (text != null) {
            StringBuilder result = new StringBuilder();
            text = text.toLowerCase();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (ENGLISH_ALPHABET.indexOf(c) != -1) {
                    result.append(c);
                }
            }
            return result.toString();
        } else
            return "";
    }

    public static String cleanTextRus(String text) {
        if (text != null) {
            StringBuilder result = new StringBuilder();
            text = text.toLowerCase();
            for (int i = 0; i < text.length(); i++) {
                char c = text.charAt(i);
                if (RUSSIAN_ALPHABET.indexOf(c) != -1) {
                    result.append(c);
                }
            }
            return result.toString();
        } else
            return "";
    }
}
