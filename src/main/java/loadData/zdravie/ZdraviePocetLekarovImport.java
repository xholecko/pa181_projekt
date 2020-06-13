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
                ZdraviePocetLekarov entity = new ZdraviePocetLekarov(
                        fields[0].replaceAll("\\s+",""),fields[1],
                        fields[2].equals("") ? 0 : Integer.parseInt(fields[2].replaceAll("\\s+", "")),
                        fields[3].equals("") ? 0 : Integer.parseInt(fields[3].replaceAll("\\s+", "")),
                        fields[4].equals("") ? 0 : Integer.parseInt(fields[4].replaceAll("\\s+", "")),
                        fields[5].equals("") ? 0 : Integer.parseInt(fields[5].replaceAll("\\s+", "")),
                        fields[6].equals("") ? 0 : Integer.parseInt(fields[6].replaceAll("\\s+", "")),
                        fields[7].equals("") ? 0 : Integer.parseInt(fields[7].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
