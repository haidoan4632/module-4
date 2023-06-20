package com.example.electronic_mailbox.service.impl;

import com.example.electronic_mailbox.model.Program;
import com.example.electronic_mailbox.repository.IProgramRepository;
import com.example.electronic_mailbox.repository.impl.ProgramRepository;
import com.example.electronic_mailbox.service.IProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProgramService implements IProgramService {
@Autowired
IProgramRepository iProgramRepository;
    @Override
    public Program getProgram() {
        return iProgramRepository.getProgram();
    }

    @Override
    public void update(Program program) {
        iProgramRepository.update(program);
    }
}