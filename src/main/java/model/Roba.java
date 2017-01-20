package model;

import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.table.DatabaseTable;

/**
 * Created by user on 19.1.2017..
 */
@DatabaseTable(tableName = "roba")
public class Roba {
    public static final String POLJE_NAZIV = "naziv";
    public static final String POLJE_OPIS = "opis";
    public static final String POLJE_TEZINA = "tezina";
    public static final String POLJE_VISINA="visina";
    public static final String POLJE_DUZINA="duzina";
    public static final String POLJE_SIRINA="sirina";

    @DatabaseField(generatedId = true)
    private int id;
    @DatabaseField(columnName = POLJE_NAZIV,canBeNull = false)
    private String naziv;
    @DatabaseField(columnName = POLJE_OPIS,canBeNull = false)
    private String opis;
    @DatabaseField(columnName = POLJE_TEZINA,canBeNull = false)
    private double tezina;
    @DatabaseField(columnName = POLJE_VISINA,canBeNull = false)
    private double visina;
    @DatabaseField(columnName = POLJE_DUZINA,canBeNull = false)
    private double duzina;
    @DatabaseField(columnName = POLJE_SIRINA,canBeNull = false)
    private double sirina;

    @DatabaseField(foreign = true,foreignAutoRefresh = true,canBeNull = true)
    private Avion avion;

    public Roba(){

    }

    public Roba(String naziv, String opis, double tezina, double visina, double duzina, double sirina) {
        this.naziv = naziv;
        this.opis = opis;
        this.tezina = tezina;
        this.visina = visina;
        this.duzina = duzina;
        this.sirina = sirina;
    }

    public int getId() {
        return id;
    }

    public String getNaziv() {
        return naziv;
    }

    public String getOpis() {
        return opis;
    }

    public double getTezina() {
        return tezina;
    }

    public double getVisina() {
        return visina;
    }

    public double getDuzina() {
        return duzina;
    }

    public double getSirina() {
        return sirina;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNaziv(String naziv) {
        this.naziv = naziv;
    }

    public void setOpis(String opis) {
        this.opis = opis;
    }

    public void setTezina(double tezina) {
        this.tezina = tezina;
    }

    public void setVisina(double visina) {
        this.visina = visina;
    }

    public void setDuzina(double duzina) {
        this.duzina = duzina;
    }

    public void setSirina(double sirina) {
        this.sirina = sirina;
    }

    @Override
    public String toString() {
        return "Roba{" +
                "id=" + id +
                ", naziv='" + naziv + '\'' +
                ", opis='" + opis + '\'' +
                ", tezina='" + tezina + '\'' +
                ", visina='" + visina + '\'' +
                ", duzina='" + duzina + '\'' +
                ", sirina='" + sirina + '\'' +
                '}';
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }
}
