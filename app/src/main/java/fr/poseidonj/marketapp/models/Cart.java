package fr.poseidonj.marketapp.models;

import java.util.List;

public class Cart extends BaseEntity{
    private List<CartLine> cartLines;
    public Cart(int id, List<CartLine> cartLines) {
        super(id);
        this.cartLines = cartLines;
    }

    public List<CartLine> getCartLines() {
        return cartLines;
    }

    public void setCartLines(List<CartLine> cartLines) {
        this.cartLines = cartLines;
    }
}
