package server;

import java.io.InputStream;

public class Request {

    private InputStream input;

    private String uri;

    public Request(InputStream input) {
        this.input = input;
    }

    public String getUri() {
        return this.uri;
    }


    public void parse() {

        StringBuffer request = new StringBuffer(2048);
        int i;
        byte[] buffer = new byte[2048];
        try {
            i = input.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
            i = -1;
        }
        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
        System.out.print(request.toString());
        uri = parseUri(request.toString());
    }

    //解析整个URL
    public String parseUri(String requestString) {
        int index1, index2;
        index1 = requestString.indexOf(" ");
        if (index1 != -1) {
            index2 = requestString.indexOf('?', index1 + 1);
            if (index2 == -1) index2 = requestString.indexOf(' ', index1 + 1);
            return requestString.substring(index1 + 2, index2);
        }
        return null;
    }


}