package com.javarush.task.task34.task3410.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;

/**
 *
 */
public class LevelLoader {

    private Path levels;

    public LevelLoader(Path levels) {
        this.levels = levels;
    }

    public GameObjects getLevel(int level) {

        Set<Wall> walls = new HashSet<>();
        Set<Box> boxes = new HashSet<>();
        Set<Home> homes = new HashSet<>();
        Player player = null;


        player = new Player(6 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 6 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2);
        homes.add(new Home(3 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 3 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
        boxes.add(new Box(2 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 2 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
        walls.add(new Wall(1 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 1 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));
        walls.add(new Wall(7 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2, 7 * Model.FIELD_SELL_SIZE + Model.FIELD_SELL_SIZE / 2));


        return new GameObjects(walls, boxes, homes, player);
    }
}
