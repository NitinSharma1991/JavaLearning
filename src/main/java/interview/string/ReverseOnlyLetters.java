package interview.string;

public class ReverseOnlyLetters {

    public static void main(String[] args) {
        String s = "a-bC-dEf-ghIj";
        String s1 = reverseOnlyLetters(s);

        StringBuilder stringBuilder = new StringBuilder();
        int i = 0;
        for (Character c : s.toCharArray()) {
            if (Character.isLetter(c)) {
                stringBuilder.append(s1.charAt(i));
                i++;
            } else {
                stringBuilder.append(c);
            }
        }

        System.out.println(stringBuilder);

    }

    public static String reverseOnlyLetters(String s) {

        if (s.isEmpty()) return s;
        if (Character.isLetter(s.charAt(0)))
            return reverseOnlyLetters(s.substring(1)) + s.charAt(0);
        else return reverseOnlyLetters(s.substring(1));
    }
}
