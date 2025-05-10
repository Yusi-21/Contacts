package com.example.shopfun;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ThanksActivity extends AppCompatActivity {

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_thanks);

        // Находим Spinner и TextView
        Spinner spinnerName = findViewById(R.id.allAboutUs);
//        TextView selectedName = findViewById(R.id.selectedName);

        // Получаем массив имен пользователей
        String[] allAbout = getResources().getStringArray(R.array.aboutUs);

        // Создаем адаптер для Spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this,
                android.R.layout.simple_spinner_item, allAbout);

        // Устанавливаем стиль для выпадающего списка
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // Привязываем адаптер к Spinner
        spinnerName.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.thanks_text), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    public void onBackPressed() {
        // Показываем диалог подтверждения
//        new AlertDialog.Builder(this)
//                .setTitle("Quit")
//                .setMessage("Are you sure, that you want to quit?")
//                .setPositiveButton("Yes", (dialog, which) -> {
//                    super.onBackPressed(); // Закрываем активность
//                })
//                .setNegativeButton("No", null)
//                .show();

        super.onBackPressed();
        finishAffinity();
        System.exit(2);
    }
}