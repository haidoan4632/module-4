package com.example.dictionary.service.impl;

import com.example.dictionary.repository.ITranslateRepository;
import com.example.dictionary.repository.impl.TranslateRepository;
import com.example.dictionary.service.ITranslateService;

public class TranslateService implements ITranslateService {
    private ITranslateRepository repository = new TranslateRepository();
    @Override
    public String translate(String englishWord) {
        return repository.translate(englishWord);
    }
}