//package javaweb.servlet;
//
//import javaweb.person.Person;
//import javaweb.personDao.PersonDao;
//
//import java.io.IOException;
//import java.sql.SQLException;
//
//public class FriendServlet extends javax.servlet.http.HttpServlet {
//    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        //操作验证,自己定义了一个method变量,从而知道该调用那个方法
//        String method=request.getParameter("method");
//        if("find".equals(method)){
//            search(request,response);
//        }else if("add".equals(method)){
//            add(request,response);
//        }else if("update".equals(method)){
//            update(request,response);
//        }else("delete".equals(method)){
//            delete(request,response);
//        }
//    }
//
//    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        doPost(request,response);
//    }
//    protected void add(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        //通过客户端获得数据
//        String name=request.getParameter("name");
//        String sex=request.getParameter("sex");
//        String school=request.getParameter("school");
//        String hight=request.getParameter("hight");
//        //封装数据
//        Person person=new Person(name,sex,school,hight);
//        //业务逻辑处理
//        PersonDao dao=new PersonDaoImpl();
//        try {
//            dao.save(person);
//            //跳转页面
//            request.getRequestDispatcher("edit.jsp").forward(request,response);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    protected void update(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String id=request.getParameter("id");
//        String name=request.getParameter("name");
//        String sex=request.getParameter("sex");
//        String school=request.getParameter("school");
//        String height=request.getParameter("height");
//        Person person=new Person(id,name,sex,school,height);
//        PersonDao dao=new PersonDaoImpl();
//        try {
//            dao.update(person);
//
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//    }
//    protected void delete(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//        String id=request.getParameter("id");
//        PersonDao dao=new PersonDaoImpl();
//        try {
//            dao.delete(id);
//            //响应客户端(页面)
//            response.sendRedirect("/FriendServlet?method=findAll");
//        }catch (SQLException e){
//            e.printStackTrace();
//        }
//    }
//    protected void search(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
//
//    }
//}
