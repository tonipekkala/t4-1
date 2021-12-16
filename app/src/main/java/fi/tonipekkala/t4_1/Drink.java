package fi.tonipekkala.t4_1;

import androidx.appcompat.app.AppCompatActivity;

/**
 * Laskee, lähettää ja alustaa 100% alkoholin määrä grammoissa
 * @author George Chirikov
 * @version 14.12.2021
 */
public class Drink {

    /**
     * @param vol juoman tilavuus (volume)
     * @param percent juoman alkoholin tilavuus prosentti
     * @param dens etanolin tiheys (789.4...g/L)
     * @param pureAlc 100% alkoholin määrä grammoissa
     */
    private double vol;
    private double percent;
    private double dens;
    private double pureAlc;

    public Drink() {
        this.dens = 789.4;
    }

    /**
     * 8 seuraavaa funktiota kutsutaan MainActivity:ssa kun painetaan juoman valitsemis nappia
     * jokainen funktio vastaa omaa nappia ja juomaa jossa asetetaan tilavuudelle ja prosentille arvot
     * kutsuvat add() funktion
     */
    public void drink2833() {
        this.vol = 0.33;
        this.percent = 2.8;
        add();
    }

    public void drink2850() {
        this.vol = 0.50;
        this.percent = 2.8;
        add();
    }

    public void drink4733() {
        this.vol = 0.33;
        this.percent = 4.7;
        add();
    }

    public void drink4750() {
        this.vol = 0.50;
        this.percent = 4.7;
        add();
    }

    public void drink5533() {
        this.vol = 0.33;
        this.percent = 5.5;
        add();
    }

    public void drink5550() {
        this.vol = 0.50;
        this.percent = 5.5;
        add();
    }

    public void drink12524() {
        this.vol = 0.24;
        this.percent = 12.5;
        add();
    }

    public void drink40004() {
        this.vol = 0.04;
        this.percent = 40;
        add();
    }

    /**
     * laskee ja tallentaa 100% alkoholin määrän grammoissa muuttujaan pureAlc
     * tilavuus(L) * (Alc% / 100) * 789.4(g/L)
     */
    public void add(){
        this.pureAlc += this.vol * this.percent / 100 * this.dens;
    }

    /**
     * Reset napilla pääohjelma kutsuu reset() funktion joka alustaa muuttujan pureAlc
     */
    public void reset(){
        this.pureAlc = 0;
    }

    /**
     * Pääohjelmassa haetaan pureAlc arvo jota käytetään myöhemmin promille lasku kaavassa
     */
    public double getPureAlc() {
        return pureAlc;
    }
}
