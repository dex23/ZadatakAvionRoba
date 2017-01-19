package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.field.ForeignCollectionField;

/**
 * Created by user on 19.1.2017..
 */
public class Avion {
    public static final String POLJE_OZNAKA = "oznaka";
    public static final String POLJE_RASPON_KRILA = "raspon_krila";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_OZNAKA,canBeNull = false)
    private String oznaka;
    @DatabaseField(columnName = POLJE_RASPON_KRILA,canBeNull = false)
    private int rasponKrila;

    @ForeignCollectionField(foreignFieldName = "avion")
    private ForeignCollectionField<Roba> roba;

    public Avion(){

    }

    public Avion(String oznaka, int rasponKrila) {
        this.oznaka = oznaka;
        this.rasponKrila = rasponKrila;
    }

    public int getId() {
        return id;
    }

    public String getOznaka() {
        return oznaka;
    }

    public int getRasponKrila() {
        return rasponKrila;
    }

    public ForeignCollectionField<Roba> getRoba() {
        return roba;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOznaka(String oznaka) {
        this.oznaka = oznaka;
    }

    public void setRasponKrila(int rasponKrila) {
        this.rasponKrila = rasponKrila;
    }

    public void setRoba(ForeignCollectionField<Roba> roba) {
        this.roba = roba;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "id=" + id +
                ", oznaka='" + oznaka + '\'' +
                ", rasponKrila=" + rasponKrila +
                ", roba=" + roba +
                '}';
    }
}
