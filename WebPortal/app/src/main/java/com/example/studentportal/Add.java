package com.example.studentportal;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

public class Add extends AppCompatActivity {
    private EditText labelTxt;
    private EditText URLTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        labelTxt = findViewById(R.id.editLabel);
        URLTxt = findViewById(R.id.editURL);

        //Obtain the parameters provided by MainActivity
        final Portal portalUpdate = getIntent().getParcelableExtra(MainActivity.EXTRA_REMINDER);
        labelTxt.setText(portalUpdate.getLabel());
        URLTxt.setText(portalUpdate.getUrl());

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String label = labelTxt.getText().toString();
                String URL = URLTxt.getText().toString();
                //(reminderUpdate.setmReminderText(updatedReminderText)));
                if (!TextUtils.isEmpty(label) && !TextUtils.isEmpty(URL)) {
                    portalUpdate.setLabel(label);
                    portalUpdate.setUrl(URL);

                    //Prepare the return parameter and return
                    Intent resultIntent = new Intent();
                    resultIntent.putExtra(MainActivity.EXTRA_REMINDER, portalUpdate);
                    setResult(Activity.RESULT_OK, resultIntent);
                    finish();
                } else {
                    Snackbar.make(view, "Not everything has been filled", Snackbar.LENGTH_LONG);
                }
            }
        });


    }

}
