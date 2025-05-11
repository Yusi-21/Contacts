package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class ContactDetailActivity extends AppCompatActivity {
    private TextView tvName, tvPhone, tvEmail, tvAddress;
    private DatabaseHelper dbHelper;
    private Contact contact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_detail);

        dbHelper = new DatabaseHelper(this);
        loadContact();
        initViews();
        setupButtons();
    }

    private void loadContact() {
        int contactId = getIntent().getIntExtra("contact_id", -1);
        contact = dbHelper.getContactById(contactId);
    }

    private void initViews() {
        tvName = findViewById(R.id.tv_name);
        tvPhone = findViewById(R.id.tv_phone);
        tvEmail = findViewById(R.id.tv_email);
        tvAddress = findViewById(R.id.tv_address);

        if (contact != null) {
            displayContact();
        }
    }

    private void displayContact() {
        tvName.setText(contact.getName());
        tvPhone.setText(contact.getPhone());
        tvEmail.setText(contact.getEmail());
        tvAddress.setText(contact.getAddress());
    }

    private void setupButtons() {
        findViewById(R.id.btn_update).setOnClickListener(v -> updateContact());
        findViewById(R.id.btn_delete).setOnClickListener(v -> deleteContact());
    }

    private void updateContact() {
        Intent intent = new Intent(this, CreateContactActivity.class);
        intent.putExtra("contact_id", contact.getId());
        startActivity(intent);
    }

    private void deleteContact() {
        new AlertDialog.Builder(this)
                .setTitle("Delete this contact?")
                .setMessage("Are you sure?")
                .setPositiveButton("✅", (d, w) -> {
                    if (dbHelper.deleteContact(contact.getId())) {
                        finish();
                        Toast.makeText(this, "Contact deleted successfully ✅", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("❌", null)
                .show();
    }
}