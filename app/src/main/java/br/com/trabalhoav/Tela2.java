package br.com.trabalhoav;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Tela2 extends AppCompatActivity {

    private Button btn_telagerador, btn_telainversor, btn_telaeventos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_tela2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btn_telagerador = findViewById(R.id.btn_telagerador);
        btn_telainversor = findViewById(R.id.btn_telainversor);
        btn_telaeventos = findViewById(R.id.btn_telaeventos);
    }

    public void tela_gerador (View view) throws ClassNotFoundException{
        Intent intent = new Intent(view.getContext(), GeradorDeValores.class);
        view.getContext().startActivity(intent);
    }

    public void tela_inversor (View view) throws ClassNotFoundException{
        Intent intent = new Intent(view.getContext(), InversorValores.class);
        view.getContext().startActivity(intent);
    }

    public void tela_eventos (View view) throws ClassNotFoundException{
        Intent intent = new Intent(view.getContext(), RegistroEvento.class);
        view.getContext().startActivity(intent);
    }
}