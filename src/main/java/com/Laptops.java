package com;

public class Laptops implements Comparable<Laptops> {
    private String name;
    private int ram;
    private int size;

    public Laptops(String name, int ram, int size) {
        this.name = name;
        this.ram = ram;
        this.size = size;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Laptops{" +
                "name='" + name + '\'' +
                ", ram=" + ram +
                ", size=" + size +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRam() {
        return ram;
    }

    public void setRam(int ram) {
        this.ram = ram;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int compareTo(Laptops o) {
        int comp = this.getName().compareTo(o.getName());
        if (comp > 0) return 1;
        else return -1;
    }
}
