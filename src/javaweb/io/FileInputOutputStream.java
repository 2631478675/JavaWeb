package javaweb.io;

import java.io.*;

/**
 * 输入输出相对idea而言
 */
public class FileInputOutputStream {

    public static  void FileInputStream(){
        //创建一个文件对象
        File file=new File("WebContent/WEB-INF/file_new.txt");
        //判断是否存在，必须存在
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileInputStream fileInputStream= null;
        try {
            fileInputStream = new FileInputStream(file);
            //调用FileInputStream的方法，进行文件内容的读取
//            int b;
//            while((b=fileInputStream.read())!=-1){
//                System.out.print ((char)b);
//            }
            byte[] bytes=new byte[20];    //一次读取的字节数
            int len;  //一次中有多少个
            while((len=fileInputStream.read(bytes))!=-1){
//                for (int i = 0;i<len;i++){
//                    System.out.print ((char)bytes[i]);

                //将字节数组转化为字符串
                String string=new String(bytes,0,len);
                System.out.print (string);
            }



        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                fileInputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void FileOutputStream(){
        //文件可以不存在，不存在会自动创建，存在覆盖原来内容
        File file=new File("WebContent/WEB-INF/file.txt");

        FileOutputStream fileOutputStream=null;
        try {
            fileOutputStream=new FileOutputStream(file);
            fileOutputStream.write(new String("China").getBytes());

        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    /**
     * 将某文件的内容写到另一文件中,可以是照片啥的
     */
    public static void FileInputOutputStream(){
        File file_input=new File("WebContent/WEB-INF/file.txt");
        File file_output=new File("WebContent/WEB-INF/file_new.txt");
        FileInputStream fileInputStream=null;
        FileOutputStream fileOutputStream=null;
        try {
            fileInputStream=new FileInputStream(file_input);
            fileOutputStream=new FileOutputStream(file_output);
            byte[] bytes=new byte[1024];
            int len;
            while((len=fileInputStream.read(bytes))!=-1){
                //注意
//                fileOutputStream.write(bytes);//这样写是错的
                fileOutputStream.write(bytes,0,len);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(fileInputStream!=null){
                try {
                    fileInputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if(fileOutputStream!=null){
                try {
                    fileOutputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

    }
    public static void main(String[] args){
        FileInputOutputStream();
    }
}
