package com.kuang;

import com.alibaba.fastjson.JSON;
import com.pojo.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@RestController
public class AjaxController {

    @RequestMapping("/t1")
    public String test()
    {
        return "hello";
    }

    @RequestMapping("/a1")
    public String a(String name, HttpServletResponse response)
    {
      System.out.println("a1:"+name);

      if(name.equals("kuang"))
      {
          System.out.print("true");
      }
      else
      {
          System.out.print("false");
      }
      return  "null";
    }

    @RequestMapping("/a2")
    public String a2()
    {
        List<User> userList=new ArrayList<User>();
        userList.add(new User("s","123"));
        userList.add(new User("s2","123"));
        System.out.print(userList);
        String str=JSON.toJSONString(userList);
        return str;
    }

    @RequestMapping(value="/a3",produces =  "application/json;charset=UTF-8" )
    public String a3(String name,String pwd)
    {
       String msg="";
       if(name!=null)
       {
           if("admin".equals(name))
           {
               msg="ok";
           }
           else
           {
               msg="用户名有误";
           }
       }
        if(pwd!=null)
        {
            if("123".equals(pwd))
            {
                msg="ok";
            }
            else
            {
                msg="密码有误";
            }
        }
        return msg;
    }
}
