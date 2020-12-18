package com.github.yury.smirnov.aoc2020;

public class Day3TobogganTrajectory {

    public static final char TREE_SIGN = '#';

    public int countTrees(char[][] map, int stepX, int stepY) {
        int numOfTrees = 0;
        int width = map[0].length;

        for (int x = 0, y = stepY; y < map.length; y += stepY) {

            if (x >= width - stepX) {
                x = stepX + x - width;
            } else {
                x += stepX;
            }

            if (map[y][x] == TREE_SIGN) {
                numOfTrees++;
            }
//            map[y][x] = map[y][x] == TREE_SIGN ? 'X' : 'O';
        }
//        printMatrix(map);
        return numOfTrees;
    }

    /*private void printMatrix(char[][] map) {
        for (char[] chars : map) {
            for (char aChar : chars) {
                System.out.print(aChar);
            }
            System.out.println();
        }
    }*/
}
