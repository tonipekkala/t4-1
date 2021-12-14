package fi.tonipekkala.t4_1;

import android.view.View;

public class BMIClass {
    private double pituus, paino, bmi;



    public BMIClass(double pituus, double paino) {
        this.pituus = pituus;
        this.paino = paino;
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

