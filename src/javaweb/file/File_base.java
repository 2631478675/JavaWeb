package javaweb.file;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.IOException;


public class File_base {

    private final static Logger LOGGER= LoggerFactory.getLogger(File_base.class);

    public static void main(String[] args){
        /**
         * 路径：
         * ①当前路径:以JavaWeb开始
         * ②绝对路径：比如以D盘开始
         */
        File file=new File("WebContent/WEB-INF/file.txt"); //可以是.text、.png、文件夹、.doc、.ppt等

        /**
         * File中常用方法：创建、删除、重命名
         * 但是！！！只要涉及到了文件内容，只能由io操作
         */
        //获取文件名字
        System.out.println( file.getName());

        //获取父文件夹:WebContent\WEB-INF
        System.out.println(file.getParent());
        //获取路径：
        file.getPath();
        //获取绝对文件路径 :E:\Spring\JavaWeb\WebContent\WEB-INF\file.txt
        System.out.println(file.getAbsolutePath());

        //文件重命名
        File file_new=new File("new_file.txt");
        file.renameTo(file_new);//要求file文件必须存在，file_new 一定不存在

        //创建未被创建的文件
        File file_create=new File("WebContent/WEB-INF/file_create");
        if(!file_create.exists()){
            //                file_create.createNewFile();
            file_create.mkdir();//创建文件目录，前提是父目录文件存在
            file_create.mkdirs();//父目录不存在，一并创建了
        }
    }
}
