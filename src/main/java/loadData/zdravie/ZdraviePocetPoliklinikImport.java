package loadData.zdravie;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.zdravie.ZdraviePocetPoliklinikDaoImpl;
import entity.zdravie.ZdraviePocetPoliklinik;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;


public class ZdraviePocetPoliklinikImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-poliklinik-a-nemocnic/1";

    public void getZdraviePocetPoliklinik(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ZdraviePocetPoliklinikDaoImpl dao = new ZdraviePocetPoliklinikDaoImpl(connectionSource);

            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ZdraviePocetPoliklinik entity = new ZdraviePocetPoliklinik(fields[0],fields[1],fields[2],fields[3]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
