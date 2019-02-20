
import java.util.*;
public class Number2 {
    public static void main(String[] args) {
        int n;
        Scanner s = new Scanner(System.in);
        
        n = s.nextInt();
        int[] digits = new int[10];
        
        while(n!=0){
            int temp = n%10;
            digits[temp]++;
            n = n/10;
        }
        int i=0;
        for (int digit : digits) {
            System.out.println("Digit: "+(i++)+" Is Present: "+digit+" Times");
        }
        
    }
}
