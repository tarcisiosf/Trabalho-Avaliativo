package br.com.trabalhoav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Random;

public class GeradorDeValores extends AppCompatActivity {

    private EditText valor1;
    private EditText valor2;
    private EditText valorGerado;
    private Random random;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gerador_de_valores);

        // inicializa o gerador de números aleatórios
        random = new Random();

        // referencia os campos do layout
        valor1       = findViewById(R.id.valor1);
        valor2       = findViewById(R.id.valor2);
        valorGerado  = findViewById(R.id.valorgerado);

        // ao clicar nos EditTexts, limpa o texto padrão
        valor1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor1.setText("");
            }
        });
        valor2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                valor2.setText("");
            }
        });
    }


    public void gerar_valor(View view) {
        String sMin = valor1.getText().toString().trim();
        String sMax = valor2.getText().toString().trim();

        int min = 0, max = 0;

        if (!sMin.isEmpty() && !sMax.isEmpty()) {
            try {
                min = Integer.parseInt(sMin);
                max = Integer.parseInt(sMax);
            } catch (NumberFormatException e) {
                Toast.makeText(this, "Digite valores numéricos válidos", Toast.LENGTH_SHORT).show();
                return;
            }
        }
        int resultado = random.nextInt(max - min + 1) + min;
        valorGerado.setText(String.valueOf(resultado));
    }
}
