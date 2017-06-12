package com.ravindra.dayscalculator;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {
    @BindView(R.id.startdateday)
    NumberPicker startdateday;
    @BindView(R.id.startdatemonth)
    NumberPicker startdatemonth;
    @BindView(R.id.startdateyear)
    NumberPicker startdateyear;
    @BindView(R.id.enddateday)
    NumberPicker enddateday;
    @BindView(R.id.enddatemonth)
    NumberPicker enddatemonth;
    @BindView(R.id.enddateyear)
    NumberPicker enddateyear;
    @BindView(R.id.noofDays)
    TextView calculatedDays;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setHomeAsUpIndicator(android.R.drawable.ic_menu_close_clear_cancel);
            getSupportActionBar().setHomeButtonEnabled(true);
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }
        startdateday.setMaxValue(31);
        startdateday.setMinValue(1);

        enddateday.setMaxValue(31);
        enddateday.setMinValue(1);

        startdatemonth.setMaxValue(12);
        startdatemonth.setMinValue(1);

        enddatemonth.setMaxValue(12);
        enddatemonth.setMinValue(1);

        startdateyear.setMaxValue(2999);
        startdateyear.setMinValue(1901);

        enddateyear.setMaxValue(2999);
        enddateyear.setMinValue(1901);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    @OnClick(R.id.btnChangeDate)
    public void setCalculatedDays(Button button) {
        DaysCalculator daysCalculator = new DaysCalculator();
        String startDate = String.valueOf(startdateyear.getValue())
                + String.format("%02d", startdatemonth.getValue())
                + String.format("%02d", startdateday.getValue());

        String endDate = String.valueOf(enddateyear.getValue())
                + String.format("%02d", enddatemonth.getValue())
                +  String.format("%02d", enddateday.getValue());
        calculatedDays.setText(String.format("%d days", daysCalculator.daysBetween(startDate, endDate)));
    }
}
