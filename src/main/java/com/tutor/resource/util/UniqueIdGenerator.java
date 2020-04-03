package com.tutor.resource.util;

import java.security.SecureRandom;
import java.util.Random;

public class UniqueIdGenerator {

    public static String generate (String type) {

        final char[] allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();

        Random random = new SecureRandom();

        StringBuilder id = new StringBuilder();

        for (int i = 0; i < 8; i++) {
            id.append(allowedCharacters[random.nextInt(allowedCharacters.length)]);

            if(!UniqueIdGenerator.isUnique(id, type)) {
                id = id.delete(0, 8);
                i = -1;
            }
        }

        return id.toString();
    }

    private static boolean isUnique(StringBuilder id, String type) {

        return true;
    }








}
