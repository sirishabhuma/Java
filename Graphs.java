import java.util.*;
public class Graphs {
    public static ArrayList<Edge>[] graph=new ArrayList[4];
    static class Edge{
        int source;
        int destination;
        int weight;
        public Edge(int s,int d,int w){
            this.source=s;
            this.destination=d;
            this.weight=w;
        }
    }
    public static void createEdge(int v){
        //initially the graph array is stored with null values
        //now create a empyt array list
        for(int i=0;i<v;i++){
            graph[i]=new ArrayList<Edge>();
        } 
        graph[0].add(new Edge(0,1,10));
        graph[1].add(new Edge(1,0,10));
        graph[1].add(new Edge(1,2,5));
        graph[1].add(new Edge(1,3,7));
        graph[2].add(new Edge(2,1,5));
        graph[3].add(new Edge(3,2,7));

    }
    public static List<Integer> getNeighbor(){
        List<Integer> ans=new ArrayList<>();
        for(int i=0;i<graph[1].size();i++){
            Edge e=graph[1].get(i);
            ans.add(e.destination);
        }
        for(int i=0;i<ans.size();i++){
            System.out.print(ans.get(i)+" ");
        }
        return ans;
    }
    public static void BFSTraversal(){
        Queue<Integer> q=new LinkedList<>();
        boolean []visited=new boolean[graph.length];
        q.add(0);
        while(!q.isEmpty()){
            int cur=q.remove();
            if(visited[cur]==false){
                System.out.print(cur+" ");
                visited[cur]=true;
                for(int i=0;i<graph[cur].size();i++){
                    q.add(graph[cur].get(i).destination);
                }
            }
        }
    }
    public static void DFSTraversal(int cur,boolean[] visited){

        System.out.print(cur+" ");
        visited[cur]=true;
        for(int i=0;i<graph[cur].size();i++){
            Edge e=graph[cur].get(i);
            if(!visited[e.destination]){
                DFSTraversal(e.destination, visited);
            }
        }
    }
    public static boolean hasPath(int src,int dest,boolean[] visited){
        if(src == dest){
            return true;
        }
        visited[src]=true;
        for(int i=0;i<graph[src].size();i++){
            Edge e=graph[src].get(i);
            if(!visited[e.destination] && hasPath(e.destination, dest, visited)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        createEdge(4);
        getNeighbor();
        System.out.println();
        BFSTraversal();
        System.out.println();
        DFSTraversal(0, new boolean[4]);
        System.out.println();
        System.out.println(hasPath(0, 2, new boolean[4]));
    }
}
