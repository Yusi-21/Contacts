package com.example.shopfun;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class VegetablesFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_vegetables, container, false);

        List<Vegetable> vegetables = new ArrayList<>();
        vegetables.add(new Vegetable(R.drawable.vegetable_cabbage, "Cabbage", CabbageActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_carrot, "Carrot", CarrotActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_cucumber, "Cucumber", CucumberActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_garlic, "Garlic", GarlicActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_melon, "Melon", MelonActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_onion, "Onion", OnionActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_pepper, "Pepper", PepperActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_potato, "Potato", PotatoActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_tomato, "Tomato", TomatoActivity.class));
        vegetables.add(new Vegetable(R.drawable.vegetable_watermelon, "Watermelon", WatermelonActivity.class));

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_vegetables);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));

        // Создаем адаптер и передаем в него список фруктов
        VegetableAdapter adapter = new VegetableAdapter(vegetables, new VegetableAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(Vegetable vegetable) {
                Intent intent = new Intent(getActivity(), vegetable.getTargetActivity());
                startActivity(intent);
                getActivity().overridePendingTransition(R.anim.slide_in_right, R.anim.slide_out_left);

            }
        });

        recyclerView.setAdapter(adapter);
        return view;
    }
}
