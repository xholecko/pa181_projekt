package loadData.spravodlivost;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class SpravodlivostTrestneCinyPodVplyvomImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-trestnych-cinov-a-pocet-stihanych-a-vysetrovanych-osob-s-vplyvom-alkoholu-a-drog/1";

    public void getSpravodlivostTrestneCinyPodVplyvom(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            SpravodlivostTrestneCinyPodVplyvomDaoImpl dao = new SpravodlivostTrestneCinyPodVplyvomDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                SpravodlivostTrestneCinyPodVplyvom entity = new SpravodlivostTrestneCinyPodVplyvom(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
