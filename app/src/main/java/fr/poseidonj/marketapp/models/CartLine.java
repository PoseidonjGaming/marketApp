package fr.poseidonj.marketapp.models;

public class CartLine extends BaseEntity{
    private Product product;
    private int quantity;
    public CartLine(int id, Product product, int quantity) {
        super(id);
        this.product = product;
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}
