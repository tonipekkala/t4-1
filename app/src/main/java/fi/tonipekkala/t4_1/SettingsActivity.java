package fi.tonipekkala.t4_1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Luokassa  tallennetaan käyttäjän syöttämät arvot
 * @author Toni Pekkala
 * @version 18.12.2021
 */

public class SettingsActivity extends AppCompatActivity {

    public static final String MyPREFERENCES = "MyPrefs" ;

    MyPreferences preferences;

    enum Moodi {
        male,female
    }

    RadioButton btm,btf;
    TextView tvn, tvh, tvw;
    Moodi moodi;

    /**
     * onCreate määrittää ja alustaa muuttujien arvot
     *
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        preferences = new MyPreferences(getSharedPreferences(MyPREFERENCES, Context.MODE_PRIVATE));

        this.tvn = findViewById(R.id.nimi);
        this.tvh = findViewById(R.id.height);
        this.tvw = findViewById(R.id.weight);
        this.btm = findViewById(R.id.male);
        this.btf = findViewById(R.id.female);

        moodi = Moodi.male;

        this.tvn.setText(preferences.getName());
        this.tvh.setText(preferences.getHeight());
        this.tvw.setText(preferences.getWeight());

        if(preferences.getGender()=="female")
            this.btf.setChecked(true);
        else
            this.btm.setChecked(true);
    }

    /**
     *  Metodi, jossa katsotaan kumpaa radionappia ollaan painettu
     *
     */
    public void radioButtonClicked(View v) {
        if (!((RadioButton) v).isChecked())
            return;

        int selectedId = v.getId();

        switch (selectedId) {
            case R.id.male:
                moodi = Moodi.male;
                break;
            case R.id.female:
                moodi = Moodi.female;
                break;
        }
        preferences.setGender(returnGender());
    }

    /**
     *
     * @return palauttaa sukupuolen
     */
    public String returnGender(){
        switch (moodi) {
            case male:
                return "male";
            case female:
                return  "female";
        }
        return "3rd gender";
    }

    /**
     * Tallennetaan tiedot
     *
     */
    public void saveButtonPressed(View v){

        preferences.setName(tvn.getText().toString());

        if(onkoNumero(tvh.getText().toString()) == true && onkoNumero(tvw.getText().toString()) == true) {
            preferences.setWeight(tvw.getText().toString());
            preferences.setHeight(tvh.getText().toString());
        }

    }

    /**
     * Metodissa tarkistetaan onko syötetty arvo numero vai ei
     * @param string luettava arvo
     * @return  palauttaa true tai false vastauksen perusteella
     */
    public static boolean onkoNumero(String string) {
        float floatVal;

        if(string == null || string.equals("")) {
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
