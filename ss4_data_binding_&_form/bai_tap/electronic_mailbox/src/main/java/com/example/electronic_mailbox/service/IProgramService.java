package com.example.electronic_mailbox.service;

import com.example.electronic_mailbox.model.Program;

public interface IProgramService {
    Program getProgram();
    void update(Program program);
}
