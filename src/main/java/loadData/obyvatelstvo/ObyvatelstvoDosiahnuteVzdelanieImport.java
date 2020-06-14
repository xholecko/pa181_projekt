package loadData.obyvatelstvo;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanieDaoImpl;
import entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.SQLException;

/**
 * Class represents:
 * @author xholecko
 */
public class ObyvatelstvoDosiahnuteVzdelanieImport {
    private static final String URL = "https://opendata.bratislava.sk/dataset/download/pocet-obyvatelov-podla-najvyssieho-dosiahnuteho-vzdelania-v-zakladnych-sidelnych-jednotkach-anonymizovane/1";

    public void getObyvatelstvoDosiahnuteVzdelanie(JdbcPooledConnectionSource connectionSource){
        try {
            java.net.URL url = new URL(URL);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream(), "Windows-1250"));
            String line = br.readLine();
            String cvsSplitBy = ";";
            ObyvatelstvoDosiahnuteVzdelanieDaoImpl dao = new ObyvatelstvoDosiahnuteVzdelanieDaoImpl(connectionSource);


            while ((line = br.readLine()) != null && !line.startsWith(";")){
                String[] fields = line.split(cvsSplitBy);
                ObyvatelstvoDosiahnuteVzdelanie entity =
                        new ObyvatelstvoDosiahnuteVzdelanie(
                                fields[3].replaceAll("\\s+",""),fields[5],fields[7],
                        fields[8].equals("") ? 0 : Integer.parseInt(fields[8].replaceAll("\\s+", "")),
                        fields[9].equals("") ? 0 :Integer.parseInt(fields[9].replaceAll("\\s+", "")),
                        fields[10].equals("") ? 0 :Integer.parseInt(fields[10].replaceAll("\\s+", "")),
                        fields[11].equals("") ? 0 :Integer.parseInt(fields[11].replaceAll("\\s+", "")));
                dao.createIfNotExists(entity);
            }
            br.close();
        } catch (IOException | SQLException e) {
            e.printStackTrace();
        }
    }
}
