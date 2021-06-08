package interview.recursion;

import java.util.*;

public class Logs {

    public static void main(String[] args) {
        String[] logs = {"dig1 2 1 5 1", "let1 art can", "dig1 3 6", "let2 own kit dig", "let3 art zero"};
//        Arrays.sort(logs, (log1, log2) -> {
//            int index1 = log1.indexOf(" ");
//            String id1 = log1.substring(0, index1);
//            String main1 = log1.substring(index1 + 1);
//
//            int index2 = log2.indexOf(" ");
//            String id2 = log2.substring(0, index2);
//            String main2 = log2.substring(index2 + 1);
//
//            boolean isDigit1 = Character.isDigit(main1.charAt(0));
//            boolean isDigit2 = Character.isDigit(main2.charAt(0));
//
//            if (!isDigit1 && !isDigit2) {
//                int value = main1.compareTo(main2);
//                if (value == 0) return id1.compareTo(id2);
//                return value;
//            }
//            return isDigit1 ? (isDigit2 ? 0 : 1) : -1;
//        });


        logs = new Logs().reorderLogFiles(logs);

        System.out.println(Arrays.toString(logs));
    }

    public String[] reorderLogFiles(String[] logs) {
        List<String> letterLogs = new ArrayList<>();
        List<String> digitLogs = new ArrayList<>();
        int index = -1;
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
