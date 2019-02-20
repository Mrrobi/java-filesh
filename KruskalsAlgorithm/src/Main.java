
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;


/*@author Mrrobi*/
public class Main {
    public static ArrayList<Edge>edge = new ArrayList<Edge>();
    public static int[] v;
    public static int[] par;
    public static int[] rank;
    public static Queue<Edge> q = new LinkedList<>();
    public static void main(String[] args) {
        Main main = new Main();
        Scanner s = new Scanner(System.in);
        int n,m;
        n = s.nextInt();
        m = s.nextInt();
        
        //System.out.println("Enter U V W");
        
        for(int i=0;i<m;i++){
            edge.add(new Edge(s.nextInt(), s.nextInt(), s.nextInt()));
        }
        
        v = new int[n];
        par = new int[n];
        rank = new int[n];
        for(int i = 0 ; i<n ; i++){
            main.makeset(i);
        }
        Collections.sort(edge, new Comparator<Edge>() {
            @Override
            public int compare(Edge t, Edge t1) {
                return t.w-t1.w; //To change body of generated methods, choose Tools | Templates.
            }
        });
        int weight=0;
        for(int i=1;i<m;i++){
            //main.parShow();
            
            if(main.findset(edge.get(i).u)!=main.findset(edge.get(i).v)){
                main.union(edge.get(i).u,edge.get(i).v);
                q.add(edge.get(i));
                weight+=edge.get(i).w;
            }
        }
        System.out.println("MST weight: "+weight);
        main.printgrpah();
    }

    int findset(int i){
        if(par[i]==i)return i;
        else{
            int v = findset(par[i]);
            //par[i]=v;
            return v;
        }
    }
    private void makeset(int i) {
        par[i] = i;
        rank[i] = 0;
    }

    private void union(int u, int v) {
         int uu = findset(u);
         int vv = findset(v);
         if(uu!=vv){
             if(rank[uu]==rank[vv]){
                 par[uu] = par[vv];
                 rank[uu]++;
             }else if(rank[uu]<rank[vv]){
                 par[vv] = par[uu];
             }else if(rank[uu]>rank[vv]){
                 par[uu] = par[vv];
             }
         }
    }

    private void printgrpah() {
        while(!q.isEmpty()){
            Edge t = q.remove();
            System.out.println(t);
        }
    }

    private void parShow() {
        for(int i=0;i<par.length;i++){
            System.out.println("Parent of: "+i+" is: "+par[i]);
        }
    }
    
}
