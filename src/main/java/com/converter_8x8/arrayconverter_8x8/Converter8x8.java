package com.converter_8x8.arrayconverter_8x8;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.Clipboard;
import javafx.scene.input.ClipboardContent;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Converter8x8 extends Application {
    GridPane grid = new GridPane();
    Button copyButton = new Button("Click to copy Array!");
    public Group mainGroup = new Group(grid, copyButton);
    private Map<Button, String> buttonColors = new HashMap<>();
    private Map<Button, int[]> buttonIndexes = new HashMap<>();
    int[][] buttonStates = new int[8][8];

    @Override
    public void start(Stage stage) {
        for (int row = 0; row < 8; row++) {
            for(int col = 0; col < 8; col++) {
                String color = (row + col) % 2 == 0 ? "lightgray" : "white";
                int[] coords = {row, col};

                Button button = new Button();
                button.setMinHeight(40);
                button.setMinWidth(40);

                setStyle(button, color);
                buttonColors.put(button, color);
                buttonIndexes.put(button, coords);

                button.setOnAction( event -> {
                    copyButton.setText("Click to copy Array!");
                    String currentColor = buttonColors.get(button);
                    if(currentColor.equals("black")) {
                        buttonStates[buttonIndexes.get(button)[0]][buttonIndexes.get(button)[1]] = 0;
                    } else {
                        buttonStates[buttonIndexes.get(button)[0]][buttonIndexes.get(button)[1]] = 1;
                    }
                    String newColor = currentColor.equals("black") ? color : "black";
                    setStyle(button, newColor);
                    buttonColors.put(button, newColor);
                });

                grid.add(button, col, row);
            }
        }
        copyButton.setMinWidth(300);
        copyButton.setMinHeight(60);
        copyButton.setTranslateX(10);
        copyButton.setTranslateY(330);
        copyButton.setStyle("-fx-background-color: lightgray;");
        copyButton.setOnMousePressed(event -> {

            copyButton.setStyle("-fx-background-color: darkgray;");
            copyButton.setText("Array Copied!");

            String result = "{" + rowVal(0) + ", " + rowVal(1) + ", " + rowVal(2) + ", " + rowVal(3) + ", " + rowVal(4) + ", " + rowVal(5) + ", " + rowVal(6) + ", " + rowVal(7) + "};";
            Clipboard clipboard = Clipboard.getSystemClipboard();
            ClipboardContent content = new ClipboardContent();
            content.putString(result);
            clipboard.setContent(content);
        });
        copyButton.setOnMouseReleased(event -> copyButton.setStyle("-fx-background-color: lightgray;"));

        Scene scene = new Scene(mainGroup, 320, 400);
        scene.setFill(Color.rgb(20,21,24));
        stage.setTitle("8x8 converter");
        stage.setScene(scene);
        stage.show();

    }

    public static void main(String[] args) {
        launch();
    }
    public void setStyle(Button button, String color) {
        button.setStyle("-fx-background-color:" + color +  ";" +
                "-fx-background-radius: 0;" +
                "-fx-border-radius: 0;");
    }
    public String rowVal(int index) {
        StringBuilder result = new StringBuilder();
        for (int col = 0; col < 8; col++) {
            result.append(buttonStates[index][col]);
        }
        int resultValue = Integer.parseInt(result.toString(), 2);
        return String.valueOf(resultValue);
    }
}