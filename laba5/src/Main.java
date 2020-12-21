import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your word: ");
        String s = sc.nextLine();
        System.out.println("Enter the offset");
        String wordToEncode = s.toLowerCase();
        int offset = sc.nextInt();
        offset %= 26;

        StringBuilder encodedWord = new StringBuilder();

        for (int i = 0; i < wordToEncode.length(); i++) {
            char baseChar = wordToEncode.charAt(i);
            if (Character.isLetter(baseChar)) {
                baseChar += offset;
                if (baseChar > 122) {
                    baseChar -= 26;
                }
            }
            encodedWord.append(baseChar);
        }
        System.out.println("Encoded string is ---> " + encodedWord.toString());

        System.out.print("\nDecoded string is ---> ");
        for (int i = 0; i < encodedWord.length(); i++) {
            char[] encodedSymbols = encodedWord.toString().toCharArray();
            char decodedLetter = (encodedSymbols[i]);
            if (Character.isLetter(decodedLetter)) {
                decodedLetter -= offset;
                if (decodedLetter < 98) {
                    decodedLetter += 26;
                }
            }
            System.out.print(decodedLetter);
        }


        System.out.println("\n\n\n Get a decoded string:");
        for (int i = 0; i < 26; i++) {
            StringBuilder decodedWord = new StringBuilder();

            char[] encodedSymbols = encodedWord.toString().toCharArray();
            for (int j = 0; j < encodedSymbols.length; j++) {
                char decodedLetter = (encodedSymbols[j]);
                if (Character.isLetter(decodedLetter)) {
                    decodedLetter -= i;
                    if (decodedLetter < 98) {
                        decodedLetter += 26;
                    }
                }
                decodedWord.append(decodedLetter);
            }
            System.out.println((i) + ": " + decodedWord.toString());
        }
    }
}
