package com.example.dictionary.repository.impl;


import com.example.dictionary.repository.ITranslateRepository;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
@Repository
public class TranslateRepository implements ITranslateRepository {
   private static Map<String, String> listMap = new HashMap<>();

    static {
        listMap.put("doctor", "bac si");
        listMap.put("kill", "giet");
        listMap.put("cat", "meo");
        listMap.put("blue", "bùa xanh");
        listMap.put("red", "bùa đỏ");
    }

    @Override
    public String translate(String englishWord) {
        for (Map.Entry<String, String> entry : listMap.entrySet()) {
            if (entry.getKey().equals(englishWord)) {
                return entry.getValue();
            }
        }
        return "Not found english word";
    }
}