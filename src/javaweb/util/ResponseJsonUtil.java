package javaweb.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseJsonUtil {

    private final String message;
    private final int code;
    private final Map<String, Object> data = new HashMap<String, Object>();

    public String getMessage() {
        return message;
    }

    public int getCode() {
        return code;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public ResponseJsonUtil putDataValue(String key, Object value) {
        data.put(key, value);
        return this;
    }

    private ResponseJsonUtil(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public static ResponseJsonUtil ok() {
        return new ResponseJsonUtil(200, "Ok");
    }

    public static ResponseJsonUtil notFound() {
        return new ResponseJsonUtil(404, "Not Found");
    }

    public static ResponseJsonUtil badRequest() {
        return new ResponseJsonUtil(400, "Bad Request");
    }

    public static ResponseJsonUtil forbidden() {
        return new ResponseJsonUtil(403, "Forbidden");
    }

    public static ResponseJsonUtil unauthorized() {
        return new ResponseJsonUtil(401, "unauthorized");
    }

    public static ResponseJsonUtil serverInternalError() {
        return new ResponseJsonUtil(500, "Server Internal Error");
    }

    public static ResponseJsonUtil customerError() {
        return new ResponseJsonUtil(1001, "customer Error");
    }
}
