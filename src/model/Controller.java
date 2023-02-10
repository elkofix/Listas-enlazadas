package model;

public class Controller {
    private String id;
    private String name;
    private Question first;

    public Controller(String id, String name, Question first){
        this.id = id;
        this.name = name;
        this.first = null;
    }

    public String getName() {
        return name;
    }

}
