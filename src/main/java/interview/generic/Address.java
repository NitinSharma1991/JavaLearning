package interview.generic;

import lombok.Data;

@Data
public class Address implements Cloneable {
    String street;
    int pincode;
    String city;

    @Override
    public String toString() {
        return "Address{" +
                "street='" + street + '\'' +
                ", pincode=" + pincode +
                ", city='" + city + '\'' +
                '}';
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
