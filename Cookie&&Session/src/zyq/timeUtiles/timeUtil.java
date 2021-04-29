package zyq.timeUtiles;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;


public class timeUtil {
    public static String getTime(){
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH时mm分ss秒");
        String time = sdf.format(date);
        time = URLEncoder.encode(time);
        time = URLDecoder.decode(time);
        return time;
    }
}
