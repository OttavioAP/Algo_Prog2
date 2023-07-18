
public class Edge {
     private int cost;
    private Student student1;
    private Student student2;
    private boolean visited;
    private boolean heaped;

    public Edge(int cost_,Student student1_, Student student2_) {
        cost = cost_;
        student1 = student1_;
        student2 = student2_;
        visited = false;
        heaped = false;
    }


    public int getCost() { return cost; }

    public void setCost(int cost_) { cost = cost_; }

    public Student getStudent1() {
        return student1;
    }
    
    public Student getStudent2() {
        return student2;
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


