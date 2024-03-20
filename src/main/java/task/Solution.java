package task;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solution {

    public static void findDuplicates(String text) {
        Pattern pattern = Pattern.compile("\\b(\\w+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(text);

        Map<String, Integer> wordCount = new HashMap<>();
        Set<String> duplicates = new HashSet<>();

        while (matcher.find()) {
            String word = matcher.group().toLowerCase();
            if (wordCount.containsKey(word)) {
                int count = wordCount.get(word);
                wordCount.put(word, count + 1);
                duplicates.add(word);
            } else {
                wordCount.put(word, 1);
            }
        }

        if (duplicates.isEmpty()) {
            throw new RuntimeException("No repeated words");
        }

        for (String word : duplicates) {
            System.out.println(word.substring(0, 1).toUpperCase() + word.substring(1) + ": " + wordCount.get(word));
        }
    }

    public static void main(String[] args) {
        String initialText = "The enormous room on the ground floor faced towards the north. Cold for all the summer beyond the panes, for all the tropical heat of the room itself, a harsh thin light glared through the windows, hungrily seeking some draped lay figure, some pallid shape of academic gooseflesh, but finding only the glass and nickel and bleakly shining porcelain of a laboratory. Wintriness responded to wintriness. The overalls of the workers were white, their hands gloved with a pale corpse-colored rubber. The light was frozen, dead, a ghost. Only from the yellow barrels of the microscopes did it borrow a certain rich and living substance, lying along the polished tubes like butter, streak after luscious streak in long recession down the worktables.";
        String removeFirstSentence = initialText.substring(initialText.indexOf(".") + 1).trim();

        Solution.findDuplicates(removeFirstSentence);
    }
}