package loadData.obyvatelstvo;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.obyvatelstvo.ObyvatelstvoPrirastokDaoImpl;
import entity.obyvatelstvo.ObyvatelstvoPrirastok;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoPrirastokImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/celkovy-prirastok-ubytok-obyvatelstva/1";

    public void getObyvatelstvoPrirastok(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ObyvatelstvoPrirastokDaoImpl dao = new ObyvatelstvoPrirastokDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ObyvatelstvoPrirastok entity = new ObyvatelstvoPrirastok(fields[0],fields[1],fields[2],fields[3],fields[4]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
