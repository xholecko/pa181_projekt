package loadData.obyvatelstvo;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.obyvatelstvo.ObyvatelstvoPocetDaoImpl;
import entity.obyvatelstvo.ObyvatelstvoPocet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPocetImport {

    private static final String URL = "https://opendata.bratislava.sk/dataset/download/obyvpocet/1";

    public void getObyvatelstvoPocet(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ObyvatelstvoPocetDaoImpl dao = new ObyvatelstvoPocetDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ObyvatelstvoPocet entity = new ObyvatelstvoPocet(fields[0],fields[1],
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")),
                        fields[3].equals("") ? 0 : Integer.parseInt(fields[3].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
