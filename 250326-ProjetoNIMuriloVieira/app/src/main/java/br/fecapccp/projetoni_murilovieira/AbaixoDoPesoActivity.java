package br.fecapccp.projetoni_murilovieira;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class AbaixoDoPesoActivity extends AppCompatActivity {

    //Intanciamento
    private Button btnT3Reset;
    private TextView textT3Resultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abaixo_do_peso);

        Log.i("Ciclo de Vida", "Tela 3 - onStart");

        //Definindo
        textT3Resultado = findViewById(R.id.textT3Resultado);
        btnT3Reset = findViewById(R.id.btnT3Fechar);

        //Pegando o bundle para usar na resposta
        Bundle bundle = getIntent().getExtras();

        float altura = bundle.getFloat("altura");
        float peso = bundle.getFloat("peso");
        float IMC = bundle.getFloat("imc");

        String resultado = "Altura: " + altura + "\nPeso: " + peso + "\nSeu IMC é: " + IMC + "\nClassificação: Abaixo do Peso";

        //Mostrando resultado
        textT3Resultado.setText(resultado);

        //Voltando à página inicial e dando destroy
        btnT3Reset.setOnClickListener(view -> {
            // Qual tela vou chamar após clicar nesse botão:
            Intent intent = new Intent(this, MainActivity.class);

            startActivity(intent);
            finish();
        });


        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 3 - onResume");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 3 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 3 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 3 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 3 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 3 - onStart");
    }

}