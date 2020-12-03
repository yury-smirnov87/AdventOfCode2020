package com.github.yury.smirnov.aoc2020;

public class Password {

    private final String password;
    private final Policy policy;

    public Password(char policyChar, int min, int max, String password) {
        this.policy = new Policy(policyChar, min, max);
        this.password = password;
    }

    public Policy getPolicy() {
        return policy;
    }

    public String getPassword() {
        return password;
    }

    public static final class Policy {
        private final char character;
        private final int min;
        private final int max;

        private Policy(char character, int min, int max) {
            this.character = character;
            this.min = min;
            this.max = max;
        }

        public char getCharacter() {
            return character;
        }

        public int getMin() {
            return min;
        }

        public int getMax() {
            return max;
        }
    }
}
