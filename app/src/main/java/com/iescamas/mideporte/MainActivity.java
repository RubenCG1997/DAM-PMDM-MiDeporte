package com.iescamas.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Spinner deportes;
    RadioGroup elecciones;
    RadioButton rb_eleccion1, rb_eleccion2, rb_eleccion3;
    TextView info;
    ArrayAdapter<CharSequence> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rb_eleccion1 = findViewById(R.id.rb_eleccion1);
        rb_eleccion2 = findViewById(R.id.rb_eleccion2);
        rb_eleccion3 = findViewById(R.id.rb_eleccion3);
        info = findViewById(R.id.lbl_info);
        deportes = findViewById(R.id.spDeportes);
        elecciones = findViewById(R.id.rg_elecciones);

        //Inicializa el adaptador en deportes individuales por defecto
        adaptador = ArrayAdapter.createFromResource(this,
                R.array.deportesIndividuales, android.R.layout.simple_spinner_item);
        adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        deportes.setAdapter(adaptador);
        //Realiza el cambio de evento según la selección
        deportes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                info.setText(deportes.getSelectedItem().toString());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


        //Modifica el adaptador según el boton seleccionado
        elecciones.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                //Verificamos si la opción 1 está seleccionada
                if (rb_eleccion1.isChecked()){
                    //Usamos MainActivity.this para obtener el contexto correcto de la actividad
                    adaptador = ArrayAdapter.createFromResource(MainActivity.this,
                            R.array.deportesIndividuales, android.R.layout.simple_spinner_item);
                    //Verificamos si la opción 2 está seleccionada
                } else if (rb_eleccion2.isChecked()) {
                    //Usamos MainActivity.this para obtener el contexto correcto de la actividad
                    adaptador = ArrayAdapter.createFromResource(MainActivity.this,R.array.deportesEnPareja, android.R.layout.simple_spinner_item );
                }
                else {
                    //Usamos MainActivity.this para obtener el contexto correcto de la actividad
                    adaptador = ArrayAdapter.createFromResource(MainActivity.this,R.array.deportesGrupal, android.R.layout.simple_spinner_item );
                }
                adaptador.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                deportes.setAdapter(adaptador);

                //Realiza el cambio de evento según la selección
                deportes.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        info.setText(deportes.getSelectedItem().toString());
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }
        });

    }
}