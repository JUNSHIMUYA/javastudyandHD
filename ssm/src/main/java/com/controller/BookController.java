package com.controller;

import com.pojo.Books;
import com.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/book")
public class BookController {
    //Controller调用service层
    @Autowired
    @Qualifier("BookServiceimpl")
    private BookService bookService;

    //查询全部书籍并且返回到书籍展示页面
    @RequestMapping("/allbook")
    public String list(Model model)
    {
        List<Books> list=bookService.queryAllBook();
        model.addAttribute("list",list);
        return "allBook";
    }

    @RequestMapping("/toAddBook")
    public String toAddPaper()
    {
        return "addBook";
    }

    @RequestMapping("/addBook")
    public String addBook(Books books)
    {
        bookService.addBook(books);
        return "redirect:/book/allbook";
    }

    @RequestMapping("/toUpdateBook/{a}")
    public String toUpdatePaper(@PathVariable("a") int a,Model model)
    {
        Books books=bookService.queryBookById(a);
        model.addAttribute("QBooks",books);
     return "updateBook";
    }

    @RequestMapping("/updateBook")
    public String updateBook(Books books)
    {

        bookService.updateBook(books);
        return "redirect:/book/allbook" ;
    }

    @RequestMapping("/deleteBook")
    public String deleteBook(int id)
    {
        bookService.deleteBookById(id);
        return "redirect:/book/allbook" ;
    }

    @RequestMapping("/queryBook")
    public String queryBook(String queryBookName,Model model)
    {
        Books books= bookService.queryBookByName(queryBookName);
        List<Books> list=new ArrayList<Books>();
        list.add(books);
        if(books==null)
        {
            list=bookService.queryAllBook();
            model.addAttribute("error","未查到");
        }

        model.addAttribute("list",list);
        return "allBook";
    }
}
