package loadData.ekonomika;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import dao.ekonomika.EkonomikaCenyBytovDaoImpl;
import entity.ekonomika.EkonomikaCenyBytov;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

/**
 * Class represents:
 * @author xholecko
 */
public class EkonomikaCenyBytovImport {

    private static final String URL_BLAVA1 = "http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-i.html";
    private static final String URL_BLAVA2 = "http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-ii.html";
    private static final String URL_BLAVA3 = "http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-iii.html";
    private static final String URL_BLAVA4 = "http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-iv.html";
    private static final String URL_BLAVA5 = "http://www.trh.sk/statistiky-cien-nehnutelnosti/bratislava-v.html";

    public void getEkonomikaCenyBytov(JdbcPooledConnectionSource connectionSource){
        HashMap<String, String> maps = new HashMap<>();
        maps.put("BratislavaI",URL_BLAVA1);
        maps.put("BratislavaII",URL_BLAVA2);
        maps.put("BratislavaIII",URL_BLAVA3);
        maps.put("BratislavaIV",URL_BLAVA4);
        maps.put("BratislavaV",URL_BLAVA5);

        try {
            EkonomikaCenyBytovDaoImpl dao = new EkonomikaCenyBytovDaoImpl(connectionSource);

            for(Map.Entry<String, String> entry : maps.entrySet()) {
                String key = entry.getKey();
                String URL = entry.getValue();
                Document doc = Jsoup.connect(URL).get();
                String data = doc.data();

                //dataset1 obsahuje tyzden, rok, a ceny bytov, domov, novostavieb a pozemkov vo formate = ["50 \/ 2019",3710,3583,2989,721]
                String dataset1;
                //dataset1 obsahuje tyzden, rok, a ceny garsoniek, 1izbove, 2izbove a 3izbove a 4a viac izbove vo formate = ["3 \/ 2020",4196,3805,3623,3538,3536]
                String dataset2;
                String[] tempSubstring;

                tempSubstring = data.split("\"Pozemky\"],");
                dataset1 = tempSubstring[1];
                dataset2 = tempSubstring[1];
                tempSubstring = dataset1.split("],\"color");
                dataset1 = tempSubstring[0];
                tempSubstring = dataset2.split("],\"color");
                dataset2 = tempSubstring[1];
                tempSubstring = dataset2.split("0e9\"],");
                dataset2 = tempSubstring[1];

                String[] spracovanyDataSet1 = spracujDataSet(dataset1);
                String[] spracovanyDataSet2 = spracujDataSet(dataset2);

                for (int i = 0; i < spracovanyDataSet1.length; i++) {
                    String[] parseDataSet1 = spracovanyDataSet1[i].split(",");
                    String[] parseDataSet2 = spracovanyDataSet2[i].split(",");
                    String tyzdenRok = parseDataSet1[0].substring(1, parseDataSet1[0].length() - 1);
                    String[] parseTyzdenRok = tyzdenRok.split(" \\\\/ ");

                    EkonomikaCenyBytov ekonomikaCenyBytov = new EkonomikaCenyBytov(key, Integer.parseInt(parseTyzdenRok[1]),
                            Integer.parseInt(parseTyzdenRok[0]), Integer.parseInt(parseDataSet1[1]), Integer.parseInt(parseDataSet1[2]),
                            Integer.parseInt(parseDataSet1[3]), Integer.parseInt(parseDataSet1[4]), Integer.parseInt(parseDataSet2[1]), Integer.parseInt(parseDataSet2[2]),
                            Integer.parseInt(parseDataSet2[3]), Integer.parseInt(parseDataSet2[4]), Integer.parseInt(parseDataSet2[5]));
                    dao.createIfNotExists(ekonomikaCenyBytov);

                }

            }
        } catch (IOException | SQLException e){
            e.printStackTrace();
        }
    }

    private String[] spracujDataSet(String dataset){
        dataset = dataset.substring(1,dataset.length()-1);
        return dataset.split("],\\[");
    }


}
