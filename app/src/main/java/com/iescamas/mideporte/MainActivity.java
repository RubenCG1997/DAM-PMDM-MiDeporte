package com.iescamas.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Spinner deportes;
    RadioGroup elecciones;
    RadioButton eleccion1, eleccion2, eleccion3;
    TextView info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        eleccion1 = findViewById(R.id.rb_eleccion1);
        eleccion2 = findViewById(R.id.rb_eleccion2);
        eleccion3 = findViewById(R.id.rb_eleccion3);
        info = findViewById(R.id.lbl_info);
        deportes = findViewById(R.id.spDeportes);
        elecciones = findViewById(R.id.rg_elecciones);

        ArrayAdapter<CharSequence> adaptador = ArrayAdapter.createFromResource(this,R.array.deportesIndividuales, android.R.layout.simple_spinner_item );

        elecciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                if (eleccion1.isChecked()){
                    adaptador = ArrayAdapter.createFromResource(this,R.array.deportesIndividuales, android.R.layout.simple_spinner_item );
                } else if (eleccion2.isChecked()) {
                    adaptador = ArrayAdapter.createFromResource(this,R.array.deportesEnPareja, android.R.layout.simple_spinner_item );
                }
                else {
                    adaptador = ArrayAdapter.createFromResource(this,R.array.deportesGrupal, android.R.layout.simple_spinner_item );
                }
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                deportes.setAdapter(adaptador);
            }
        });



    }
}