package br.fecapccp.projetoni_murilovieira;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class CalculoIMCActivity extends AppCompatActivity {

    //Intanciamento
    private Button btnT2Fechar;
    private Button btnT2Set;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_calculo_imcactivity);

        //Definindo
        EditText campoAltura = findViewById(R.id.editTextAltura);
        EditText campoPeso = findViewById(R.id.editTextPeso);
        btnT2Fechar = findViewById(R.id.btnT2Fechar);

       // Vinculando o btnT1Set com o Views pela id:
        btnT2Set = findViewById(R.id.btnT2Set);

       // Chama a próxima tela 2 + Transferindo valores:
        btnT2Set.setOnClickListener(view -> {
            // Transferência de valores:
            float altura = Float.parseFloat(campoAltura.getText().toString());
            float peso = Float.parseFloat(campoPeso.getText().toString());
            float IMC = peso / (altura * altura);

            // Qual tela vou chamar após clicar nesse botão, dependendo do resultado do cálculo do IMC:
            if (IMC <= 18.5) {
                Intent intent = new Intent(this, AbaixoDoPesoActivity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            } else if (IMC <= 24.9) {
                Intent intent = new Intent(this, PesoNormalActivity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            } else if (IMC <= 29.9) {
                Intent intent = new Intent(this, SobrepesoActivity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            } else if (IMC <= 34.9) {
                Intent intent = new Intent(this, Obesidade1Activity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            } else if (IMC <= 39.9) {
                Intent intent = new Intent(this, Obesidade2Activity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            } else {
                Intent intent = new Intent(this, Obesidade3Activity.class);

                // Adicionando Parâmetro para outra Activity:
                intent.putExtra("peso", peso);
                intent.putExtra("altura", altura);
                intent.putExtra("imc", IMC);

                startActivity(intent);
                finish();
            }
        });

        //Voltando página se quiser fechar
        btnT2Fechar.setOnClickListener(view -> {
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
/*    @SuppressLint("SetTextI18n")
    public void enviar(View view) {
        //Istanciamento de objetos
        EditText campoPeso = findViewById(R.id.editTextPeso);
        EditText campoAltura = findViewById(R.id.editTextAltura);
        //Criar variáveis para recuperar o seu conteúdo e converter em String
        float peso = Float.parseFloat(campoPeso.getText().toString());
        float altura = Float.parseFloat(campoAltura.getText().toString());

    }*/

    public void limpar (View view) {
        EditText campoPeso = findViewById(R.id.editTextPeso);
        EditText campoAltura = findViewById(R.id.editTextAltura);


        campoPeso.setText("");
        campoAltura.setText("");
    }

    @Override
    protected void onResume(){
        super.onResume();
        Log.i("Ciclo de Vida", "Tela 2 - onResume");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 2 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 2 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 2 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 2 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 2 - onStart");
    }
}