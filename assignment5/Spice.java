public class Spice implements Comparable<Spice> {

    public String name;
    public double price;
    public double quantity;
    public double unitPrice;

    public Spice(String name, String price, String quantity) {

        // Parse our strings into proper data types.
        this.name = name;
        this.price = Double.parseDouble(price);
        this.quantity = Double.parseDouble(quantity);
        this.unitPrice = this.price / this.quantity;
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

    public String toString() {
        return this.name + ": $" + this.unitPrice;
    }

}
