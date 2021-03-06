package com.example.vertice.preferencias;

import android.content.Context;
import android.content.SharedPreferences;

public class Preferencies
{
    private static final String NOM_PREFERENCIES = "PreferenciasVertice";
    private final static String CLAU_USER="usuario";
    private final static String CLAU_PASSWD="password";

    private String user;
    private String password;

    private SharedPreferences prefs;

    public Preferencies(Context ctx)
    {
        this.prefs = ctx.getSharedPreferences(NOM_PREFERENCIES, ctx.MODE_PRIVATE);
        this.user = this.prefs.getString(CLAU_USER, "");
        this.password = this.prefs.getString(CLAU_PASSWD, "");
    }

    public String getUser()
    {
        return user;
    }

    public void setUser(String user)
    {
        this.user = user;
        SharedPreferences.Editor editor = this.prefs.edit();
        editor.putString(CLAU_USER,user);
        editor.commit();
    }

    public String getPassword()
    {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
        SharedPreferences.Editor editor = this.prefs.edit();
        editor.putString(CLAU_PASSWD,password);
        editor.commit();
    }
}