package cz.pa181.project;

import com.j256.ormlite.jdbc.JdbcPooledConnectionSource;
import cz.pa181.project.dao.doprava.DopravaPocetNehodDao;
import cz.pa181.project.dao.doprava.DopravaPocetNehodDaoImpl;
import cz.pa181.project.dao.ekonomika.*;
import cz.pa181.project.dao.infrastruktura.InfrastrukturaPocetPostDao;
import cz.pa181.project.dao.infrastruktura.InfrastrukturaPocetPostDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPamatihodnostiDao;
import cz.pa181.project.dao.kultura.KulturaPamatihodnostiDaoImpl;
import cz.pa181.project.dao.kultura.KulturaPocetZariadeniDao;
import cz.pa181.project.dao.kultura.KulturaPocetZariadeniDaoImpl;
import cz.pa181.project.dao.obyvatelstvo.*;
import cz.pa181.project.dao.socialne.SocialneZariadeniaDao;
import cz.pa181.project.dao.socialne.SocialneZariadeniaDaoImpl;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyDao;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyDaoImpl;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDao;
import cz.pa181.project.dao.spravodlivost.SpravodlivostTrestneCinyPodVplyvomDaoImpl;
import cz.pa181.project.dao.vzdelanie.VzdelanieInternatyVSDao;
import cz.pa181.project.dao.vzdelanie.VzdelanieInternatyVSDaoImpl;
import cz.pa181.project.dao.vzdelanie.VzdelaniePocetZiakovDao;
import cz.pa181.project.dao.vzdelanie.VzdelaniePocetZiakovDaoImpl;
import cz.pa181.project.dao.zdravie.*;
import cz.pa181.project.enums.Priority;
import cz.pa181.project.enums.TypSkoly;
import cz.pa181.project.enums.TypZariadeni;
import lombok.Getter;
import lombok.Setter;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;


@Setter
@Getter
public class EvaluateResponse {

    AppLogic appLogic = new AppLogic();
    JdbcPooledConnectionSource connectionSource;

    DopravaPocetNehodDao dopravaPocetNehod;
    EkonomikaCenyBytovDao ekonomikaCenyBytovDao;
    EkonomikaIndexStartnutiaDao ekonomikaIndexStartnutiaDao;
    EkonomikaMieraNezamestnanostiDao ekonomikaMieraNezamestnanostiDao;
    InfrastrukturaPocetPostDao infrastrukturaPocetPostDao;
    KulturaPamatihodnostiDao kulturaPamatihodnostiDao;
    KulturaPocetZariadeniDao kulturaPocetZariadeniDao;
    ObyvatelstvoDosiahnuteVzdelanieDao obyvatelstvoDosiahnuteVzdelanieDao;
    ObyvatelstvoPocetDao obyvatelstvoPocetDao;
    ObyvatelstvoPrirastokDao obyvatelstvoPrirastokDao;
    ObyvatelstvoVierovyznanieDao obyvatelstvoVierovyznanieDao;
    SocialneZariadeniaDao socialneZariadeniaDao;
    SpravodlivostTrestneCinyDao spravodlivostTrestneCinyDao;
    SpravodlivostTrestneCinyPodVplyvomDao spravodlivostTrestneCinyPodVplyvomDao;
    VzdelanieInternatyVSDao vzdelanieInternatyVSDao;
    VzdelaniePocetZiakovDao vzdelaniePocetZiakovDao;
    ZdraviePocetLekarovDao zdraviePocetLekarovDao;
    ZdraviePocetNemocnicDao zdraviePocetNemocnicDao;
    ZdraviePocetPoliklinikDao zdraviePocetPoliklinikDao;

    public Integer[] all;
    public Integer[] must;
    public Integer[] nice;
    public Integer[] not;

    public List<String> resolve() throws SQLException, IOException {
        try {
            initConnection();
            appLogic.reset();
            CriteriaType[] criteriaTypes = CriteriaType.values();

            Arrays.stream(must).forEach(i -> {
                appLogic.addPointsProportional(resultForCriteria(criteriaTypes[i - 1]), Priority.MUST_HAVE);
            });
            Arrays.stream(nice).forEach(i -> {
                appLogic.addPointsProportional(resultForCriteria(criteriaTypes[i - 1]), Priority.NICE_TO_HAVE);
            });
            Arrays.stream(not).forEach(i -> {
                appLogic.addPointsProportional(resultForCriteria(criteriaTypes[i - 1]), Priority.DO_NOT_WANT);
            });

            return appLogic.getWinner();
        } finally {
            connectionSource.close();
        }

    }

