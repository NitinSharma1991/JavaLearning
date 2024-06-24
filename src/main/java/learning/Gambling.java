package learning;

public class Gambling {

    public static String[] adjectives = {"Nice", "Pretty", "Fun", "Spicy"};
    public static String[] verbs = {"Runs", "Trots", "Walks", "Neighs", "Swaims", "Flies"};

    public static void main(String[] args) {
        for (int i = 2; i < 5; i++) {
            System.out.println(generateRandomSequence("Horse", i));
        }
    }

    private static String generateRandomSequence(String horse, int i) {

        return "The " + adjectives[i % adjectives.length] + " " + horse + " " + verbs[i % verbs.length];
    }
    /*public static void main(String[] args) {
        int a = gamling(18, 0);

        System.out.println(a);
    }

    private static int gamling(int i, int i1) {
        int bet = 1;
        int count = 0;
        int count1 = i;

        if (i1 == 0) return i - 1;

        while (count1 != 2 && i1 != 0) {
//            if (bet == 1) count = 2 * bet;

            if (count1 % 2 == 0) {
                count1 = count1 / 2;
                i1--;
                count++;
            } else {
                count1--;
            }

        }
        count = count1 + count;
        return count;

    }*/
}
