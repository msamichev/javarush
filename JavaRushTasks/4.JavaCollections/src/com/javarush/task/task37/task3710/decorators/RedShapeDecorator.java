package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 *
 */
public class RedShapeDecorator extends ShapeDecorator {
    private Shape decorator;

    private void setBorderColor(Shape decorator) {
        String ding = decorator.getClass().getSimpleName();
        System.out.println("Setting border color for " + ding + " to red.");
    }

    @Override
    public void draw() {
        setBorderColor(decorator);
        decorator.draw();
    }

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
        this.decorator = decoratedShape;
    }
}
