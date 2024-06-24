package learning.DataStructure;

public class LLExample {

    public static void main(String[] args) {
        LList list = new LList();
        list.insert("Kaka");
        list.insert("Nitin");
        list.insert("Nupur");
        list.insert("Apurva");
        list.insert("Swati");
        list.insertAt(6, "love");
        list.print(list.head);
        System.out.println(" ");
        list.print(list.reverse(list.head));

        LList list1 = new LList();
        list1.insert("Kaka1");
        list1.insert("Nitin1");
        list1.insert("Nupur1");
        list1.insert("Apurva1");


       list1.print(list1.swapPairs(list1.head));

        intersectionPoint(list, list1);
    }


    private static void intersectionPoint(LList list, LList lList) {

        int alen = list.length(list.head);
        int blen = lList.length(lList.head);

        int diff = 0;
        LList.Node node = list.head;
        LList.Node node1 = lList.head;

        if (alen >= blen) {
            diff = alen - blen;
            while (diff != 0) {
                node = node.getNode();
                diff--;
            }

        } else {
            diff = blen - alen;
            while (diff != 0) {
                node1 = node1.getNode();
                diff--;
            }
        }

        while (node.getNode() != null && node1.getNode() != null) {

            if (node.getData() == node1.getData()) {
                System.out.println(node.getData());
                break;
            } else {
                node = node.getNode();
                node1 = node1.getNode();
            }

        }


    }
}
