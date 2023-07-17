/*
 * Name: <your name>
 * EID: <your EID>
 */

// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.*;

public class Student {
    private int minCost;
    private int name;
    private boolean visited;
    private boolean heaped;
    private ArrayList<Student> neighbors;
    private ArrayList<Integer> prices;

    public Student(int x) {
        name = x;
        minCost = Integer.MAX_VALUE;
        neighbors = new ArrayList<Student>();
        prices = new ArrayList<Integer>();
        visited = false;
        heaped = false;
    }

    public Student(int x,int cost) {
    name = x;
    minCost = cost;
    neighbors = new ArrayList<Student>();
    prices = new ArrayList<Integer>();
    visited = false;
    heaped = false;
    }

    public void setNeighborAndPrice(Student n, Integer w) {
        neighbors.add(n);
        prices.add(w);
    }

    public ArrayList<Student> getNeighbors() {
        return neighbors;
    }

    public ArrayList<Integer> getPrices() {
        return prices;
    }

    public int getminCost() { return minCost; }

    public void setminCost(int x) {
        minCost = x;
    }

    public void resetminCost() {
        minCost = Integer.MAX_VALUE;
    }

    public int getName() {
        return name;
    }

    public void setVisited() {
        visited = true;
    }

    public void setUnVisited() {
        visited = false;
    }

    public boolean isVisited() {
        return visited;
    }

    public void setHeaped() {
        heaped = true;
    }

    public void setUnHeaped() {
        heaped = false;
    }

    public boolean isHeaped() {
        return heaped;
    }

}
