package com.example.shopfun;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AppleAdapter extends ArrayAdapter<String> {

    private Context context;
    private String[] items;

    public AppleAdapter(Context context, String[] items) {
        super(context, R.layout.item_content_apple, items);
        this.context = context;
        this.items = items;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.item_content_apple, parent, false);

        // Находим элементы в макете
//        ImageView imageApple = rowView.findViewById(R.id.image_apple);
//        TextView priceLabel = rowView.findViewById(R.id.price);
//        TextView priceValue = rowView.findViewById(R.id.price_value);
//        TextView descriptionText = rowView.findViewById(R.id.description_text);

//        // Устанавливаем значения
//        imageApple.setImageResource(R.drawable.fruit_apple); // Установите ваше изображение
//        priceLabel.setText("Price (1 kg):");
//        priceValue.setText("$1.89");
//        descriptionText.setText(context.getString(R.string.apple));

        return rowView;
    }
}
