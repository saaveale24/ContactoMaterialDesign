package com.saaveale.contactomaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    private TextView tvFnac;
    private Button btnSiguiente;
    private EditText etNombre;
    private EditText etTelefono;
    private EditText etEmail;
    private EditText etDescripcion;
    private DatePickerDialog.OnDateSetListener mDataSetListener;
    private int sanio;
    private int smes;
    private int sdia;
    private Bundle extra=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNombre=(EditText) findViewById(R.id.etNombre);
        etTelefono=(EditText) findViewById(R.id.etTelefono);
        etEmail=(EditText) findViewById(R.id.etEmail);
        etDescripcion=(EditText) findViewById(R.id.etDescripcion);
        tvFnac=(TextView) findViewById(R.id.tvFnac);
        btnSiguiente=(Button) findViewById(R.id.btnSiguiente);

        extra= getIntent().getExtras();
        if(extra!=null){
            cargarDatos();
        }else {
            Calendar cal = Calendar.getInstance();
            sanio = cal.get(Calendar.YEAR);
            smes = cal.get(Calendar.MONTH);
            sdia = cal.get(Calendar.DAY_OF_MONTH);
        }

        tvFnac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog dialog= new DatePickerDialog(MainActivity.this,
                        android.R.style.Theme_Material_Light_Dialog,
                        mDataSetListener,
                        sanio, smes, sdia);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.WHITE));
                dialog.show();
            }
        });

        mDataSetListener= new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                sanio =year;
             smes =month;
             sdia =day;
             tvFnac.setText(sdia +"/"+ smes +"/"+ sanio);
            }
        };
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this,ConfirmacionDato.class);
                intent.putExtra(getResources().getString(R.string.pnombre),etNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfnac),tvFnac.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),etTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),etEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),etDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.panio),String.valueOf(sanio));
                intent.putExtra(getResources().getString(R.string.pmes),String.valueOf(smes));
                intent.putExtra(getResources().getString(R.string.pdia),String.valueOf(sdia));
                startActivity(intent);
                finish();
            }
        });



    }

    private void cargarDatos() {
        sanio =Integer.parseInt(extra.getString(getResources().getString(R.string.panio)));
        smes =Integer.parseInt(extra.getString(getResources().getString(R.string.pmes)));
        sdia =Integer.parseInt(extra.getString(getResources().getString(R.string.pdia)));

        etNombre.setText(extra.getString(getResources().getString(R.string.pnombre)));
        tvFnac.setText(String.valueOf(sdia)+"/"+String.valueOf(smes)+"/"+String.valueOf(sanio));
        etTelefono.setText(extra.getString(getResources().getString(R.string.ptelefono)));
        etEmail.setText(extra.getString(getResources().getString(R.string.pemail)));
        etDescripcion.setText(extra.getString(getResources().getString(R.string.pdescripcion)));

    }
}