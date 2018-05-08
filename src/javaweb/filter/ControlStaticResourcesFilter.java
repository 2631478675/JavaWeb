package javaweb.filter;


import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Filter to control static resources in browser cache pages
 * 控制浏览器缓存（一般css 3个月  image 1个月  js 3个月）:这里为了方便，设为一致的
 */
public class ControlStaticResourcesFilter implements Filter {

    private FilterConfig filterConfig=null;
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig=filterConfig;
    }

    //
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {

        HttpServletResponse response=(HttpServletResponse) servletResponse;
        HttpServletRequest request=(HttpServletRequest) servletRequest;
        // judging from the suffix in the URL
        String url = request.getRequestURI();

        if(url.endsWith(".css")||url.endsWith(".js")||url.endsWith(".jpg")){
            long expiresTime = Long.parseLong(this.filterConfig.getInitParameter("jpg"));
            //用缓存时间设置response相应的缓存头
            response.setDateHeader("Expires", System.currentTimeMillis() + expiresTime*60*1000);

            filterChain.doFilter(request, response);
        }
        else {
            filterChain.doFilter(request, response);
        }
    }

    @Override
    public void destroy() {

    }
}
