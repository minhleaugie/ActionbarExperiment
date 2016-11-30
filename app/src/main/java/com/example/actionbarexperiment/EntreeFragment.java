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

public class EntreeFragment extends Fragment{

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_entree, container, false);

        RadioGroup radioGroup = (RadioGroup) view.findViewById(R.id.entree_choice);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.beef_steak:
                        break;
                    case R.id.chicken:
                        break;

                }
            }
        });


        // Inflate the layout for this fragment
        return view;
    }
}
