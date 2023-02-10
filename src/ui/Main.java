package ui;
import model.Controller;
import java.util.Scanner;
public class Main {

    private Controller control;
    private Scanner sc;

    public Main(){
        control =new Controller();
        sc = new Scanner(System.in);
    }
    public static void main(String[] args){
        Main main = new Main();

    }
    
    public void askName(){
        System.out.println("Insert your name");
        String name = sc.nextLine();
        
    }
    
}
