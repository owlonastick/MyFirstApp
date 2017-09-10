package com.example.greg.myfirstapp;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    TextView helloTextView;
    ToggleButton visibilityButton;
    SeekBar opacityBar;
    RadioGroup colorButtons;
    RadioButton red, blue, green, black;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        helloTextView = (TextView)findViewById(R.id.helloTextView);
        visibilityButton = (ToggleButton)findViewById(R.id.visibilityButton);
        opacityBar = (SeekBar)findViewById(R.id.seekBar);

        visibilityButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (helloTextView.getVisibility()== View.VISIBLE) {
                    helloTextView.setVisibility(View.INVISIBLE);
                } else {
                    helloTextView.setVisibility(View.VISIBLE);
                }
            }
        });

        opacityBar.setProgress(100);
        opacityBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
             @Override
             public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                 System.out.println(progress);
                 helloTextView.setAlpha(progress / 100f);
             }

             @Override
             public void onStartTrackingTouch(SeekBar seekBar) {

             }

             @Override
             public void onStopTrackingTouch(SeekBar seekBar) {

             }
         }

        );

        colorButtons.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
                switch (checkedId){
                    case R.id.blackButton:
                        helloTextView.setTextColor(Color.BLACK);
                        break;
                    case R.id.blueButton:
                        helloTextView.setTextColor(Color.BLUE);
                        break;
                    case R.id.greenButton:
                        helloTextView.setTextColor(Color.GREEN);
                        break;
                    case R.id.redButton:
                        helloTextView.setTextColor(Color.RED);
                        break;
                }
            }
        });

        //Reverse the Text
        //reverseSwitch.setOnCheckedChangeListener(new CompoundButton());
    }
}
