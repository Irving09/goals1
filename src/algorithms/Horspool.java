package algorithms;

import com.company.Main;
import java.util.HashMap;
import java.util.Map;

public class Horspool {
    private String pattern;
    private Map<Character, Integer> table;

    public Horspool(final String pattern) {
        this.pattern = pattern;
        table = new HashMap<>();
    }

    private final void generateTable() {
        final String letters = this.pattern.toLowerCase();

        int i, size;
        for (size = this.pattern.length(), i = 0; i < size - 1; i++) {
            Character letter = letters.charAt(i);
            table.put(letter, size - i - 1);
        }
    }

    public boolean isSubstringOf(final String text) {
        generateTable();

        final int patternSize = pattern.length();
        int patternIndex = patternSize - 1;
        String chunk;
        int textIndex;
        for (textIndex = patternIndex; textIndex < text.length();) {
            chunk = text.substring(textIndex - patternIndex, textIndex + 1);
            if (chunk.equals(pattern)) {
                return true;
            }
            textIndex += incrementIndexByTableValue(textIndex, text, patternSize);
        }
        return false;
    }

    public int incrementIndexByTableValue(final int textIndex, final String text, final int patternSize) {
        final Integer shiftValue = table.get(text.charAt(textIndex));
        return shiftValue == null ? patternSize : shiftValue;
    }

    public static boolean bruteForceStringComparison(final String text, final String pattern) {
        String chunk;
        for (int i = pattern.length() - 1; i < text.length(); i ++) {
            chunk = text.substring(i - (pattern.length() - 1), i + 1);
            if (chunk.equals(pattern)) {
                return true;
            }
        }
        return false;
    }

    public static void main(final String[] args) {
        final String pattern = "hello";
        final String text = Main.LONG_TEXT;
        final Horspool horspool = new Horspool(pattern);

        long start = System.nanoTime();
        final boolean horspoolResult = horspool.isSubstringOf(text);
        long end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("horspoolResult: " + horspoolResult);

        System.out.println();

        start = System.nanoTime();
        final boolean bruteForceResult = bruteForceStringComparison(text, pattern);
        end = System.nanoTime();
        System.out.println(end - start);
        System.out.println("bruteForceResult: " + bruteForceResult);
    }

}
