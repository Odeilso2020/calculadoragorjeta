package br.com.progiv.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Objetos formatadores de moeda
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private double vrConta = 0.0; // Valor da conta inserido pelo usuario
    private double percent = 0.15; // Porcentagem inicial da gorjeta
    private TextView valorContaTextView; // Mostra o valor da conta
    private TextView valorTotalTextView; // Mostra o valor da conta total calculada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obter referencias para o TextView manipulados via programação
        valorContaTextView = (TextView)findViewById(R.id.valorConta);

    }
}