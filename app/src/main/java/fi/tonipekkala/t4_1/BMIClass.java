package fi.tonipekkala.t4_1;

import android.view.View;

//Luokassa määritetään BMI
public class BMIClass {
    private double pituus, paino, bmi;



    public BMIClass(String pituus, String paino) {
        this.pituus = Double.parseDouble(pituus);
        this.paino = Double.parseDouble(paino);
    }

    public double getPituus() {
        return pituus;
    }

    public double getPaino() {
        return paino;
    }

    public double getBmi(){
        bmi = (paino / pituus / pituus) * 10000;
        return bmi;
    }

}



