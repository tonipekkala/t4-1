package fi.tonipekkala.t4_1;

import android.content.Context;
import android.content.SharedPreferences;

public class MyPreferences
{
    SharedPreferences sharedpreferences;

    public MyPreferences(SharedPreferences preferences) {
        this.sharedpreferences = preferences;
    }

    public String getName()
    {
        return sharedpreferences.getString("name","");
    }

    public void setName(String name) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("name",name);
        edit.commit();
    }

    public String getGender()
    {
        return sharedpreferences.getString("gender","");
    }

    public void setGender(String gender) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("gender",gender);
        edit.commit();
    }

    public String getHeight()
    {
        return sharedpreferences.getString("height","");
    }

    public void setHeight(String height) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("height",height);
        edit.commit();
    }

    public String getWeight()
    {
        return sharedpreferences.getString("weight","");
    }

    public void setWeight(String weight) {
        SharedPreferences.Editor edit = sharedpreferences.edit();
        edit.putString("weight",weight);
        edit.commit();
    }

}