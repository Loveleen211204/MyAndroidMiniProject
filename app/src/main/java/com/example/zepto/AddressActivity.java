package com.example.zepto;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class AddressActivity extends BaseActivity {

    EditText etFirstName, etLastName, etAddress, etCity, etState, etZip;
    Button btnSubmit,btnDelete,btnAddNew;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        ImageView backArrow = findViewById(R.id.back_arrow);
        backArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();}
        });

        etFirstName = findViewById(R.id.etFirstName);
        etLastName = findViewById(R.id.etLastName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        etState = findViewById(R.id.etState);
        etZip = findViewById(R.id.etZip);
        btnSubmit = findViewById(R.id.btnSubmit);
        btnDelete = findViewById(R.id.btnDelete);
        btnAddNew = findViewById(R.id.btnAddNew);

        btnAddNew.setOnClickListener(v -> {
            // Clear all EditText fields
            etFirstName.setText("");
            etLastName.setText("");
            etAddress.setText("");
            etCity.setText("");
            etState.setText("");
            etZip.setText("");

            // Optionally show a toast or set focus
            Toast.makeText(this, "Form reset for new address", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
        });
        btnDelete.setOnClickListener(v -> {
            // Clear all EditText fields
            etFirstName.setText("");
            etLastName.setText("");
            etAddress.setText("");
            etCity.setText("");
            etState.setText("");
            etZip.setText("");

            // Optionally show a toast or set focus
            Toast.makeText(this, " Address Deleted", Toast.LENGTH_SHORT).show();
            etFirstName.requestFocus();
        });

        btnSubmit.setOnClickListener(v -> {
            String info = "Submitted:\n"
                    + etFirstName.getText() + " " + etLastName.getText() + "\n"
                    + etAddress.getText() + ", " + etCity.getText() + ", "
                    + etState.getText() + " - " + etZip.getText();

            Toast.makeText(this, info, Toast.LENGTH_LONG).show();
        });


    }
}
