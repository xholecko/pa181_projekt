package loadData.zdravie;

import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.zdravie.ZdraviePocetLekarovDaoImpl;
import entity.zdravie.ZdraviePocetLekarov;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;


public class ZdraviePocetLekarovImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/prakticki-lekari-a-specialisti/1";

    public void getZdraviePocetLekarov(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ZdraviePocetLekarovDaoImpl dao = new ZdraviePocetLekarovDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ZdraviePocetLekarov entity = new ZdraviePocetLekarov(fields[0],fields[1],fields[2],fields[3],fields[4],fields[5],fields[6],fields[7]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
