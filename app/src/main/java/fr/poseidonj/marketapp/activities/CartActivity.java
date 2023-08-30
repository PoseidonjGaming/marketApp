package fr.poseidonj.marketapp.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import org.w3c.dom.Text;

import fr.poseidonj.marketapp.R;
import fr.poseidonj.marketapp.models.Cart;
import fr.poseidonj.marketapp.models.CartLine;

public class CartActivity extends AppCompatActivity {
    TableLayout cartLines;
    TextView total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartLines = findViewById(R.id.cartLines);
        total = findViewById(R.id.total);

        Cart cart;
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            cart = getIntent().getSerializableExtra("data", Cart.class);
        } else {
            cart = null;
        }
        addLine(null, -1);
        assert cart != null;
        cart.getCartLines().forEach(cartLine -> {
            addLine(cartLine, cart.getCartLines().indexOf(cartLine));
        });

        total.setText("Total: " + cart.getTotalPrice());


    }

    private void addLine(CartLine cartLine, int line) {

        TableRow row = new TableRow(this);

        addColumn(row, line, "#", String.valueOf(line + 1), new TextView(this));

        addColumn(row, line, "Product", (cartLine != null) ? cartLine.getProduct().getDesc() : "", new TextView(this));

        TextView qte = new TextView(this);

        if (line == -1) {
            qte.setText("QTE");
            row.addView(qte);
        } else {
            qte.setText(String.valueOf(cartLine.getQuantity()));

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);

            Button btnLess = new Button(this);
            btnLess.setText("-");

            btnLess.setOnClickListener(v -> {

            });

            Button btnMore = new Button(this);
            btnMore.setText("+");

            btnMore.setOnClickListener(v -> {

            });


            layout.addView(btnLess);
            layout.addView(qte);
            layout.addView(btnMore);

            row.addView(layout);
        }

        cartLines.addView(row);

    }

    private void addColumn(TableRow row, int line, String toAdd, String orAdd, TextView textView) {
        if (line == -1)
            textView.setText(toAdd);
        else
            textView.setText(orAdd);

        row.addView(textView);
    }
}