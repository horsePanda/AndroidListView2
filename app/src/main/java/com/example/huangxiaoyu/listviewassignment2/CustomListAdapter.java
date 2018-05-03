package com.example.huangxiaoyu.listviewassignment2;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter {
    //to reference the Activity
    private final Activity _context;

    //to store the animal images
    private final Integer[] _imageIDArray;

    //to store the list of countries
    private final String[] _nameArray;

    //to store the list of countries

    public CustomListAdapter(Activity context, String[] nameArray, Integer[] imageIDArray) {
        super(context, R.layout.listview_row, nameArray);
        this._context = context;
        this._imageIDArray = imageIDArray;
        this._nameArray = nameArray;
    }
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=_context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.listview_row, null,true);

        //this code gets references to objects in the listview_row.xml file
        TextView nameTextField = (TextView) rowView.findViewById(R.id.nameTextViewID);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.imageView1ID);

        //this code sets the values of the objects to values from the arrays
        nameTextField.setText(_nameArray[position]);
        imageView.setImageResource(_imageIDArray[position]);

        return rowView;

    };

}
