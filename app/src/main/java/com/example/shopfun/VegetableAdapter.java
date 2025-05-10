package com.example.shopfun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class VegetableAdapter extends RecyclerView.Adapter<VegetableAdapter.VegetableViewHolder> {

    private List<Vegetable> vegetables;

    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Vegetable vegetable);
    }

    public VegetableAdapter(List<Vegetable> vegetables, OnItemClickListener listener) {
        this.vegetables = vegetables;
        this.listener = listener;
    }

    @NonNull
    @Override
    public VegetableViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.vegetable_item, parent, false);
        return new VegetableViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull VegetableViewHolder holder, int position) {
        // Получаем два продукта для текущей строки
        Vegetable leftVegetable = vegetables.get(position * 2);
        Vegetable rightVegetable = (position * 2 + 1 < vegetables.size()) ? vegetables.get(position * 2 + 1) : null;

        // Устанавливаем данные для левого продукта
        holder.imageLeft.setImageResource(leftVegetable.getImageResId());
        holder.nameLeft.setText(leftVegetable.getName());

        holder.leftLayout.setOnClickListener(v -> {
            if (listener != null) {
                listener.onItemClick(leftVegetable);
            }
        });

        // Устанавливаем данные для правого продукта (если он есть)
        if (rightVegetable != null) {
            holder.imageRight.setImageResource(rightVegetable.getImageResId());
            holder.nameRight.setText(rightVegetable.getName());
            holder.imageRight.setVisibility(View.VISIBLE);
            holder.nameRight.setVisibility(View.VISIBLE);

            // Обработка нажатия на правый элемент
            holder.rightLayout.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onItemClick(rightVegetable);
                }
            });
        } else {
            // Если правого продукта нет, скрываем правый блок
            holder.imageRight.setVisibility(View.GONE);
            holder.nameRight.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        // Количество строк = общее количество продуктов / 2 (округление вверх)
        return (vegetables.size() + 1) / 2;
    }

    static class VegetableViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLeft, imageRight;
        TextView nameLeft, nameRight;
        View leftLayout, rightLayout;

        public VegetableViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLeft = itemView.findViewById(R.id.image_left_cabbage);
            nameLeft = itemView.findViewById(R.id.name_left_cabbage);
            imageRight = itemView.findViewById(R.id.image_right_carrot);
            nameRight = itemView.findViewById(R.id.name_right_carrot);

            // Находим контейнеры для левого и правого элементов
            leftLayout = itemView.findViewById(R.id.left_layout);
            rightLayout = itemView.findViewById(R.id.right_layout);
        }
    }
}
