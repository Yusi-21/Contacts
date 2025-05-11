package com.example.contacts;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.PopupMenu;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ContactsActivity extends AppCompatActivity {
    private RecyclerView rvContacts;
    private ContactAdapter adapter;
    private DatabaseHelper dbHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacts);

        dbHelper = new DatabaseHelper(this);
        rvContacts = findViewById(R.id.rv_contacts);
        rvContacts.setLayoutManager(new LinearLayoutManager(this));

        AuthManager authManager = new AuthManager(this);
        if (!authManager.isLoggedIn()) {
            startActivity(new Intent(this, LoginActivity.class));
            finish();
            return;
        }

        setupToolbar();
        loadContacts();
    }

    private void setupToolbar() {
        findViewById(R.id.btn_create).setOnClickListener(v -> {
            startActivity(new Intent(this, CreateContactActivity.class));
        });

        findViewById(R.id.btn_search).setOnClickListener(v -> showSearchDialog());
        findViewById(R.id.btn_settings).setOnClickListener(v -> {
            showSettingsMenu();
        });
    }

    private void loadContacts() {
        List<Contact> contacts = dbHelper.getAllContacts();
        adapter = new ContactAdapter(contacts, this::onContactClick);
        rvContacts.setAdapter(adapter);
    }

    private void onContactClick(Contact contact) {
        Intent intent = new Intent(this, ContactDetailActivity.class);
        intent.putExtra("contact_id", contact.getId());
        startActivity(intent);
    }

    private void showSearchDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Search contact \uD83D\uDD0D");

        // Create field for search contacts by name or phone number
        final EditText input = new EditText(this);
        input.setHint("    Enter Name or Phone number");
        builder.setView(input);

        builder.setPositiveButton("\uD83D\uDD0D", (dialog, which) -> {
            String query = input.getText().toString().trim();
            if (!query.isEmpty()) {
                searchContacts(query);

            }
        });

        builder.setNegativeButton("❌", null);
        builder.show();
    }

    // For search contacts
    private void searchContacts(String query) {
        List<Contact> foundContacts = dbHelper.searchContacts(query);
        if (foundContacts.isEmpty()) {
            Toast.makeText(this, "Contact not found \uD83E\uDD37\u200D♂\uFE0F", Toast.LENGTH_SHORT).show();
        } else {
            adapter = new ContactAdapter(foundContacts, this::onContactClick);
            rvContacts.setAdapter(adapter);
        }
    }

    // For show settings menu
    private void showSettingsMenu() {
        PopupMenu popup = new PopupMenu(this, findViewById(R.id.btn_settings));
        popup.getMenuInflater().inflate(R.menu.settings_menu, popup.getMenu());

        popup.setOnMenuItemClickListener(item -> {
            if (item.getItemId() == R.id.menu_logout) {
                new AuthManager(this).logout();
                startActivity(new Intent(this, LoginActivity.class));
                finish();
                return true;
            }
            return false;
        });

        popup.show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        loadContacts(); // Update list of contacts(список) when you come back
    }
}