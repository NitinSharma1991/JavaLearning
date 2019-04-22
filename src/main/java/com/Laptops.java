package com;

import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
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
