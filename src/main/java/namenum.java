import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class namenum {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("namenum.in"));
        String cowId = scanner.nextLine();

        PrintWriter out = new PrintWriter(new BufferedWriter(new FileWriter("namenumdict.out")));
        scanner = new Scanner(new File("namenumdict.txt"));
        boolean matchedExisting = false;
        while (scanner.hasNext()) {
            String word = scanner.nextLine();
            if(isMatched(word, cowId)) {
                matchedExisting = true;
                out.println(word);
            }
        }
        if (!matchedExisting) {
            out.println("NONE");
        }
        out.flush();
    }
    private static char[] MAPPINGS = {
            '2', '2', '2', '3', '3', '3','4', '4', '4','5', '5', '5',
            '6', '6', '6', '7', '0', '7', '7','8', '8', '8','9', '9', '9', '0'
    };
    public static boolean isMatched(String word, String cowId) {
        if(word == null || cowId == null){
            throw new IllegalArgumentException("Please enter a valid number");
        }
        if (word.length() != cowId.length()) {
            return false;
        }
        boolean matched = true;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            char converted = MAPPINGS[c - 'A'];
            if (cowId.charAt(i) != converted) {
                return false;
            }
        }
        return true;
    }
}
