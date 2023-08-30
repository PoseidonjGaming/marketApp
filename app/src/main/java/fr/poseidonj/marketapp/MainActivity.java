package fr.poseidonj.marketapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

import fr.poseidonj.marketapp.activities.AddToCartActivity;
import fr.poseidonj.marketapp.utils.Utils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void exoCart(View view) {
        startActivity(Utils.startIntent(this, AddToCartActivity.class));
    }
}