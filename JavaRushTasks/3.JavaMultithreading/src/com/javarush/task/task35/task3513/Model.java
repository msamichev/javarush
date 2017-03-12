package com.javarush.task.task35.task3513;

import java.util.*;

/**
 *
 */
public class Model {
    private static final int FIELD_WIDTH = 4;
    int score;
    int maxTile;
    private Tile[][] gameTiles;

    private Stack<Tile[][]> previousStates = new Stack<>();
    private Stack<Integer> previousScores = new Stack<>();
    private boolean isSaveNeeded = true;

    public Model() {
        resetGameTiles();
    }


    private  boolean hasBoardChanged() {
        int sum1 = 0;
        int sum2 = 0;
        if(!previousStates.isEmpty()) {
            Tile[][] prevGameTiles = previousStates.peek();
            for (int i = 0; i < FIELD_WIDTH; i++) {
                for (int j = 0; j < FIELD_WIDTH; j++) {
                    sum1 += gameTiles[i][j].value;
                    sum2 += prevGameTiles[i][j].value;
                }
            }
        }
        return sum1 != sum2;
    }

    public MoveEfficiency getMoveEfficiency(Move move){
        MoveEfficiency moveEfficiency;
        move.move();
        if(hasBoardChanged()){
            moveEfficiency = new MoveEfficiency(getEmptyTiles().size(), score, move);
        }else{
            moveEfficiency = new MoveEfficiency(-1, 0, move);
        }
        rollback();
        return moveEfficiency;
    }


    public void autoMove(){
        PriorityQueue<MoveEfficiency> queue = new PriorityQueue<>(4, Collections.reverseOrder());
        queue.offer(getMoveEfficiency(this::left));
        queue.offer(getMoveEfficiency(this::right));
        queue.offer(getMoveEfficiency(this::up));
        queue.offer(getMoveEfficiency(this::down));

        MoveEfficiency moveEfficiency = queue.poll();
        moveEfficiency.getMove().move();
    }

    public void randomMove() {
        int n = ((int) (Math.random() * 100)) % 4;
        switch (n) {
            case 0: {
                left();
                break;
            }
            case 1: {
                right();
                break;
            }
            case 2: {
                up();
                break;
            }
            case 3: {
                down();
                break;
            }
        }
    }

    private void saveState(Tile[][] arr) {
        Tile[][] copy = getCopy(arr);
        previousScores.push(score);
        previousStates.push(copy);
        isSaveNeeded = false;
    }

    public void rollback() {
        if (!previousStates.isEmpty() && !previousScores.isEmpty()) {
            score = previousScores.pop();
            gameTiles = previousStates.pop();
        }
    }

    public Tile[][] getGameTiles() {
        return gameTiles;
    }

    public void resetGameTiles() {
        this.gameTiles = new Tile[FIELD_WIDTH][FIELD_WIDTH];
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles[i].length; j++) {
                gameTiles[i][j] = new Tile();
            }
        }

        score = 0;
        maxTile = 2;
        addTile();
        addTile();
    }

    private Tile[][] getCopy(Tile[][] arr) {
        Tile[][] copyArr = new Tile[FIELD_WIDTH][FIELD_WIDTH];

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                Tile copyTile = new Tile();
                copyTile.value = arr[i][j].value;
                copyArr[i][j] = copyTile;

            }
        }
        return copyArr;
    }

    private void rotateToRight(Tile[][] arr) {
        for (int i = 0; i < FIELD_WIDTH / 2; i++) {
            for (int j = i; j < FIELD_WIDTH - 1 - i; j++) {
                Tile tmp = arr[i][j];
                arr[i][j] = arr[FIELD_WIDTH - 1 - j][i];
                arr[FIELD_WIDTH - 1 - j][i] = arr[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j];
                arr[FIELD_WIDTH - 1 - i][FIELD_WIDTH - 1 - j] = arr[j][FIELD_WIDTH - 1 - i];
                arr[j][FIELD_WIDTH - 1 - i] = tmp;
            }
        }
    }

    public boolean canMove() {
        boolean res = false;
        int scoreTmp = score;
        int maxTileTmp = maxTile;
        Tile[][] copy = getCopy(gameTiles);

        for (int i = 0; i < FIELD_WIDTH; i++) {
            for (int j = 0; j < FIELD_WIDTH; j++) {
                if (compressTiles(copy[j]) | mergeTiles(copy[j])) {
                    res = true;
                    break;
                }
            }
            if (res) break;
            rotateToRight(copy);
        }
        score = scoreTmp;
        maxTile = maxTileTmp;
        return res;
    }

    void right() {
        saveState(gameTiles);
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);
        left();
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);
    }

    void up() {
        saveState(gameTiles);
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);
        left();
        rotateToRight(gameTiles);
    }

    void down() {
        saveState(gameTiles);
        rotateToRight(gameTiles);
        left();
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);
        rotateToRight(gameTiles);

    }

    void left() {
        if (isSaveNeeded) saveState(gameTiles);
        boolean isChanged = false;
        for (int i = 0; i < FIELD_WIDTH; i++) {
            if (compressTiles(gameTiles[i]) | mergeTiles(gameTiles[i])) {
                isChanged = true;
            }
        }
        if (isChanged) addTile();
        isSaveNeeded = true;
    }

    private void addTile() {
        List<Tile> emptyTiles = getEmptyTiles();
        if (!emptyTiles.isEmpty()) {
            emptyTiles.get((int) (Math.random() * emptyTiles.size())).value = (Math.random() < 0.9 ? 2 : 4);
        }
    }

    private List<Tile> getEmptyTiles() {
        List<Tile> emptyTiles = new ArrayList<>();
        for (int i = 0; i < gameTiles.length; i++) {
            for (int j = 0; j < gameTiles.length; j++) {
                if (gameTiles[i][j].isEmpty()) {
                    emptyTiles.add(gameTiles[i][j]);
                }
            }
        }
        return emptyTiles;
    }

    private boolean compressTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 1; i < tiles.length; i++) {
            for (int j = 1; j < tiles.length; j++) {
                if (tiles[j - 1].isEmpty() && !tiles[j].isEmpty()) {
                    change = true;
                    tiles[j - 1] = tiles[j];
                    tiles[j] = new Tile();
                }
            }
        }
        return change;
    }

    private boolean mergeTiles(Tile[] tiles) {
        boolean change = false;
        for (int i = 1; i < tiles.length; i++) {
            if ((tiles[i - 1].value == tiles[i].value) && !tiles[i - 1].isEmpty() && !tiles[i].isEmpty()) {
                change = true;
                tiles[i - 1].value *= 2;
                score += tiles[i - 1].value;
                maxTile = maxTile > tiles[i - 1].value ? maxTile : tiles[i - 1].value;
                tiles[i] = new Tile();
                compressTiles(tiles);
            }
        }
        return change;
    }

}
