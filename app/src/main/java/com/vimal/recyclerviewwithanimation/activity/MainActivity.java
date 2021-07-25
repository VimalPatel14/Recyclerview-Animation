/**
 * Created by Vimal on July-2021.
 */
package com.vimal.recyclerviewwithanimation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.vimal.recyclerviewwithanimation.R;
import com.vimal.recyclerviewwithanimation.adapter.PostAdapter;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerviewpost;
    ArrayList<String> categorypost;
    PostAdapter postAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Intent intent = getIntent();
        String trans = intent.getStringExtra("trans");

        recyclerviewpost = findViewById(R.id.recyclerviewpost);

        categorypost = new ArrayList<String>();

        for (int i = 0; i < 100; i++) {
            categorypost.add(i + "pos");
        }

        postAdapter = new PostAdapter(MainActivity.this, categorypost);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        layoutManager.setGapStrategy(StaggeredGridLayoutManager.GAP_HANDLING_NONE);
        recyclerviewpost.setLayoutManager(layoutManager);
//        recyclerviewpost.setLayoutManager(new GridLayoutManager(MainActivity.this, 2));
        recyclerviewpost.setAdapter(postAdapter);
        if (trans.equals("top")) {
            recyclerviewpost.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_animation_up_to_down));
        } else if (trans.equals("bottom")) {
            recyclerviewpost.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_animation_down_to_up));
        } else if (trans.equals("left")) {
            recyclerviewpost.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_animation_left_to_right));
        } else {
            recyclerviewpost.setLayoutAnimation(AnimationUtils.loadLayoutAnimation(MainActivity.this, R.anim.layout_animation_right_to_left));
        }

    }
}