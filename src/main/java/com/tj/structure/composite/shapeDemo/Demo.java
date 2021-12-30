package com.tj.structure.composite.shapeDemo;

import com.tj.structure.composite.shapeDemo.editor.ImageEditor;
import com.tj.structure.composite.shapeDemo.shapes.Circle;
import com.tj.structure.composite.shapeDemo.shapes.CompoundShape;
import com.tj.structure.composite.shapeDemo.shapes.Dot;
import com.tj.structure.composite.shapeDemo.shapes.Rectangle;

import java.awt.*;

public class Demo {
    public static void main(String[] args) {
        ImageEditor editor = new ImageEditor();

        editor.loadShapes(
                new Circle(10, 10, 10, Color.BLUE),

                new CompoundShape(
                    new Circle(110, 110, 50, Color.RED),
                    new Dot(160, 160, Color.RED)
                ),

                new CompoundShape(
                        new Rectangle(250, 250, 100, 100, Color.GREEN),
                        new Dot(240, 240, Color.GREEN),
                        new Dot(240, 360, Color.GREEN),
                        new Dot(360, 360, Color.GREEN),
                        new Dot(360, 240, Color.GREEN)
                )
        );
    }
}