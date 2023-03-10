package model;
import java.lang.Math;

public class Controller {
    private String id;
    private String name;
    private String username;
    public void setUsername(String username) {
        this.username = username;
    }

    private Question first;
    private Question last;
    private int numQuestions;
    private int userPoints;

    public Controller(String id, String name){
        this.id = id;
        this.name = name;
        this.numQuestions = 0;
        this.first = null;
        this.last = null;
        this.userPoints = 0;
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

    public Question search(String id) {
        return search(id, first);
    }

    private Question search(String id, Question current) {
        if(current==null){
            return current;
        }
        if(current.getId().equals(id)){
            return current;
        }
        current = current.getNext();
        return search(id, current);
    }

    public Question searchPrevious(String id) {
        return searchPrevious(id, first, null);
    }

    private Question searchPrevious(String id, Question current, Question previous){
        if(current.getId()==id){
            return previous;
        }
            previous = current;
            current = current.getNext();
        return searchPrevious(id, current, previous);
    }

    public void deleteQuestion(String id){
        Question current = search(id);
        Question previous = searchPrevious(id);
        if(previous!=null){
            previous.setNext(current.getNext());
            current=null;
           }else{
                this.first = current.getNext();
                current=null;
           }
           return;
       }

    public String[] askQuestion(){
        return askQuestion(first, false);
    }

    private String[] askQuestion(Question currentQuestion, boolean isSolved){
        if(currentQuestion==null){
            String a[] = {"Terminaste el juego", "-1"};
            return a;
        }
        if((currentQuestion.isSolved()==false && currentQuestion.isPointed()==false) || ((currentQuestion.isSolved()==false && currentQuestion.isPointed()==true) && currentQuestion.equals(first))){
            currentQuestion.point();
            String a[] = {currentQuestion.getStatement(), currentQuestion.getId()};
            currentQuestion.unpoint();
            return a;
        }
        if(currentQuestion.isSolved()==true && currentQuestion.isPointed()==true){
            currentQuestion.unpoint();
        }
        currentQuestion = currentQuestion.getNext();
        return askQuestion(currentQuestion, false);
    }

    public boolean verifyQuestion(int result, String id){
        boolean correct=false;
        if(search(id).getResult()==result){
            
            search(id).wasSolved();
            search(id).wasCorrect();
            this.userPoints++;
            correct = true;
        }else{
            search(id).wasSolved();
        }
        return correct;
    }

    public boolean generateQuestion(int numberQuestions){
        return generateQuestion(numberQuestions, null, 1);
    }

    private boolean generateQuestion(int numberQuestions, Question addQuestion, int currentQuestion){
        if(currentQuestion>numberQuestions){
            return true;
        }
        int n = ((int)((Math.random())*100))+1;
        int m = ((int)((Math.random())*100))+1;
        int operation = ((int)((Math.random())*3))+1;
        int result = giveResult(n, m, operation);
        addQuestion = new Question(currentQuestion+"", giveStatement(n, m, operation), result);
        addQuestion(addQuestion);
        currentQuestion++;
        this.numQuestions++;
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

    public String displayResults(){
        return displayResults(first, "", 0);
    }

    public String displayResults(Question current, String msj, int counter){
        if(current==null){
            return msj+"Skipped "+(this.numQuestions-counter)+"\n"+
            this.username+", your score was: "+userPoints;
        }
        if(current.isCorrect()){
            msj+=current.getStatement()+ " CORRECT \n";
        }else{
            msj+=current.getStatement()+ " INCORRECT \n";
        }
        current = current.getNext();
        return displayResults(current, msj, ++counter);
    }

    public int giveResult(int n, int m, int operation){
        int result = 1;
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

    public void penalize(){
        this.userPoints = userPoints-3;
    }

    public String giveStatement(int n, int m, int operation){
        String statement = "";
        if(operation==1){
            statement = n+"+"+m;
        }
        if(operation==2){
            statement = n+"-"+m;
        }
        if(operation==3){
            statement = n+"*"+m;
        }
        return statement; 
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

    public int getNumQuestions() {
        return numQuestions;
    }

}
