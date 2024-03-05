package com.kuang;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;

@Controller
public class MyController {
    @RequestMapping("/login")
    public String login(HttpSession session, String username, String password)
    {
        session.setAttribute("userloginInfo",username);
        return "main";
    }

    @RequestMapping("/gologin")
    public String login()
    {
        return "login";
    }


    @RequestMapping("/main")
    public String main(HttpSession session)
    {
        String msg=(String) session.getAttribute("userloginInfo");
        if(msg==null)
        {
            System.out.print("请先登录");
            return "login";
        }
        else{
            System.out.print("ok");
            return "main";
        }
    }

    @RequestMapping("/upload")
    @ResponseBody
    public String upload(@RequestParam("file") CommonsMultipartFile file , HttpServletRequest request) throws IOException{
       System.out.print("ni");
        if (!file.isEmpty()) {

            String contextPath = request.getContextPath();//"/SpringMvcFileUpload"
            String servletPath = request.getServletPath();//"/gotoAction"
            String scheme = request.getScheme();//"http"


            String storePath= "F:\\";//存放我们上传的文件路径

            String fileName = file.getOriginalFilename();

            File filepath = new File(storePath, fileName);

            if (!filepath.getParentFile().exists()) {

                filepath.getParentFile().mkdirs();//如果目录不存在，创建目录

            }

            try {
                file.transferTo(new File(storePath+File.separator+fileName));//把文件写入目标文件地址

            } catch (Exception e) {

                e.printStackTrace();

                return "error";

            }

            return "success";//返回到成功页面

        }else {

            return "error";//返回到失败的页面
        }

    }


}
