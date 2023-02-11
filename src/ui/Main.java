package ui;

import model.Controller;
import java.util.Scanner;

public class Main {

    private Controller control;
    private Scanner sc;

    public Main() {
        control = new Controller("1", "Nico's Game");
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        Main main = new Main();
        main.startGame();
    }

    public void startGame() {
        System.out.println("Welcome to " + control.getName() + "!");
        askName();
        initializeUserQuestions();
        System.out.println(control.printList());
        askQuestion();
    }

    public void askQuestion() {
        askQuestion(control.getNumQuestions());
        return;
    }

    public void askQuestion(int numberQuestions){
        if(numberQuestions<=0){
            return;
        }
        String[] statementResult = control.askQuestion();
        System.out.println("How many is "+statementResult[0]);
        if(!statementResult[1].equals("-1")){
            try {
                int result = sc.nextInt();
                
                if(control.verifyQuestion(result, control.askQuestion()[1])){
                System.out.println("Correct!");   
                }
                else{
                    System.out.println("Too bad! Wrong.");
                }
                numberQuestions--;
                System.out.println(control.printList());
                askQuestion();
            } catch (Exception e) {
                control.deleteQuestion(statementResult[1]);
                control.penalize();
                sc.nextLine();
                System.out.println(control.printList());
                askQuestion();
                return;
            }
        }else{
            System.out.println(control.displayResults());
            return;
        }

    
            
        
        
        return;
    }

    public void askName() {
        System.out.println("Please, Insert your name to start");
        String name = sc.nextLine();
        control.setUsername(name);
    }

    public void initializeUserQuestions() {
        System.out.println("Insert desired number of questions");
        int numberQuestions = sc.nextInt();
        control.generateQuestion(numberQuestions);
    }

}
