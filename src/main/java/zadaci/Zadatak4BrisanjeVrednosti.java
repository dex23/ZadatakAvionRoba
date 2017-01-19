package zadaci;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import model.Avion;
import model.Roba;

import java.io.IOException;
import java.util.List;

/**
 * Created by user on 19.1.2017..
 */
public class Zadatak4BrisanjeVrednosti {
    static Dao<Avion,Integer> avionDao;
    static Dao<Roba,Integer> robaDao;

    public static void main(String[] args) {
        ConnectionSource connectionSource = null;
        try {
            //Potrebno je prvo konektovati se na bazu
            connectionSource = new JdbcConnectionSource("jdbc:sqlite:avionRoba.db");
            //Instanciranje Dao objekata
            avionDao = DaoManager.createDao(connectionSource, Avion.class);
            robaDao = DaoManager.createDao(connectionSource, Roba.class);

            //Prikaz vrednosti tabele Roba
            List<Roba> roba=robaDao.queryForAll();
            for(Roba r:roba)
                System.out.println("Roba = " + r);

            //Pronalazenje robe koje za vrednost kolone naziv imaju
            // vrednost "Voda"
            List<Roba> pronadjenaRoba=robaDao.queryForEq(Roba.POLJE_NAZIV,"Voda");
            Roba robaZaBrisanje=pronadjenaRoba.get(0);//Preuzimamo prvu pronadjenu
            //Brisemo vrednost iz baze
            robaDao.delete(robaZaBrisanje);

            /*Prikaz vrednosti tabele Roba
               da potvrdimo da je vrednost obrisana
             */
            roba=robaDao.queryForAll();
            for(Roba r:roba)
                System.out.println("Roba = " + r);


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
