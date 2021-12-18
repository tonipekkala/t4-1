package fi.tonipekkala.t4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

/**
 * Pääohjelma, joka näyttää käyttäjän tallentamat tiedot, ja voidaan siirtyä eri aktiviteetteihin
 * @author Toni Pekkala
 * @version 18.12.2021
 */
public class MainActivity extends AppCompatActivity {

    SharedPreferences sharedpreferences;

    TextView tvn;
    BMIClass bmi;

    /**
     * onCreatessa määritellään muuttujat ja asetetaan omat tiedot, mikäli muuttujissa on jotkin arvot
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyPreferences preferences = new MyPreferences(getSharedPreferences("MyPrefs", Context.MODE_PRIVATE));

        this.tvn = findViewById(R.id.nimi);
        DecimalFormat df = new DecimalFormat("0.00");

        bmi = new BMIClass(preferences.getHeight(), preferences.getWeight());
        tvn.setText("Hello "+preferences.getName() + "\nYou are a "  + preferences.getGender()
                + "\n\nYou're " + preferences.getHeight() + "cm"
                + "\nAnd " + preferences.getWeight() + " kg" + "\n\nBMI " + df.format(bmi.getBmi())
        );


    }


    /**
     * Metodi, jossa vaihdetaan BMI-aktiviteettiin
     */

    public void switchBMI(View view) {
        Intent intent = new Intent(this, DisplayBMIActivity.class);

        startActivity(intent);
    }

    /**
     *
     * Metodi, jota kutsuessa vaihdetaan asetuksiin
     */
    public void switchSettings(View view){
        Intent intent = new Intent(this, SettingsActivity.class);

        startActivity(intent);
    }

    /**
     *
     * Metodi, jossa vaihdetaan alkoholilaskuriin
     */
    public void switchAlcCalc(View view){
        Intent intent = new Intent(this, DrinkActivity.class);

        startActivity(intent);
    }
}