package com.example.shopfun;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class BananaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_banana);

        // Инициализация всех элементов
        initViews();
    }

    private void initViews() {
        // Инициализация ListView
        ListView contentList = findViewById(R.id.content_list_banana);

        // Создаем массив данных (в данном случае просто заглушка)
        String[] items = new String[1];
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item " + (i + 1);
        }

        // Создаем адаптер и устанавливаем его для ListView
        BananaAdapter adapter = new BananaAdapter(this, items);
        contentList.setAdapter(adapter);

//        // Обработка нажатия на элемент ListView
//        contentList.setOnItemClickListener((parent, view, position, id) -> {
//            String selectedItem = (String) parent.getItemAtPosition(position);
//            Toast.makeText(this, "Selected: " + selectedItem, Toast.LENGTH_SHORT).show();
//        });

        // Кнопка "назад"
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Иконка "поделиться"
        ImageButton shareIcon = findViewById(R.id.share_icon);
        shareIcon.setOnClickListener(v -> showToast("Share clicked!"));

//        // Spinner для выбора килограммов
//        Spinner kilogramSpinner = findViewById(R.id.kilogram_spinner);
//        setupSpinner(kilogramSpinner);

        Button addToCatalogButton = findViewById(R.id.add_to_catalog_button);
        addToCatalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catalog.getInstance().addItem("Banana");
                Toast.makeText(BananaActivity.this, "Product added to catalog", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}