package com.javacto.day002.util;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Properties;

public class BaseDao {
    private static  String driverName;
    private static  String sqlurl;
    private static  String sqluser;
    private static  String sqlpwd;
//静态代码块 每次类加载之前执行一次
    static {
        init();
    }
    public static void init(){
        //创建Properties对象用来存取数据
        Properties properties=new Properties();

        //2.拿到文件的路径
        String pathSbq ="db.properties";

        //3.通过输入流读取db.properties  通过反射，直接这样写
        InputStream inputStream = BaseDao.class.getClassLoader().getResourceAsStream(pathSbq);

        //4.把数据读取到Properties
        try {
            properties.load(inputStream);
        }catch (Exception e){
            e.printStackTrace();
        }

        //5.通过键值对赋值
        driverName=(String)properties.get("driver");
        sqlurl=(String)properties.get("url");
        sqluser=(String)properties.get("user");
        sqlpwd=(String)properties.get("pwd");
    }

    /**
     * 封装数据库信息
     * @return
     */
    public static Connection getConnection(){
        Connection conn=null;
        try {
            //1.加载驱动
            Class.forName(driverName);
            //2.建立连接
            conn= DriverManager.getConnection(sqlurl,sqluser,sqlpwd);
        }catch (Exception e){
            e.printStackTrace();
        }
      return conn;
    }


    public  static void closeAll(Connection conn, PreparedStatement pstm, ResultSet rs){
            //4.释放资源
        try {
            if (rs!=null){
                rs.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (pstm!=null){
                pstm.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if (conn!=null){
                conn.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    /**
     * 封装SQL语句
     * @param sql
     * @param sbq
     * @return
     */
    public static int executeUpdate(String sql,Object sbq[]){
        int num=0;
        Connection conn =null;
        PreparedStatement pstm=null;
        try {
            conn= BaseDao.getConnection();
            //3.处理预编译SQL语句
            pstm=conn.prepareStatement(sql);
            //4.给？赋值
            for (int i=0;i<sbq.length;i++){
                pstm.setObject(i+1,sbq[i]);
            }

            num=pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }
        //释放资源
        BaseDao.closeAll(conn,pstm,null);
        return num;
    }

    public static ResultSet executeQuery(String sql, Object[] sbq){
        ResultSet rs=null;
        Connection conn =null;
        PreparedStatement pstm=null;
        try {
            conn= BaseDao.getConnection();
            //3.处理预编译SQL语句
            pstm=conn.prepareStatement(sql);
            //4.给？赋值
            for (int i=0;i<sbq.length;i++){
                pstm.setObject(i+1,sbq[i]);
            }

            rs=pstm.executeQuery();
        }catch (Exception e){
            e.printStackTrace();
        }

//        //释放资源
//        BaseDao.closeAll(conn,pstm,rs);
        return rs;
    }
}


