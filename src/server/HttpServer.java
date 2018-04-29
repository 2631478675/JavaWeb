package server;


import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public void create() {
        //创建端口号，套接字
        ServerSocket serverSocket = null;
        int port = 8080;
        try {
            serverSocket = new ServerSocket(8080, 3, InetAddress.getByName("127.0.0.1"));
        } catch (Exception e) {
            e.printStackTrace();
            System.exit(0);
        }
        while (true) {
            Socket socket = null;
            InputStream input = null;
            OutputStream output = null;
            //主要对html进行处理
            try {
                socket = serverSocket.accept();
                input = socket.getInputStream();
                output = socket.getOutputStream();
                //进行请求，并进行解析
                Request request = new Request(input);
                request.parse();

                //对请求进行响应
                Response response = new Response(output);
                response.setRequest(request);
                response.sendStaticResource();
            } catch (Exception e) {
                e.printStackTrace();
                continue;
            }
        }
    }

    public static void main(String[] args) {
        HttpServer server = new HttpServer();
        System.out.println("在浏览器上输入http://localhost:8080/index.html");
        server.create();
        }
}
