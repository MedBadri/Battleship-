package com.example.demo1;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import java.util.Scanner;
import java.util.Random;

import java.io.IOException;

public class game extends Application {
    public static final int BOARD_SIZE = 10;
    public static final int NUM_SHIPS = 5;
    private char[][] board = new char[BOARD_SIZE][BOARD_SIZE];
    private int[] shipsX = new int[NUM_SHIPS];
    private int[] shipsY = new int[NUM_SHIPS];
    private int numHits = 0;
    private int remainingShips = NUM_SHIPS;
    private int totalGuesses = 0;
    @Override
    public void start(Stage primaryStage) {
        GridPane root = new GridPane();

        for (int i = 0; i < BOARD_SIZE; i++) {
            for (int j = 0; j < BOARD_SIZE; j++) {
                board[i][j] = '.';

                Button btn = new Button(".");
                btn.setMinSize(40, 40);
                btn.setOnAction(event -> {
                    int row = GridPane.getRowIndex(btn);
                    int col = GridPane.getColumnIndex(btn);
                    totalGuesses++;
                    if (board[row][col] == 'S') {
                        btn.setText("H");
                        numHits++;
                        remainingShips--;
                    } else {
                        btn.setText("M");
                        btn.setDisable(true);
                    }
                });
                root.add(btn, j, i);
            }
        }

        Random random = new Random();
        for (int i = 0; i < NUM_SHIPS; i++) {
            shipsX[i] = random.nextInt(BOARD_SIZE);
            shipsY[i] = random.nextInt(BOARD_SIZE);
            board[shipsX[i]][shipsY[i]] = 'S';
        }

        Scene scene = new Scene(root, BOARD_SIZE * 40, BOARD_SIZE * 40);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    };


