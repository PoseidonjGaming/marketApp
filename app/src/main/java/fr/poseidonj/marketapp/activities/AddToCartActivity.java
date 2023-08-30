package fr.poseidonj.marketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.poseidonj.marketapp.R;
import fr.poseidonj.marketapp.models.Cart;
import fr.poseidonj.marketapp.models.CartLine;
import fr.poseidonj.marketapp.models.Product;
import fr.poseidonj.marketapp.utils.Utils;

public class AddToCartActivity extends AppCompatActivity {

    TextView txtProduct, txtQTE;
    Spinner spinnerProduct;
    EditText inputQTE;
    Button btnAdd, btnSeeCart;

    ArrayAdapter<Product> productArrayAdapter;
    List<Product> products;
    int intCurrentProduct;
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        cart = new Cart(1, new ArrayList<>());

        products = new ArrayList<>(Arrays.asList(
                new Product(1, "RTX 4090", 1799.90),
                new Product(1, "RTX 4070", 669.99),
                new Product(1, "RTX 4060", 369.99),
                new Product(1, "RTX 2060", 299.90)
        ));

        txtProduct = findViewById(R.id.txtProduct);
        txtQTE = findViewById(R.id.txtQTE);

        spinnerProduct = findViewById(R.id.spinnerProduct);

        inputQTE = findViewById(R.id.inputQTE);

        btnAdd = findViewById(R.id.btnAdd);
        btnSeeCart = findViewById(R.id.btnSeeCart);

        productArrayAdapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, products);
        spinnerProduct.setAdapter(productArrayAdapter);
        spinnerProduct.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                intCurrentProduct = position;
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                intCurrentProduct = 0;
            }
        });
    }

    public void btnAddClick(View view) {

        Product currentProduct = products.get(intCurrentProduct);
        int qte = Integer.parseInt(inputQTE.getText().toString());
        if(!cart.getProducts().contains(currentProduct)){
            cart.getCartLines().add(new CartLine(cart.getCartLines().size() + 1, currentProduct, qte));
            btnSeeCart.setText("Voir le panier (" + cart.getCartLines().size() + ")");
        }

    }

    public void btnSeeCartClick(View view) {
        startActivity(Utils.startIntentWithBundle(this, CartActivity.class, cart));
    }
}