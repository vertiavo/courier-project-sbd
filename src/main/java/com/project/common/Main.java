package com.project.common;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application{

    public static void main(final String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("Main.fxml"));

        primaryStage.setTitle("Courier Project");
        primaryStage.setScene(new Scene(root,900,600));
        primaryStage.setResizable(false);
        primaryStage.show();
    }
}