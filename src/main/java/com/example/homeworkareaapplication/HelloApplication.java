package com.example.homeworkareaapplication;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;


public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        Group group = new Group();
        Scene scene = new Scene(group, 1000, 750);
        stage.setResizable(false);

        Button button01 = new Button("Перемести");
        button01.setLayoutX(40);
        button01.setLayoutY(30);
        double button01XSIZE = 200;
        double button01YSIZE = 200;
        double button02XSIZE = 200;
        double button02YSIZE = 200;
        button01.setMinSize(button01XSIZE, button01YSIZE);
        group.getChildren().add(button01);

        final double[] button01Coords = new double[2];

        button01.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button01Coords[0] = mouseEvent.getX();
                button01Coords[1] = mouseEvent.getY();
                scene.setCursor(Cursor.CLOSED_HAND);
            }
        });


        button01.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });


        double[] coords01 = new double[2];

        button01.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                coords01[0] = mouseEvent.getSceneX() - button01Coords[0];
                coords01[1] = mouseEvent.getSceneY() - button01Coords[1];
                button01.setLayoutX(coords01[0]);
                button01.setLayoutY(coords01[1]);
            }
        });


        Button button02 = new Button("Перемести");
        button02.setLayoutX(360);
        button02.setLayoutY(30);

        button02.setMinSize(button02XSIZE, button02YSIZE);
        group.getChildren().add(button02);

        final double[] button02Coords = new double[2];

        button02.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                button02Coords[0] = mouseEvent.getX();
                button02Coords[1] = mouseEvent.getY();
                scene.setCursor(Cursor.CLOSED_HAND);
            }
        });


        button02.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                scene.setCursor(Cursor.DEFAULT);
            }
        });


        double[] coords02 = new double[2];
        button02.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                coords02[0] = mouseEvent.getSceneX() - button02Coords[0];
                coords02[1] = mouseEvent.getSceneY() - button02Coords[1];
                button02.setLayoutX(coords02[0]);
                button02.setLayoutY(coords02[1]);
            }
        });

        Button button1 = new Button("Посчитать площадь");
        button1.setLayoutX(200);
        button1.setLayoutY(500);
        button1.setMinSize(200, 30);
        group.getChildren().add(button1);

        double[] b1 = new double[2];
        double[] b2 = new double[2];

        button1.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                b1[0] = button01.getLayoutX();
                b1[1] = button01.getLayoutY();
                b2[0] = button02.getLayoutX();
                b2[1] = button02.getLayoutY();


                System.out.println("Площадь - " + areaCalculate(button01XSIZE, button01YSIZE, button02XSIZE, button02YSIZE, b1, b2));
            }
        });

        stage.setScene(scene);
        stage.setTitle("Домашняя_Работа");
        stage.show();
    }
    public double areaCalculate(double button1sizeX, double button1sizeY, double button2sizeX, double button2sizeY, double[] coords1, double[] coords2){
        double area = 0;
        if ((Math.abs(coords1[0] - coords2[0]) > 200) || (Math.abs(coords1[1] - coords2[1]) > 200)){
            area = 0;
        }else if (coords1[0] <= coords2[0]){
            if (coords1[1] <= coords2[1]){
                area = (coords1[0] + button1sizeX - coords2[0]) * (coords1[1] + button1sizeY - coords2[1]);
            }else if (coords1[1] > coords2[1]){
                area = (coords1[0] + button1sizeX - coords2[0]) * (coords2[1] + button2sizeY - coords1[1]);
            }
        } else if (coords1[0] >= coords2[0]){
            if (coords1[1] <= coords2[1]){
                area = (coords2[0] + button2sizeX - coords1[0]) * (coords1[1] + button1sizeY - coords2[1]);
            }else if (coords1[1] > coords2[1]){
                area = (coords2[0] + button2sizeX - coords1[0]) * (coords2[1] + button2sizeY - coords1[1]);
            }
        }
        return area;
    }
    public static void main(String[] args) {
        launch();
    }
}

