package server;//package server;
//
//
//import java.io.File;
//import java.io.FileInputStream;
//import java.io.IOException;
//import java.io.OutputStream;
//
//
//
//
//public class Response {
//
//    public static final String PATH = "E:\\Spring\\JavaWeb\\src\\server\\recourses";
//
//    Request request;
//
//    OutputStream output;
//
//    public Response(OutputStream output) {
//        this.output = output;
//    }
//
//    public void setRequest(Request request) {
//        this.request = request;
//    }
//
//    public void sendStaticResource() throws IOException {
//        byte[] bytes = new byte[1024];
//        FileInputStream fis = null;
////        if (PATH != null && request.getUri() != null) {
////            File file = new File(PATH, request.getUri());
////            String str = "";
////            if (file.exists()) {
////                fis = new FileInputStream(file);
////                str = "HTTP/1.1 200 OK \r\n" +
////                        "Content-Type: text/html\r\n" +
////                        "\r\n";
////                output.write(str.getBytes());
////                int b = fis.read(bytes);
////                while (b != -1) {
////                    output.write(bytes, 0, b);
////                    b = fis.read(bytes, 0, 1024);
////                }
////            }
////            else {
////
////                str = "HTTP/1.1 404 File Not Found\r\n" +
////                        "Content-Type:text/html\r\n" +
////                        "Content-Length:23\r\n" +
////                        "\r\n" +
////                        "<h1>File Not Found</h1>";
////                output.write(str.getBytes());
////            }
//        }
//        output.close();
//    }
//}