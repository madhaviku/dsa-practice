Graph Representation:
  
Adjecency List representation of graph:

public class Main {
    List<List<Integer>> graph = new ArrayList<>();
    private void addEdge(int u, int v){
        graph.get(u).add(v);
        graph.get(v).add(u);
    }
    private void construct(){
        int V = 5;
        
        for(int i = 0; i < V; i++) graph.add(new ArrayList<>());
        addEdge(0,1);
        addEdge(1,2);
        addEdge(0,2);
        addEdge(1,3);
        addEdge(2,4);
        System.out.println(graph);
    }
    public static void main(String[] args) {
        Main obj = new Main();
        obj.construct();
        System.out.println("Hello World!");
    }
}
