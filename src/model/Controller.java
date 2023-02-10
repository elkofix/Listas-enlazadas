package model;
import java.lang.Math;

public class Controller {
    private String id;
    private String name;
    private Question first;

    public Controller(String id, String name, Question first){
        this.id = id;
        this.name = name;
        this.first = null;
    }

    public void generateQuestion(int numberQuestions){
        int n = ((int)(Math.random())*100)+1;
        int m = ((int)(Math.random())*100)+1;
        int operation = ((int)(Math.random())*4)+1;
        int result;
    }

    public String giveStatement(int n, int m, int operation){
        String statement = "";
        if(operation==1){
            statement = "Cuanto es "+n+"+"+m;
        }
        if(operation==2){
            statement = "Cuanto es "+n+"-"+m;
        }
        if(operation==3){
            statement = "Cuanto es "+n+"*"+m;
        }
        return statement; 
    }

    public int giveResult(int n, int m, int operation){
        int result = 0;
        if(operation==1){
            result = n+m;
        }
        if(operation==2){
            result=n-m;
        }
        if(operation==3){
            result=n*m;
        }
        return result;

    }


    public String getName() {
        return name;
    }

}
