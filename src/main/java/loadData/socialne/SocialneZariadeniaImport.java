package loadData.socialne;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.socialne.SocialneZariadeniaDaoImpl;
import entity.socialne.SocialneZariadenia;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class SocialneZariadeniaImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-socialnych-zariadenii/1";

    public void getSocialneZariadenia(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            SocialneZariadeniaDaoImpl dao = new SocialneZariadeniaDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                SocialneZariadenia entity = new SocialneZariadenia(fields[0].replaceAll("\\s+",""),
                        fields[1].equals("") ? 0 : Integer.parseInt(fields[1].replaceAll("\\s+", "")),
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
