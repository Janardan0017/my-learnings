package leetcode;

import java.util.ArrayList;
import java.util.List;

public class Problem68 {

    public static void main(String[] args) {
        String[] words = {"This", "is", "an", "example", "of", "text", "justification."};
        System.err.println(fullJustify(words, 16));
    }

    public static List<String> fullJustify(String[] words, int maxWidth) {
        List<String> justifiedLines = new ArrayList<>();
        List<String> wordsInCurrentLine = new ArrayList<>();
        int lengthOfWordsInLine = 0;
        int i = 0;
        while (i < words.length) {
            if (lengthOfWordsInLine + wordsInCurrentLine.size() + words[i].length() > maxWidth) {
                int[] spaces = totalSpace(wordsInCurrentLine.size() - 1, maxWidth - lengthOfWordsInLine);
                StringBuilder sb = new StringBuilder(wordsInCurrentLine.getFirst());
                for (int s = 1; s < wordsInCurrentLine.size(); s++) {
                    sb.append(" ".repeat(spaces[s - 1])).append(wordsInCurrentLine.get(s));
                }
                if(sb.length() < maxWidth) {
                    sb.append(" ".repeat(maxWidth-sb.length()));
                }
                justifiedLines.add(sb.toString());
                wordsInCurrentLine = new ArrayList<>();
                lengthOfWordsInLine = 0;
            } else {
                lengthOfWordsInLine += words[i].length();
                wordsInCurrentLine.add(words[i]);
                i++;
            }
        }
        if (!wordsInCurrentLine.isEmpty()) {
            String lastLine = String.join(" ", wordsInCurrentLine);
            if(lastLine.length() != maxWidth) {
                lastLine += " ".repeat(maxWidth-lastLine.length());
            }
            justifiedLines.add(lastLine);
        }
        return justifiedLines;
    }

    public static int[] totalSpace(int gapCount, int totalSpace) {
        int[] spaces = new int[gapCount];
        int i = gapCount - 1;
        while (totalSpace > 0 && gapCount > 0) {
            spaces[i] = totalSpace / gapCount;
            totalSpace -= spaces[i];
            gapCount--;
            i--;
        }
        return spaces;
    }
}
