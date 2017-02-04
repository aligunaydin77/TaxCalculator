package com.vd.taxcalc.control;

import java.util.HashMap;
import java.util.Map;


public class TextTranslator {

    private static Map<String, String> keyWordMap = new HashMap<>();
    static {
        keyWordMap.put("one", "1");
    }

    public static String translate(String itemText) {
        String changedText = itemText;
        for(Map.Entry<String, String> wordsToReplace: keyWordMap.entrySet()) {
            changedText = changedText.replace(wordsToReplace.getKey(), wordsToReplace.getValue());
        }
        return changedText.trim() + ": ";
    }
}
