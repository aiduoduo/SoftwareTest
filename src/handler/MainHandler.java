package handler;

import tools.Tool;
import object.Paper;
import object.Request;

import java.sql.*;

/**
 * Created by admin on 2019/4/23.
 */
public class MainHandler {
    //数据库 URL，并确定编码格式为UTF-8
    private static final String DB_URL = "jdbc:mysql://127.0.0.1:3306/software?useUnicode=true&characterEncoding=UTF-8";
    // 数据库的用户名与密码
    private static Connection conn = null;
    private static final String USER = "root";
    private static final String PASS = "123456";
    private static volatile MainHandler mainHandler = null;

    public static MainHandler getInstance() {
        if (mainHandler == null) {
            mainHandler = new MainHandler();
            mainHandler.init();
        }
        return mainHandler;
    }

    //连接数据库，初始化处理类
    private void init() {
        try {
            //连接数据库，并设置提交方式
            System.out.println("连接数据库…");
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            conn.setAutoCommit(false);
        } catch (Exception e) {
            System.out.println("运行中错误：" + e);
        }

    }

    //接受请求，调用请求处理函数
    public void receiveRequest(String requestString) {
        Request[] request = Tool.generateRequest(requestString);
        handleRequest(request);
    }

    private void handleRequest(Request[] requests) {
        for (Request request : requests) {
            if (!request.isRight()) {
                //TODO:响应前端，报告错误
                System.out.print("请求信息错误");
            }
        }
        String title = "";
        Date date = new Date(1);
        Paper paper = new Paper(date, title);
        PreparedStatement pstmt = null;
        //TODO:利用请求类的信息，获取试题，完善paper类
        for (Request request : requests) {
            try {
                String sql = "select * from question where "+Tool.generateCondition(request.getPropertyNames(), request.getInformations());
                pstmt = conn.prepareStatement(sql);
            }catch (SQLException e){
                try {
                    if (pstmt != null) pstmt.close();
                } catch (Exception e1) {
                    System.out.print("SQLException");
                }
            }
        }
        Tool.getJSON(paper);
        //TODO:将paper转换为JSON字符串，报告给前端
    }
    
    public void close(){
        try {
            if (conn != null) conn.close();
        } catch (Exception e1) {
            System.out.print("SQLException");
        }
    }


}
