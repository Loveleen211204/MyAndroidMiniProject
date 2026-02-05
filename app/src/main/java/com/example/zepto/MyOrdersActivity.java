package com.example.zepto;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class MyOrdersActivity extends BaseActivity {
    RecyclerView recyclerMyOrders;
    List<OrderModel> orderList;
    OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_myorders);

        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();}
        });

        recyclerMyOrders = findViewById(R.id.recycler_my_orders);
        recyclerMyOrders.setLayoutManager(new LinearLayoutManager(this));


        orderList = new ArrayList<>();
        List<Product> cartItems = CartManager.getInstance().getcartItems();

        String[] statuses = {"Pending", "On the Way", "Delivered", "Cancelled"};
        int[] progresses = {10, 50, 100, 0};

        int index = 0;
        for (Product product : cartItems) {
            String status = statuses[index % statuses.length];
            int progress = progresses[index % progresses.length];

            orderList.add(new OrderModel(
                    product.getName(),
                    "Price: " + product.getPrice(),
                    product.getImageResId(),
                    status,
                    progress));
            index++;
        }


        orderAdapter = new OrderAdapter(this, orderList);
        recyclerMyOrders.setAdapter(orderAdapter);
    }
}



