package br.fecapccp.projetoni_murilovieira;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private Button btnT1Set;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        Log.i("Ciclo de Vida", "Tela 1 - onCreate");

        // Vinculando o btnT1Set com o Views pela id:
        btnT1Set = findViewById(R.id.btnT1Set);

        // Chama a próxima tela 2 + Transferindo valores:
        btnT1Set.setOnClickListener(view -> {
            // Qual tela vou chamar após clicar nesse botão:
            Intent intent = new Intent(this, CalculoIMCActivity.class);
            startActivity(intent);
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
        Log.i("Ciclo de Vida", "Tela 1 - onResume");
    }

    @Override
    protected  void onPause(){
        super.onPause();
        Log.i("Ciclo de Vida", "Tela 1 - onPause");
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
        Log.i("Ciclo de Vida", "Tela 1 - onDestroy");
    }

    @Override
    protected void onStop(){
        super.onStop();
        Log.i("Ciclo de Vida", "Tela 1 - onStop");
    }

    @Override
    protected void onRestart(){
        super.onRestart();
        Log.i("Ciclo de Vida", "Tela 1 - onRestart");
    }

    @Override
    protected void onStart(){
        super.onStart();
        Log.i("Ciclo de Vida", "Tela 1 - onStart");
    }
}