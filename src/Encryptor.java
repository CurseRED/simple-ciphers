import java.util.ArrayList;

public class Encryptor {

    private static final int[][] HOLES = {{0, 0}, {1, 3}, {2, 2}, {3, 1}, {0, 3}, {1, 0}, {2, 1},
            {3, 2}, {0, 2}, {1, 1}, {2, 0}, {3, 3}, {0, 1}, {1, 2}, {2, 3}, {3, 0}};
    private static final int N = 4;

    public static String columnEncrypt(String text, String key) {
        if (!key.isEmpty() && !text.isEmpty()) {
            StringBuilder result = new StringBuilder();
            for (int i = 0; i < Utils.ENGLISH_COUNT; i++) {
                if (key.indexOf(Utils.ENGLISH_ALPHABET.charAt(i)) >= 0) {
                    for (int j = 0; j < key.length(); j++) {
                        if (key.charAt(j) == Utils.ENGLISH_ALPHABET.charAt(i)) {
                            int k = 0;
                            while (k * key.length() + j < text.length()) {
                                result.append(text.charAt(k * key.length() + j));
                                k++;
                            }
                        }
                    }
                }
            }
            return result.toString();
        } else
            return "";
    }

    public static String columnDecrypt(String text, String key) {
        if (!key.isEmpty() && !text.isEmpty()) {
            if (key.length() > text.length()) {
                key = key.substring(text.length());
            }
            StringBuilder result = new StringBuilder();
            ArrayList<Integer> sizes = new ArrayList<>();
            int[] numbers = new int[key.length()];
            int k = 0;
            for (int i = 0; i < Utils.ENGLISH_COUNT; i++) {
                if (key.indexOf(Utils.ENGLISH_ALPHABET.charAt(i)) >= 0) {
                    for (int j = 0; j < key.length(); j++) {
                        if (key.charAt(j) == Utils.ENGLISH_ALPHABET.charAt(i)) {
                            numbers[j] = k;
                            k++;
                            int ost = text.length() / key.length();
                            if (j < text.length() % key.length()) {
                                ost++;
                            }
                            sizes.add(ost);
                        }
                    }
                }
            }
            ArrayList<String> strings = new ArrayList<>();
            int i = 0;
            for (int j = 0; j < sizes.size(); j++) {
                strings.add(text.substring(i, i + sizes.get(j)));
                i += sizes.get(j);
            }
            i = 0;
            while (i < text.length()) {
                result.append(strings.get(numbers[i % key.length()]).charAt(i / key.length()));
                i++;
            }
            return result.toString();
        } else
            return "";
    }

    public static String customGridEncrypt(String text) {
        if (!text.isEmpty()) {
            StringBuilder result = new StringBuilder();
            char[][] grid = new char[N][N];
            int i = 0;
            while (i < text.length()) {
                int j = 0;
                while (j < 16 && i < text.length()) {
                    grid[HOLES[i % 16][0]][HOLES[i % 16][1]] = text.charAt(i);
                    j++;
                    i++;
                }
                for (int k = 0; k < grid.length; k++) {
                    for (int p = 0; p < grid.length; p++) {
                        if (grid[k][p] != 0) {
                            result.append(grid[k][p]);
                            grid[k][p] = 0;
                        }
                    }
                }
            }
            return result.toString();
        } else
            return "";
    }

    public static String customGridDecrypt(String text) {
        if (!text.isEmpty()) {
            StringBuilder result = new StringBuilder();
            char[][] grid = new char[N][N];
            int i = 0;
            while (i < text.length()) {
                if (i + 16 <= text.length()) {
                    for (int k = 0; k < N; k++) {
                        for (int p = 0; p < N; p++) {
                            grid[k][p] = text.charAt(i);
                            i++;
                        }
                    }
                    for (int j = 0; j < 16; j++) {
                        result.append(grid[HOLES[j % 16][0]][HOLES[j % 16][1]]);
                    }
                } else {
                    for (int j = 0; j < text.length() - i; j++) {
                        grid[HOLES[j][0]][HOLES[j][1]] = 1;
                    }
                    int j = text.length() - i;
                    for (int k = 0; k < grid.length; k++) {
                        for (int p = 0; p < grid.length; p++) {
                            if (grid[k][p] == 1) {
                                grid[k][p] = text.charAt(i);
                                i++;
                            }
                        }
                    }
                    for (int k = 0; k < j; k++) {
                        result.append(grid[HOLES[k % 16][0]][HOLES[k % 16][1]]);
                    }
                }
            }
            return result.toString();
        } else
            return "";
    }

    private static String generateKey(String text, String key) {
        StringBuilder result = new StringBuilder();
        result.append(key);
        if (text.length() > key.length()) {
            result.append(text.subSequence(0, text.length() - key.length()));
        } else {
            result.append(key.substring(text.length()));
        }
        return result.toString();
    }

    private static int getAlphabetIndex(char c) {
        return Utils.RUSSIAN_ALPHABET.indexOf(c);
    }

    public static String visenerEncrypt(String text, String key) {
        if (!key.isEmpty() && !text.isEmpty()) {
            StringBuilder result = new StringBuilder();
            String generatedKey = generateKey(text, key);
            for (int i = 0; i < text.length(); i++) {
                char a = text.charAt(i);
                char k = generatedKey.charAt(i);
                int r = (getAlphabetIndex(a) + getAlphabetIndex(k)) % Utils.RUSSIAN_ALPHABET.length();
                result.append(Utils.RUSSIAN_ALPHABET.charAt(r));
            }
            return result.toString();
        }
        return "";
    }

    public static String visenerDecrypt(String text, String key) {
        if (!key.isEmpty() && !text.isEmpty()) {
            StringBuilder result = new StringBuilder();
            StringBuilder generatedKey = new StringBuilder(key);
            for (int i = 0; i < text.length(); i++) {
                char a = text.charAt(i);
                char k = generatedKey.charAt(i);
                int r = (getAlphabetIndex(a) - getAlphabetIndex(k) + Utils.RUSSIAN_COUNT) % Utils.RUSSIAN_COUNT;
                generatedKey.append(Utils.RUSSIAN_ALPHABET.charAt(r));
                result.append(Utils.RUSSIAN_ALPHABET.charAt(r));
            }
            return result.toString();
        } else
            return "";
    }
}