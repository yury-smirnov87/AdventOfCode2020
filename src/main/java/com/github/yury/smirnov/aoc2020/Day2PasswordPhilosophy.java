package com.github.yury.smirnov.aoc2020;

import java.util.List;
import java.util.function.Predicate;

public class Day2PasswordPhilosophy {

    public static final Predicate<Password> VALIDATOR_1 = new PasswordValidator1();
    public static final Predicate<Password> VALIDATOR_2 = new PasswordValidator2();

    public long countWrongPasswords(List<Password> passwords, Predicate<Password> validator) {
        return passwords.stream().filter(validator).count();
    }

    private static final class PasswordValidator1 implements Predicate<Password> {

        @Override
        public boolean test(Password password) {
            int numOfChars = 0;
            for (char ch : password.getPassword().toCharArray()) {
                if (ch == password.getPolicy().getCharacter()) {
                    numOfChars++;
                    if (numOfChars > password.getPolicy().getMax()) {
                        return false;
                    }
                }
            }
            return numOfChars >= password.getPolicy().getMin();
        }
    }

    private static final class PasswordValidator2 implements Predicate<Password> {

        @Override
        public boolean test(Password password) {
            char policyChar = password.getPolicy().getCharacter();
            String pass = password.getPassword();

            char char1 = pass.charAt(password.getPolicy().getMin() - 1);
            char char2 = pass.charAt(password.getPolicy().getMax() - 1);

            return (char1 == policyChar && char2 != policyChar) || (char1 != policyChar && char2 == policyChar);
        }
    }
}
