package sample;

public class player {

    private Integer ID;
    private String name;
    private String surname;
    private Integer win;
    private Integer loss;

    public player(Integer ID, String name, String surname, Integer win, Integer loss) {
        this.ID = ID;
        this.name = name;
        this.surname = surname;
        this.win = win;
        this.loss = loss;
    }

    public Integer getID() {
        return ID;
    }

    public void setID(Integer ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getWin() {
        return win;
    }

    public void setWin(Integer win) {
        this.win = win;
    }

    public Integer getLoss() {
        return loss;
    }

    public void setLoss(Integer loss) {
        this.loss = loss;
    }






}
