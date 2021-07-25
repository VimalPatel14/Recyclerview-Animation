/**
 * Created by Vimal on July-2021.
 */
package com.vimal.recyclerviewwithanimation.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.vimal.recyclerviewwithanimation.R;

import java.io.Serializable;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);

        findViewById(R.id.top).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassIntent("top");
            }
        });

        findViewById(R.id.bottom).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassIntent("bottom");
            }
        });

        findViewById(R.id.left).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassIntent("left");
            }
        });

        findViewById(R.id.right).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PassIntent("right");
            }
        });
    }

    public void PassIntent(String str){
        Intent intent = new Intent(StartActivity.this, MainActivity.class);
        intent.putExtra("trans", str);
        startActivity(intent);
    }
}