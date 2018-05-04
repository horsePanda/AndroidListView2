package com.example.huangxiaoyu.listviewassignment2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Random;

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity _context;

    //to store the animal images
    private final Integer[] _imageIDArray;

    //to store the list of countries
    private ArrayList<String> _comment;
    private ArrayList<Integer> _imageNumber = new ArrayList<>();

    //to store the list of countries

    public CustomListAdapter(Activity context, ArrayList<String> comment, Integer[] imageIDArray) {
        super(context, R.layout.listview_row, comment);
        this._context = context;
        this._imageIDArray = imageIDArray;
        this._comment = comment;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=_context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);
        Random randomNumberGenerator = new Random();
        //this is the upper bound of our generator, it will generate int number from 0 - 5
        int number = randomNumberGenerator.nextInt(6);

        //this code gets references to objects in the listView_row.xml file
        TextView commentTextField = (TextView) rowView.findViewById(R.id.commentTextViewID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);

        //this code sets the values of the objects to values from the arrays
        commentTextField.setText(_comment.get(position));
        if (_imageNumber.size() == 0 || _imageNumber.size() - 1 < position) {
            imageView.setImageResource(_imageIDArray[number]);
            _imageNumber.add(number);
        } else {
            imageView.setImageResource(_imageIDArray[_imageNumber.get(position)]);
        }


        return rowView;

    };

}
