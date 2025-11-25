package com.moiof.aplicacionbasketball;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.moiof.aplicacionbasketball.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    //Contadores para poder pasar la información a la siguiente pantalla
    int contadorLocal = 0;
    int contadorVisitante = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Vincula el layout con la Activity con Data Binding

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Asignar valor inicial de los contadores

        binding.scoreLocal.setText(String.valueOf(contadorLocal));
        binding.scoreVisitante.setText(String.valueOf(contadorVisitante));

        //Listeners para los botones de la puntuación

        binding.plusOneButton.setOnClickListener(v -> SumarPuntos(binding.scoreLocal, 1, true));
        binding.plusTwoButton.setOnClickListener(v -> SumarPuntos(binding.scoreLocal, 2, true));
        binding.minusOneButton.setOnClickListener(v -> RestarPunto(binding.scoreLocal, true));

        binding.plusOneButtonVis.setOnClickListener(v -> SumarPuntos(binding.scoreVisitante, 1, false));
        binding.plusTwoButtonVis.setOnClickListener(v -> SumarPuntos(binding.scoreVisitante, 2, false));
        binding.minusOneButtonVis.setOnClickListener(v -> RestarPunto(binding.scoreVisitante, false));

        binding.resetButton.setOnClickListener(v -> ResetearPuntos());

        binding.resultButton.setOnClickListener(v -> openScoreActivity(contadorLocal, contadorVisitante));
    }

    private void openScoreActivity(int contadorLocal, int contadorVisitante){ //Metodo para abrir ScoreActivity
        //Creo el Intent para introducir los contadores y pasar a la siguiente pantalla
        Intent intent = new Intent(this, ScoreActivity.class);
        intent.putExtra(ScoreActivity.CONTADOR_LOCAL_KEY, contadorLocal);
        intent.putExtra(ScoreActivity.CONTADOR_VISITANTE_KEY, contadorVisitante);

        startActivity(intent);
    }

    //Métodos para los botones
    private void SumarPuntos(TextView contadorLugar, int cantidadPuntos, boolean esLocal){
        if (esLocal){
            if (Integer.parseInt(contadorLugar.getText().toString()) >= 0){
                contadorLocal += cantidadPuntos;
                contadorLugar.setText(String.valueOf(contadorLocal));
            }
        } else {
            if (Integer.parseInt(contadorLugar.getText().toString()) >= 0){
                contadorVisitante += cantidadPuntos;
                contadorLugar.setText(String.valueOf(contadorVisitante));
            }
        }
    }
    private void RestarPunto(TextView contadorLugar, boolean esLocal){
        if (esLocal){
            if (Integer.parseInt(contadorLugar.getText().toString()) > 0){
                contadorLocal--;
                contadorLugar.setText(String.valueOf(contadorLocal));
            }
        } else {
            if (Integer.parseInt(contadorLugar.getText().toString()) > 0){
                contadorVisitante--;
                contadorLugar.setText(String.valueOf(contadorVisitante));
            }

        }
    }
    private void ResetearPuntos(){
        contadorLocal = 0;
        contadorVisitante = 0;
        binding.scoreLocal.setText(String.valueOf(contadorLocal));
        binding.scoreVisitante.setText(String.valueOf(contadorVisitante));
    }
}