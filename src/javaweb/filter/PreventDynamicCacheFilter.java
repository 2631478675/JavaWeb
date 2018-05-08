package javaweb.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * prevent browsers from caching all dynamic page Filter
 */
public class PreventDynamicCacheFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        /**
         * reference ：https://blog.csdn.net/u013417227/article/details/70599063
         */
        HttpServletResponse response=(HttpServletResponse) servletResponse;
        //不是所有浏览器都支持上面的三个响应，因此同时使用
        response.setDateHeader("Expires",-1);   //Expires数据头：值为GMT时间值，为-1指浏览器不要缓存页面
        response.setHeader("Cache-Control","no-cache");  //Cache-Control响应头有两个常用值：no-cache指浏览器不要缓存当前页面。max-age:xxx指浏览器缓存页面xxx秒。
        response.setHeader("Pragma","no-cache");
    }

    @Override
    public void destroy() {

    }
}
