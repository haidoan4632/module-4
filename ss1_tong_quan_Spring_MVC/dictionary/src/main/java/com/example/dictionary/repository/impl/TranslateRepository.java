package com.example.dictionary.repository.impl;


import com.example.dictionary.repository.ITranslateRepository;

import java.util.HashMap;
import java.util.Map;

public class TranslateRepository implements ITranslateRepository {
    static Map<String, String> listMap = new HashMap<>();

    static {
        listMap.put("banana", "chuối");
        listMap.put("apple", "táo");
        listMap.put("watermelon", "dưa hấu");
        listMap.put("orange", "cam");
        listMap.put("mango", "soài");
    }

    @Override
    public String translate(String englishWord) {
        for (Map.Entry<String, String> entry : listMap.entrySet()) {
            if (entry.getKey().equals(englishWord)) {
                return entry.getValue();
            }
        }
        return "Not found";
    }
}