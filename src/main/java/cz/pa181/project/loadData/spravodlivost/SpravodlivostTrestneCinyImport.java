package cz.pa181.project.loadData.spravodlivost;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCiny;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class SpravodlivostTrestneCinyImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-zistenych-objasnenych-a-dodatocne-objasnenych-trestnych-cinov/1";

    public void getSpravodlivostTrestneCiny(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            SpravodlivostTrestneCinyDaoImpl dao = new SpravodlivostTrestneCinyDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                SpravodlivostTrestneCiny entity = new SpravodlivostTrestneCiny(
                        fields[0].replaceAll("\\s+",""),fields[1],
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")),
                        fields[3].equals("") ? 0 : Integer.parseInt(fields[3].replaceAll("\\s+", "")),
                        fields[4].equals("") ? 0 : Integer.parseInt(fields[4].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
