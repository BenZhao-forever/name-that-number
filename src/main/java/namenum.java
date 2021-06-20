import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.util.Scanner;
public class namenum {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("namenum.in"));
        String cowId = scanner.nextLine();

        List<String> words = Files.readAllLines(Path.of("namenumdict.txt"));
        List<String> result = new ArrayList<>();
        char[] chars = cawId.toCharArray();
        for (String word : words) {
            if (word.length() != cowId.length()) {
                continue;
            }
            boolean matched = true;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                char converted = '0';
                if(c == 'A' || c == 'B' || c == 'C') {
                    converted = '2';
                }else if (c == 'D' || c == 'E' || c == 'F') {
                    converted = '3';
                }else if (c == 'G' || c == 'H' || c == 'I') {
                    converted = '4';
                }else if (c == 'J' || c == 'K' || c == 'L') {
                    converted = '5';
                }else if (c == 'M' || c == 'N' || c == 'O') {
                    converted = '6';
                }else if (c == 'P' || c == 'R' || c == 'S') {
                    converted = '7';
                }else if (c == 'T' || c == 'U' || c == 'V') {
                    converted = '8';
                }else if (c == 'W' || c == 'X' || c == 'Y') {
                    converted = '9';
                }
                if (chars[i] != converted) {
                    matched = false;
                    break;
                }
            }
            if(matched) {
                result.add(word);
            }
        }
        File file = new File("namenum.out");
        PrintWriter out = new PrintWriter("namenum.out");
        for(String s : result) {
            out.println(s);
        }
    }
}
