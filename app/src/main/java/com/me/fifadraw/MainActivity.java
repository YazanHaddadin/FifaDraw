package com.me.fifadraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

public class MainActivity extends AppCompatActivity{

    Spinner spinner;
    Button nextBtn;
    public static int noOfPlayers=2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        assignUI();

        final ArrayAdapter<CharSequence> adapter = ArrayAdapter
                .createFromResource(this, R.array.noOfPlayers,
                        R.layout.spinner_text_style);

        adapter.setDropDownViewResource(R.layout.spinner_text_style);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                noOfPlayers = Integer.parseInt(parent.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, PlayerNamesActivity.class));
            }
        });
    }

    private void assignUI() {
        spinner = (Spinner) findViewById(R.id.spinnerNoPlayer);
        nextBtn = (Button) findViewById(R.id.nextBtn);
    }
}
