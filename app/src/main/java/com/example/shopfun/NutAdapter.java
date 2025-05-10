package com.example.shopfun;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NutAdapter extends RecyclerView.Adapter<NutAdapter.NutViewHolder> {

    private List<Nut> nuts;

    public NutAdapter(List<Nut> nuts) {
        this.nuts = nuts;
    }

    @NonNull
    @Override
    public NutViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.nut_item, parent, false);
        return new NutViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull NutViewHolder holder, int position) {
        // Получаем два продукта для текущей строки
        Nut leftNut = nuts.get(position * 2);
        Nut rightNut = (position * 2 + 1 < nuts.size()) ? nuts.get(position * 2 + 1) : null;

        // Устанавливаем данные для левого продукта
        holder.imageLeft.setImageResource(leftNut.getImageResId());
        holder.nameLeft.setText(leftNut.getName());

        // Устанавливаем данные для правого продукта (если он есть)
        if (rightNut != null) {
            holder.imageRight.setImageResource(rightNut.getImageResId());
            holder.nameRight.setText(rightNut.getName());
            holder.imageRight.setVisibility(View.VISIBLE);
            holder.nameRight.setVisibility(View.VISIBLE);
        } else {
            // Если правого продукта нет, скрываем правый блок
            holder.imageRight.setVisibility(View.GONE);
            holder.nameRight.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        // Количество строк = общее количество продуктов / 2 (округление вверх)
        return (nuts.size() + 1) / 2;
    }

    static class NutViewHolder extends RecyclerView.ViewHolder {
        ImageView imageLeft, imageRight;
        TextView nameLeft, nameRight;

        public NutViewHolder(@NonNull View itemView) {
            super(itemView);
            imageLeft = itemView.findViewById(R.id.image_left_apricot_pit);
            nameLeft = itemView.findViewById(R.id.name_left_apricot_pit);
            imageRight = itemView.findViewById(R.id.image_right_nuts);
            nameRight = itemView.findViewById(R.id.name_right_nuts);
        }
    }
}