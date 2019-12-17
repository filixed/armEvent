package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.*;

public class Tournament implements Initializable {

    select query = new select();
    int ile = query.selectAll();
    @FXML
    Button playerRight;
    @FXML
    Button playerLeft;
    List ilo = new ArrayList(ile);
    public void wypelniacz(){
        for (int i = 1; i<=ile; i++)
            ilo.add(i);
    }
    public void los(){
        System.out.println(ilo.size());
        Collections.shuffle(ilo);
        System.out.println("List after shuffle : "+ilo);
    }




    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        wypelniacz();
        System.out.println(ile);
        los();
        for (Object o : ilo) {
            List subIlo = ilo.subList(ilo.indexOf(o)+1, ilo.size());
            for(Object o2 : subIlo){
                playerLeft.setText(query.playerName((Integer) o));
                playerRight.setText(query.playerName((Integer) o2));
            }

        }

    }

    @FXML
    public void onActionLeft(ActionEvent ActionEvent){
        String winner = playerLeft.getText();
        String [] nameSurname = winner.split(" ");
        String name = nameSurname[0];
        String surname = nameSurname[1];
        select select = new select();

        insertPlayer insertPlayer = new insertPlayer();
        insertPlayer.updateWin(select.playerID(name, surname));

    }
    @FXML
    public void onActionRight(ActionEvent ActionEvent){
        String winner = playerLeft.getText();
        String [] nameSurname = winner.split(" ");
        String name = nameSurname[0];
        String surname = nameSurname[1];
        insertPlayer insertPlayer = new insertPlayer();
        select select = new select();
        insertPlayer.updateWin(select.playerID(name, surname));
    }

}
