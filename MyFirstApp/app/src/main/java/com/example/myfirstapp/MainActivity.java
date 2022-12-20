package com.example.myfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempts to launch an activity within our own app.
        Button multiplierActivityButton = (Button) findViewById(R.id.multiplierActivityButton);
        multiplierActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent multiplierIntent = new Intent(getApplicationContext(), MultiplyActivity.class);
                // Show how to pass information to another activity:
                multiplierIntent.putExtra("com.example.myfirstapp.HELLO", "Helloooooooo :)");
                startActivity(multiplierIntent);
            }
        });

        Button listActivityButton = (Button) findViewById(R.id.listActivityButton);
        listActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent listIntent = new Intent(getApplicationContext(), ListActivity.class);
                startActivity(listIntent);
            }
        });

        // Attempts to launch an activity outside our app.
        Button googleActivityButton = (Button) findViewById(R.id.googleActivityButton);
        googleActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String google = "http://www.google.com";
                Uri webAddress = Uri.parse(google);

                Intent goToGoogle = new Intent(Intent.ACTION_VIEW, webAddress);
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }
            }
        });
    }
}