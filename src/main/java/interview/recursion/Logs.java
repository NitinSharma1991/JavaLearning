package interview.recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Logs {

    public static void main(String[] args) {
        String[] logs = {"dig1 2 1 5 1", "let1 art can", "dig1 3 6", "let2 own kit dig", "let3 art zero"};

        logs = new Logs().reorderLogFiles(logs);
        System.out.println(Arrays.toString(logs));
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        int index;
        for (String log : logs) {
            index = log.indexOf(" ");
            if (Character.isLetter(log.charAt(index + 1))) {
                letterLogs.add(log);
            } else {
                digitLogs.add(log);
            }
        }
        letterLogs.sort(new LogComparator());
        letterLogs.addAll(digitLogs);
        return letterLogs.toArray(new String[0]);
    }
}

class LogComparator implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int index1 = o1.indexOf(" ");
        int index2 = o2.indexOf(" ");
        String word1 = o1.substring(index1 + 1);
        String word2 = o2.substring(index2 + 1);
        if (word1.equals(word2)) {
            String identifier1 = o1.substring(0, index1);
            String identifier2 = o2.substring(0, index2);
            return identifier1.compareTo(identifier2);
        } else {
            return word1.compareTo(word2);
        }
    }
}
