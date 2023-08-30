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
    Cart cart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);

        cartLines = findViewById(R.id.cartLines);
        total = findViewById(R.id.total);


        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.TIRAMISU) {
            cart = getIntent().getSerializableExtra("data", Cart.class);
        } else {
            cart = null;
        }
        addLine(null, -1);
        assert cart != null;
        display();




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
            assert cartLine != null;
            qte.setText(String.valueOf(cartLine.getQuantity()));

            LinearLayout layout = new LinearLayout(this);
            layout.setOrientation(LinearLayout.HORIZONTAL);

            Button btnLess = new Button(this);
            btnLess.setText("-");

            btnLess.setOnClickListener(v -> {
                if (cartLine.getQuantity() > 1) {
                    cartLine.setQuantity(cartLine.getQuantity() - 1);
                } else {
                    cart.getCartLines().remove(cartLine);
                }
                cartLines.removeAllViews();
                display();
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

        addColumn(row, line, "UnitPrice", String.valueOf((cartLine != null) ? cartLine.getProduct().getPrice() : ""), new TextView(this));

        TextView actions = new TextView(this);

        if (line == -1) {
            actions.setText("Action");
            row.addView(actions);
        } else {
            Button btnDel = new Button(this);
            btnDel.setText("Delete");
            btnDel.setOnClickListener(v -> {
                cart.getCartLines().remove(cartLine);
                cartLines.removeAllViews();
                display();
            });
            row.addView(btnDel);
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

    private void display() {
        total.setText("Total: " + cart.getTotalPrice());
        cart.getCartLines().forEach(cartLine -> {
            addLine(cartLine, cart.getCartLines().indexOf(cartLine));
        });
    }
}