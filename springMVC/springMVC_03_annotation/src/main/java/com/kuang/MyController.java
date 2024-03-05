package com.kuang;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MyController {
    @RequestMapping("/hello")
    public String hello(Model model)
    {
        //封装数据
        model.addAttribute("msg","my");
        return "hello"; //被视图解析器处理
    }
}
