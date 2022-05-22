package org.example;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;


import java.io.IOException;

/**
 * JavaFX App
 */
public class App extends Application {

    private static Scene scene;
    // private TableView table = new TableView();

    @Override
    public void start(Stage stage) throws IOException {

        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);

        scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();

        TableView<InternetPack> tableView = new TableView<>();
        tableView.setId("myTable");
        TableColumn<InternetPack, String> firstnameCol = new TableColumn<>("First Name");
        TableColumn<InternetPack, String> lastNameCol = new TableColumn<>("Last Name");
        TableColumn<InternetPack, String> addressCol = new TableColumn<>("Address");
        TableColumn<InternetPack, Integer> speedCol = new TableColumn<>("Speed(mb/s)");
        TableColumn<InternetPack, Integer> bandWidthCol = new TableColumn<>("BandWidth");
        TableColumn<InternetPack, Integer> durationCol = new TableColumn<>("Duration");


        tableView.getColumns().addAll(firstnameCol, lastNameCol, addressCol, speedCol, bandWidthCol, durationCol);

        firstnameCol.setCellValueFactory(new PropertyValueFactory<>("firstName"));
        lastNameCol.setCellValueFactory(new PropertyValueFactory<>("lastName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<>("address"));
        speedCol.setCellValueFactory(new PropertyValueFactory<>("speed"));
        bandWidthCol.setCellValueFactory(new PropertyValueFactory<>("bandWidth"));
        durationCol.setCellValueFactory(new PropertyValueFactory<>("duration"));


        TextField firstName = new TextField("First Name:");
        gridPane.add(firstName, 0, 1);
        TextField lastName = new TextField("Last Name: ");
        gridPane.add(lastName, 0, 2);
        TextField address = new TextField("Address:");
        gridPane.add(address, 0, 3);

        Label speedLabel = new Label("speed (mb/s):");
        gridPane.add(speedLabel, 0, 4);
        Label bandwidthLabel = new Label("bandwidth:");
        gridPane.add(bandwidthLabel, 0, 6);
        Label durationLabel = new Label("duration:");
        gridPane.add(durationLabel, 0, 8);


        ToggleButton toggleButton_2 = new ToggleButton("2"); toggleButton_2.setId("2");
        ToggleButton toggleButton_5 = new ToggleButton("5"); toggleButton_5.setId("5");
        ToggleButton toggleButton_10 = new ToggleButton("10"); toggleButton_10.setId("10");
        ToggleButton toggleButton_20 = new ToggleButton("20"); toggleButton_20.setId("20");
        ToggleButton toggleButton_50 = new ToggleButton("50"); toggleButton_50.setId("50");
        ToggleButton toggleButton_100 = new ToggleButton("100"); toggleButton_100.setId("100");


        ToggleGroup speed_toggleGroup = new ToggleGroup();


        toggleButton_2.setToggleGroup(speed_toggleGroup);
        toggleButton_5.setToggleGroup(speed_toggleGroup);
        toggleButton_10.setToggleGroup(speed_toggleGroup);
        toggleButton_20.setToggleGroup(speed_toggleGroup);
        toggleButton_50.setToggleGroup(speed_toggleGroup);
        toggleButton_100.setToggleGroup(speed_toggleGroup);



        ToggleButton toggleButtonONE = new ToggleButton("1"); toggleButtonONE.setId("1");
        ToggleButton toggleButtonFIVE = new ToggleButton("5"); toggleButtonFIVE.setId("5");
        ToggleButton toggleButtonTEN = new ToggleButton("10"); toggleButtonTEN.setId("10");
        ToggleButton toggleButtonHUNDRET = new ToggleButton("100"); toggleButtonHUNDRET.setId("100");
        ToggleButton toggleButtonFLAT = new ToggleButton("Flat"); toggleButtonFLAT.setId("Flat");

        ToggleGroup bandwidthToggleGroup = new ToggleGroup();

        toggleButtonONE.setToggleGroup(bandwidthToggleGroup);
        toggleButtonFIVE.setToggleGroup(bandwidthToggleGroup);
        toggleButtonTEN.setToggleGroup(bandwidthToggleGroup);
        toggleButtonHUNDRET.setToggleGroup(bandwidthToggleGroup);
        toggleButtonFLAT.setToggleGroup(bandwidthToggleGroup);

        ToggleButton toggleButton1YEAR = new ToggleButton("1 year");
        toggleButton1YEAR.setId("oneYear");
        ToggleButton toggleButton2YEAR = new ToggleButton("2 year");
        toggleButton2YEAR.setId("twoYear");

        ToggleGroup durationToggleGroup = new ToggleGroup();

        toggleButton1YEAR.setToggleGroup(durationToggleGroup);
        toggleButton2YEAR.setToggleGroup(durationToggleGroup);


        Button saveBtn = new Button("_Save Package");
        Button clearBtn = new Button("_Clear Form");
        Button deleteBtn = new Button("_Delete Table Row");


        HBox hBox = new HBox(toggleButton_2, toggleButton_5, toggleButton_10, toggleButton_20, toggleButton_50, toggleButton_100);
        HBox hBox1 = new HBox(toggleButtonONE, toggleButtonFIVE, toggleButtonTEN, toggleButtonHUNDRET, toggleButtonFLAT);
        HBox hBox2 = new HBox(toggleButton1YEAR, toggleButton2YEAR);
        HBox hBox3 = new HBox(saveBtn, deleteBtn, clearBtn);


        gridPane.add(hBox, 0, 5);
        gridPane.add(hBox1, 0, 7);
        gridPane.add(hBox2, 0, 9);
        gridPane.add(hBox3, 0, 10);


        gridPane.add(tableView, 1, 0);
        GridPane.setRowSpan(tableView, 10);


        saveBtn.setOnAction(actionEvent -> {

            if (!firstName.getText().isBlank() && !lastName.getText().isBlank() && !address.getText().isBlank()) {
                InternetPack internetPack = new InternetPack();
                tableView.getItems().addAll(internetPack);

                internetPack.firstNameProperty().set(firstName.getText());
                internetPack.lastNameProperty().set(lastName.getText());
                internetPack.addressProperty().set(address.getText());

               ToggleButton button= (ToggleButton) speed_toggleGroup.getSelectedToggle();
               internetPack.speedProperty().set(Integer.parseInt(button.getId()));

               ToggleButton button1= (ToggleButton) bandwidthToggleGroup.getSelectedToggle();
               internetPack.bandWidthProperty().set(Integer.parseInt(button1.getId()));

               ToggleButton button2=(ToggleButton) durationToggleGroup.getSelectedToggle();
               if(button2.getId() == "oneYear")
                   internetPack.durationProperty().set(1);
               else
                   internetPack.durationProperty().set(2);

            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING, "You have to fill all the fields to complete the order");
                alert.showAndWait();

            }


        });


        deleteBtn.setOnAction(actionEvent -> {
            InternetPack selectedItem = tableView.getSelectionModel().getSelectedItem();
            tableView.getItems().remove(selectedItem);
        });

        clearBtn.setOnAction(actionEvent -> {
            firstName.textProperty().set("");
            lastName.textProperty().set("");
            address.textProperty().set("");
            speed_toggleGroup.getSelectedToggle().setSelected(false);
            bandwidthToggleGroup.getSelectedToggle().setSelected(false);
            durationToggleGroup.getSelectedToggle().setSelected(false);

        });

    }



      /*  scene = new Scene(gridPane);
        stage.setScene(scene);
        stage.show();*/
    //}




    public static void main(String[] args) {

        launch();
    }

}