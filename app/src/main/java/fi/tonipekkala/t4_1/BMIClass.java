package fi.tonipekkala.t4_1;

import android.view.View;

/**
 * Luokka, jossa tapahtuu BMI:n laskeminen
 * @author Toni Pekkala
 * @version
 */

public class BMIClass {
    /**
     * Muuttujat, joita tarvitaan BMI:n laskuun
     */
    private double pituus, paino, bmi;


    /**
     * Konstruktorissa tarkistetaan, onko saatu arvo numero ja muutetaan Stringistä doubleksi
     * @param pituus pituus muuttuja
     * @param paino paino muuttuja
     */
    public BMIClass(String pituus, String paino) {
        if(pituus.isEmpty())
            this.pituus = 0;
        else
            this.pituus = Double.parseDouble(pituus);

        if(paino.isEmpty())
            this.paino = 0;
        else
            this.paino = Double.parseDouble(paino);
    }

    /**
     *
     * @return palautetaan pituus
     */
    public double getPituus() {
        return pituus;
    }

    /**
     *
     * @return palautetaan paino
     */
    public double getPaino() {
        return paino;
    }

    /**
     *
     * @return palautetaan BMI
     */
    public double getBmi(){
        bmi = (paino / pituus / pituus) * 10000;
        return bmi;
    }

}



