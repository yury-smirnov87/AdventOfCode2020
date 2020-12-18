package com.github.yury.smirnov.aoc2020;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class Day3TobogganTrajectoryTest {

    private Day3TobogganTrajectory tobogganTrajectory;
    private char[][] map;

    @Before
    public void setUp() throws Exception {
        tobogganTrajectory = new Day3TobogganTrajectory();

        Path path = Paths.get("src/test/resources/day3_input.txt");
        List<String> lines = Files.readAllLines(path);
        map = new char[lines.size()][];
        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            map[i] = line.toCharArray();
        }
    }

    @Test
    public void countTrees_1_1() {
        assertEquals(93, tobogganTrajectory.countTrees(map, 1, 1));
    }

    @Test
    public void countTrees_3_1() {
        assertEquals(164, tobogganTrajectory.countTrees(map, 3, 1));
    }

    @Test
    public void countTrees_5_1() {
        assertEquals(82, tobogganTrajectory.countTrees(map, 5, 1));
    }

    @Test
    public void countTrees_7_1() {
        assertEquals(91, tobogganTrajectory.countTrees(map, 7, 1));
    }

    @Test
    public void countTrees_1_2() {
        assertEquals(44, tobogganTrajectory.countTrees(map, 1, 2));
    }
}