/*
 * Name: <your name>
 * EID: <your EID>
 */

// Implement your heap here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;

public class edgeHeap {
    private ArrayList<Edge> minHeap;

    public edgeHeap() {
        minHeap = new ArrayList<Edge>();
    }

    /**
     * buildHeap(ArrayList<Edge> Edges)
     * Given an ArrayList of Edges, build a min-heap keyed on each Edge's minCost
     * Time Complexity - O(nlog(n)) or O(n)
     *
     * @param Edges
     */
    public void buildHeap(ArrayList<Edge> Edges) {
        // Add all Edges to the heap
        minHeap.addAll(Edges);
        for(int i =0; i < Edges.size();i++){
            Edges.get(i).setHeaped();
        }

        // Starting from the parent of the last element, perform minHeapify
        for (int i = (minHeap.size() - 1) / 2; i >= 0; i--) {
            minHeapify(i);
        }
    }



    /**
     * insertNode(Edge in)
     * Insert a Edge into the heap.
     * Time Complexity - O(log(n))
     *
     * @param in - the Edge to insert.
     */

    public void insertNode(Edge in) {
        // Add the new Edge to the end of the heap
        
        minHeap.add(in);
        in.setHeaped();

        int index = minHeap.size() - 1;
        int parentIndex = getParentIndex(index);

        // Move the new Edge up the heap while it's smaller than its parent
        while (index > 0 && minHeap.get(index).getCost() < minHeap.get(parentIndex).getCost()) {
            swap(index, parentIndex);
            index = parentIndex;
            parentIndex = getParentIndex(index);
        }
    }

    /**
     * findMin()
     * Time Complexity - O(1)
     *
     * @return the minimum element of the heap.
     */
    public Edge findMin() {
        if (minHeap.isEmpty()) {
            return null;
        }
        return minHeap.get(0);
    }


    public boolean isEmpty() {
        if (minHeap.isEmpty()) {
            return true;
        }
        return false;
    }

    /**
     * extractMin()
     * Time Complexity - O(log(n))
     *
     * @return the minimum element of the heap, AND removes the element from said heap.
     */
    public Edge extractMin() {
        if (minHeap.isEmpty()) {
            return null;
        }

        Edge minEdge = minHeap.get(0);

        // Replace the root with the last Edge in the heap
        minHeap.set(0, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);

        minHeapify(0); // Restore the min-heap property
        minEdge.setUnHeaped();
        return minEdge;
    }

    /**
     * delete(int index)
     * Deletes an element in the min-heap given an index to delete at.
     * Time Complexity - O(log(n))
     *
     * @param index - the index of the item to be deleted in the min-heap.
     */
    public void delete(int index) {

        if (index < 0 || index >= minHeap.size()) {
            return;
        }

        minHeap.get(index).setUnHeaped();
        // Replace the element to delete with the last element in the heap
        minHeap.set(index, minHeap.get(minHeap.size() - 1));
        minHeap.remove(minHeap.size() - 1);

        int parentIndex = getParentIndex(index);

        // Check if the replaced element is smaller than its parent or violates the heap property
        if (index > 0 && minHeap.get(index).getCost() < minHeap.get(parentIndex).getCost()) {
            // Move the element up the heap
            while (index > 0 && minHeap.get(index).getCost() < minHeap.get(parentIndex).getCost()) {
                swap(index, parentIndex);
                index = parentIndex;
                parentIndex = getParentIndex(index);
            }
        } else {
            // Move the element down the heap
            minHeapify(index);
        }
    }

    /**
     * changeKey(Edge r, int newCost)
     * Changes minCost of Edge s to newCost and updates the heap.
     * Time Complexity - O(log(n))
     *
     * @param r       - the Edge in the heap that needs to be updated.
     * @param newCost - the new cost of Edge r in the heap (note that the heap is keyed on the values of minCost)
     */
    public void changeKey(Edge s, int newCost) {
        int index = minHeap.indexOf(s);

        if (index != -1) {
            int oldCost = minHeap.get(index).getCost();
            minHeap.get(index).setCost(newCost);

            if (newCost < oldCost) {
                // Move the element up the heap
                int parentIndex = getParentIndex(index);
                while (index > 0 && minHeap.get(index).getCost() < minHeap.get(parentIndex).getCost()) {
                    swap(index, parentIndex);
                    index = parentIndex;
                    parentIndex = getParentIndex(index);
                }
            } else if (newCost > oldCost) {
                // Move the element down the heap
                minHeapify(index);
            }
        }
    }

    private void minHeapify(int index) {
        int smallest = index;
        int leftChild = getLeftChildIndex(index);
        int rightChild = getRightChildIndex(index);

        if (leftChild < minHeap.size() && minHeap.get(leftChild).getCost() < minHeap.get(smallest).getCost()) {
            smallest = leftChild;
        }

        if (rightChild < minHeap.size() && minHeap.get(rightChild).getCost() < minHeap.get(smallest).getCost()) {
            smallest = rightChild;
        }

        if (smallest != index) {
            swap(index, smallest);
            minHeapify(smallest);
        }
    }

    private int getParentIndex(int index) {
        return (index - 1) / 2;
    }

    private int getLeftChildIndex(int index) {
        return 2 * index + 1;
    }

    private int getRightChildIndex(int index) {
        return 2 * index + 2;
    }

    private void swap(int i, int j) {
        Edge temp = minHeap.get(i);
        minHeap.set(i, minHeap.get(j));
        minHeap.set(j, temp);
    }


    // public String toString() {
    //     String output = "";
    //     for (int i = 0; i < minHeap.size(); i++) {
    //         output += minHeap.get(i).getName() + " ";
    //     }
    //     return output;
    // }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public ArrayList<Edge> toArrayList() {
        return minHeap;
    }
}

