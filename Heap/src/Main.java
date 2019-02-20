
/*@author Mrrobi*/

import java.util.*;
public class Main {
    
    ArrayList<Integer> heap;

    public Main(ArrayList<Integer> heap) {
        this.heap = heap;
    }
    
    void buildMaxHeap(int n){
        int i=heap.size()/2-1;
        System.out.println(i);
        while(i>=0){
            maxHeapify(i,n);
            i--;
        }
    }
    
    private void maxHeapify(int i,int n) {
        if(i>n){
            return;
        }
        else{
            int t = i , l = i*2+1 , r = i*2+2;
            if(i==0){
                l = 1;
                r = 2;
            }
            if(l<n&&heap.get(t)<heap.get(l)){
                t = l;
            }
            if(r<n&&heap.get(t)<heap.get(r)){
                t = r;
            }

            if(t!=i){
                swap(t,i);
            }
            maxHeapify(l, n);
            maxHeapify(r, n);
        }
    }

    
    void buildMinHeap(int n){
        int i=heap.size()/2-1;
        while(i>=0){
            minHeapify(i,n);
            i--;
        }
    }
    
    private void minHeapify(int i,int n) {
        if(i>n){
            return;
        }
        else{
            int t = i , l = i*2+1 , r = i*2+2;
            if(i==0){
                l = 1;
                r = 2;
            }
            if(l<n&&heap.get(t)>heap.get(l)){
                t = l;
            }
            if(r<n&&heap.get(t)>heap.get(r)){
                t = r;
            }

            if(t!=i){
                swap(t,i);
            }
            minHeapify(l, n);
            minHeapify(r, n);
        }
    }
    
    
    private void swap(Integer p, Integer i) {
         int t = heap.get(p);
         heap.set(p, heap.get(i));
         heap.set(i, t); 
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        int n = s.nextInt();
        ArrayList<Integer>data = new ArrayList<>();
        for(int i=0;i<n;i++){
            data.add(s.nextInt());
        }
        
        Main m = new Main(data);
        
        System.out.println("---------Scramble data--------");
        for (Integer integer : m.heap) {
            System.out.print(integer+" ");
        }
        m.buildMaxHeap(n);
        System.out.println("");
        System.out.println("---------Max Heap--------------");
        for (Integer integer : m.heap) {
            System.out.print(integer+" ");
        }
        m.heap = data;
        m.buildMinHeap(n);
        System.out.println("");
        System.out.println("---------Min Heap--------------");
        for (Integer integer : m.heap) {
            System.out.print(integer+" ");
        }
    }
}