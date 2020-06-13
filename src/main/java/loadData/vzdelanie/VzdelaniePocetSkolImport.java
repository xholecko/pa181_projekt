package loadData.vzdelanie;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.vzdelanie.VzdelaniePocetSkolDaoImpl;
import entity.vzdelanie.VzdelaniePocetSkol;
import enums.TypSkoly;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents:
 * @author xholecko
 */
public class VzdelaniePocetSkolImport {
    private static final String URL_ZS = "https://opendata.bratislava.sk/dataset/download/pocet-zakladnych-skol-a-pocet-ziakov-zakladnych-skol---rocnik/1";
    private static final String URL_GYMNAZIUM = "https://opendata.bratislava.sk/dataset/download/pocet-gymnazii-a-pocet-ziakov-gymnazii/1";
    private static final String URL_STREDNA_OSBORNA = "https://opendata.bratislava.sk/dataset/download/pocet-strednych-odbornych-skol-a-pocet-ziakov-strednych-odbornych-skol/1";
    private static final String URL_JAZYKOVA = "https://opendata.bratislava.sk/dataset/download/pocet-sukromnych-jazykovych-skol-a-pocet-ziakov-v-sukromnych-jazykovych-skolach/1";



    public void getVzdelaniePocetSkol(JdbcPooledConnectionSource connectionSource){
        HashMap<String, String> maps = new HashMap<>();
        maps.put(TypSkoly.ZAKLADNA_SKOLA.toString(), URL_ZS);
        maps.put(TypSkoly.GYMNAZIUM.toString(), URL_GYMNAZIUM);
        maps.put(TypSkoly.STREDNA_ODBORNA_SKOLA.toString(), URL_STREDNA_OSBORNA);
        maps.put(TypSkoly.JAZYKOVA_SKOLA.toString(), URL_JAZYKOVA);


        try {
            VzdelaniePocetSkolDaoImpl dao = new VzdelaniePocetSkolDaoImpl(connectionSource);
            for(Map.Entry<String, String> entry : maps.entrySet()) {
                String key = entry.getKey();
                String URL = entry.getValue();
                java.net.URL url = new URL(URL);
                BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
                String line = br.readLine();
                String cvsSplitBy = ";";
                while ((line = br.readLine()) != null && !line.startsWith(";")){
                    String[] fields = line.split(cvsSplitBy);
                    VzdelaniePocetSkol entity = new VzdelaniePocetSkol(
                            fields[0].replaceAll("\\s+",""),fields[1],
                            fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")),
                            fields[3].equals("") ? 0 : Integer.parseInt(fields[3].replaceAll("\\s+", "")),
                            key);
                    dao.createIfNotExists(entity);
                }
                br.close();
            }
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
