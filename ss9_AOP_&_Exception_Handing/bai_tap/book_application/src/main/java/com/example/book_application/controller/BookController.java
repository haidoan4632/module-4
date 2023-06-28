package com.example.book_application.controller;

import com.example.book_application.configs.MainExceptionHandler;
import com.example.book_application.model.Book;
import com.example.book_application.model.Borrow;
import com.example.book_application.service.IBookService;
import com.example.book_application.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/books")
public class BookController {
    @Autowired
    private IBookService iBookService;
    @Autowired
    private IBorrowService borrowService;

    @GetMapping()
    public String showListSach(Model model) {
        model.addAttribute("bookList", iBookService.getAll());
        return "/list";
    }

    @GetMapping("/{id}/borrow")
    public String borrowBook(@PathVariable int id,Model model) throws MainExceptionHandler {
        Book book = iBookService.finById(id);
        if (book.getQuantity() == 0) {
            throw new MainExceptionHandler();
        }
        book.setQuantity(book.getQuantity() - 1);
        Borrow borrow = new Borrow();
        int code;
        do {
            code = (int) (Math.random() * (99999 - 10000) + 10000);
        } while (borrowService.findByCode(code) != false);
        borrow.setCode(code);
        long time = System.currentTimeMillis();
        borrow.setDate(new java.sql.Date(time));

        List<Borrow> borrowList = book.getBorrowList();
        borrowList.add(borrow);
        book.setBorrowList(borrowList);
        borrowService.save(borrow);
        iBookService.save(book);
        model.addAttribute("books", iBookService.finById(id));
        model.addAttribute("code", code);
        return "detailBook";
    }

    @ExceptionHandler(MainExceptionHandler.class)
    public String handleException(Exception exception) {
        return "/book/500";
    }

    @GetMapping("/{id}/pay")
    public String showPay(@PathVariable int id, Model model){
        if (iBookService.finById(id)!=null){
            return "pay";
        }
        return "redirect:/books";
    }


    @PostMapping("/pay")
    public String payForm(@RequestParam Integer id, int code, Model model) throws MainExceptionHandler {
      List<Borrow> borrowList = borrowService.getAll();
      Book book = iBookService.finById(id);
        if (borrowService.findByCode(code) == true) {
            book.setQuantity(book.getQuantity() + 1);
            iBookService.save(book);
            model.addAttribute("mess", "da tra sach");
            return "redirect:/books";
        }
 throw  new MainExceptionHandler();
    }
}
