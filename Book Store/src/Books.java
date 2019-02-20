
/*@author Mrrobi*/
public class Books {
    
    String name;
    String author;
    int quantity;

    public Books(String name, int quantity) {
        this.name = name;
        this.quantity = quantity;
    }
    
    void sell(int d){
        if(d>this.quantity){
            System.out.println("Doesn't Have enough copy");
        }
        this.quantity-=d;
    }

    @Override
    public String toString() {
        return "Books{" + "name=" + name + ", quantity=" + quantity + '}';
    }

    
}
