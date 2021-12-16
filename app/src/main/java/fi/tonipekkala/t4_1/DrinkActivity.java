package fi.tonipekkala.t4_1;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Alkoholi pitoisuuden laskuri
 * @author George Chirikov
 * @version 15.12.2021
 */


public class DrinkActivity extends AppCompatActivity {

    /**
     *Tarvittavien muuttujien luominen
     * @param TextView muuttujat joihin määritellään UI elementit
     * @param mass käyttäjän syöttämä paino (Kg)
     * @param k laskukaavassa käytettävä kerroin, joka riippuu sukupuolesta
     * @param q1...q8 muuttuja, johon tallennetaan käyttäjän syöttämien juomien määrä (quantity)
     * @param sob aika jolloin alkoholi poistunut kehosta
     * @param h aika juomisen aloittamisesta
     * @param drink luokan "Drink" olio
     * @param result laskettu alkoholin pitoisuus promilleissa
     */
    private TextView tv, tv2, summary, tvm, tvh, tvq1 , tvq2, tvq3 , tvq4, tvq5 , tvq6, tvq7 , tvq8;
    private int mass;
    private double k;
    private int q1, q2, q3, q4, q5, q6, q7, q8;
    private double sob;
    private int h;
    Drink drink = new Drink();
    private double result;

    /**
     * onCreate määrittää ja alustaa muuttujien arvot
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);
        this.tv = findViewById(R.id.result);
        this.tv2 = findViewById(R.id.result2);
        this.summary = findViewById(R.id.sum);
        this.tvm = findViewById(R.id.mass);
        this.tvh = findViewById(R.id.time);
        this.tvq1 = findViewById(R.id.Q1);
        this.tvq2 = findViewById(R.id.Q2);
        this.tvq3 = findViewById(R.id.Q3);
        this.tvq4 = findViewById(R.id.Q4);
        this.tvq5 = findViewById(R.id.Q5);
        this.tvq6 = findViewById(R.id.Q6);
        this.tvq7 = findViewById(R.id.Q7);
        this.tvq8 = findViewById(R.id.Q8);
        this.q1 = 0;
        this.q2 = 0;
        this.q3 = 0;
        this.q4 = 0;
        this.q5 = 0;
        this.q6 = 0;
        this.q7 = 0;
        this.q8 = 0;
        this.k = 0;
        this.mass = 0;
        this.h = 0;
    }

    /**
     * Kutsutaan aina kun kun lisätään juoma napin painalluksella
     * Riippuen napin ID:stä kutsuu tietyn funktion luokasta "Drink"
     * Päivittää syöttämien juomien määrän
     * buttonReset asettaa muuttujat ja UI elementit alku arvoihin
     */
    public void onButtonPressed(View v) {
        switch (v.getId()) {
            case R.id.button1:
                drink.drink2833();
                this.q1++;
                this.tvq1.setText("x " + this.q1);
                break;
            case R.id.button2:
                drink.drink2850();
                this.q2++;
                this.tvq2.setText("x " + this.q2);
                break;
            case R.id.button3:
                drink.drink4733();
                this.q3++;
                this.tvq3.setText("x " + this.q3);
                break;
            case R.id.button4:
                drink.drink4750();
                this.q4++;
                this.tvq4.setText("x " + this.q4);
                break;
            case R.id.button5:
                drink.drink5533();
                this.q5++;
                this.tvq5.setText("x " + this.q5);
                break;
            case R.id.button6:
                drink.drink5550();
                this.q6++;
                this.tvq6.setText("x " + this.q6);
                break;
            case R.id.button7:
                drink.drink12524();
                this.q7++;
                this.tvq7.setText("x " + this.q7);
                break;
            case R.id.button8:
                drink.drink40004();
                this.q8++;
                this.tvq8.setText("x " + this.q8);
                break;
            case R.id.buttonReset:
                drink.reset();
                this.tv.setText("Select gender and add values");
                this.tv2.setText("Select what have you been drinking");
                this.summary.setText("");
                this.q1 = 0;
                this.tvq1.setText("x " + this.q1);
                this.q2 = 0;
                this.tvq2.setText("x " + this.q2);
                this.q3 = 0;
                this.tvq3.setText("x " + this.q3);
                this.q4 = 0;
                this.tvq4.setText("x " + this.q4);
                this.q5 = 0;
                this.tvq5.setText("x " + this.q5);
                this.q6 = 0;
                this.tvq6.setText("x " + this.q6);
                this.q7 = 0;
                this.tvq7.setText("x " + this.q7);
                this.q8 = 0;
                this.tvq8.setText("x " + this.q8);
                break;
            default:
                break;
        }
    }

