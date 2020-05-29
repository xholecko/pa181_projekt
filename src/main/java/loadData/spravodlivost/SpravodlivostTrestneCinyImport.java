package loadData.spravodlivost;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import entity.spravodlivost.SpravodlivostTrestneCiny;

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
                SpravodlivostTrestneCiny entity = new SpravodlivostTrestneCiny(fields[0],fields[1],fields[2],fields[3],fields[4]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
