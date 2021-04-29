package zyq.loginProject;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

@WebServlet("/checkCode")
public class checkCode extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        int width = 100;
        int height = 50;
        //图片对象
        BufferedImage bufferedImage = new BufferedImage(width,height,BufferedImage.TYPE_INT_RGB);
        //画笔对象
        Graphics graphics = bufferedImage.getGraphics();
        //填充灰色
        graphics.setColor(Color.GRAY);
        graphics.fillRect(1,1,width-1,height-1);
        //画边框
        graphics.setColor(Color.BLACK);
        graphics.drawRect(0,0,width-1,height-1);
        //设置验证码字母
        String code = "QWERTYUIOPASDFGHJKLZXCVBNMqwertyuiopasdfghjklzxcvbnm";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 1 ;i<=4;i++){
            int index = random.nextInt(code.length());
            char c = code.charAt(index);
            graphics.drawString(c+"",20*i,25);
            sb.append(c);
        }
        String checkCode_session = sb.toString();
        request.getSession().setAttribute("checkCode",checkCode_session);
        //话虚线
        for (int i = 1;i<=8;i++){
            int x1 = random.nextInt(width-1);
            int y1 = random.nextInt(height-1);
            int x2 = random.nextInt(width-1);
            int y2 = random.nextInt(height-1);
            graphics.drawLine(x1,y1,x2,y2);
        }
        //将验证码输出到页面上
        ImageIO.write(bufferedImage,"jpg",response.getOutputStream());
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doPost(request, response);
    }
}
