package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        dbCreate dbCreate = new dbCreate();
        dbCreate.createNewDatabase("armLubiana");
        createTable createTable = new createTable();
        createTable.createNewTable("zawodnicy");
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Tittle");
        primaryStage.setScene(new Scene(root, 800, 640));
        primaryStage.show();


        Connect conToDb = new Connect();

        Connect.connect();


    }


    public static void main(String[] args) {
        launch(args);




    }
}
