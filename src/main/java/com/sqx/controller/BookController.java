package com.sqx.controller;

import com.sqx.pojo.Books;
import com.sqx.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {

    // Controller调用service层
    private BookService bookService;

    @Autowired
    @Qualifier("BookServiceImpl")
    public void setBookService(BookService bookService) {
        this.bookService = bookService;
    }

    @RequestMapping("/allBook")
    // 查询全部的书籍，并且返回到一个书籍展示页面
    public String list(Model model) {
        List<Books> books = bookService.queryAllBook();

        model.addAttribute("list", books);

        return "allBook";
    }

    @RequestMapping("/allBook1")
    @ResponseBody
    // 查询全部的书籍，并且返回到一个书籍展示页面
    public List<Books> list() {
        List<Books> books = bookService.queryAllBook();

        return books;
    }


    @RequestMapping("/toAddBook")
    // 跳转到增加书籍页面
    public String toAddPaper() {
        return "addBook";
    }

    @RequestMapping("/addBook")
    // 添加书籍的请求
    public String addBooks(Books books) {
        System.out.println("addBooks=>" + books);
        bookService.addBook(books);

        return "redirect:/book/allBook";
    }

    @RequestMapping("/toUpdateBook")
    // 跳转到修改页面
    public String toUpdatePaper(int id, Model model) {
        Books books = bookService.queryBookByID(id);
        model.addAttribute("QBook", books);
        return "updateBook";
    }

    @RequestMapping("/updateBook")
    // 修改书籍
    public String updateBook(Books books) {
        System.out.println("updateBook=>" + books);
        bookService.updateBook(books);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/deleteBook/{bookID}")
    // 删除书籍
    public String deleteBook(@PathVariable("bookID") int id) {
        bookService.deleteBookByID(id);
        return "redirect:/book/allBook";
    }

    @RequestMapping("/queryBook")
    // 查询书籍
    public String queryBook(String queryBookName, Model model) {
        List<Books> books = bookService.queryBookByName(queryBookName);

        if (books.size() == 0) {
            books = bookService.queryAllBook();
        }

        model.addAttribute("list", books);
        return "allBook";
    }

}
