package fr.poseidonj.marketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import fr.poseidonj.marketapp.R;
import fr.poseidonj.marketapp.models.Product;

public class AddToCartActivity extends AppCompatActivity {

    TextView txtProduct, txtQTE;
    Spinner spinnerProduct;
    EditText inputQTE;
    Button btnAdd, btnSeeCart;

    ArrayAdapter<Product> productArrayAdapter;
    List<Product> products;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_cart);

        products=new ArrayList<>(Arrays.asList(
                new Product(1,"RTX 4090", 1799.90),
                new Product(1,"RTX 4070", 669.99),
                new Product(1,"RTX 4060", 369.99),
                new Product(1,"RTX 2060", 299.90)
        ));

        txtProduct=findViewById(R.id.txtProduct);
        txtQTE=findViewById(R.id.txtQTE);

        spinnerProduct=findViewById(R.id.spinnerProduct);

        inputQTE=findViewById(R.id.inputQTE);

        btnAdd=findViewById(R.id.btnAdd);
        btnSeeCart=findViewById(R.id.btnSeeCart);

        productArrayAdapter=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,products);
        spinnerProduct.setAdapter(productArrayAdapter);
    }

    public void btnAddClick(View view) {
    }

    public void btnSeeCartClick(View view) {
    }
}