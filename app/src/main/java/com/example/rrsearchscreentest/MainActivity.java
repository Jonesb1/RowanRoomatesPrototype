package com.example.rrsearchscreentest;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {

    Spinner academicYearSpinner, sexSpinner, dormStyleSpinner, attribute3Spinner, attribute4Spinner, attribute5Spinner, attribute6Spinner, attribute7Spinner;
    Button searchButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_screen);
        academicYearSpinner = findViewById(R.id.academic_year_spinner);
        sexSpinner = findViewById(R.id.sex_spinner);
        dormStyleSpinner = findViewById(R.id.dorm_style_spinner);
        attribute3Spinner = findViewById(R.id.attribute_3);
        attribute4Spinner = findViewById(R.id.attribute_4);
        attribute5Spinner = findViewById(R.id.attribute_5);
        attribute6Spinner = findViewById(R.id.attribute_6);
        attribute7Spinner = findViewById(R.id.attribute_7);
        searchButton = findViewById(R.id.searchButton);
        populateSpinner(academicYearSpinner, R.array.year_array);
        populateSpinner(sexSpinner, R.array.sex_array);
        populateSpinner(dormStyleSpinner, R.array.dorm_rooms);
        populateSpinner(attribute3Spinner, R.array.attribute_options);
    }

    // called when the searchButton is pressed
    public void searchPressed(View v)
    {
        JSONObject json = new JSONObject();
        try {
            json.put("year", academicYearSpinner.getSelectedItem().toString());
            json.put("sex", sexSpinner.getSelectedItem().toString());
            json.put("dorm", dormStyleSpinner.getSelectedItem().toString());
            json.put("attribute3", attribute3Spinner.getSelectedItem().toString());
        } catch (JSONException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
        Toast.makeText(MainActivity.this, json.toString(), Toast.LENGTH_LONG).show();

    }

    private void populateSpinner(Spinner spinner, int textArrayResId)
    {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, textArrayResId, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
}