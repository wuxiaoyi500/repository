package cn.zyq.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class JDBCUtil {
    private static DataSource ds;
    static {
        try {
            //加载配置文件
            Properties pro = new Properties();
            //使用classloader类加载器加载配置文件，获取字节流对象
            InputStream is = JDBCUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接池
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static DataSource getDataSource(){
        return ds;
    }
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