    /**
     * Tarkistaa painon ja ajan syöttökenttien arvot (täytyy olla luku)
     * @return true jos syötetty arvo kelvollinen tai false jos syötetty arvo virheellinen
     */
    public static boolean ifNumber(String string) {
        float floatVal;

        if(string == null || string.equals("")) {
            return false;
        }

        try {
            floatVal = Float.parseFloat(string);
            return true;
        } catch (NumberFormatException e) {
        }
        return false;
    }

    /**
     * Asettaa muuttujalle "k" arvon riippuen kumpi radioButton on painettu
     */
    public void onRbuttonPressed1(View v){
        this.k = 0.75;
    }

    public void onRbuttonPressed2(View v){
        this.k = 0.66;
    }

    /**
     * Tarkistetaan ifNumber() funktiolla ovatko käyttäjän syötetyt arvot kelvolliset
     * jos ei, käyttäjää varoitetaan
     * jos ovat, haetaan syöttökenttien arvot ja käytetään niitä promille laskurin kaavassa
     * lasketaan missä ajassa alkoholi poistuu kehosta (sob)
     * tarkistaa ettei kumpikaan tuloksista ole negatiivinen (result ja sob)
     * kutsuu update() funktion
     * promillet = (juotu 100% alkoholi - poltettu alkoholi juomisen aikana) / (kerroin k * paino)
     * Alkoholi hajoaa kehossa 0.1 g/h/Kg esim. 80 Kg polttaa tunnissa 8 g ja viidessä 40 g
     * @return result eli promillet ja sob eli missä ajassa alkoholi poistuu kehosta
     */
    public void alcCalc(View view){

        if(!ifNumber(this.tvm.getText().toString())){
            this.tv.setText("Enter valid values");
            this.tv2.setText("");
            this.summary.setText("");
        }
        else if(!ifNumber(this.tvh.getText().toString())){
            this.tv.setText("Enter valid values");
            this.tv2.setText("");
            this.summary.setText("");
        }
        else if(k == 0){
            this.tv.setText("Select gender");
            this.tv2.setText("");
            this.summary.setText("");
        }
        else{

            this.mass = Integer.parseInt(this.tvm.getText().toString());
            this.h = Integer.parseInt(this.tvh.getText().toString());

            result = (drink.getPureAlc() - h * mass * 0.1) / (k * mass);

            if(result < 0){
                result = 0;
            }

            sob = (drink.getPureAlc() - h * mass * 0.1)/(mass * 0.1);

            if(sob < 0){
                sob = 0;
            }

            update();
        }
    }

    /**
     * Asettaa alcCalc() funktion tuottamat tulokset tekstikenttiin
     * String.format leikkaa ylimääräset desimaalit pois (rajoitettu yhteen desimaaliin)
     */
    public void update(){
        this.tv.setText((String.format("Your blood alcohol consentration is " + "%.1f", result) + " ppt"));
        this.tv2.setText(String.format("You will be souber after " + "%.1f", sob) + " hours");

        if(result < 0.5 && result > 0.1){
            this.summary.setText("You are having fun");
        }
        else if(result >= 0.5 && result < 1){
            this.summary.setText("Illegal to drive");
        }
        else if(result >= 1 && result < 3){
            this.summary.setText("Walking becomes harder");
        }
        else if(result >= 3 && result < 5){
            this.summary.setText("Get some help :/");
        }
        else if(result >= 5 ){
            this.summary.setText("Lethal dose");
        }
        else{

        }
    }
}
