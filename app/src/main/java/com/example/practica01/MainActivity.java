package com.example.practica01;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText Peso, Altura;
    TextView Resultado, Respuesta2, Recomendacion;
    Button Calcular;
    ImageView imagen3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Peso = (EditText) findViewById(R.id.txtPeso);
        Altura = (EditText) findViewById(R.id.txtAltura);
        Resultado = (TextView) findViewById(R.id.txtResultado);
        Calcular = (Button) findViewById(R.id.btnCalcular);
        Respuesta2 = (TextView) findViewById(R.id.txtResultado2);
        Recomendacion = (TextView) findViewById(R.id.txtRecomendaciones);
        imagen3 = (ImageView) findViewById(R.id.imagencaso3);

        Calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                double peso, altura, IMC;
                //hacerle una variable flotante...
                peso = Double.parseDouble(Peso.getText().toString());
                altura = Double.parseDouble(Altura.getText().toString());

                IMC=peso/Math.pow(altura,2);

                int caso=0;
                if(IMC<=18.5){
                    caso=1;
                }if(IMC>18.5 && IMC < 24.99){
                    caso=2;
                }if (IMC>25){
                    caso=3;
                }
                switch (caso){
                    case 1:
                        Respuesta2.setText(R.string.textocaso1);
                        Recomendacion.setText(R.string.textocaso11);
                        imagen3.setImageResource(R.drawable.delgado);
                        break;

                    case 2:
                        Respuesta2.setText(R.string.textocaso2);
                        Recomendacion.setText(R.string.textocaso22);
                        imagen3.setImageResource(R.drawable.pesonormal);
                        break;
                    case 3:
                        Respuesta2.setText(R.string.textocaso3);
                        Recomendacion.setText(R.string.textocaso33);
                        imagen3.setImageResource(R.drawable.obesoimg);
                        break;
                }
                Resultado.setText(""+IMC);
            }
        });
    }
}