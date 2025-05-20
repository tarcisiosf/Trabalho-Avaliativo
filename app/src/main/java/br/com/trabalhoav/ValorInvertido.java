// ValorInvertido.java
package br.com.trabalhoav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ValorInvertido extends AppCompatActivity {
    private Button rgEventos;

    private EditText valorInvertido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_valor_invertido);

        valorInvertido = findViewById(R.id.valorInvertido);

        // recupera o texto invertido da Intent
        String texto = getIntent().getStringExtra("texto_invertido");
        if (texto != null) {
            valorInvertido.setText(texto);
        }

        rgEventos = findViewById(R.id.rgEventos);
    }

    public void registroEventos (View view) throws ClassNotFoundException{
        Intent intent = new Intent(view.getContext(), RegistroEvento.class);
        view.getContext().startActivity(intent);
    }
}
