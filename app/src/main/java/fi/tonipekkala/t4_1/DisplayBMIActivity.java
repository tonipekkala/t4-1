package fi.tonipekkala.t4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import android.view.View;

public class DisplayBMIActivity extends AppCompatActivity {

    private BMIClass luokka;
    private String pituus, paino, bmi, asetaTeksti = "";
    TextView tvi, tva, tv;


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_message);
        Intent intent = getIntent();
        this.tvi = findViewById(R.id.pituus);
        this.tva = findViewById(R.id.paino);
        this.tv = findViewById(R.id.teksti);

        updateUI();
    }

    public void laskeBMI(View view){
        pituus = tvi.getText().toString();
        paino = tva.getText().toString();
        float ppituus = Float.parseFloat(pituus);
        float ppaino = Float.parseFloat(paino);
        luokka = new BMIClass(ppituus, ppaino);
        asetaTeksti = Float.toString(luokka.getBmi());
        updateUI();
    }

    public void updateUI(){
        tv.setText(asetaTeksti);
    }
}