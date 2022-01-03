package com.company.javapractice8;

import com.company.javapractice8.controller.PetsController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class PetsApplication extends Application {

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(PetsApplication.class.getResource("view/main-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        PetsController petsController = fxmlLoader.getController();
        stage.setTitle("Practice 8");
        stage.setScene(scene);
        stage.getIcons().add(new Image(Objects.requireNonNull(getClass().getResourceAsStream("pictures/applicationIcon.png"))));
        stage.setOnHidden(windowEvent -> petsController.shutdown());
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}