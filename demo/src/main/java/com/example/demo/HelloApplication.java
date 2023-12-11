package com.example.demo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 1920, 1080);
        stage.setTitle("KZKZKZKZ?");
        stage.setScene(scene);
        stage.show();
    }

    public class SQLiteConnection {
        private static final String JDBC_URL = "jdbc:sqlite:db.db";

        public static Connection connect() {
            try {
                Class.forName("org.sqlite.JDBC");
                return DriverManager.getConnection(JDBC_URL);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
                throw new RuntimeException("Failed to connect to the database");
            }
        }
    }

    public static void main(String[] args) {
        launch();
    }
}