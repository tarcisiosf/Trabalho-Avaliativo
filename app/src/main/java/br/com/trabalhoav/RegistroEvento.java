package br.com.trabalhoav;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class RegistroEvento extends AppCompatActivity {

    private EditText txtRegistro;
    private DatePicker datePicker;
    private ListView listaEventos;
    private ArrayList<String> eventos;
    private ArrayAdapter<String> adapter;
    private int contador = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_evento);

        txtRegistro   = findViewById(R.id.txtRegistro);
        datePicker    = findViewById(R.id.date);
        listaEventos  = findViewById(R.id.Lista_eventos);

        // Inicializa lista e adapter
        eventos = new ArrayList<>();
        adapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                eventos
        );
        listaEventos.setAdapter(adapter);
    }


    public void gravar_evento(View view) {
        String texto = txtRegistro.getText().toString().trim();
        if (texto.isEmpty()) {
            Toast.makeText(this, "Digite um texto para registrar", Toast.LENGTH_SHORT).show();
            return;
        }

        // Formata data do DatePicker como dd/MM/yyyy
        int dia   = datePicker.getDayOfMonth();
        int mes   = datePicker.getMonth() + 1; // meses começam em 0
        int ano   = datePicker.getYear();
        String data = String.format("%02d/%02d/%04d", dia, mes, ano);

        // Monta linha: contador – data – evento
        String linha = contador + " – " + data + " – " + texto;
        eventos.add(linha);
        adapter.notifyDataSetChanged();

        contador++;
        txtRegistro.setText("");
    }
}
