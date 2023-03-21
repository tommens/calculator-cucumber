package calculator;


import java.util.*;


public class Log {

    private Date date = new Date();

    private List<Map.Entry<String,Expression>> pairList= new java.util.ArrayList<>();

    public void add(Expression expression) {
        pairList.add(new AbstractMap.SimpleEntry<>(date.toString(), expression));
    }

    public List<Map.Entry<String, Expression>> getPairList() {
        return pairList;
    }

    public void displayLog(int n) {
        if (n > pairList.size()) {
            System.out.println(pairList);
        }
        for(int a = pairList.size()-n; a!= pairList.size(); a++) {
            System.out.println(pairList.get(a).getKey() + " " + pairList.get(a).getValue());
        }
    }

    public void displayLog() {
        System.out.println(pairList);
    }

    public void saveLog() {
        // TODO
    }

    public void loadLog() {
        // TODO
    }
}