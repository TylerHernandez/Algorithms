public class Spice implements Comparable<Spice> {

    public String name;
    public double price;
    public double quantity;
    public double unitPrice;

    public Spice(String name, double price, double quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
        this.unitPrice = price / quantity;
    }

    @Override
    public int compareTo(Spice spice) {
        if (this.unitPrice > spice.unitPrice) {
            return 1;
        } else if (this.unitPrice == spice.unitPrice) {
            return 0;
        } else {
            return -1;
        }
    }

}
