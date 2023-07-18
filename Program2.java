/*
 * Name: <your name>
 * EID: <your EID>
 */

// Implement your algorithms here
// Methods may be added to this file, but don't remove anything
// Include this file in your final submission

import java.util.ArrayList;

public class Program2 {
    private ArrayList<Student> students;    // this is a list of all Students, populated by Driver class
    private Heap minHeap;

    // additional constructors may be added, but don't delete or modify anything already here
    public Program2(int numStudents) {
        minHeap = new Heap();
        students = new ArrayList<Student>();
    }

    /**
     * findMinimumStudentCost(Student start, Student dest)
     *
     * @param start - the starting Student.
     * @param dest  - the end (destination) Student.
     * @return the minimum cost possible to get from start to dest.
     * Assume the given graph is always connected.
     */
    public int findMinimumStudentCost(Student start, Student dest) {

        System.out.println("start is " + start.getName());
        System.out.println("dest is " + dest.getName());

        // Initialize a distance array or dictionary to store the tentative distances from the source node to all other nodes in the graph. Set the distance of the source node to 0 and the distances of all other nodes to infinity.
        // Create a visited array or dictionary to keep track of the visited nodes. Initialize it as empty.
   
  
        // Create a min-heap to serve as the priority queue. Each element in the min-heap should contain a node and its corresponding distance from the source node. Initially, insert the source node with a distance of 0 into the min-heap.

        minHeap.insertNode(start);
        start.setminCost(0);


        // While the min-heap is not empty, do the following steps:

        // a. Extract the node with the smallest distance from the min-heap. This can be done by removing the top element of the min-heap.

        while(!minHeap.isEmpty()){ //runs n times since each node is visited once
            Student currentStudent = minHeap.extractMin(); //logv 
            // b. Mark the extracted node as visited by adding it to the visited array or dictionary.
            currentStudent.setVisited();

            for(int i =0; i < currentStudent.getNeighbors().size();i++){
                // c. For each neighbor of the extracted node, calculate the tentative distance from the source node to that neighbor. If the calculated distance is smaller than the current distance stored in the distance array or dictionary, update the distance.

                Student neighbor = currentStudent.getNeighbors().get(i);

                int neighborCost = currentStudent.getminCost() + currentStudent.getPrices().get(i);

                if(neighborCost < neighbor.getminCost()){
                    neighbor.setminCost(neighborCost);
                }
                
                //what if the neighbor is already in the heap?
                // d. If the neighbor is not visited, insert it into the min-heap with its updated distance.
                if(!neighbor.isVisited()){
                    if(neighbor.isHeaped()){
                        minHeap.changeKey(neighbor, neighborCost);
                    }else{
                        minHeap.insertNode(neighbor);
                    }

                }
            }



        }



        return dest.getminCost();
    }

    /**
     * findMinimumClassCost()
     *
     * @return the minimum total cost required to connect (span) each student in the class.
     * Assume the given graph is always connected.
     */
    public int findMinimumClassCost() {

        int classCost = 0;
        // Initialize an empty MST and a set of visited vertices. Start with any vertex as the initial vertex.
        ArrayList<Edge> minSpanTree = new ArrayList<>();

        // Create a priority queue (min-heap) to store the edges of the graph. Each element in the priority queue will represent an edge with its weight.

        edgeHeap edgeHeap = new edgeHeap();

        //catch case of empty student array
        if(students.isEmpty()){
            return -1;
        }

        //get any student to start with
        Student startingStudent = students.get(0);

        // Assign a weight of 0 to the initial vertex and add it to the priority queue.
        Edge startEdge = new Edge(0,startingStudent,startingStudent); //first student is always visted, second student always unvisited
        //prims algorithm
        edgeHeap.insertNode(startEdge);

        while(!edgeHeap.isEmpty()){

            //extract an edge
            Edge currentEdge = edgeHeap.extractMin();
            currentEdge.setUnHeaped();
            Student visitStudent = currentEdge.getStudent2();
            //check if student2 is unvisited
            if(!visitStudent.isVisited()){
                //if so, mark student2 as visited
                visitStudent.setVisited();
                //add edge to minspantree
                minSpanTree.add(currentEdge);
                classCost += currentEdge.getCost();
                System.out.println("adding edge from" + currentEdge.getStudent1().getName() + "to " + currentEdge.getStudent2().getName() + "with cost " + currentEdge.getCost());

                //for each edge of student2
                    //add all of its edges to the minheap
                for(int i = 0; i < visitStudent.getNeighbors().size();i++){
                    Edge newEdge = new Edge(visitStudent.getPrices().get(i),visitStudent,visitStudent.getNeighbors().get(i));
                    edgeHeap.insertNode(newEdge);
                }
            }
                
                
                

        }

        
   
        return classCost;
    }

    //returns edges and prices in a string.
    public String toString() {
        String o = "";
        for (Student v : students) {
            boolean first = true;
            o += "Student ";
            o += v.getName();
            o += " has neighbors ";
            ArrayList<Student> ngbr = v.getNeighbors();
            for (Student n : ngbr) {
                o += first ? n.getName() : ", " + n.getName();
                first = false;
            }
            first = true;
            o += " with prices ";
            ArrayList<Integer> wght = v.getPrices();
            for (Integer i : wght) {
                o += first ? i : ", " + i;
                first = false;
            }
            o += System.getProperty("line.separator");

        }

        return o;
    }

///////////////////////////////////////////////////////////////////////////////
//                           DANGER ZONE                                     //
//                everything below is used for grading                       //
//                      please do not change :)                              //
///////////////////////////////////////////////////////////////////////////////

    public Heap getHeap() {
        return minHeap;
    }

    public ArrayList<Student> getAllstudents() {
        return students;
    }

    // used by Driver class to populate each Student with correct neighbors and corresponding prices
    public void setEdge(Student curr, Student neighbor, Integer price) {
        curr.setNeighborAndPrice(neighbor, price);
    }

    // used by Driver.java and sets students to reference an ArrayList of all Students
    public void setAllNodesArray(ArrayList<Student> x) {
        students = x;
    }
}
