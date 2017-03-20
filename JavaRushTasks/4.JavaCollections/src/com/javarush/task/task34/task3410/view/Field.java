package com.javarush.task.task34.task3410.view;

import com.javarush.task.task34.task3410.controller.EventListener;
import com.javarush.task.task34.task3410.model.Home;
import com.javarush.task.task34.task3410.model.Player;

import javax.swing.*;
import java.awt.*;

/**
 *
 */
public class Field extends JPanel {

    private View view;
    private EventListener eventListener;

    public Field(View view) {
        this.view = view;
    }

    public void paint(Graphics g){
        Player player = new Player(10, 10);
        player.draw(g);

        Home home = new Home(100 ,100);
        home.draw(g);

    }

    public void setEventListener(EventListener eventListener)
    {
        this.eventListener = eventListener;
    }

}
