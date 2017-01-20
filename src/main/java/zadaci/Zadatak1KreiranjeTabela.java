package zadaci;

import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.TableUtils;
import model.Avion;
import model.Roba;

import java.io.IOException;

/**
 * Created by user on 19.1.2017..
 */
public class Zadatak1KreiranjeTabela {
    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            //Potrebno je prvo konektovati se na bazu
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");


            TableUtils.dropTable(connectionSource, Roba.class,true);
            TableUtils.dropTable(connectionSource, Avion.class,true);
            
            TableUtils.createTable(connectionSource, Avion.class);
            TableUtils.createTable(connectionSource,Roba.class);


        }catch (Exception e) {
            e.printStackTrace();
        }finally {
            if (connectionSource != null) {
                try {
                    //Zatvaranje konekcije sa bazom
                    connectionSource.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
