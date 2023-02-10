package model;
import java.lang.Math;

public class Controller {
    private String id;
    private String name;
    private Question first;
    private Question last;
    private int numQuestions;

    public Controller(String id, String name){
        this.id = id;
        this.name = name;
        this.numQuestions = 0;
        this.first = null;
        this.last = null;
    }

    public void addQuestion(Question newQuestion){
        if(this.first == null){
            newQuestion.point();
            this.first = newQuestion;
            this.last = newQuestion;
        }else if(last !=null){
            last.setNext(newQuestion);
            this.last=newQuestion;
        }
    }
    public boolean generateQuestion(int numberQuestions){
        return generateQuestion(numberQuestions, null, 1);
    }
        


    public boolean generateQuestion(int numberQuestions, Question addQuestion, int currentQuestion){
        if(currentQuestion>numberQuestions){
            return true;
        }
        int n = ((int)(Math.random())*100)+1;
        int m = ((int)(Math.random())*100)+1;
        int operation = ((int)(Math.random())*4)+1;
        int result = giveResult(n, m, operation);
        addQuestion = new Question(currentQuestion+"", giveStatement(n, m, operation), result);
        addQuestion(addQuestion);
        currentQuestion++;
        return generateQuestion(numberQuestions, addQuestion, currentQuestion);

    }
    public String printList(){
        String msj = "";
        return printlist(first, msj);
    }

    private String printlist(Question current, String list){
        if(current==null){
            return list;
        }
        list+=current.toString();
        current = current.getNext();
        return printlist(current, list);
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

    public void updateNumQuetions(){
        this.numQuestions++;
    }

    public String getName() {
        return name;
    }

    public Question getFirst() {
        return first;
    }

    public void setFirst(Question first) {
        this.first = first;
    }

}
