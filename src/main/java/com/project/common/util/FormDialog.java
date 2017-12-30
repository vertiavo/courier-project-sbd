package com.project.common.util;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class FormDialog {

    private FormDialog() {
    }

    public static void display(List<String> fields){

        Stage window = new Stage();

        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("New ");
        window.setMinWidth(300);

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 300, 275);
        window.setScene(scene);

        List<TextField> textFields = new ArrayList<>();

        int rowNum = 1;
        for (String field : fields) {
            Label label = new Label(field);
            grid.add(label, 0, rowNum);
            TextField textField = new TextField();
            grid.add(textField, 1, rowNum);
            textFields.add(textField);
            rowNum++;
        }

        Button addButton = new Button("Add");
        addButton.setOnAction(e -> {
            fields.clear();
            textFields.forEach(field -> fields.add(field.getText()));
            window.close();
        });

        Button cancelButton = new Button("Close");
        cancelButton.setOnAction(e -> {
            fields.clear();
            window.close();
        });

        HBox hBox = new HBox(10);
        hBox.setAlignment(Pos.BOTTOM_RIGHT);
        hBox.getChildren().addAll(addButton, cancelButton);
        grid.add(hBox, 1, 4);

        window.showAndWait();

    }

}
