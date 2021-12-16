package fi.tonipekkala.t4_1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

import android.view.View;

import java.text.DecimalFormat;

public class DisplayBMIActivity extends AppCompatActivity {

    // Alustetaan muuttujat
    private BMIClass luokka;
    private String pituus, paino, bmi, asetaTeksti = "";
    private TextView tvi, tva, tv;


    //ohjelman luodessa asetetaan näkymä ja etsitään id:t xml tiedostosta
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_message);
        Intent intent = getIntent();
        this.tvi = findViewById(R.id.pituus);
        this.tva = findViewById(R.id.paino);
        this.tv = findViewById(R.id.teksti);

        updateUI();
    }

    // BMI:n laskufunktio
    public void laskeBMI(View view) {
        // Asetetaan pituudelle ja painolle arvot, jotka saadaan lukemalla tekstikentän xml:stä
        pituus = tvi.getText().toString();
        paino = tva.getText().toString();

        //tarkistetaan, että kentän ei ole tyhjiä tai ettei niissä ole merkkijonoja, jonka jälkeen stringit muutetaan doubleiksi
        if (onkoNumero(pituus) == true && onkoNumero(paino) == true) {
            luokka = new BMIClass(paino, pituus);

            // asetaan luvut siten, että näytetään vain 2 desimaalia
            DecimalFormat df = new DecimalFormat("0.00");
            asetaTeksti = "Your BMI is: " + df.format(luokka.getBmi());

            // Tarkistaan saatu arvo ja annetaan sen perusteella tekstille väri
            if (luokka.getBmi() >= 0 && luokka.getBmi() <= 14.9) {
                tv.setTextColor(this.getResources().getColor(R.color.lighterblue));
                asetaTeksti += "\nUnderweight (Severe thinness)\t";
            }
            if (luokka.getBmi() > 14.9 && luokka.getBmi() < 16.9) {
                tv.setTextColor(this.getResources().getColor(R.color.lightblue));
                asetaTeksti += "\nUnderweight (Moderate thinness)\t";
            }
            if (luokka.getBmi() >= 16.9 && luokka.getBmi() <= 18.9) {
                tv.setTextColor(this.getResources().getColor(R.color.yellow));
                asetaTeksti += "\nUnderweight (Mild thinness)\t";
            }
            if (luokka.getBmi() > 18.9 && luokka.getBmi() <= 24.9) {
                tv.setTextColor(this.getResources().getColor(R.color.green));
                asetaTeksti += "\nNormal range";
            }
            if (luokka.getBmi() > 24.9 && luokka.getBmi() <= 29.9) {
                tv.setTextColor(this.getResources().getColor(R.color.lightgreen));
                asetaTeksti += "\nOverweight (Pre-obese)";
            }
            if (luokka.getBmi() > 29.9 && luokka.getBmi() <= 34.9) {
                tv.setTextColor(this.getResources().getColor(R.color.yellow));
                asetaTeksti += "\nObese (Class I)";
            }
            if (luokka.getBmi() > 34.9 && luokka.getBmi() <= 39.9) {
                tv.setTextColor(this.getResources().getColor(R.color.red));
                asetaTeksti += "\nObese (Class II)\t";
            }
            if (luokka.getBmi() >= 40) {
                tv.setTextColor(this.getResources().getColor(R.color.darkred));
                asetaTeksti += "\nObese (Class III)\t";
            }
        } else {
            asetaTeksti = "Add numbers to the fields";
        }
        updateUI();

    }

    // Asetetaan BMI-arvo tekstikenttään
    public void updateUI() {
        tv.setText(asetaTeksti);
    }


    //Tarkistetaan onko syötetty String numero vai ei
    public static boolean onkoNumero(String string) {
        float floatVal;

        if (string == null || string.equals("")) {
            System.out.println("Syötä luvut");
            return false;
        }

        try {
            floatVal = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("Syötä jokin luku");
        }
        return false;
    }

}