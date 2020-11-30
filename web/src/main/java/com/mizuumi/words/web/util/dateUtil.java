package com.mizuumi.words.web.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateUtil {

    public static String getNowDate() {
        // 現在日時
        LocalDateTime nowDateTime = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");

        return nowDateTime.format(formatter);
    }
}
