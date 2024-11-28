package com.siddhantbhardwaj.planetsapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class MyCustomAdapter extends ArrayAdapter<Planet> {

    private ArrayList<Planet> planetsArrayList;
    private Context context;

    public MyCustomAdapter(ArrayList<Planet> planetsArrayList, Context context) {
        super(context, R.layout.item_list_layout,planetsArrayList);
        this.planetsArrayList = planetsArrayList;
        this.context = context;
    }

    public ArrayList<Planet> getPlanetsArrayList() {
        return planetsArrayList;
    }

    public void setPlanetsArrayList(ArrayList<Planet> planetsArrayList) {
        this.planetsArrayList = planetsArrayList;
    }

    @NonNull
    @Override
    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Planet planet = getItem(position);
         //Inflate layout
        ViewHolder viewHolder;
        final View result;

        if(convertView == null){

            viewHolder = new ViewHolder();
            LayoutInflater layoutInflater = LayoutInflater.from(getContext());
            convertView = layoutInflater.inflate(
                    R.layout.item_list_layout,
                    parent,
                    false
            );
            viewHolder.planetName = (TextView) convertView.findViewById(R.id.planetName);
            viewHolder.moonCount = (TextView) convertView.findViewById(R.id.planetMoon);
            viewHolder.planetImg = (ImageView) convertView.findViewById(R.id.imageView);

            result = convertView;
            convertView.setTag(viewHolder);

        }else{
            viewHolder = (ViewHolder) convertView.getTag();
            result = convertView;
        }
        viewHolder.planetName.setText(planet.getPlanetName());
        viewHolder.moonCount.setText(planet.getMoonCount());
        viewHolder.planetImg.setImageResource(planet.getPlanetImage());
        return result;
    }

    private static class ViewHolder{
        TextView planetName;
        TextView moonCount;
        ImageView planetImg;
    }

}
