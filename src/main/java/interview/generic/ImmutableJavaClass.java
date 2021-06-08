package interview.generic;

import java.util.ArrayList;

public final class ImmutableJavaClass {

    final int id;
    final String name;
    final ArrayList<String> list;
    final Address address;

    public ImmutableJavaClass(int id, String name, ArrayList<String> list, Address address) {
        this.id = id;
        this.name = name;
        this.list = (ArrayList<String>) list.clone();
        this.address = address;
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        ArrayList list = new ArrayList<String>();
        list.add("KAkak");
        Address address = new Address();
        address.setCity("Mumbai");
        ImmutableJavaClass immutableJavaClass = new ImmutableJavaClass(1, "Nitin", list, address);
        System.out.println(immutableJavaClass);
        list.add("Nitin");
        immutableJavaClass.getAddress().setCity("Ghaziabad");
        System.out.println(immutableJavaClass);

    }

    public Address getAddress() throws CloneNotSupportedException {
        return (Address) address.clone();
    }

    @Override
    public String toString() {
        return "ImmutableJavaClass{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", list=" + list +
                ", address=" + address +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public ArrayList<String> getList() {
        return (ArrayList<String>) list.clone();
    }


}
