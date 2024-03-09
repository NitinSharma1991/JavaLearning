package com.DataStructure;

import java.util.SortedMap;
import java.util.TreeMap;

public class ConsistentHashing {

    private final SortedMap<Integer, String> ring = new TreeMap<>();

    public void addNode(String node) {
        int hash = getHash(node);
        ring.put(hash, node);
    }

    public void removeNode(String node) {
        int hash = getHash(node);
        ring.remove(hash);
    }

    public String getNodeForKey(String key) {
        if (ring.isEmpty()) {
            return null;
        }

        int hash = getHash(key);
        SortedMap<Integer, String> tailMap = ring.tailMap(hash);

        // If tailMap is empty, wrap around to the first node in the ring
        int selectedHash = tailMap.isEmpty() ? ring.firstKey() : tailMap.firstKey();

        return ring.get(selectedHash);
    }

    private int getHash(String key) {
        // In a real-world scenario, you would use a proper hash function
        // For simplicity, we use the default hashCode() method in this example
        return key.hashCode();
    }

    public static void main(String[] args) {
        ConsistentHashing consistentHashing = new ConsistentHashing();

        // Adding nodes to the ring
        consistentHashing.addNode("NodeA");
        consistentHashing.addNode("NodeB");
        consistentHashing.addNode("NodeC");

        // Getting node for a specific key
        String key = "SampleKey";
        String selectedNode = consistentHashing.getNodeForKey(key);

        System.out.println("Node for key '" + key + "': " + selectedNode);

        String key1 = "Nitin";

        selectedNode = consistentHashing.getNodeForKey(key1);

        System.out.println("Node for key '" + key1 + "': " + selectedNode);

        // Removing a node from the ring
        consistentHashing.removeNode("NodeA");

        // Getting node for the same key after removing a node
        selectedNode = consistentHashing.getNodeForKey(key);

        System.out.println("Node for key '" + key + "' after removing NodeA: " + selectedNode);
    }
}
