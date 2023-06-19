package com.example.electronic_mailbox.repository.impl;

import com.example.electronic_mailbox.model.Program;
import com.example.electronic_mailbox.repository.IProgramRepository;


public class ProgramRepository implements IProgramRepository {
    private Program program = new Program("English", 5, false, "Thor");
    @Override
    public Program getProgram() {
        return program;
    }

    @Override
    public void update(Program program1) {
        program.setLanguages(program1.getLanguages());
        program.setPageSize(program1.getPageSize());
        program.setSpamsFilter(program1.getSpamsFilter());
        program.setSignature(program1.getSignature());
    }
}