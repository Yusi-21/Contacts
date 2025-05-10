package com.example.shopfun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.FruitViewHolder> {

    private List<Fruit> fruits;
    private OnItemClickListener listener;

    // Интерфейс для обработки нажатий
    public interface OnItemClickListener {
        void onItemClick(Fruit fruit);
    }

    // Конструктор адаптера
    public FruitAdapter(List<Fruit> fruits, OnItemClickListener listener) {
        this.fruits = fruits;
        this.listener = listener;
    }

    @NonNull
    @Override
    public FruitViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) { // RecyclerView вызывает этот метод всякий раз, когда ему необходимо создать новый ViewHolder.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.fruit_item, parent, false);
        return new FruitViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FruitViewHolder holder, int position) { // RecyclerView вызывает этот метод, чтобы связать ViewHolder с данными.
        // Получаем два продукта для текущей строки
        Fruit leftFruit = fruits.get(position * 2);
        Fruit rightFruit = (position * 2 + 1 < fruits.size()) ? fruits.get(position * 2 + 1) : null;

        // Устанавливаем данные для левого продукта
        holder.imageLeft.setImageResource(leftFruit.getImageResId());
        holder.nameLeft.setText(leftFruit.getName());

        // Обработка нажатия на левый элемент
        holder.leftLayout.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(leftFruit);
            }
        });

        // Устанавливаем данные для правого продукта (если он есть)
        if (rightFruit != null) {
            holder.imageRight.setImageResource(rightFruit.getImageResId());
            holder.nameRight.setText(rightFruit.getName());
            holder.imageRight.setVisibility(View.VISIBLE);
            holder.nameRight.setVisibility(View.VISIBLE);

            // Обработка нажатия на правый элемент
            holder.rightLayout.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(rightFruit);
                }
            });
        } else {
            // Если правого продукта нет, скрываем правый блок
            holder.imageRight.setVisibility(View.GONE);
            holder.nameRight.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() { // RecyclerView вызывает этот метод, чтобы получить размер набора данных.
        // Количество строк = общее количество продуктов / 2 (округление вверх)
        return (fruits.size() + 1) / 2;
    }

    static class FruitViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLeft, imageRight;
        TextView nameLeft, nameRight;
        View leftLayout, rightLayout;

        public FruitViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLeft = itemView.findViewById(R.id.image_left_apple);
            nameLeft = itemView.findViewById(R.id.name_left_apple);
            imageRight = itemView.findViewById(R.id.image_right_ananas);
            nameRight = itemView.findViewById(R.id.name_right_ananas);

            // Находим контейнеры для левого и правого элементов
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
        }
    }
}