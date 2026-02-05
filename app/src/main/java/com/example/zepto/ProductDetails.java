package com.example.zepto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class ProductDetails extends BaseActivity {

    ImageView productImage;
    TextView productName, productPrice, productMrp, productQuantity, productDescription;
    Button addToCart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.product_details);


        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();}
        });


        productImage = findViewById(R.id.product_detail_image);
        productName = findViewById(R.id.product_detail_name);
        productPrice = findViewById(R.id.product_detail_price);
        productMrp = findViewById(R.id.product_detail_mrp);
        productQuantity = findViewById(R.id.product_detail_quantity);
        productDescription = findViewById(R.id.product_detail_description);
        addToCart = findViewById(R.id.product_detail_add_to_cart);


        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            productImage.setImageResource(bundle.getInt("image"));
            productName.setText(bundle.getString("name"));
            productPrice.setText(bundle.getString("price"));
            productMrp.setText("MRP: " + bundle.getString("mrp"));
            productQuantity.setText(bundle.getString("quantity"));
            productDescription.setText(bundle.getString("description"));
        }
        addToCart.setOnClickListener(v -> addToCart());
    }
    private void addToCart() {
        Bundle bundle = getIntent().getExtras();
        if (bundle != null) {
            Product product = new Product(
                    bundle.getString("name"),
                    bundle.getInt("image"),
                    bundle.getString("price"),
                    bundle.getString("mrp"),
                    bundle.getString("quantity"),
                    bundle.getString("description")
            );
            CartManager cartManager = CartManager.getInstance();
            cartManager.addToCart(product);
            Toast.makeText(this, product.getName() + " added to cart!",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

