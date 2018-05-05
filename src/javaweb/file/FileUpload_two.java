package javaweb.file;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;

/**
 * 使用commands-upload组件实现文件上传
 */
public class FileUpload_two extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //更改请求的编码，使用了upload.parseRequest(req)，这里不管用
        req.setCharacterEncoding("utf-8");
        //创建文件项工厂
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //创建用于解析请求的数据的组件
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            //开始解析数据
            List<FileItem> list = upload.parseRequest(req);
            //查看其中
            for (int i = 0; i < list.size(); i++) {
                //遍历列表中每个文件项
                FileItem item = list.get(i);
                //验证是表单还是文件
                if (item.isFormField()) {//判断该文件项是否为表单字段（如果表单字段是description）
                    if ("description".equals(item.getFieldName())) {
                        System.out.println(item.getString());
                    }
                } else {//处理文件
                    //获取文件名
                    String filename = item.getName();
                    System.out.println(filename);
                    //上传的文件有可能两个人相同，需自己定义名字保证在服务器端是唯一的
                    //截取原文件的后缀名，如截取image.png中的png
                    String extName = filename.substring(filename.lastIndexOf("."));
                    //使用UUID来生成新的文件名
                    String newName = UUID.randomUUID().toString();


                    //获取服务器上自定义存放文件的目录
                    //得到服务器端的上下文，获取根目录
                    String rootPath = req.getServletContext().getRealPath("/upload");
                    String newPath = rootPath + "/" + newName + extName;
                    try {
                        //写入文件
                        item.write(new File(newPath));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
