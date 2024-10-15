package com.example.quadraticapp;

import android.view.View;
import android.widget.TextView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import java.lang.Math;


import com.example.quadraticapp.databinding.ActivityMainBinding;


public class Quadratic extends BaseObservable {
    String input1,input2,input3;

    TextView textView;
    ActivityMainBinding activityMainBinding;

    public Quadratic(ActivityMainBinding activityMainBinding) {
        this.activityMainBinding = activityMainBinding;
    }

    public Quadratic(String input1, String input2, String input3) {
        this.input1 = input1;
        this.input2 = input2;
        this.input3 = input3;
    }

    @Bindable
    public String getInput1() {
        return input1;
    }

    public void setInput1(String input1) {
        this.input1 = input1;
        notifyPropertyChanged(BR.input1);
    }

    @Bindable
    public String getInput2() {
        return input2;
    }

    public void setInput2(String input2) {
        this.input2 = input2;
        notifyPropertyChanged(BR.input2);
    }

    @Bindable
    public String getInput3() {
        return input3;
    }

    public void setInput3(String input3) {
        this.input3 = input3;
        notifyPropertyChanged(BR.input3);
    }

    public void solveQudraticEquation(View view){
        int a = Integer.parseInt(getInput1());
        int b = Integer.parseInt(getInput2());
        int c = Integer.parseInt(getInput3());

        double discriminant = ((b*b) - 4*(a*c));
        double denominator = 2*a;
        double numerator = -b;

        if (discriminant>0){
            double result1 = (numerator + Math.sqrt(discriminant))/(denominator);

            double result2 = (numerator - Math.sqrt(discriminant))/(denominator);

            activityMainBinding.textView.setText("X1= "+result1+ " X2= "+result2);

        } else if (discriminant<0) {
            activityMainBinding.textView.setText("No real solution");

        }
        else {
            double result1 = (numerator/denominator);
            activityMainBinding.textView.setText("X1= "+result1);
        }

    }

}
