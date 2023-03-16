package com.example.project005;

import androidx.appcompat.app.AppCompatActivity;

import android.icu.text.Transliterator;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
private ListView Lista;
private TextView T1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        T1=findViewById(R.id.T1);
        setContentView(R.layout.activity_main);
        final ArrayList<String> pais = new ArrayList<String>();
        pais.add("Colombia");
        pais.add("Mexico");
        pais.add("Argentina");
        pais.add("Brazil");
        pais.add("Ecuador");
        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, pais);
        Lista=findViewById(R.id.Lista);
        Lista.setAdapter(adaptador);
        Lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Has pulsado: "+ pais.get(position), Toast.LENGTH_LONG).show();
                String text = String.valueOf(pais.get(position));
                T1=findViewById(R.id.T1);

                if(text.equals("Colombia")) {
                    T1.setText("Hay 100 habitantes");
                }  else if(text.equals("Mexico")) {
                    T1.setText("Hay 300 habitantes");
                }else if(text.equals("Argentina")) {
                    T1.setText("Hay 432 habitantes");
                }else if(text.equals("Brazil")) {
                    T1.setText("Hay 121 habitantes");
                }else if(text.equals("Ecuador")) {
                    T1.setText("Hay 600 habitantes");
                }
            }





        });
    }
}