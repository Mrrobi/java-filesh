
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Scanner;


/*@author Mrrobi*/
public class Main {
    
    
    
    
    ArrayList<Edge>[] graph;
    int n;
    Scanner s;
    void makeGraph(){
        System.out.print("Enter Intials(V,E):");
        int m;
        s = new Scanner(System.in);
        n = s.nextInt();
        m = s.nextInt();
        graph = new ArrayList[n];
        
        for(int i =0;i< n ;i++){
            graph[i] = new ArrayList<>();
        }
        
        for(int i=0;i<m;i++){
            int u = s.nextInt();
            int v = s.nextInt();
            int w = s.nextInt();
            graph[u].add(new Edge(u, v, w));
            graph[v].add(new Edge(v, u, w));
        }
        showGraph(n);
    }
    
    void showGraph(int n){
        for(int i=0;i<n;i++){
            for (Edge edge : graph[i]) {
                System.out.println("From: "+i+" To"+edge.v+" Cost is:"+edge.w);
            }
        }
        System.out.println("=================X==================");
        System.out.println("Enter a source");
        dijkstra(s.nextInt());
    }
    int[] par;
    
    
    void printPath(int parent[], int j) 
    { 

        // Base Case : If j is source 
        if (parent[j] == - 1) 
            return; 

        printPath(parent, parent[j]); 

        System.out.println(j); 
    } 
    
    
    void dijkstra(int source){
        int[] dis = new int[n];
        par = new int[n];
        PriorityQueue<Integer> Q = new PriorityQueue<>();
        for(int i=0;i<dis.length;i++){
            dis[i] = 1000000000;
        }
        
        dis[source] = 0;
        par[source] = -1;
        Q.add(source);
        
        while(!Q.isEmpty()){
            int t = Q.peek();
            Q.remove();
            for(int i=0;i<graph[t].size();i++){
                int v = graph[t].get(i).v;
                if(dis[v]>dis[t]+graph[t].get(i).w){
                    dis[v] = dis[t]+graph[t].get(i).w;
                    par[v] = t;
                    Q.add(v);
                }
            }
        }
        
        for(int i = 0;i<n;i++){
            System.out.println("Distance from: "+source+" to: "+i+" is: "+dis[i]);
        }
        printPath(par, n);
    }
    
    
    //Pilot Method
    public static void main(String[] args) {
        Main m = new Main();
        m.makeGraph();
    }
}
