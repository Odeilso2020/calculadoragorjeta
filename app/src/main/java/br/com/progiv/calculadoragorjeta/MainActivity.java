package br.com.progiv.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    // Objetos formatadores de moeda
    private static final NumberFormat currencyFormat = NumberFormat.getCurrencyInstance();

    private double vrConta = 0.0; // Valor da conta inserido pelo usuario
    private double percent = 0.15; // Porcentagem inicial da gorjeta
    private TextView valorContaTextView; // Mostra o valor da conta
    private TextView valorGorjetaTextView; // Mostra o valor da gorjeta
    private TextView valorTotalTextView; // Mostra o valor da conta total calculada

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Obter referencias para o TextView manipulados via programação
        valorContaTextView = (TextView)findViewById(R.id.valorConta);
        valorTotalTextView = (TextView)findViewById(R.id.valorTotal);
        valorGorjetaTextView = (TextView)findViewById(R.id.valorGorjeta);

        // Zerando
        valorTotalTextView.setText(currencyFormat.format(0));
        valorGorjetaTextView.setText(currencyFormat.format(0));

        // Configura o receptor TextWatcher de valorContaEditText
        EditText valorContaEditText = (EditText)findViewById(R.id.valorConta);
        valorContaEditText.addTextChangedListener(valorContaEditWatcher);

        // Configura o receptor OnSeekBarChangeListener de porcentagemBar
        SeekBar percentSeekBar = (SeekBar)findViewById(R.id.porcentagemBar);
        percentSeekBar.setOnSeekBarChangeListener(seekBarListener);
    }

    private void calcular(){
        try{
            double gorjeta = vrConta * percent;
            double total = vrConta + gorjeta;
            valorTotalTextView.setText(currencyFormat.format(total));
            valorGorjetaTextView.setText((currencyFormat.format(gorjeta)));
            // %
        }catch (Exception ex){
            String y = ex.getMessage();
        }
    }

    private final SeekBar.OnSeekBarChangeListener seekBarListener = new SeekBar.OnSeekBarChangeListener() {
        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            percent = progress / 100.0;
            calcular();
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    };

    private final TextWatcher valorContaEditWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            try{
                vrConta = Double.parseDouble(s.toString());
                valorTotalTextView.setText(currencyFormat.format(vrConta));
            }
            catch (Exception ex){
                String y = ex.getMessage();
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}