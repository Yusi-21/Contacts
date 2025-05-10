package com.example.shopfun;

import android.content.Intent;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;

public class FruitsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_fruits, container, false);

        // Создаем список фруктов
        List<Fruit> fruits = new ArrayList<>();
        fruits.add(new Fruit(R.drawable.fruit_apple, "Apple", AppleActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_ananas, "Ananas", AnanasActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_apricot, "Apricot", ApricotActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_banana, "Banana", BananaActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_berry, "Berry", BerryActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_blueberry, "Blueberry", BlueberryActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_cherry, "Cherry", CherryActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_grape, "Grape", GrapeActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_kiwi, "Kiwi", KiwiActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_limon, "Limon", LimonActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_orange, "Orange", OrangeActivity.class));
        fruits.add(new Fruit(R.drawable.fruit_pear, "Pear", PearActivity.class));

        // Находим RecyclerView и настраиваем его
        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_fruits);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1)); // 1 колонка

        // Создаем адаптер и передаем в него список фруктов
//        FruitAdapter adapter = new FruitAdapter(fruits, new FruitAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(Fruit fruit) {
//                // Обработка нажатия на элемент списка
//                if (fruit.getName().equals("Apple")) {
//                    // Переход на AppleActivity
//                    Intent intent = new Intent(getActivity(), AppleActivity.class);
//                    startActivity(intent);
//                    getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
//                }
//            }
//        });

        FruitAdapter adapter = new FruitAdapter(fruits, new FruitAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Fruit fruit) {
                // Обработка нажатия на элемент списка
                Intent intent = new Intent(getActivity(), fruit.getTargetActivity());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);
            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}