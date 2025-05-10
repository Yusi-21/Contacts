package com.example.shopfun;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class NutsFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_nuts, container, false);

        List<Nut> nuts = new ArrayList<>();
        nuts.add(new Nut(R.drawable.nut_apricot_pit, "Apricot Pit"));
        nuts.add(new Nut(R.drawable.nut_nuts, "Nuts"));
        nuts.add(new Nut(R.drawable.nut_pistachio, "Pistachio"));
        nuts.add(new Nut(R.drawable.nut_walnut, "Walnut"));

        RecyclerView recyclerView = view.findViewById(R.id.recycler_view_nuts);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 1));
        NutAdapter adapter = new NutAdapter(nuts);
        recyclerView.setAdapter(adapter);
        return view;
    }
}