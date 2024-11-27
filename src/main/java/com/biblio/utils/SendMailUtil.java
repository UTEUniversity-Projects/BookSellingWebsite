package com.biblio.utils;

import java.util.Random;

public class SendMailUtil {
    public static String generateOTP() {
        Random rnd = new Random();
        int number = rnd.nextInt(999999);
        return String.format("%06d", number);
    }
}