    private List<String[]> resultForCriteria(CriteriaType criteriaType) {
        int year = Calendar.getInstance().get(Calendar.YEAR);

        try {
            switch (criteriaType) {
                case Posty:
                    return infrastrukturaPocetPostDao.getPocetPostByRokSorted(year);
                case CenyBytov:
                    return null; // ekonomikaCenyBytovDao.getPriemernuCenuBytovByOkres(null);
                case Internaty:
                    return vzdelanieInternatyVSDao.getPocetLozokByRokSorted(year);
                case Prirastok:
                    return obyvatelstvoPrirastokDao.getPrirastokByRokSorted(year);
                case Krminalita:
                    return spravodlivostTrestneCinyDao.getPocetZistenychTrestnychCinovByRokSorted(year);
                case PocetNehod:
                    return dopravaPocetNehod.getPocetNehodByRokSorted(year);
                case PocetZiakov:
                    return vzdelaniePocetZiakovDao.getPocetZiakovByRokATypSkolySorted(year, TypSkoly.ZAKLADNA_SKOLA);
                case Obyvatelstvo:
                    return obyvatelstvoPocetDao.getPocetObyvatelovByRokSorted(year);
                case Vierovyznania:
                    return obyvatelstvoVierovyznanieDao.getVierovyznanieSorted();
                case Nezamestnanost:
                    return ekonomikaMieraNezamestnanostiDao.getMieraNezamestnanostiByRokSorted(year);
                case KulturaZariadenia:
                    return kulturaPocetZariadeniDao.getPocetZariadeniByRokATypZariadeniaSorted(year, TypZariadeni.GALERIA);
                case DosiahnuteVzdelanie:
                    return obyvatelstvoDosiahnuteVzdelanieDao.getDosiahnuteVzdelanieSpoluByRokSorted();
                case SocialneZaraiadenia:
                    return socialneZariadeniaDao.getPocetSocialnychZariadeniByRokSorted(year);
                case KulturaPamatihodnosti:
                    return kulturaPamatihodnostiDao.getPamatihodnostiSorted();
                case ZdravotnickeZariadenia:
                    return zdraviePocetLekarovDao.getPocetLekarovByRokSorted(year);
                default:
                    break;
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    private void initConnection() throws SQLException, IOException {
        connectionSource
                = new JdbcPooledConnectionSource("jdbc:postgresql://echo.db.elephantsql.com:5432/iaiikhsz");
        connectionSource.setUsername("iaiikhsz");
        connectionSource.setPassword("qxD5ZWMDSWhxcN9lNSmts2BQeA2UpcgZ");

        dopravaPocetNehod = new DopravaPocetNehodDaoImpl(connectionSource);
        ekonomikaCenyBytovDao = new EkonomikaCenyBytovDaoImpl(connectionSource);
        ekonomikaIndexStartnutiaDao = new EkonomikaIndexStartnutiaDaoImpl(connectionSource);
        ekonomikaMieraNezamestnanostiDao = new EkonomikaMieraNezamestnanostiDaoImpl(connectionSource);
        infrastrukturaPocetPostDao = new InfrastrukturaPocetPostDaoImpl(connectionSource);
        kulturaPamatihodnostiDao = new KulturaPamatihodnostiDaoImpl(connectionSource);
        kulturaPocetZariadeniDao = new KulturaPocetZariadeniDaoImpl(connectionSource);
        obyvatelstvoDosiahnuteVzdelanieDao = new ObyvatelstvoDosiahnuteVzdelanieDaoImpl(connectionSource);
        obyvatelstvoPocetDao = new ObyvatelstvoPocetDaoImpl(connectionSource);
        obyvatelstvoPrirastokDao = new ObyvatelstvoPrirastokDaoImpl(connectionSource);
        obyvatelstvoVierovyznanieDao = new ObyvatelstvoVierovyznanieDaoImpl(connectionSource);
        socialneZariadeniaDao = new SocialneZariadeniaDaoImpl(connectionSource);
        spravodlivostTrestneCinyDao = new SpravodlivostTrestneCinyDaoImpl(connectionSource);
        spravodlivostTrestneCinyPodVplyvomDao = new SpravodlivostTrestneCinyPodVplyvomDaoImpl(connectionSource);
        vzdelanieInternatyVSDao = new VzdelanieInternatyVSDaoImpl(connectionSource);
        vzdelaniePocetZiakovDao = new VzdelaniePocetZiakovDaoImpl(connectionSource);
        zdraviePocetLekarovDao = new ZdraviePocetLekarovDaoImpl(connectionSource);
        zdraviePocetNemocnicDao = new ZdraviePocetNemocnicDaoImpl(connectionSource);
        zdraviePocetPoliklinikDao = new ZdraviePocetPoliklinikDaoImpl(connectionSource);

    }
}
