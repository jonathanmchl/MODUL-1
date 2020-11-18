package com.example.user.HealeApps.fragment.about;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.user.HealeApps.R;
import com.example.user.HealeApps.fragment.medicine.DetailActivity;

import java.util.ArrayList;
import java.util.List;



public class aboutFragment extends Fragment {

    List<about> homeList;

    ListView listView;

    public aboutFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        homeList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView1);

        homeList.add(new about(R.drawable.jo, "Jonathan Michael", "1817051064"));
        homeList.add(new about(R.drawable.zia, "Zia Danisvara Pakpahan", "1817051067"));
        homeList.add(new about(R.drawable.nia, "Nia Nur Atika", "1817051015"));
        aboutadapter adapter = new aboutadapter(getActivity(), R.layout.item_list, homeList);

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