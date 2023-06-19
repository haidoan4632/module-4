package com.example.electronic_mailbox.repository;

import com.example.electronic_mailbox.model.Program;

public interface IProgramRepository {
    Program getProgram();
    void update(Program program1);
}
