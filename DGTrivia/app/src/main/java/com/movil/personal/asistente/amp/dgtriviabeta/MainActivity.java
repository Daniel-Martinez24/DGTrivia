package com.movil.personal.asistente.amp.dgtriviabeta;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    Button btn_materias, btn_jugar, button_salir;
    Intent intent;
    String tipoDeJuego = "Aleatorio"; // 0 Aleatorio, 1 Materia
    int puntaje_biologia = 0, puntaje_logica = 0, puntaje_geometria = 0, puntaje_ingles = 0;


    public void onBackPressed() {
        Toast.makeText(this, "oprime salir para cerrar la aplicacion", Toast.LENGTH_SHORT).show();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_jugar = (Button) findViewById(R.id.button_jugar);
        btn_jugar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), BiologiaPregunta1.class);

                //Pasar parametro "tipo_de_juego", con valor 0 (aleatorio)
                intent.putExtra("tipo_de_juego", tipoDeJuego);
                //Pasar los puntajes acumulados a la siguiente activity
                intent.putExtra("puntaje_biologia", puntaje_biologia);
                intent.putExtra("puntaje_logica", puntaje_logica);
                intent.putExtra("puntaje_ingles", puntaje_ingles);
                intent.putExtra("puntaje_geometria", puntaje_geometria);


                startActivityForResult(intent, 0);
            }
        });
        button_salir = (Button) findViewById(R.id.button_salir);
        button_salir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                Intent intent = new Intent(Intent.ACTION_MAIN);
                intent.addCategory(Intent.CATEGORY_HOME);
                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);

            }
        });
        btn_materias = (Button) findViewById(R.id.button_materias);
        btn_materias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), Main2Activity.class);
                //Pasar los puntajes acumulados a la siguiente activity
                intent.putExtra("puntaje_biologia", puntaje_biologia);
                intent.putExtra("puntaje_logica", puntaje_logica);
                intent.putExtra("puntaje_ingles", puntaje_ingles);
                intent.putExtra("puntaje_geometria", puntaje_geometria);


                startActivityForResult(intent, 0);
            }
        });

    }
}