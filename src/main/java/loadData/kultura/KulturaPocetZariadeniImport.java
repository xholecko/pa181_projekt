package loadData.kultura;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.kultura.KulturaPocetZariadeniDaoImpl;
import entity.kultura.KulturaPocetZariadeni;
import enums.TypZariadeni;

import java.io.*;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents:
 * @author xholecko
 */
public class KulturaPocetZariadeniImport {
    private static final String URL_DIVADLA = "https://opendata.bratislava.sk/dataset/download/pocet-divadiel/1";
    private static final String URL_GALERIA = "https://opendata.bratislava.sk/dataset/download/pocet-galerii/1";
    private static final String URL_MUZEUM = "https://opendata.bratislava.sk/dataset/download/pocet-muzei/1";
    private static final String URL_KINO = "https://opendata.bratislava.sk/dataset/download/pocet-premietacich-sal/1";
    private static final String URL_VEDECKA_KNIZNICA = "https://opendata.bratislava.sk/dataset/download/pocet-vedeckych-kniznic-a-pocet-kniznicnych-jednotiek/1";
    private static final String URL_VEREJNA_KNIZNICA = "https://opendata.bratislava.sk/dataset/download/pocet-verejnych-kniznic-a-pocet-kniznicnych-jednotiek/1";
    private static final String URL_VOLNY_CAS = "https://opendata.bratislava.sk/dataset/download/pocet-zariadeni-na-volny-cas-a-zaujmovu-cinnost-pre-deti-a-mladez/1";


    public void getKulturaPocetZariadeni(JdbcPooledConnectionSource connectionSource){
        HashMap<String, String> maps = new HashMap<>();
        maps.put(TypZariadeni.DIVADLO.toString(),URL_DIVADLA);
        maps.put(TypZariadeni.GALERIA.toString(),URL_GALERIA);
        maps.put(TypZariadeni.MUZEUM.toString(),URL_MUZEUM);
        maps.put(TypZariadeni.KINO.toString(),URL_KINO);
        maps.put(TypZariadeni.VEDECKA_KNIZNICA.toString(),URL_VEDECKA_KNIZNICA);
        maps.put(TypZariadeni.VEREJNA_KNIZNICA.toString(),URL_VEREJNA_KNIZNICA);
        maps.put(TypZariadeni.VOLNY_CAS_MLADEZ.toString(),URL_VOLNY_CAS);

        try {
            KulturaPocetZariadeniDaoImpl dao = new KulturaPocetZariadeniDaoImpl(connectionSource);

            for(Map.Entry<String, String> entry : maps.entrySet()) {
                String key = entry.getKey();
                String URL = entry.getValue();
                URL url = new URL(URL);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
                String line = br.readLine();
                String cvsSplitBy = ";";
                while ((line = br.readLine()) != null && !line.startsWith(";")){
                    String[] fields = line.split(cvsSplitBy);
                    KulturaPocetZariadeni entity = new KulturaPocetZariadeni(
                            fields[0].replaceAll("\\s+",""),fields[1],
                            fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")),
                            fields[3].equals("") ? 0 : Integer.parseInt(fields[3].replaceAll("\\s+", "")), key);
                    dao.createIfNotExists(entity);
                }
                br.close();
            }
            } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
