package game;

import com.sun.istack.internal.NotNull;
import com.sun.javafx.image.PixelGetter;
import javafx.scene.image.PixelReader;

import java.awt.*;
import java.awt.image.PixelGrabber;

/**
 * Created by mati on 2016-05-18.
 * TODO: comments.
 */

class View {
    Canvas canvas;
    public static void main(String[] args){

    }

    @NotNull
    Color getColor(@NotNull Position position) {
        Color color = new Color(12,12,12);
        return color;
    }

    void draw(@NotNull Position position, @NotNull Color color) {

    }

    void createCanvas(int width, int height) {
        canvas = new Canvas();
        canvas.setBounds(10, 10, width, height);
    }
}
