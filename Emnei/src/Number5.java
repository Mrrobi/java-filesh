import java.util.*;

public class Number5 {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        char ch = s.next().charAt(0);
        
        if(ch>='A'&&ch<='Z'||ch>='a'&&ch<='z'){
            System.out.println("Input is a charecter");
        }else if(ch>='0'&&ch<='9'){
            System.out.println("Input is a Digit");
        }else{
            System.out.println("Special Charecter");
        }
    }
}
