package com.siddhantbhardwaj.planetsapp;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<Planet> planetArrayList;

    private static MyCustomAdapter myCustomAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        listView = findViewById(R.id.listView);
        planetArrayList = new ArrayList<>();
        Planet earth = new Planet("Earth","1 Moon",R.drawable.earth);
        Planet mercury = new Planet("Mercury","0 Moons",R.drawable.mercury);
        Planet venus = new Planet("Venus","0 Moons",R.drawable.venus);
        Planet mars = new Planet("Mars","0 Moons",R.drawable.mars);
        Planet jupiter = new Planet("Jupiter","79 Moons",R.drawable.jupiter);
        Planet saturn = new Planet("Saturn","83 Moons",R.drawable.saturn);
        Planet uranus = new Planet("Uranus","27 Moons",R.drawable.uranus);
        Planet neptune = new Planet("Neptune","14 Moons",R.drawable.neptune);
        Planet pluto = new Planet("Pluto","1 Moon",R.drawable.pluto);
        planetArrayList.add(earth);
        planetArrayList.add(mercury);
        planetArrayList.add(venus);
        planetArrayList.add(mars);
        planetArrayList.add(jupiter);
        planetArrayList.add(saturn);
        planetArrayList.add(uranus);
        planetArrayList.add(neptune);
        planetArrayList.add(pluto);

        myCustomAdapter = new MyCustomAdapter(planetArrayList,getApplicationContext());
        listView.setAdapter(myCustomAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(
                        MainActivity.this,
                        "Planet " + myCustomAdapter.getItem(position).getPlanetName() + " has " + myCustomAdapter.getItem(position).getMoonCount(),
                        Toast.LENGTH_SHORT
                ).show();
            }
        });

    }
}