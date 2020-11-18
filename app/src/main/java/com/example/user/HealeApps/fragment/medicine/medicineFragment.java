package com.example.user.HealeApps.fragment.medicine;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.HealeApps.R;

import java.util.ArrayList;
import java.util.List;



public class medicineFragment extends Fragment {

    List<medicine> homeList;

    ListView listView;

    public medicineFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_medicine_layout, container, false);

        homeList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView1);

        homeList.add(new medicine(R.drawable.panadol, "PANADOL", "Parasetamol atau asetaminofen adalah obat analgesik dan antipiretik yang populer dan digunakan untuk meredakan sakit kepala dan nyeri ringan, serta demam. Obat digunakan sebagian besar sebagai obat resep untuk analgesik dan flu"));
        homeList.add(new medicine(R.drawable.simvastatin, "SIMVASTATIN", "Simvastatin adalah jenis obat yang berfungsi untuk menurunkan kolesterol yang memiliki efek samping berupa meningkatnya timbulnya katarak atau malah memperburuk keadaan katarak bagi penderitanya"));

        medicineadapter adapter = new medicineadapter(getActivity(), R.layout.item_list, homeList);

        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                int image =  homeList.get(position).image;
                String title =  homeList.get(position).title;
                System.out.println(image);
                Intent myIntent = new Intent(view.getContext(), DetailActivity.class);
                myIntent.putExtra("image", image);
                myIntent.putExtra("title", title);
                myIntent.putExtra("desc", homeList.get(position).desc);
                startActivityForResult(myIntent, 0);
            }
        });
        return view;
    }

}