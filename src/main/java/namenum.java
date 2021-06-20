import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class namenum {

    public static void main(String[] args) throws IOException {
        Scanner scanner = new Scanner(new File("namenum.in"));
        String cowId = scanner.nextLine();

        List<String> words = Files.readAllLines(Path.of("namenumdict.txt"));
        List<String> result = findMatched(cowId, words);
        File file = new File("namenum.out");
        PrintWriter out = new PrintWriter("namenum.out");
        if(result.isEmpty()) {
            out.println("None");
        }
        for(String s : result) {
            out.println(s);
        }
        out.flush();
    }
    private static char[] MAPPINGS = {
            '2', '2', '2', '3', '3', '3','4', '4', '4','5', '5', '5',
            '6', '6', '6', '7', '0', '7', '7','8', '8', '8','9', '9', '9', '0'
    };
    private static List<String> findMatched(String cowId, List<String> words) {
        List<String> result = new ArrayList<>();
        char[] chars = cowId.toCharArray();
        for (String word : words) {
            if (word.length() != cowId.length()) {
                continue;
            }
            boolean matched = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                char converted = MAPPINGS[c - 'A'];
                if (chars[i] != converted) {
                    matched = false;
                    break;
                }
            }
            if(matched) {
                result.add(word);
            }
        }
        return result;
    }
}
