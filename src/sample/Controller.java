package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.sql.*;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Controller implements Initializable {

    private Connection con = null;
    private PreparedStatement pts = null;
    private ResultSet rs = null;
    private ObservableList<player> data;

    @FXML
    Button clearButton;
    @FXML
    Button addButton;
    @FXML
    TextField nameField;
    @FXML
    TextField surField;
    @FXML
    TableView<player> tableview;
    @FXML
    TableColumn<?, ?> ID;
    @FXML
    TableColumn<?, ?> name;
    @FXML
    TableColumn<?, ?> surname;
    @FXML
    TableColumn<?, ?> win;
    @FXML
    TableColumn<?, ?> loss;


    @FXML
    void onClickClear(ActionEvent ActionEvent){
        nameField.setText(null);
        surField.setText(null);


    }

    @FXML
    public void onClickAdd(ActionEvent event) {
        insertPlayer newPlayer = new insertPlayer();

        newPlayer.insert(nameField.getText(), surField.getText());
        tableview.getItems().clear();
        loadData();
        nameField.setText(null);
        surField.setText(null);

    }

    private void setCellTable(){
        ID.setCellValueFactory(new PropertyValueFactory<>("ID"));
        name.setCellValueFactory(new PropertyValueFactory<>("name"));
        surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        win.setCellValueFactory(new PropertyValueFactory<>("win"));
        loss.setCellValueFactory(new PropertyValueFactory<>("loss"));
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            con = DriverManager.getConnection("jdbc:sqlite:armLubiana.db");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        data = FXCollections.observableArrayList();
        setCellTable();
        loadData();

    }



    public void loadData(){
        try{
            pts = con.prepareStatement("SELECT ID, name, surname, win, loss FROM zawodnicy");

            rs = pts.executeQuery();
            System.out.println(rs);
            while(rs.next()){
                data.add(new player(rs.getInt("ID"),rs.getString("name"),rs.getString("surname"),
                        rs.getInt("win"), rs.getInt("loss")));

            }
        }catch(SQLException ex){
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex );
        }
        tableview.setItems(data);
    }

}
