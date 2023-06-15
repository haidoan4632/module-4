package com.example.dictionary.service.impl;

import com.example.dictionary.repository.ITranslateRepository;
import com.example.dictionary.repository.impl.TranslateRepository;
import com.example.dictionary.service.ITranslateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TranslateService implements ITranslateService {
    @Autowired
    private ITranslateRepository repository;
    @Override
    public String translate(String englishWord) {
        return repository.translate(englishWord);
    }
}