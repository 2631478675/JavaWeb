
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Log4jTest {

    private final static Logger logger = LoggerFactory.getLogger(Log4jTest.class);

    public static void main(String[] args) throws InterruptedException {
        //指定配置文件的位置，写在web.xml中
//        PropertyConfigurator.configure("E:\\Spring\\JavaWeb\\src\\log4j.properties");
        for (int i = 0; i < 5000; i++) {
            logger.trace("跟踪信息");
            logger.debug("调试信息");
            logger.info("输出信息");
            logger.warn("警告信息");
            logger.error("错误信息");
        }
    }
}
