package com.iescamas.mideporte;

import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView info;
    ArrayAdapter<CharSequence> adaptador;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        info = findViewById(R.id.lbl_info);

        int idBtnSeleccionado = ((RadioGroup) findViewById(R.id.rg_elecciones)).getCheckedRadioButtonId();
        if(idBtnSeleccionado!=-1){
            eligeAdaptador(idBtnSeleccionado);
        }

        ((RadioGroup) findViewById(R.id.rg_elecciones)).setOnCheckedChangeListener((radioGroup, i) -> {
            eligeAdaptador(i);
        });
    }

    private void eligeAdaptador(int i) {
        adaptador = ArrayAdapter.createFromResource(this,idArray(i), android.R.layout.simple_spinner_dropdown_item);
        ((Spinner)findViewById(R.id.spDeportes)).setAdapter(adaptador);
        ((Spinner)findViewById(R.id.spDeportes)).setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                info.setText( ((Spinner) findViewById(R.id.spDeportes)).getSelectedItem().toString());
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {}
        });
    }

    private int idArray(int i) {
        int idArray;
        if(i == R.id.rb_eleccion1){
            idArray = R.array.deportesIndividuales;
        }
        else if(i == R.id.rb_eleccion2){
            idArray = R.array.deportesEnPareja;
        }
        else {
            idArray = R.array.deportesGrupal;
        }
        return idArray;
    }


}