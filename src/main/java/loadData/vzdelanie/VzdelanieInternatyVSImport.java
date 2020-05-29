package loadData.vzdelanie;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import entity.vzdelanie.VzdelanieInternatyVS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class VzdelanieInternatyVSImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-vysokoskolskych-internatov-a-pocet-lozok/1";

    public void getVzdelanieInternatyVS(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            VzdelanieInternatyVSDaoImpl dao = new VzdelanieInternatyVSDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                VzdelanieInternatyVS entity = new VzdelanieInternatyVS(fields[0],fields[1],fields[2],fields[3],fields[4]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
