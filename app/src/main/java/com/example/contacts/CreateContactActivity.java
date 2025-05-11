package com.example.contacts;

import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class CreateContactActivity extends AppCompatActivity {
    private EditText etName, etPhone, etEmail, etAddress;
    private DatabaseHelper dbHelper;
    private boolean isEditMode = false;
    private Contact existingContact;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact);

        dbHelper = new DatabaseHelper(this);
        initViews();
        checkEditMode();
        setupButtons();
    }

    private void initViews() {
        etName = findViewById(R.id.et_name);
        etPhone = findViewById(R.id.et_phone);
        etEmail = findViewById(R.id.et_email);
        etAddress = findViewById(R.id.et_address);
    }

    private void checkEditMode() {
        int contactId = getIntent().getIntExtra("contact_id", -1);
        if (contactId != -1) {
            isEditMode = true;
            existingContact = dbHelper.getContactById(contactId);
            if (existingContact != null) {
                fillContactData();
            }
        }
    }

    private void fillContactData() {
        etName.setText(existingContact.getName());
        etPhone.setText(existingContact.getPhone());
        etEmail.setText(existingContact.getEmail());
        etAddress.setText(existingContact.getAddress());
    }

    private void setupButtons() {
        findViewById(R.id.btn_save).setOnClickListener(v -> saveContact());
        findViewById(R.id.btn_cancel).setOnClickListener(v -> finish());
    }

    private void saveContact() {
        if (validateInput()) {
            if (isEditMode) {
                updateContact();
            } else {
                createContact();
            }
        }
    }

    private boolean validateInput() {
        // Realization validation
        return true;
    }

    private void createContact() {
        Contact contact = new Contact(
                0,
                etName.getText().toString(),
                etPhone.getText().toString(),
                etEmail.getText().toString(),
                etAddress.getText().toString()
        );

        if (dbHelper.addContact(contact)) {
            finish();
        }
    }

    private void updateContact() {
        existingContact.setName(etName.getText().toString());
        existingContact.setPhone(etPhone.getText().toString());
        existingContact.setEmail(etEmail.getText().toString());
        existingContact.setAddress(etAddress.getText().toString());

        if (dbHelper.updateContact(existingContact)) {
            finish();
        }
    }
}