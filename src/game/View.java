package game;

import com.sun.istack.internal.NotNull;

import javafx.application.Application;
import javafx.scene.*;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.*;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;

/**
 * Created by mati on 2016-05-18.
 *
 */

public class View extends Application {

    private static GraphicsContext gc;
    private static Engine engine;
    private static int multiplier; //1px ant is too small to notice sth;

    public static void main(String[] args) {
        //init javaFX window;
        launch(args);
    }

    private Scene prepare(){
        //width and height will be multiple by multiplier, care for screen resolution;
        //now set for 1200 x 600 (400 * 3 and 200 * 3);
        int width = 400;
        int height = 200;
        multiplier = 3;

        Board board = new Board(width, height);

        //user should select ants position, but now it is here;
        ArrayList<Ant> ants = new ArrayList<>();
        Ant ant = new Ant(new Position(80, 100));
        Ant ant2 = new Ant(new Position(80, 80));
        Ant ant3 = new Ant(new Position(300,100));
        ants.add(ant);
        ants.add(ant2);
        ants.add(ant3);

        //create game engine;
        engine = new Engine(board, ants);

        //return a Scene object;
        return createCanvas(width * multiplier, height * multiplier);
    }

    private static Scene createCanvas(int width, int height) {
        //some javaFX;
        Group root = new Group();
        Scene s = new Scene(root, width, height);
        Canvas canvas = new Canvas(width, height);
        gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        return s;

    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Scene scene = prepare();
        primaryStage.setTitle("Langton's Ant");
        primaryStage.setScene(scene);

        //otherwise game will still running after close window;
        primaryStage.setOnCloseRequest(event -> Engine.stop());
        primaryStage.show();
        engine.start();
    }

    static void draw(@NotNull int x, @NotNull int y, @NotNull Color color) {
        gc.setFill(color);
        int k = multiplier;
        //all dimensions must be multiply by k for keep scale;
        gc.fillRect(x * k, y * k, k, k);
    }
}
