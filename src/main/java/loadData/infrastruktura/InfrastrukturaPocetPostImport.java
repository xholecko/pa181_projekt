package loadData.infrastruktura;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import entity.infrastruktura.InfrastrukturaPocetPost;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class InfrastrukturaPocetPostImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-post/1";

    public void getInfrastrukturaPocetPost(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            InfrastrukturaPocetPostDaoImpl dao = new InfrastrukturaPocetPostDaoImpl(connectionSource);
            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                InfrastrukturaPocetPost entity = new InfrastrukturaPocetPost(fields[0],fields[1],fields[2],fields[3]);
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
