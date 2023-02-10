package model;

public class Question {
    private String id;
    private String statement;
    private int result;
    private Question next;
    
    public Question(String id, String statement, int result, Question next) {
        this.id = id;
        this.statement = statement;
        this.result = result;
        this.next = next;
    }


}
