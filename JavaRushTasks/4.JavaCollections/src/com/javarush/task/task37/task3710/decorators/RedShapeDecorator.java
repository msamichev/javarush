package com.javarush.task.task37.task3710.decorators;

import com.javarush.task.task37.task3710.shapes.Shape;

/**
 *
 */
public class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        super(decoratedShape);
    }

    @Override
    public void draw() {
        setBorderColor(this);
        super.draw();
    }

    private void setBorderColor(ShapeDecorator shape) {
        System.out.println("Setting border color for " + shape.decoratedShape.getClass().getSimpleName() + " to red.");
    }
}
