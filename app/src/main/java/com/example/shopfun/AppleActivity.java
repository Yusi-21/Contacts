package com.example.shopfun;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;

public class AppleActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_apple);

        // Инициализация всех элементов
        initViews();
    }

    private void initViews() {
        // Инициализация ListView
        ListView contentList = findViewById(R.id.content_list);

        // Создаем массив данных (в данном случае просто заглушка)
        String[] items = new String[1];
        for (int i = 0; i < items.length; i++) {
            items[i] = "Item " + (i + 1);
        }

        // Создаем адаптер и устанавливаем его для ListView
        AppleAdapter adapter = new AppleAdapter(this, items);
        contentList.setAdapter(adapter);

        // Кнопка "назад"
        ImageButton backButton = findViewById(R.id.back_button);
        backButton.setOnClickListener(v -> finish());

        // Иконка "поделиться"
        ImageButton shareIcon = findViewById(R.id.share_icon);
        shareIcon.setOnClickListener(v -> showToast("Share clicked!"));

        // Кнопка "добавить в каталог"
        Button addToCatalogButton = findViewById(R.id.add_to_catalog_button);
        addToCatalogButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Catalog.getInstance().addItem("Apple");
                Toast.makeText(AppleActivity.this, "Product added to catalog", Toast.LENGTH_SHORT).show();
            }
        });
//        initSpinner();
    }

//    private void initSpinner() {
//        // Находим Spinner и TextView
//        Spinner spinnerName = findViewById(R.id.kilogram_spinner_apple);
//        TextView selectedName = findViewById(R.id.selectedNameApple);
//
//        // Получаем массив опций
//        String[] allAbout = getResources().getStringArray(R.array.kilogram_options_all);
//
//        // Создаем адаптер для Spinner
//        ArrayAdapter<String> spinAdapter = new ArrayAdapter<>(this,
//                android.R.layout.simple_spinner_item, allAbout);
//
//        // Устанавливаем стиль для выпадающего списка
//        spinAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
//
//        // Привязываем адаптер к Spinner
//        spinnerName.setAdapter(spinAdapter);
//
//        // Обработка выбора элемента в Spinner
//        spinnerName.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
//            @Override
//            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
//                // Получаем выбранное значение
//                String selectedItem = allAbout[position];
//
//                // Отображаем выбранное значение в TextView
//                selectedName.setText("Выбрано: " + selectedItem);
//            }
//
//            @Override
//            public void onNothingSelected(AdapterView<?> parent) {
//                // Если ничего не выбрано
//                selectedName.setText("Выбрано: ничего");
//            }
//        });
//    }
    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}