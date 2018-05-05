package javaweb.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 使用servlet3.0的新特性实现文件上传
 * ①注解@MultipartConfig
 * ②使用request.getPart()
 */
@WebServlet(name = "FileUpload_servlet_three",urlPatterns = {"sa/FileUpload_servlet_three"})
//配置文件的类型：文件大小，类型等
@MultipartConfig   //servlet3.0新特性
public class FileUpload_servlet_three extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取组件
        Part part=request.getPart("");
        //获取服务端的上下文，获取存放文件的目录
        String root=request.getServletContext().getRealPath("/upload");
        //获取文件头部信息
//        String name=part.getName();
        String header=part.getHeader("content-disposition");
        //获取文件后缀名
        String extName=header.substring(header.lastIndexOf("."),header.length()-1);
        String filName=root+File.separator+UUID.randomUUID().toString()+extName;
        part.write(filName);
    }
}
