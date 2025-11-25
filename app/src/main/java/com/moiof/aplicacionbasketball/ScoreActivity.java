package com.moiof.aplicacionbasketball;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.moiof.aplicacionbasketball.databinding.ActivityScoreBinding;

public class ScoreActivity extends AppCompatActivity {
    //Claves para recuperar los datos enviados desde MainActivity
    public static final String CONTADOR_LOCAL_KEY = "contadorlocal";
    public static final String CONTADOR_VISITANTE_KEY = "contadorvisitante";
    private ActivityScoreBinding binding;
    private int contadorLocal;
    private int contadorVisitante;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Vincula el layout con la Activity con Data Binding
        binding = ActivityScoreBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        //Obtiene los datos enviados desde la Activity anterior
        Intent intent = getIntent();
        contadorLocal = intent.getIntExtra(CONTADOR_LOCAL_KEY, 0);
        contadorVisitante = intent.getIntExtra(CONTADOR_VISITANTE_KEY, 0);
        binding.finalScoreView.setText(contadorLocal+"-"+contadorVisitante);

        //Muestra el resultado final del partido
        mostrarResultado();
    }

    private void mostrarResultado(){
        String ganador;
        String empate = getString(R.string.empate);
        if (contadorLocal > contadorVisitante){ //Si el equipo local gana
            ganador = getString(R.string.ganador, getString(R.string.local_text));
            binding.resultView.setText(ganador);
        } else if (contadorLocal < contadorVisitante) { //Si el equipo visitante gana
            ganador = getString(R.string.ganador, getString(R.string.visitante_text));
            binding.resultView.setText(ganador);
        } else if (contadorLocal == contadorVisitante) { //Si el resultado es un empate
            binding.resultView.setText(empate);
        }
    }
}