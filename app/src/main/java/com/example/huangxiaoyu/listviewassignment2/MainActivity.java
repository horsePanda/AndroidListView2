package com.example.huangxiaoyu.listviewassignment2;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private EditText commentText;
    private Button addButton;
    private Integer[] imageArray = {
            R.drawable.apple_icon,
            R.drawable.banana_icon,
            R.drawable.lemon_icon,
            R.drawable.peach_icon,
            R.drawable.pineapple_icon,
            R.drawable.rose_icon,
    };
    private ListView listView;
    private ArrayList<String> commentArray;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //set adaptor
        commentArray = new ArrayList<>();
        commentArray.add("this is an example ^-^");
        final CustomListAdapter sportsListViewAdaptor = new CustomListAdapter(this, commentArray, imageArray);
        listView = (ListView) findViewById(R.id.listViewID);
        listView.setAdapter(sportsListViewAdaptor);

        commentText = findViewById(R.id.editTextID);
        addButton = findViewById(R.id.addButtonID);
        //set button click listener
        addButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String userInput = commentText.getText().toString();

                //if input is empty
                if (TextUtils.isEmpty(commentText.getText())) {
                    AlertDialog alertDialog = new AlertDialog.Builder(MainActivity.this).create();
                    alertDialog.setTitle("Alert");
                    alertDialog.setMessage("there must be something you want to say");
                    alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                            new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    alertDialog.show();
                } else {
                    commentArray.add(userInput);
                    sportsListViewAdaptor.notifyDataSetChanged();
                }

                InputMethodManager imm = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
                if (imm.isAcceptingText()) { // verify if the soft keyboard is open
                    imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
                }
            }
        });

    }
}


