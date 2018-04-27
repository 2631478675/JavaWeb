//package javaweb.file;
//
//import org.apache.commons.fileupload.FileItem;
//import org.apache.commons.fileupload.FileUploadException;
//import org.apache.commons.fileupload.disk.DiskFileItemFactory;
//import org.apache.commons.fileupload.servlet.ServletFileUpload;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.File;
//import java.io.IOException;
//import java.util.List;
//import java.util.UUID;
//
////引进文件上传的组件     commands-upload;commands-i/o;
////新建目录来存放已上传的文件   在web中创建目录
////（多部件的文件类型）字符串，，，用FileItem来封装
//
///**
// * 使用commands-upload组件实现文件上传
// */
//@WebServlet(name = "Servlet",urlPatterns = {"sa/Servlet"})
////@MultipartConfig   servlet3.0新特性
//public class Servlet extends HttpServlet {
//    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        doGet(request,response);
//    }
//
//    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//       //使用command_i/o;command_upload组件；
//        //创建文件项的工厂
//        DiskFileItemFactory factory=new DiskFileItemFactory();
//        //解析数据的组件
//        ServletFileUpload upload=new ServletFileUpload(factory);
//        //开始解析数据
//        try {
//            List<FileItem> list=upload.parseRequest(request);
//            //遍历数据
//            for(int i=0;i<list.size();i++){
//                //在里面取出
//                FileItem item=list.get(i);
//                if(item.isFormField()){
//                    if ("description".equals(item.getFieldName())){
//                        System.out.println(item.getString());
//                    }
//                }
//                else {
//                    String filename=item.getName();
//                    String extname=filename.substring(filename.lastIndexOf("."));
//                    String rootPath=request.getServletContext().getRealPath("/upload");
//                    String newname=UUID.randomUUID().toString();
//                    String name=rootPath+"/"+newname+extname;
//                    item.write(new File(name));
//                }
//            }
//        } catch (FileUploadException e) {
//            e.printStackTrace();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//
//
//
//
//
//
//}}
