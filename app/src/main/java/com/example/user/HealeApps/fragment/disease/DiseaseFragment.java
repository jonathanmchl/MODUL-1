package com.example.user.HealeApps.fragment.disease;


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



public class DiseaseFragment extends Fragment {

    List<disease> homeList;

    ListView listView;

    public DiseaseFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_disease_layout, container, false);

        homeList = new ArrayList<>();
        listView = (ListView) view.findViewById(R.id.listView1);

        homeList.add(new disease(R.drawable.hiv , "HIV-AIDS", "HIV causes AIDS and interferes with the body's ability to fight infections.\n" +
                "The virus can be transmitted through contact with infected blood, semen or vaginal fluids.\n" +
                "Within a few weeks of HIV infection, flu-like symptoms such as fever, sore throat and fatigue can occur"));
        homeList.add(new disease(R.drawable.diare, "Diarrhea", "Diarrhea is loose, watery stools (bowel movements). You have diarrhea if you have loose stools three or more times in one day. Acute diarrhea is diarrhea that lasts a short time. It is a common problem. It usually lasts about one or two days, but it may last longer."));

        diseaseadapter adapter = new diseaseadapter(getActivity(), R.layout.item_list, homeList);

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