package com.peng.www.weblogview.controller;

import com.google.gson.Gson;
import com.peng.www.weblogview.model.FlowNum;
import com.peng.www.weblogview.model.FlowReturnPojo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;




/**
 * @author peng_it_2011
 * t_avgpv_num表对应的Controller层
 *
 */
@WebServlet(name = "FlowNumController",value = "/FlowNum")
public class FlowNumController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //业务逻辑
        //1.获取日平均访问量的集合
        ArrayList<FlowNum>   FlowNumList  = null;
        try {
            //1.1数据库有相应的表数据
            //1.2导入jar包
            //1.3注册驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            //1.4获取连接
            String URI = "jdbc:mysql://127.0.0.1:3306/web_log_view?serverTimezone=Asia/Shanghai&useUnicode=true&characterEncoding=utf8&useSSL=false";
            String USER = "root";
            String PASSWORD = "password";
            Connection connection = DriverManager.getConnection(URI, USER, PASSWORD);
            //1.5创建sql的运算器
            Statement statement = connection.createStatement();
            //1.6执行sql语句
            String sql = "select * from t_flow_num;";
            ResultSet rs = statement.executeQuery(sql);
            FlowNumList = new ArrayList<>();
            while (rs.next()){
                Long id = rs.getLong("id");
                String dateStr = rs.getString("dateStr");
                Long newvNum = rs.getLong("newUvNum");
                Long vNum = rs.getLong("visitNum");
                FlowNum avgPvNumDb = new  FlowNum(id, dateStr, newvNum,vNum);
                FlowNumList.add(avgPvNumDb);
            }
            System.out.println( FlowNumList);
            //1.7关闭资源
            rs.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        //2.创建数据传输pojo对象
        FlowReturnPojo avgReturnPojo = new FlowReturnPojo ();
        ArrayList<String> dateStrArrayList = new ArrayList<>();
        ArrayList<Long> newvisitnum = new ArrayList<>();
        ArrayList<Long> vnum = new ArrayList<>();

        for( FlowNum avgPvNum :  FlowNumList){
            dateStrArrayList.add(avgPvNum.getData());
            newvisitnum.add(avgPvNum.getNewUvNum());
            vnum.add(avgPvNum.getVisitNum());
        }

        //3.设置数据传输pojo对象的属性值
        avgReturnPojo.setDates(dateStrArrayList);
        avgReturnPojo.setNewNum(newvisitnum);
        avgReturnPojo.setvNum(vnum);

        //4.将pojo对象转换成json字符串，并且相应给客户端
        Gson gson = new Gson();
        String json = gson.toJson(avgReturnPojo);

        response.setContentType("test/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter writer = response.getWriter();

        writer.println(json);
        writer.flush();
        writer.close();


    }
}
