package com.example.shopfun;

import android.content.Intent;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.List;

public class CatalogActivity extends AppCompatActivity {
    private ListView catalogListView;
    private ArrayAdapter<String> adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_catalog);

        // Кнопка "назад"
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Иконка "поделиться"
        ImageButton shareIcon = findViewById(R.id.share_icon);
        shareIcon.setOnClickListener(v -> showToast("Share clicked!"));

        catalogListView = findViewById(R.id.catalog_list_view);

        // Получаем список выбранных товаров
        List<String> selectedItems = Catalog.getInstance().getSelectedItems();

        // Настраиваем адаптер для ListView
        adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, selectedItems);
        catalogListView.setAdapter(adapter);

        // Обработка удаления товара
        catalogListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String item = selectedItems.get(position);
                Catalog.getInstance().removeItem(item); // Удаляем товар
                adapter.notifyDataSetChanged(); // Обновляем список
                Toast.makeText(CatalogActivity.this, "Product removed from catalog: " + item, Toast.LENGTH_SHORT).show();
            }
        });

        // Находим кнопку "Pay"
        Button payButton = findViewById(R.id.pay_btn);

        payButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создаем Intent для перехода на ThanksActivity
                Intent intent = new Intent(CatalogActivity.this, ThanksActivity.class);
                startActivity(intent);
                Toast.makeText(CatalogActivity.this, "Paid Successful!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}