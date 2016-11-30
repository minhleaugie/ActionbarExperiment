package com.example.actionbarexperiment;

/**
 * Created by minhle13 on 11/28/2016.
 */

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

public class DessertFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dessert, container, false);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.dessert_choice);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.ice_cream:
                        break;
                    case R.id.chocolate_cake:
                        break;

                }
            }
        });

        // Inflate the layout for this fragment
        return view;


    }
}
