
import java.util.ArrayList;
import java.util.Scanner;


/*@author Mrrobi*/
public class Store {

    ArrayList<Books> b = new ArrayList<>();
    private void show() {
        for (Books object : b) {
            System.out.println(object);
        }
    }

    private void sell() {
        Books nw;
        if(b.isEmpty()){
            System.out.println("No books to sell");
            return;
        }
        int i=1;
        for (Books books : b) {
            System.out.println((i++)+": "+books.name+ " Available: "+books.quantity+ " Pcs");
        }
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the serial number of book you want to sell");
        int ch = s.nextInt();
        System.out.print("Enter how many copy do you want to sell");
        int d = s.nextInt();
        nw = b.get(ch-1);
        nw.sell(d);
        if(nw.quantity==0){
            b.remove(ch-1);
        }
    }

    private void buy() {
        Scanner s = new Scanner(System.in);
        System.out.print("Enter the name of book");
        String ch = s.nextLine();
        System.out.print("Enter how many copy do you want to buy");
        int d = s.nextInt();
        b.add(new Books(ch, d));
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Store s1 = new Store();
        while(true){
            System.out.println("1.Show Book");
            System.out.println("2.Sell Book");
            System.out.println("3.Order Book");
            System.out.println("4.Close Store");
            int c = s.nextInt();
            switch(c){
                case 1:
                    s1.show();
                    break;
                case 2:
                    s1.sell();
                    break;
                case 3:
                    s1.buy();
                    break;
                case 4:
                    return;
            }
        }
    }

}
