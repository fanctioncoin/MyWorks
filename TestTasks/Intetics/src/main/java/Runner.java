import java.util.Scanner;

public class Runner {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.println("write word1 in 2^ :");
        String word1 =scanner.nextLine();
        System.out.println("write word2:");
        String word2 =scanner.nextLine();

          CreateArray createArray = new CreateArray();
          char[][] arrayWord1 = createArray.fillTheArray(word1);
          createArray.printArray(arrayWord1);
          SimileWords simileWords = new SimileWords();
          simileWords.matchSearch(arrayWord1,word2);



    }
}
