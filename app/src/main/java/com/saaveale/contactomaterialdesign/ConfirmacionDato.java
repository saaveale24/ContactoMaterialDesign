package com.saaveale.contactomaterialdesign;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ConfirmacionDato extends AppCompatActivity {
    private TextView tvNombre, tvFnac, tvTelefono, tvEmail, tvDescripcion;
    private Button btnEditarDato;
    private String anio, mes, dia;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirmacion_dato);

        tvNombre=(TextView)findViewById(R.id.tvNombreConfirmacion);
        tvFnac=(TextView)findViewById(R.id.tvFnacConfirmacion);
        tvTelefono=(TextView)findViewById(R.id.tvTelefonoConfirmacion);
        tvEmail=(TextView)findViewById(R.id.tvEmailConfirmacion);
        tvDescripcion=(TextView)findViewById(R.id.tvDescripcionConfirmacion);
        btnEditarDato=(Button)findViewById(R.id.btnEditarDato);

        Bundle extra=getIntent().getExtras();
        String nombre= extra.getString(getResources().getString(R.string.pnombre));
        String fnac= extra.getString(getResources().getString(R.string.pfnac));
        String telefono= extra.getString(getResources().getString(R.string.ptelefono));
        String email= extra.getString(getResources().getString(R.string.pemail));
        String descripcion= extra.getString(getResources().getString(R.string.pdescripcion));
        anio=extra.getString(getResources().getString(R.string.panio));
        mes=extra.getString(getResources().getString(R.string.pmes));
        dia=extra.getString(getResources().getString(R.string.pdia));

        tvNombre.setText(nombre);
        tvFnac.setText(fnac);
        tvTelefono.setText(telefono);
        tvEmail.setText(email);
        tvDescripcion.setText(descripcion);

        btnEditarDato.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(ConfirmacionDato.this,MainActivity.class);
                intent.putExtra(getResources().getString(R.string.pnombre),tvNombre.getText().toString());
                intent.putExtra(getResources().getString(R.string.pfnac),tvFnac.getText().toString());
                intent.putExtra(getResources().getString(R.string.ptelefono),tvTelefono.getText().toString());
                intent.putExtra(getResources().getString(R.string.pemail),tvEmail.getText().toString());
                intent.putExtra(getResources().getString(R.string.pdescripcion),tvDescripcion.getText().toString());
                intent.putExtra(getResources().getString(R.string.panio),anio);
                intent.putExtra(getResources().getString(R.string.pmes),mes);
                intent.putExtra(getResources().getString(R.string.pdia),dia);
                startActivity(intent);
                finish();
            }
        });

    }
}