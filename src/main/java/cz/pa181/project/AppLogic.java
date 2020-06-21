package cz.pa181.project;

import cz.pa181.project.enums.Priority;

import java.util.*;

public class AppLogic {


    HashMap<String, Integer> resultMap = new HashMap<>();

    public void reset(){
        this.resultMap = new HashMap<>();
        resultMap.put("BratislavaI",0);
        resultMap.put("BratislavaII",0);
        resultMap.put("BratislavaIII",0);
        resultMap.put("BratislavaIV",0);
        resultMap.put("BratislavaV",0);
    }

    public AppLogic() {
        resultMap.put("BratislavaI",0);
        resultMap.put("BratislavaII",0);
        resultMap.put("BratislavaIII",0);
        resultMap.put("BratislavaIV",0);
        resultMap.put("BratislavaV",0);
    }

    /**
     * Rozdeluje body typom vytaz berie vsetko
     * @param result vysledok cz.pa181.project.dao metody
     * @param priority zadana priorita
     */
    public void addPointsWinnerTakesAll(List<String[]> result, Priority priority){
        if (priority.equals(Priority.MUST_HAVE)){
            addPointsWinnerTakesAll(result.get(0)[0],2);

        }else if (priority.equals(Priority.NICE_TO_HAVE)){
            addPointsWinnerTakesAll(result.get(0)[0],1);

        }else if (priority.equals(Priority.DO_NOT_WANT)){
            addPointsWinnerTakesAll(result.get(0)[0],-1);
        }
    }

    /**
     * Rozdeluje body proporcne
     * @param result vysledok cz.pa181.project.dao metody
     * @param priority zadana priorita
     */
    public void addPointsProportional(List<String[]> result, Priority priority){
        if (priority.equals(Priority.MUST_HAVE)){
            addPointsWinnerTakesAll(result.get(0)[0],10);
            addPointsWinnerTakesAll(result.get(1)[0],8);
            addPointsWinnerTakesAll(result.get(2)[0],6);
            addPointsWinnerTakesAll(result.get(3)[0],4);
            addPointsWinnerTakesAll(result.get(4)[0],2);

        } else if (priority.equals(Priority.NICE_TO_HAVE)){
            addPointsWinnerTakesAll(result.get(0)[0],5);
            addPointsWinnerTakesAll(result.get(1)[0],4);
            addPointsWinnerTakesAll(result.get(2)[0],3);
            addPointsWinnerTakesAll(result.get(3)[0],2);
            addPointsWinnerTakesAll(result.get(4)[0],1);

        } else if (priority.equals(Priority.DO_NOT_WANT)){
            addPointsWinnerTakesAll(result.get(0)[0],1);
            addPointsWinnerTakesAll(result.get(1)[0],2);
            addPointsWinnerTakesAll(result.get(2)[0],3);
            addPointsWinnerTakesAll(result.get(3)[0],4);
            addPointsWinnerTakesAll(result.get(4)[0],5);
        }
    }


    private void addPointsWinnerTakesAll(String okres, int body){
        resultMap.put(okres, resultMap.get(okres) + body);
    }

    public List<String> getWinner(){
        List<String> result = new ArrayList<>();
        int maxValueInMap = (Collections.max(resultMap.values()));
        for (Map.Entry<String, Integer> entry : resultMap.entrySet()) {
            if (entry.getValue() == maxValueInMap){
                result.add(entry.getKey());
            }
        }
        return result;
    }
}
