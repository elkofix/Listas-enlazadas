package model;

import java.nio.charset.CoderResult;

public class Question {
    private String id;
    private String statement;
    private int result;
    private Question next;
    private boolean solved;
    private boolean pointed;
    private boolean correct;

    public Question getNext() {
        return next;
    }

    public void setNext(Question next) {
        this.next = next;
    }

    public void wasSolved(){
        this.solved = true;
    }

    public void point(){
        this.pointed=true;
    }

    public Question(String id, String statement, int result) {
        this.id = id;
        this.statement = statement;
        this.result = result;
        this.next = null;
        this.solved = false;
        this.pointed = false;
        this.correct = false;
    }

    public String toString(){
        if(pointed==true){
           return " ["+id+"*] "; 
        }else if(pointed == false && solved ==true){
            if(correct==true){
                return " [+] ";
            }else{
                return " [X] ";  
            }
        }else{
            return " ["+id+"] ";
        }
        
    }
    


}
