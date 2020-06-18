package cz.pa181.project;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import com.j256.ormlite.table.TableUtils;
import cz.pa181.project.dao.ekonomika.EkonomikaCenyBytovDaoImpl;
import cz.pa181.project.dao.ekonomika.EkonomikaIndexStartnutiaDaoImpl;
import cz.pa181.project.dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPamatihodnostiDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPocetZariadeniDaoImpl;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import cz.pa181.project.dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import cz.pa181.project.dao.zdravie.ZdraviePocetLekarovDaoImpl;
import cz.pa181.project.dao.zdravie.ZdraviePocetNemocnicDaoImpl;
import cz.pa181.project.entity.doprava.DopravaPocetNehod;
import cz.pa181.project.entity.ekonomika.EkonomikaCenyBytov;
import cz.pa181.project.entity.ekonomika.EkonomikaIndexStartnutia;
import cz.pa181.project.entity.ekonomika.EkonomikaMieraNezamestnanosti;
import cz.pa181.project.entity.infrastruktura.InfrastrukturaPocetPost;
import cz.pa181.project.entity.kultura.KulturaPamatihodnosti;
import cz.pa181.project.entity.kultura.KulturaPocetZariadeni;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanie;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoPocet;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoPrirastok;
import cz.pa181.project.entity.obyvatelstvo.ObyvatelstvoVierovyznanie;
import cz.pa181.project.entity.socialne.SocialneZariadenia;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCiny;
import cz.pa181.project.entity.spravodlivost.SpravodlivostTrestneCinyPodVplyvom;
import cz.pa181.project.entity.vzdelanie.VzdelanieInternatyVS;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetSkol;
import cz.pa181.project.entity.vzdelanie.VzdelaniePocetZiakov;
import cz.pa181.project.entity.zdravie.ZdraviePocetLekarov;
import cz.pa181.project.entity.zdravie.ZdraviePocetNemocnic;
import cz.pa181.project.entity.zdravie.ZdraviePocetPoliklinik;
import cz.pa181.project.enums.Priority;
import cz.pa181.project.enums.TypZariadeni;
import cz.pa181.project.loadData.doprava.DopravaPocetNehodImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaCenyBytovImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaIndexStartnutiaImport;
import cz.pa181.project.loadData.ekonomika.EkonomikaMieraNezamestnanostiImport;
import cz.pa181.project.loadData.infrastruktura.InfrastrukturaPocetPostImport;
import cz.pa181.project.loadData.kultura.KulturaPamatihodnostiImport;
import cz.pa181.project.loadData.kultura.KulturaPocetZariadeniImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoDosiahnuteVzdelanieImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoPocetImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoPrirastokImport;
import cz.pa181.project.loadData.obyvatelstvo.ObyvatelstvoVierovyznanieImport;
import cz.pa181.project.loadData.socialne.SocialneZariadeniaImport;
import cz.pa181.project.loadData.spravodlivost.SpravodlivostTrestneCinyImport;
import cz.pa181.project.loadData.spravodlivost.SpravodlivostTrestneCinyPodVplyvomImport;
import cz.pa181.project.loadData.vzdelanie.VzdelanieInternatyVSImport;
import cz.pa181.project.loadData.vzdelanie.VzdelaniePocetSkolImport;
import cz.pa181.project.loadData.vzdelanie.VzdelaniePocetZiakovImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetLekarovImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetNemocnicImport;
import cz.pa181.project.loadData.zdravie.ZdraviePocetPoliklinikImport;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

/**
 * Class represents: cz.pa181.project.Main Class
 * @author xholecko
 */
