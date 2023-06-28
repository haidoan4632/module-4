package com.example.book_application.service.impl;

import com.example.book_application.model.Borrow;
import com.example.book_application.repository.IBorrowRepository;
import com.example.book_application.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    private IBorrowRepository borrowRepository;
    @Override
    public List<Borrow> getAll() {
        return borrowRepository.findAll();
    }

    @Override
    public Borrow findById(int id) {
        return borrowRepository.findById(id).get();
    }

    @Override
    public void save(Borrow order) {
        borrowRepository.save(order);
    }

    @Override
    public boolean findByCode(int code) {
        List<Borrow> orderList=borrowRepository.findAll();
        for (int i=0;i<orderList.size();i++){
            if (orderList.get(i).getCode()==code){
                return true;
            }
        }
        return false;
    }

}
