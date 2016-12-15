package zju.ccnt.mdsp;

import zju.ccnt.mdsp.assaysheet.RegularBlood;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Dewayne on 2016/11/13.
 */

public class RegularBloodServlet extends HttpServlet {
    public void doGet(HttpServletRequest request
            , HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------- >>> RegularBloodServlet ... -------");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = response.getWriter();
        out.append(new RegularBlood().toJsonString());
        out.close();
        System.out.println("------- <<< RegularBloodServlet ... -------");
    }
}