package javaweb.filter;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * 自定义过滤器
 */
public class MyFilter implements Filter {
    private final static Logger logger = LoggerFactory.getLogger(MyFilter.class);

    /**
     * 服务器启动即执行
     * @param filterConfig
     * @throws ServletException
     */
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    /**
     * 核心：拦截客户请求
     * @param servletRequest
     * @param servletResponse
     * @param filterChain：过滤链
     * @throws IOException
     * @throws ServletException
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        String name = (String)request.getSession().getAttribute("name");
        if(name == null || "".equals(name)){
            logger.info("此用户没有登录");
        }else {
            //执行过滤链的下一个过滤器，如果没有，执行目标对象
            //放行
            filterChain.doFilter(servletRequest,servletResponse);
        }

    }

    @Override
    public void destroy() {

    }
}
