package cn.zyq.jedis.web.servlet;

import cn.zyq.jedis.domain.Province;
import cn.zyq.jedis.service.ProvinceService;
import cn.zyq.jedis.service.impl.ProvinceServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/provinceServlet")
public class provinceServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        ProvinceService service = new ProvinceServiceImpl();
//        List<Province> provinces = service.findAll();
//        ObjectMapper mapper = new ObjectMapper();
//        String provinceJson = mapper.writeValueAsString(provinces);
        ProvinceService service = new ProvinceServiceImpl();
        String provinceJson = service.findAllJson();
        response.setContentType("application/json;charset=utf-8");
        response.getWriter().write(provinceJson);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
