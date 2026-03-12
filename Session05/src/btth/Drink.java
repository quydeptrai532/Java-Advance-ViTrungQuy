package btth;

public class Drink extends MenuItem {

    private String size;

    public Drink(String id, String name, double price, String size) {
        super(id, name, price);
        this.size = size;
    }

    @Override
    public double calculatePrice() {

        if(size.equalsIgnoreCase("L"))
            return getPrice() + 10000;

        if(size.equalsIgnoreCase("M"))
            return getPrice() + 5000;

        return getPrice();
    }

    @Override
    public String toString() {
        return super.toString() + " Size:" + size;
    }
}