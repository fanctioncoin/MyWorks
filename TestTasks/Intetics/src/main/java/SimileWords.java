import java.util.Locale;

public class SimileWords {
    private boolean isAlive = false;
    private int countWord2 = 0;


    public void matchSearch(char[][] array, String word2) {
        char[] arrayWord2 = word2.toUpperCase(Locale.ROOT).toCharArray();
        while (countWord2 < word2.length()) {
            for (int i = 0; i < array.length; i++) {
                if (isAlive) {
                    break;
                }
                for (int j = 0; j < array[0].length; j++) {
                    if ((arrayWord2[countWord2]) == (array[i][j])) {
                        System.out.print("[" + i + "," + j + "]-> ");
                        isAlive = true;
                        break;
                    }
                }
            }
            countWord2++;
            isAlive = false;
        }
    }
}
