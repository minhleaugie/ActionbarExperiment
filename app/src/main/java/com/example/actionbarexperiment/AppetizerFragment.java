package com.example.actionbarexperiment;

/**
 * Created by minhle13 on 11/28/2016.
 */

import android.content.Context;
import android.content.SharedPreferences;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;
import android.widget.RadioButton;

public class AppetizerFragment extends Fragment{
    private RadioGroup radioGroup;
    private final String KEY_SAVED_RADIO_BUTTON_INDEX = "SAVED_RADIO_BUTTON_INDEX";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_appetizer, container, false);

        radioGroup = (RadioGroup) view.findViewById(R.id.appetizer_choice);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                switch (checkedId) {
                    case R.id.fries:
                        break;
                    case R.id.potato:
                        break;
                    case R.id.taco:
                        break;
                }
                RadioButton checkedRadioButton = (RadioButton)radioGroup.findViewById(checkedId);
                int checkedIndex = radioGroup.indexOfChild(checkedRadioButton);
                SavePreferences(KEY_SAVED_RADIO_BUTTON_INDEX, checkedIndex);
            }
        });

        LoadPreferences();


        // Inflate the layout for this fragment
        return view;
    }

    // These methods are originally from the article "SharedPreferences.Editor for RadioButton in RadioGroup" of "Android-er" blog

    private void SavePreferences(String key, int value){
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putInt(key, value);
        editor.commit();
    }

    private void LoadPreferences() {
        Context context = getActivity();
        SharedPreferences sharedPref = context.getSharedPreferences("MY_SHARED_PREF", Context.MODE_PRIVATE);
        int savedRadioIndex = sharedPref.getInt(KEY_SAVED_RADIO_BUTTON_INDEX, 0);
        RadioButton savedCheckedRadioButton = (RadioButton)radioGroup.getChildAt(savedRadioIndex);
        savedCheckedRadioButton.setChecked(true);
    }
}
