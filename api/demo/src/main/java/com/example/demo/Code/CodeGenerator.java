package com.example.demo.Code;

import java.util.Random;

public class CodeGenerator {

    private static final String ALPHA_NUMERIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
    private static final int CODE_LENGTH = 4; // Length of the code generated

    public static String generateCode() {
        StringBuilder builder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < CODE_LENGTH; i++) {
            int character = random.nextInt(ALPHA_NUMERIC_STRING.length());
            builder.append(ALPHA_NUMERIC_STRING.charAt(character));
        }
        return builder.toString();
    }
}
