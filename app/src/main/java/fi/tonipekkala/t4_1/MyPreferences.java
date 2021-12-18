package fi.tonipekkala.t4_1;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Luokka, jossa tallennetaan ja luetaan sovelluksen tiedot
 * @author Toni Pekkala
 * @version 18.12.2021
 */
public class MyPreferences
{
    /**
     * @param sharedpreferences tietojen tallentamiseen käyttettävä muuttuja
     */
    SharedPreferences sharedpreferences;

    /**
     *
     * @param preferences Muuttuja, joka annetaan tietojen tallentamiseen
     */
    public MyPreferences(SharedPreferences preferences) {
        this.sharedpreferences = preferences;
    }

    /**
     *
     * @return Palauttaa nimi muuttujan
     */
    public String getName()
    {
        return sharedpreferences.getString("name","");
    }

    /**
     *
     * @param name Asetetaan nimi muuttuja ja tallennetaan se sharedpreferenceillä
     */
    public void setName(String name) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("name",name);
        edit.commit();
    }

    /**
     *
     * @return Palauttaa sukupuolen
     */
    public String getGender()
    {
        return sharedpreferences.getString("gender","");
    }

    /**
     *
     * @param gender Asetetaan sukupuoli ja tallennetaan se sharedpreferenceillä
     */
    public void setGender(String gender) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("gender",gender);
        edit.commit();
    }

    /**
     *
     * @return palauttaa pituuden
     */
    public String getHeight()
    {
        return sharedpreferences.getString("height","");
    }

    /**
     *
     * @param height Asetetaan pituus ja tallennetaan se sharedpreferenceillä
     */
    public void setHeight(String height) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("height",height);
        edit.commit();
    }

    /**
     *
     * @return palauttaa paino
     */
    public String getWeight()
    {
        return sharedpreferences.getString("weight","");
    }

    /**
     *
     * @param weight Asetetaan paino ja tallennetaan se sharedpreferenceillä
     */
    public void setWeight(String weight) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("weight",weight);
        edit.commit();
    }

}