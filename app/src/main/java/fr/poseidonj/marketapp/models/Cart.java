package fr.poseidonj.marketapp.models;

import java.util.List;
import java.util.stream.Collectors;

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

    public List<Product> getProducts(){
        return cartLines.stream().map(CartLine::getProduct).collect(Collectors.toList());
    }

    public double getTotal(){
        return cartLines.stream().mapToDouble(value -> value.getProduct().getPrice()* value.getQuantity()).sum();
    }
}
