package com.learning;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public class Laptops implements Comparable<Laptops> {
    private String name;
    private int ram;
    private int size;


    public int compareTo(Laptops o) {
        int comp = this.getName().compareTo(o.getName());
        if (comp > 0) return 1;
        else return -1;
    }
}
