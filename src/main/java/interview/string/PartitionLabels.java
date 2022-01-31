package interview.string;

import java.util.*;

public class PartitionLabels {

    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        int[] last = new int[26];

        for (int i = s.length() - 1; i >= 0; i--) {
            if (last[s.charAt(i) - 'a'] == 0) {
                last[s.charAt(i) - 'a'] = i;
            }
        }

        List<Integer> res = new LinkedList<>();
        int i = -1;
        int j = 0;
        int idx = last[s.charAt(j) - 'a'];

        while (true) {

            if (idx == j) {
                res.add(j - i);
                i = j;
            }

            j++;
            if (j == s.length()) break;
            char ch = s.charAt(j);
            idx = Math.max(idx, last[ch - 'a']);

        }

        System.out.println(res);
        String[] strs = {"eat", "tea", "tan", "ate", "nat", "bat"};
        groupAnagrams(strs);

    }

    private static void groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] a = s.toCharArray();
            Arrays.sort(a);
            if (map.containsKey(String.valueOf(a))) {
                List<String> l = map.get(String.valueOf(a));
                l.add(s);
                map.put(String.valueOf(a), l);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(String.valueOf(a), list);
            }
        }
        List<List<String>> res = new ArrayList<>(map.values());
        System.out.println(res);
    }

}
