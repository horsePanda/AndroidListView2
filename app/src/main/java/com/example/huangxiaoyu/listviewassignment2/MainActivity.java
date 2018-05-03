package com.example.huangxiaoyu.listviewassignment2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    private String[] nameArray = {
            "Base Jump",
            "Bungee Jumping",
            "Diving",
            "Ski Jumping",
            "Paragliding",
            "Trampoline",
            "VolleyBall",
            "SkyDiving",
            "Yoga" };

    private String[] infoArray = {
            "this is the basic sports",
            "It is very popular for adventures",
            "you can explore a new world",
            "you have to control yourself",
            "It is like a fly",
            "It is interesting but need practice",
            "It is popular in colleage",
            "It is a little bit scary but worth it",
            "It is strench your muscle "
    };

    private Integer[] imageArray = {
            R.drawable.base_jumping96,
            R.drawable.bungee_jumping,
            R.drawable.diving_96,
            R.drawable.ski_jumping_96,
            R.drawable.paragliding_96,
            R.drawable.trampoline_96,
            R.drawable.volleyball_player_96,
            R.drawable.skydive_96,
            R.drawable.yoga_96
    };
    private ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CustomListAdapter sportsListView = new CustomListAdapter(this, nameArray,imageArray);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(sportsListView);

    }
}
