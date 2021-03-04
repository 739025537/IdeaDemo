package com.javacto.day002.dao;

import com.javacto.day002.po.User;
import com.javacto.day002.util.BaseDao;
import com.javacto.day002.util.PageInfo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class UserDaoIml implements UserDao {
    @Override
    public int addUser(User user) throws Exception{
        int num = 0;
        String sql="insert into user values(?,?,?)";
        String sbqargs[]={String.valueOf(user.getId()),user.getName(),user.getPwd()};

        num=BaseDao.executeUpdate(sql,sbqargs);
        return  num;
    }

    @Override
    public int deleteUser(int id) throws Exception{
        int num = 0;

            //3.处理预编译SQL语句
            String sql="delete from user where id=?";
            String sbqargs[]={String.valueOf(id)};

            num=BaseDao.executeUpdate(sql,sbqargs);

        return  num;
    }

    @Override
    public User findUserById(int id) {
        User  user1 = null;
        Connection conn =null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            //1.加载驱动
           conn= BaseDao.getConnection();
            //3.处理预编译SQL语句
            String sql="select * from user where id=?";
            String sbqargs[]={String.valueOf(id)};

            //3.处理预编译SQL语句
            pstm=conn.prepareStatement("select * from user where id=?");
            pstm.setInt(1,id);
            rs=pstm.executeQuery();
            while (rs.next()){
                //这里必须再创建新的对象
                user1=new User();
                user1.setId(rs.getInt(1));
                user1.setName(rs.getString(2));
                user1.setPwd(rs.getString(3));
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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

        return  user1;
    }

    @Override
    public int updateUser(User user) {
        int num = 0;
        Connection conn =null;
        PreparedStatement pstm=null;

        try {
            //1.加载驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.建立连接
            conn= DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","root");
            //3.处理预编译SQL语句
            pstm=conn.prepareStatement("UPDATE user SET name=?,pwd=? WHERE  id=?");
            pstm.setString(1,user.getName());
            pstm.setString(2,user.getPwd());
            pstm.setInt(3,user.getId());
            num=pstm.executeUpdate();
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            //4.释放资源
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

        return  num;
    }

    @Override
    public List<User> querAll() {
        List<User> list = new ArrayList<User>();
        Connection conn =null;
        PreparedStatement pstm=null;
        ResultSet rs=null;
        try {
            conn= BaseDao.getConnection();
            //3.处理预编译SQL语句
            pstm=conn.prepareStatement("select * from user");
            rs= pstm.executeQuery();
            while (rs.next()){
                User user1=new User();
                user1.setId(rs.getInt(1));
                user1.setName(rs.getString(2));
                user1.setPwd(rs.getString(3));

                list.add(user1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
        return  list;
    }


    /**
     * 登录验证
     *
     * @return
     */
    public boolean  login(String name1, String pwd1) {
        Connection conn=null;
        PreparedStatement pstm=null;
        //int x=0;
        boolean flag=false;
        ResultSet rs=null;
        String sql="select * from user where name=? and pwd=?";
        String sbqargs[]={name1,pwd1};

        rs=BaseDao.executeQuery(sql,sbqargs);
        try {
            while (rs.next()){
                flag=true;
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
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
//         if (rs.next()){
//             x=rs.getInt(1);
//         }else {
//             x=-1;
//         }

        return flag;
    }
    /**
     * 查询每页显示的数量
     */
    public  List<User> queryAllPage(PageInfo page, User user1){
        List<User> list = new ArrayList<User>();
        Connection conn = BaseDao.getConnection();

        PreparedStatement pstm = null;
        ResultSet rs=null;
        try{
            //3.处理预编译sql语句
            //请注意，？相当于占位符    t_name=?(这是1个) AND t_password=?（这是第2个）  ?(这是第3个)
            pstm = conn.prepareStatement("SELECT * FROM user LIMIT ?,? ");

            //SELECT * FROM emp LIMIT (pageNo-1)*pageSize,pageSize;
            int begin = (page.getCurPageNo()-1)*page.getPageSize();
            int end=page.getPageSize();

            pstm.setObject(1,begin);
            pstm.setObject(2,end);

            //没有？号就不需给？点位符赋值
            //5.执行预编译sql语句
            rs = pstm.executeQuery();
            //6.循环遍历
            while (rs.next()){
                //注意，这需必需new对象
                User user = new User();
                user.setId(rs.getInt(1));
                user.setName(rs.getString(2));
                user.setPwd(rs.getString(3));
                //很多同学这里忘记了  ,必需把对象添加到集合中
                list.add(user);
            }
        }catch (Exception e){
                e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }
        return  list;
    }

    /**
     * 查询总条数
     */
    public  int getTotalCount(User user){
        int i=0;
        Connection conn = BaseDao.getConnection();
        PreparedStatement pstm = null;
        ResultSet rs=null;
        try{
            //3.处理预编译sql语句
            //请注意，？相当于占位符    t_name=?(这是1个) AND t_password=?（这是第2个）  ?(这是第3个)
            pstm = conn.prepareStatement("SELECT  count(*) FROM user ");
            //没有？号就不需给？点位符赋值
            //5.执行预编译sql语句
            rs = pstm.executeQuery();
            //6.循环遍历
            while (rs.next()){
                i=rs.getInt(1);
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            BaseDao.closeAll(conn,pstm,rs);
        }

        return  i;
    }

    /**
     * 验证用户是否已经存在
     */
    public boolean  findUserByName(String name) throws SQLException {
                Connection conn=null;
                PreparedStatement pstm=null;
                //int x=0;
                boolean flag=false;
                ResultSet rs=null;
                String sql="select * from user where name=?";
                String sbqargs[]={name};

                rs=BaseDao.executeQuery(sql,sbqargs);
                try {
                    while (rs.next()){
                        flag=true;
                    }
                }catch (Exception e){
                    e.printStackTrace();
        }finally {
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
//         if (rs.next()){
//             x=rs.getInt(1);
//         }else {
//             x=-1;
//         }

        return flag;
    }
}
