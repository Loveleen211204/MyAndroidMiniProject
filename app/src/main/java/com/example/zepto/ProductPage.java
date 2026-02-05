package com.example.zepto;

import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberFormattingTextWatcher;
import android.text.Editable;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;

public class ProductPage extends BaseActivity {


    private EditText searchbar;
    private ImageView profileIcon;
    private RecyclerView recyclerview;
    private ProductAdapter productAdapter;
    private List<Product> productList;
    private List<Product> filteredList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_page);

        recyclerview = findViewById(R.id.recyclerview);
        searchbar = findViewById(R.id.search_bar);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        profileIcon=findViewById(R.id.profile);

        recyclerview.setLayoutManager(new GridLayoutManager(this, 3));
        productList = new ArrayList<>();
        productList.add(new Product("Fortune Sunflower", R.drawable.ata, " ₹167", "₹190", "1kg", "Nutritious and high-fiber Sunflower Atta for soft and healthy rotis. Milled from premium quality grains to ensure freshness and purity in every pack."));
        productList.add(new Product("Amul Milk", R.drawable.amul_milk, "₹50", "₹75", "500ml","Fresh and pure Amul Milk, rich in calcium and protein to keep your family healthy. Ideal for drinking, tea, coffee, and cooking. Enjoy the goodness of nature in every drop."));
        productList.add(new Product("Amul Butter", R.drawable.butter, "₹40", "₹55", "0.5kg","The classic Amul Butter with its rich, creamy taste and smooth texture. Perfect for spreading on bread, cooking, and baking. “Utterly Butterly Delicious!”"));
        productList.add(new Product("Lays", R.drawable.lays, "₹50", "₹60", "2 packets","Crispy, crunchy potato chips with irresistible flavors. Perfect for sharing with friends or snacking solo. Open a pack and bring home the fun!"));
        productList.add(new Product("Noodles", R.drawable.noodles, "₹65", "₹100", "1 packet", "Quick and tasty instant noodles for a delicious snack anytime. Flavored with aromatic spices for a satisfying, warm bowl in just 2 minutes."));
        productList.add(new Product("Haldiram Rasgulla", R.drawable.rasgulla, "₹205", "₹250", "1kg","Soft, spongy, and juicy Rasgullas made from premium quality ingredients. A traditional Bengali sweet that melts in your mouth with every bite."));

        filteredList = new ArrayList<>(productList);
        productAdapter = new ProductAdapter(this, filteredList);
        recyclerview.setAdapter(productAdapter);

        searchbar.addTextChangedListener(new PhoneNumberFormattingTextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int count, int before) {
                filterProducts(s.toString());
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int itemId = item.getItemId();
                if (itemId == R.id.nav_back) {
                    startActivity(new Intent(ProductPage.this, ProductPage.class));
                    return true;
                } else if (itemId == R.id.nav_categories) {
                    startActivity(new Intent(ProductPage.this, CategoryActivity.class));
                    return true;
                }
                else if (itemId == R.id.nav_apparel) {
                    startActivity(new Intent(ProductPage.this, Apparel.class));
                    return true;
                }
                else if (itemId == R.id.nav_cart) {
                    startActivity(new Intent(ProductPage.this, CartActivity.class));
                    return true;
                }
                return false;
            }

        });
        profileIcon.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent=new Intent(ProductPage.this,SettingsActivity.class);
                startActivity(intent);
            }
        });
    }
        private void filterProducts(String query){
        filteredList.clear();
        if(query.isEmpty()){
            filteredList.addAll(productList);
        }else{
            for(Product product:productList){
                if(product.getName().toLowerCase().contains(query.toLowerCase())){
                    filteredList.add(product);
                }
            }
        }
    }
}
