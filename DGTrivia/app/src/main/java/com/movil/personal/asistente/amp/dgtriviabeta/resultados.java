package com.movil.personal.asistente.amp.dgtriviabeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class resultados extends AppCompatActivity {
    Button inicio;
    int puntaje_biologia = 0, puntaje_logica = 0, puntaje_geometria = 0, puntaje_ingles = 0, cant_j = 0;
    @Override
    public void onBackPressed() {
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);


        Bundle bundle = getIntent().getExtras();
        final String fraseimportada = bundle.getString("tipo_de_juego");
        //Puntajes recibidos del activity anterior
        puntaje_biologia = bundle.getInt("puntaje_biologia");
        puntaje_logica = bundle.getInt("puntaje_logica");
        puntaje_geometria = bundle.getInt("puntaje_geometria");
        puntaje_ingles = bundle.getInt("puntaje_ingles");
        cant_j = bundle.getInt("cant_j");

        TextView calif_bio = (TextView)findViewById(R.id.calificacion_biologia);
        calif_bio.setText(Integer.toString(puntaje_biologia));
        TextView calif_geo = (TextView)findViewById(R.id.calificacion_geometria);
        calif_geo.setText(Integer.toString(puntaje_geometria));
        TextView calif_ing = (TextView)findViewById(R.id.calificacion_ingles);
        calif_ing.setText(Integer.toString(puntaje_ingles));
        TextView calif_log = (TextView)findViewById(R.id.calificacion_logica);
        calif_log.setText(Integer.toString(puntaje_logica));

        Button edit = (Button) findViewById(R.id.inicio);
        edit.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
                if (cant_j == 0)
                {
                    Intent Intent = new Intent(view.getContext(), Reinicio.class);
                    startActivity(Intent);
                    finish();
                }else{
                    Intent Intent = new Intent(view.getContext(), MainActivity.class);
                    startActivity(Intent);
                    finish();}
            }


        });

    }
}
