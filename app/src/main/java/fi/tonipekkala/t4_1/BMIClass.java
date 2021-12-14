package fi.tonipekkala.t4_1;

public class BMIClass {
    private float pituus, paino, bmi;



    public BMIClass(float pituus, float paino) {
        this.pituus = pituus;
        this.paino = paino;
    }

    public float getPituus() {
        return pituus;
    }

    public float getPaino() {
        return paino;
    }

    public float getBmi(){
        bmi = (paino/(pituus * pituus))*10000;
        return bmi;
    }
}

