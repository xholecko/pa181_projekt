package loadData.kultura;


import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.kultura.KulturaPamatihodnostiDaoImpl;
import entity.kultura.KulturaPamatihodnosti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPamatihodnostiImport {
    private static final String URL_BYVANIE = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/1";
    private static final String URL_DOPRAVA = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/2";
    private static final String URL_LUDOVA_KULTURA = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/3";
    private static final String URL_POMNIKY = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/4";
    private static final String URL_PRIEMYSEL = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/5";
    private static final String URL_SAKRALNE_PAMATIHODNOSTI = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/6";
    private static final String URL_VOJENSKE_PAMATIHODNOSTI = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/7";
    private static final String URL_ZAHRADY_PARKY = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/8";
    private static final String URL_ZDRAVOTNICTVO_SKOLSTVO = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/9";
    private static final String URL_INE = "https://opendata.bratislava.sk/dataset/download/celomestsky-zoznam-pamatihodnosti-mesta-bratislavy/10";

    public void getKulturaPamatihodnosti(JdbcPooledConnectionSource connectionSource){
        ArrayList<String>  typy = new ArrayList<>();
        typy.add(URL_BYVANIE);
        typy.add(URL_DOPRAVA);
        typy.add(URL_LUDOVA_KULTURA);
        typy.add(URL_POMNIKY);
        typy.add(URL_PRIEMYSEL);
        typy.add(URL_SAKRALNE_PAMATIHODNOSTI);
        typy.add(URL_VOJENSKE_PAMATIHODNOSTI);
        typy.add(URL_ZAHRADY_PARKY);
        typy.add(URL_ZDRAVOTNICTVO_SKOLSTVO);
        typy.add(URL_INE);

        try {
            KulturaPamatihodnostiDaoImpl dao = new KulturaPamatihodnostiDaoImpl(connectionSource);

            for(String val : typy) {
                java.net.URL url = new URL(val);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
                String line = br.readLine();
                String cvsSplitBy = ";";
                while ((line = br.readLine()) != null && !line.startsWith(";")){
                    String[] fields = line.split(cvsSplitBy);
                    KulturaPamatihodnosti entity = new KulturaPamatihodnosti(fields[4],fields[2],fields[0]);
                    dao.createIfNotExists(entity);
                }
                br.close();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
