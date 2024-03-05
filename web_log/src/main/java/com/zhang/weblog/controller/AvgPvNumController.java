import com.zhang.weblog.domain.AvgPvNum;
import com.zhang.weblog.domain.AvgReturnPojo;
import com.zhang.weblog.service.AvgPvNumService;
import com.gec.weblog.service.impl.AvgPvNumServiceImpl;
import com.google.gson.Gson;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AvgPvNumController", value = "/AvgPvNum")
public class AvgPvNumController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        AvgPvNumService service = new AvgPvNumServiceImpl();
        List<AvgPvNum> avgPvNumList = service.queryAvgPvNumList();

        AvgReturnPojo avgReturnPojo = new AvgReturnPojo();

        List<String> dataStrArrays = new ArrayList<>();
        List<String> pvStrArrays = new ArrayList<>();

        for (AvgPvNum avgPvNum : avgPvNumList) {

            System.out.println(avgPvNum);
            dataStrArrays.add(avgPvNum.getDateStr());
            pvStrArrays.add(String.valueOf(avgPvNum.getAvgPvNum()));

        }

        avgReturnPojo.setDates(dataStrArrays);
        avgReturnPojo.setData(pvStrArrays);

        Gson gson = new Gson();
        String json = gson.toJson(avgReturnPojo);

        response.setContentType("text/json");
        response.setCharacterEncoding("UTF-8");
        PrintWriter pw = response.getWriter();

        pw.println(json);
        pw.flush();
        pw.close();


    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        doPost(request, response);

    }
}