package com.me.fifadraw;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public class NoClueYet extends AppCompatActivity {

    Button backbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_no_clue_yet);

        assignUI();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1 , PlayerNamesActivity.playerNames);
        ListView lv = (ListView) findViewById(R.id.listV);

        lv.setAdapter(adapter);

        backbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private void assignUI() {
        backbtn = (Button) findViewById(R.id.backBtn2);
    }
}
