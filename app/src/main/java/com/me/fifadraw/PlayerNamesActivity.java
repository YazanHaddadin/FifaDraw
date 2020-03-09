package com.me.fifadraw;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.InputType;
import android.text.Layout;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerNamesActivity extends AppCompatActivity {

    LinearLayout playerNameLayout;
    Button nextBtn, backBtn;
    public static ArrayList<String> playerNames;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player_names);

        assignUI();
        playerNames = new ArrayList<>();

        for (int i=2; i<MainActivity.noOfPlayers; i++){
            int id = getResources().getIdentifier("Player"+i+1, "id", getPackageName());
            playerNameLayout.addView(createEditText(id, "Player " + (i+1)));
        }

        nextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int j=0;
                for (int i=0; i<playerNameLayout.getChildCount(); i++){
                    EditText temp = (EditText) playerNameLayout.getChildAt(i);
                    playerNames.add(temp.getText().toString());
                    j=i;
                }

                if(j == playerNameLayout.getChildCount() - 1){
                    startActivity(new Intent(PlayerNamesActivity.this, NoClueYet.class));
                }
            }
        });

        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        playerNames = new ArrayList<>();
    }

    public EditText createEditText(int id, String hint) {

        LinearLayout.LayoutParams etParams=
                new LinearLayout.LayoutParams
                        (LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        Resources r = getResources();
        float px = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                15,
                r.getDisplayMetrics()
        );

        etParams.topMargin = (int)px;
        etParams.gravity = Gravity.CENTER;

        EditText editText = new EditText(this);

        editText.setLayoutParams(etParams);

        editText.setHint(hint);
        editText.setId(id);
        editText.setInputType(InputType.TYPE_TEXT_VARIATION_NORMAL);
        editText.setEms(13);

        return editText;

    }

    private void assignUI() {
        nextBtn = (Button) findViewById(R.id.nextBtn2);
        backBtn = (Button) findViewById(R.id.backBtn);
        playerNameLayout = (LinearLayout) findViewById(R.id.playerNamesLayout);
    }
}
