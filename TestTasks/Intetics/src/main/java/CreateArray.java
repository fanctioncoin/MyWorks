
import java.util.Locale;

public class CreateArray {
    private int count = 0;
    private int res = 0;

    public char[][] fillTheArray(String word1) {
//        String newWord1 = squaringWord1(word1);  //размытое условие на случай если слово нужно возводить в квадрат для образования квадратной матрицы
        int lengthWord1=(int)Math.sqrt(word1.length()); // условие на случай, если слово пришло уже в квадрате
        char[][] array = new char[lengthWord1][lengthWord1];
        for (int i = 0; i < lengthWord1; i++) {
            for (int j = 0; j < lengthWord1; j++) {
                array[i][j] = word1.toUpperCase(Locale.ROOT).charAt(count);
                count++;
            }
        }
        return array;
    }

    public void printArray(char[][] array) {
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                System.out.print(" [" + array[i][j] + "] ");
            }
            System.out.println();
        }
    }
//    private String squaringWord1(String word1) {
//        StringBuffer sb = new StringBuffer();
//        while (res < word1.length()) {
//            String s = sb.append(word1).toString();
//            res++;
//        }
//        return sb.toString();
//    }
}