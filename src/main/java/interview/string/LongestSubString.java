package interview.string;

import java.util.*;

public class LongestSubString {


    public static void main(String[] args) {
        lengthOfLongestSubstring("abacus");
        LinkedHashSet<Character> set = new LinkedHashSet<>();
        addBinary();

    }

    public static void lengthOfLongestSubstring(String s) {

        int j = 0;
        String k = "";
        Map<Character, Integer> map = new HashMap();
        for (int i = 0; s.length() > i; i++) {

            if (map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)) + 1, j);
            }

            if (k.length() < i - j + 1) {
                k = s.substring(j, i + 1);
            }

            map.put(s.charAt(i), i);
        }

        String s1 = "abca";
        Set<Character> set = new HashSet();
        for (char c : s1.toCharArray()) {
            if (!set.contains(c))
                set.add(c);
            else set.remove(c);
        }

        isAnagram("anagram", "nagaram");

        System.out.println(Math.pow(3, 9 / 3));
    }

    public static boolean isAnagram(String s, String t) {
        int[] sLetterCount = new int[26];
        char[] sLetters = s.toCharArray();
        for (char letter : sLetters) {
            sLetterCount[letter - 'a']++;
        }

        int[] tLetterCount = new int[26];
        char[] tLetters = t.toCharArray();
        for (char letter : tLetters) {
            tLetterCount[letter - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sLetterCount[i] != tLetterCount[i]) {
                return false;
            }
        }

        return true;
    }

    public static void addBinary() {
        String date = "20th Oct 2052";
        String str [] = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        List<String> list = Arrays.asList(str);
        StringBuilder build = new StringBuilder();


        build.append(date.substring(date.length() - 4)).append("-")
                .append(list.indexOf(date.split(" ")[1]) + 1).append("-").append(date, 0, 2);

        System.out.println(build);
    }


}
