import java.util.*;
public class Number6 {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        n = s.nextInt();
        for(int i=2;i<n;i++){
            
            if(isprime(i)==1){
                System.out.println(i+" Is a Prime");
            }
        }
    }

    private static int isprime(int n) {
        for(int i=2;i<n;i++){
            if(n%i==0){
                return 0;
            }
        }
        return 1;
    }
}
