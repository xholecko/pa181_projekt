package loadData.zdravie;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.zdravie.ZdraviePocetNemocnicDaoImpl;
import entity.zdravie.ZdraviePocetNemocnic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;


public class ZdraviePocetNemocnicImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-poliklinik-a-nemocnic/2";

    public void getZdraviePocetNemocnic(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ZdraviePocetNemocnicDaoImpl dao = new ZdraviePocetNemocnicDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ZdraviePocetNemocnic entity = new ZdraviePocetNemocnic(
                        fields[0].replaceAll("\\s+",""),fields[1],
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
