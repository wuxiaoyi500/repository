package zyq.loginProject;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class druidUtil {
    private static DataSource ds;
    static {

        try {
            //加载配置文件，获取字节流
            Properties properties = new Properties();
            InputStream is = druidUtil.class.getClassLoader().getResourceAsStream("druid.properties");
            properties.load(is);
            //初始化连接池
            ds = DruidDataSourceFactory.createDataSource(properties);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //获取连接池对象
    public static DataSource getDataSource(){
        return ds;
    }
    //获取Connection连接对象
    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
