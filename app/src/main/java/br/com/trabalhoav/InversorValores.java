package br.com.trabalhoav;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class InversorValores extends AppCompatActivity {

    private EditText inverterTexto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inversor_valores);

        inverterTexto = findViewById(R.id.inverterTexto);
    }

    public void inverter(View view) {
        String textoOriginal = inverterTexto.getText().toString();
        // limpa o campo para nova digitação
        inverterTexto.setText("");

        // inverte o texto
        String textoInvertido = new StringBuilder(textoOriginal)
                .reverse()
                .toString();

        // envia para a última tela
        Intent intent = new Intent(this, ValorInvertido.class);
        intent.putExtra("texto_invertido", textoInvertido);
        startActivity(intent);
    }
}
