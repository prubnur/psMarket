package project11;

/**
 *
 * @author isaluja1811
 */
public class Product implements Comparable<Product>{
    private int id;
    private String name;
    private float price;
    private String type;
    private int quantity;
    private String addDate;
    private byte[] picture;
    
    public Product(int pid, String pname, float pprice, String ptype, int pquantity, String pAddDate, byte[] pimg) {
        this.id = pid;
        this.name = pname;
        this.price = pprice;
        this.type = ptype;
        this.quantity = pquantity;
        this.addDate = pAddDate;
        this.picture = pimg;
    }
    
    public int getId() {
        return id;
    }
    
    public String getName() {
        return name;
    }
    
    public float getPrice() {
        return price;
    }
    
    public String getType() {
        return type;
    }
    
    public int getQuantity() {
        return quantity;
    }
    
    public String getAddDate() {
        return addDate;
    }
    
    public byte[] getImage() {
        return picture;
    }
    
    public void setQuantity(int qty) {
        this.quantity = qty;
    }
    
    @Override
    public int compareTo(Product product) {
        return ( this.getPrice() > product.getPrice() ? -1 :
                ( this.getPrice()==product.getPrice()? 0 : 1 ));
        
    }
}
