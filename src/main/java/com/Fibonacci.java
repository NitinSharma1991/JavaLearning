package com;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class Fibonacci {
    public static void main(String[] args) {

        Fatca fatca = new Fatca();
        fatca.setId("10");
        List<Additional> list = new ArrayList<>();
        fatca.setAdditionalList(list);
        Optional.ofNullable(fatca.getAdditionalList()).ifPresent(l -> process(fatca, l));

    }

    private static void process(Fatca fatca, List<Additional> l) {
        l.getFirst();
    }


    static class Fatca {
        List<Additional> additionalList;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        String id;

        public List<Additional> getAdditionalList() {
            return additionalList;
        }

        public void setAdditionalList(List<Additional> additionalList) {
            this.additionalList = additionalList;
        }
    }

    static class Additional {
        String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