@SpringBootApplication
public class Main  extends SpringBootServletInitializer {

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(Main.class);
    }

    public static void main(String[] args)  throws SQLException, IOException {
        SpringApplication application = new SpringApplication(Main.class);
        application.run();

        JdbcPooledConnectionSource connectionSource
                = new JdbcPooledConnectionSource("jdbc:postgresql://echo.db.elephantsql.com:5432/iaiikhsz");
        connectionSource.setUsername("iaiikhsz");
        connectionSource.setPassword("qxD5ZWMDSWhxcN9lNSmts2BQeA2UpcgZ");

//        loadDoprava(connectionSource);
//        loadEkonomika(connectionSource);
//        loadInfrastruktura(connectionSource);
//        loadKultura(connectionSource);
//        loadObyvatelstvo(connectionSource);
//        loadSocialne(connectionSource);
//        loadSpravodlivost(connectionSource);
//        loadVzdelania(connectionSource);
//        loadZdravie(connectionSource);
//
//
//        //Delete later
//        testDao(connectionSource);
//        testCenyBytov(connectionSource);
//        testApp(connectionSource);
//        testPametihodnosti(connectionSource);
//        System.out.println("OK");


        connectionSource.close();
    }

    private static void testDao(JdbcPooledConnectionSource connectionSource) throws SQLException {
        ZdraviePocetNemocnicDaoImpl dao = new ZdraviePocetNemocnicDaoImpl(connectionSource);

        //kazda implementovana metoda v DAO vrati pri zadani validnych parametrov zoradeny zoznam o velkosti 5
        //napr v tomto pripade to vrati {[" Bratislava II","6"],[" Bratislava I","5"],[" Bratislava III","4"],[" Bratislava V","2"],[" Bratislava IV","0"]}
        List<String[]> tmp = dao.getPocetNemocnicByRokSorted(2017);

        String okres = tmp.get(0)[0]; // " BratislavaII"
        String hodnota = tmp.get(0)[1]; // "6"

        System.out.println(tmp);
        System.out.println(okres);
        System.out.println(hodnota);
    }


    private static void testCenyBytov(JdbcPooledConnectionSource connectionSource) throws SQLException {
        EkonomikaCenyBytovDaoImpl ekonomikaCenyBytovDao = new EkonomikaCenyBytovDaoImpl(connectionSource);
        String cenaBytovBlavaI = ekonomikaCenyBytovDao.getPriemernuCenuBytovByOkres("BratislavaI");
        System.out.println(cenaBytovBlavaI);
    }


    //Rovnako zadane priority ale rozne typy prepocitavania
    private static void testApp(JdbcPooledConnectionSource connectionSource) throws SQLException {
        ZdraviePocetNemocnicDaoImpl zdraviePocetNemocnics = new ZdraviePocetNemocnicDaoImpl(connectionSource);
        ZdraviePocetLekarovDaoImpl zdraviePocetLekarovs = new ZdraviePocetLekarovDaoImpl(connectionSource);
        EkonomikaIndexStartnutiaDaoImpl ekonomikaIndexStartnutias = new EkonomikaIndexStartnutiaDaoImpl(connectionSource);
        VzdelanieInternatyVSDaoImpl vzdelanieInternatyVS = new VzdelanieInternatyVSDaoImpl(connectionSource);
        InfrastrukturaPocetPostDaoImpl infrastrukturaPocetPosts = new InfrastrukturaPocetPostDaoImpl(connectionSource);
        KulturaPocetZariadeniDaoImpl kulturaPocetZariadenis = new KulturaPocetZariadeniDaoImpl(connectionSource);
        SpravodlivostTrestneCinyPodVplyvomDaoImpl spravodlivostTrestneCinyPodVplyvoms = new SpravodlivostTrestneCinyPodVplyvomDaoImpl(connectionSource);

        AppLogic appLogicWinnerTakesAll = new AppLogic();
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetNemocnics.getPocetNemocnicByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(zdraviePocetLekarovs.getPocetLekarovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(ekonomikaIndexStartnutias.getIndexStarnutiaByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(vzdelanieInternatyVS.getPocetInternatovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(infrastrukturaPocetPosts.getPocetPostByRokSorted(2017), Priority.DO_NOT_WANT);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadeniaSorted(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicWinnerTakesAll.addPointsWinnerTakesAll(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(2017), Priority.DO_NOT_WANT);
        List<String> result = appLogicWinnerTakesAll.getWinner();

        AppLogic appLogicProportional = new AppLogic();
        appLogicProportional.addPointsProportional(zdraviePocetNemocnics.getPocetNemocnicByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(zdraviePocetLekarovs.getPocetLekarovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(ekonomikaIndexStartnutias.getIndexStarnutiaByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(vzdelanieInternatyVS.getPocetInternatovByRokSorted(2017), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(infrastrukturaPocetPosts.getPocetPostByRokSorted(2017), Priority.DO_NOT_WANT);
        appLogicProportional.addPointsProportional(kulturaPocetZariadenis.getPocetZariadeniByRokATypZariadeniaSorted(2017, TypZariadeni.DIVADLO), Priority.MUST_HAVE);
        appLogicProportional.addPointsProportional(spravodlivostTrestneCinyPodVplyvoms.getPocetZistenychTrestnychCinovPodVplyvomByRokSorted(2017), Priority.DO_NOT_WANT);
        List<String> resultOther = appLogicProportional.getWinner();

        System.out.println("Vysledok - Winner takes all " + result); // Result - BratislavaI (3 points) a BratislavaII (3 points)
        System.out.println("Vysledok - Proporcne " + resultOther); // Result - BratislavaI (44 points) (BratislavaII je az na tretom mieste (38 points))
    }

    private static void testPametihodnosti(JdbcPooledConnectionSource connectionSource) throws SQLException {
        KulturaPamatihodnostiDaoImpl dao = new KulturaPamatihodnostiDaoImpl(connectionSource);
        List<KulturaPamatihodnosti> list = dao.queryForAll();
        List<String[]> tmp = dao.getPamatihodnostiSorted();
        System.out.println(tmp);
    }


    ////////////////////// NACITANIE DAT Z DATASETOV /////////////////////
    private static void loadDoprava(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, DopravaPocetNehod.class);
        DopravaPocetNehodImport dopravaPocetNehodImport = new DopravaPocetNehodImport();
        dopravaPocetNehodImport.getDopravaPocetNehod(connectionSource);
    }

    private static void loadEkonomika(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, EkonomikaIndexStartnutia.class);
        EkonomikaIndexStartnutiaImport ekonomikaIndexStartnutiaImport = new EkonomikaIndexStartnutiaImport();
        ekonomikaIndexStartnutiaImport.getEkonomikaIndexStartnutia(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, EkonomikaMieraNezamestnanosti.class);
        EkonomikaMieraNezamestnanostiImport ekonomikaMieraNezamestnanostiImport = new EkonomikaMieraNezamestnanostiImport();
        ekonomikaMieraNezamestnanostiImport.getEkonomikaMieraNezamestnanosti(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, EkonomikaCenyBytov.class);
        EkonomikaCenyBytovImport ekonomikaCenyBytovImport = new EkonomikaCenyBytovImport();
        ekonomikaCenyBytovImport.getEkonomikaCenyBytov(connectionSource);
    }

    private static void loadInfrastruktura(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, InfrastrukturaPocetPost.class);
        InfrastrukturaPocetPostImport infrastrukturaPocetPostImport = new InfrastrukturaPocetPostImport();
        infrastrukturaPocetPostImport.getInfrastrukturaPocetPost(connectionSource);
    }

    private static void loadKultura(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, KulturaPocetZariadeni.class);
        KulturaPocetZariadeniImport kulturaZariadeniaVolnyCasImport = new KulturaPocetZariadeniImport();
        kulturaZariadeniaVolnyCasImport.getKulturaPocetZariadeni(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, KulturaPamatihodnosti.class);
        KulturaPamatihodnostiImport kulturaPamatihodnostiImport = new KulturaPamatihodnostiImport();
        kulturaPamatihodnostiImport.getKulturaPamatihodnosti(connectionSource);
    }

    private static void loadObyvatelstvo(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoVierovyznanie.class);
        ObyvatelstvoVierovyznanieImport obyvatelstvoVierovyznanieImport = new ObyvatelstvoVierovyznanieImport();
        obyvatelstvoVierovyznanieImport.getObyvatelstvoVierovyznanie(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoPocet.class);
        ObyvatelstvoPocetImport obyvatelstvoPocetImport = new ObyvatelstvoPocetImport();
        obyvatelstvoPocetImport.getObyvatelstvoPocet(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoPrirastok.class);
        ObyvatelstvoPrirastokImport obyvatelstvoPrirastokImport = new ObyvatelstvoPrirastokImport();
        obyvatelstvoPrirastokImport.getObyvatelstvoPrirastok(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ObyvatelstvoDosiahnuteVzdelanie.class);
        ObyvatelstvoDosiahnuteVzdelanieImport obyvatelstvoDosiahnuteVzdelanieImport = new ObyvatelstvoDosiahnuteVzdelanieImport();
        obyvatelstvoDosiahnuteVzdelanieImport.getObyvatelstvoDosiahnuteVzdelanie(connectionSource);
    }

    private static void loadSocialne(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, SocialneZariadenia.class);
        SocialneZariadeniaImport socialneZariadeniaImport = new SocialneZariadeniaImport();
        socialneZariadeniaImport.getSocialneZariadenia(connectionSource);
    }

    private static void loadVzdelania(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, VzdelaniePocetSkol.class);
        VzdelaniePocetSkolImport vzdelaniePocetSkolImport = new VzdelaniePocetSkolImport();
        vzdelaniePocetSkolImport.getVzdelaniePocetSkol(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, VzdelaniePocetZiakov.class);
        VzdelaniePocetZiakovImport vzdelaniePocetZiakovImport = new VzdelaniePocetZiakovImport();
        vzdelaniePocetZiakovImport.getVzdelaniePocetZiakov(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, VzdelanieInternatyVS.class);
        VzdelanieInternatyVSImport vzdelanieInternatyVSImport = new VzdelanieInternatyVSImport();
        vzdelanieInternatyVSImport.getVzdelanieInternatyVS(connectionSource);
    }

    private static void loadSpravodlivost(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, SpravodlivostTrestneCiny.class);
        SpravodlivostTrestneCinyImport spravodlivostTrestneCinyImport = new SpravodlivostTrestneCinyImport();
        spravodlivostTrestneCinyImport.getSpravodlivostTrestneCiny(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, SpravodlivostTrestneCinyPodVplyvom.class);
        SpravodlivostTrestneCinyPodVplyvomImport spravodlivostTrestneCinyPodVplyvomImport = new SpravodlivostTrestneCinyPodVplyvomImport();
        spravodlivostTrestneCinyPodVplyvomImport.getSpravodlivostTrestneCinyPodVplyvom(connectionSource);
    }

    private static void loadZdravie(JdbcPooledConnectionSource connectionSource) throws SQLException {
        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetLekarov.class);
        ZdraviePocetLekarovImport zdraviePocetLekarovImport = new ZdraviePocetLekarovImport();
        zdraviePocetLekarovImport.getZdraviePocetLekarov(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetPoliklinik.class);
        ZdraviePocetPoliklinikImport zdraviePocetPoliklinikImport = new ZdraviePocetPoliklinikImport();
        zdraviePocetPoliklinikImport.getZdraviePocetPoliklinik(connectionSource);

        TableUtils.createTableIfNotExists(connectionSource, ZdraviePocetNemocnic.class);
        ZdraviePocetNemocnicImport zdraviePocetNemocnicImport = new ZdraviePocetNemocnicImport();
        zdraviePocetNemocnicImport.getZdraviePocetNemocnic(connectionSource);
    }
}