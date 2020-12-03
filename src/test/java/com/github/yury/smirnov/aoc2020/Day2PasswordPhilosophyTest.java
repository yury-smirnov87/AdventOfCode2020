package com.github.yury.smirnov.aoc2020;

import org.junit.Before;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class Day2PasswordPhilosophyTest {

    private Day2PasswordPhilosophy passwordPhilosophy;
    private List<Password> inputData;

    @Before
    public void setUp() throws Exception {
        passwordPhilosophy = new Day2PasswordPhilosophy();

        Path inputPath = Paths.get("src/test/resources/day2_input.txt");
        inputData = Files.readAllLines(inputPath).stream()
                .map(this::parsePassword)
                .collect(Collectors.toList());
    }

    private Password parsePassword(String line) {
        String[] tokens = line.split(" ");
        String[] range = tokens[0].split("-");
        int min = Integer.parseInt(range[0]);
        int max = Integer.parseInt(range[1]);
        char policyChar = tokens[1].charAt(0);

        return new Password(policyChar, min, max, tokens[2]);
    }

    @Test
    public void countWrongPasswords_explanation1__returnsExpectedNumber() {
        assertEquals(458, passwordPhilosophy.countWrongPasswords(inputData, Day2PasswordPhilosophy.VALIDATOR_1));
    }

    @Test
    public void checkPassword_tooFewChars_returnFalse() {
        assertFalse(Day2PasswordPhilosophy.VALIDATOR_1.test(new Password('g', 4, 6, "sbwggg")));
    }

    @Test
    public void checkPassword_tooManyChars_returnFalse() {
        assertFalse(Day2PasswordPhilosophy.VALIDATOR_1.test(new Password('g', 4, 6, "sbwggggggg")));
    }

    @Test
    public void checkPassword_withinLimits_returnTrue() {
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_1.test(new Password('g', 4, 6, "sbwgggg")));
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_1.test(new Password('g', 4, 6, "sbwggggg")));
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_1.test(new Password('g', 4, 6, "sbwgggggg")));
    }

    @Test
    public void countWrongPasswords_explanation2_returnsExpectedNumber() {
        assertEquals(342, passwordPhilosophy.countWrongPasswords(inputData, Day2PasswordPhilosophy.VALIDATOR_2));
    }

    @Test
    public void checkPassword_explanation2_tooFewChars_returnFalse() {
        assertFalse(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('s', 1, 6, "sbwggs")));
        assertFalse(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('s', 1, 6, "sbwggsss")));

        assertFalse(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('g', 4, 6, "sbwggg")));
        assertFalse(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('g', 4, 6, "sbwggggggg")));
    }

    @Test
    public void checkPassword_explanation2_successCases_returnTrue() {
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('g', 1, 5, "sbwgg")));
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('g', 1, 6, "sbwggg")));

        assertTrue(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('s', 1, 5, "sbwgg")));
        assertTrue(Day2PasswordPhilosophy.VALIDATOR_2.test(new Password('s', 1, 6, "sbwggg")));
    }
}