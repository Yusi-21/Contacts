package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {
    private EditText etUsername, etPhone;
    private Button btnLogin;
    private AuthManager authManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        authManager = new AuthManager(this);
        if (authManager.isLoggedIn()) {
            startActivity(new Intent(this, ContactsActivity.class));
            finish();
            return;
        }

        etUsername = findViewById(R.id.et_username);
        etPhone = findViewById(R.id.et_phone);
        btnLogin = findViewById(R.id.btn_login);

        btnLogin.setOnClickListener(v -> {
            String username = etUsername.getText().toString().trim();
            String phone = etPhone.getText().toString().trim();

            if (validateInput(username, phone)) {
                authManager.login(username, phone);
                startContactsActivity();
                finish();
            }
        });
    }

    private boolean validateInput(String username, String phone) {
        if (username.isEmpty() || phone.isEmpty()) {
            Toast.makeText(this, "Please fill all fields!", Toast.LENGTH_SHORT).show();
            return false;
        }
        if (!phone.matches("\\+?\\d{10,15}")) {
            Toast.makeText(this, "Incorrect phone number", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void startContactsActivity() {
        startActivity(new Intent(this, ContactsActivity.class));
    }

    private void handleLogin() {
        String username = etUsername.getText().toString().trim();
        String phone = etPhone.getText().toString().trim();

        if (validateInput(username, phone)) {
            authManager.login(username, phone);
            startActivity(new Intent(this, ContactsActivity.class));
            finish(); // Закрываем LoginActivity
        }
    }
}