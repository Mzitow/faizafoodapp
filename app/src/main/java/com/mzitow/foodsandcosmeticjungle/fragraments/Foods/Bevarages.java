package com.mzitow.foodsandcosmeticjungle.fragraments.Foods;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mzitow.foodsandcosmeticjungle.R;
import com.mzitow.foodsandcosmeticjungle.adabters.CustomerFoodAdapter;
import com.mzitow.foodsandcosmeticjungle.adabters.WhatsNewAdapter;
import com.mzitow.foodsandcosmeticjungle.database.FoodProductEntity;
import com.mzitow.foodsandcosmeticjungle.database.UserDatabase;
import com.mzitow.foodsandcosmeticjungle.database.WhatsNewEntity;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link Bevarages#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Bevarages extends Fragment {
    RecyclerView beverages, whatsNew;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public Bevarages() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Bevarages.
     */
    // TODO: Rename and change types and number of parameters
    public static Bevarages newInstance(String param1, String param2) {
        Bevarages fragment = new Bevarages();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_bevarages, container, false);
    }
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        UserDatabase userDatabase = UserDatabase.getUserDatabase(getContext());
        List<FoodProductEntity> foodProductEntities = userDatabase.foodProductDao().getAllProductsList();
        beverages = view.findViewById(R.id.my_bavrecycler);
       beverages.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        CustomerFoodAdapter customerFoodAdapter = new CustomerFoodAdapter(foodProductEntities,getContext());
        beverages.setAdapter(customerFoodAdapter);

        // UserDatabase userDatabase = UserDatabase.getUserDatabase(getApplicationContext());
        List<WhatsNewEntity> whatsNewEntities = userDatabase.whatsNewDao().getAllProductsList();
        whatsNew = view.findViewById(R.id.my_newrecycler);
        whatsNew.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        WhatsNewAdapter whatsNewAdapter = new WhatsNewAdapter(whatsNewEntities);
        whatsNew.setAdapter(whatsNewAdapter);
    }
}