package ui;
import model.Controller;
import java.util.Scanner;
public class Main {

    private Controller control;
    private Scanner sc;

    public Main(){
        control =new Controller("1", "Nico's Game", null);
        sc = new Scanner(System.in);
    }
    public static void main(String[] args){
        Main main = new Main();
        main.startGame();

    }

    public void startGame(){
        System.out.println("Welcome to "+control.getName()+"!");
        askName();
        initializeUserQuestions();
    }
    
    public void askName(){
        System.out.println("Please, Insert your name to start");
        String name = sc.nextLine();
    }

    public void initializeUserQuestions(){
        System.out.println("Insert desired number of questions");
        int numberQuestions = sc.nextInt();
        control.generateQuestion(numberQuestions);
    }
    
}
