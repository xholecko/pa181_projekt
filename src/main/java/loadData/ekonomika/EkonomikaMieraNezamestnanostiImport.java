package loadData.ekonomika;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.ekonomika.EkonomikaMieraNezamestnanostiDaoImpl;
import entity.ekonomika.EkonomikaMieraNezamestnanosti;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;


/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaMieraNezamestnanostiImport {

    private static final String URL = "https://opendata.bratislava.sk/dataset/download/miera-evidovanej-nezamestnanosti-v/1";

    public void getEkonomikaMieraNezamestnanosti(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            EkonomikaMieraNezamestnanostiDaoImpl dao = new EkonomikaMieraNezamestnanostiDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                EkonomikaMieraNezamestnanosti entity = new EkonomikaMieraNezamestnanosti(fields[0],fields[1],fields[2]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
