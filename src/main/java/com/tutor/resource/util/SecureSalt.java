package com.tutor.resource.util;

import java.security.SecureRandom;
import java.util.Random;

public class SecureSalt {

    public static String generateSalt () {

        final char[] allowedCharacters = "abcdefghijklmnopqrstuvwxyzABCDEFGJKLMNPRSTUVWXYZ0123456789".toCharArray();

        //Use cryptographically secure random number generator
        Random random = new SecureRandom();

        StringBuilder salt = new StringBuilder();

        for (int i = 0; i < 32; i++) {
            salt.append(allowedCharacters[random.nextInt(allowedCharacters.length)]);
        }
        return salt.toString();
    }
}
