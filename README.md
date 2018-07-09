# JavaWeb
Implement JavaWeb basic functionality

---
### 内容（content）
##### jdbc数据库访问
> 简介：java dataBase connection:数据库连接，交互

- 使用Statement实现数据库连接(jdbcBase)
- 使用Statement子类PreparedStatement(防SQL注入)(jdbcBase)
- 优化代码，自定义工具类(jdbcByDao)
    - dao
    - domain
    - util
- 优化代码，自定义Tempelete(jdbcByTempleteUtil)
- 使用工具类DBUtils，**一般采用**(jdbcByDbUtils)
---
> 对客户请求处理，请求经过过滤链（设置统一编码的过滤器）
- filter使用：
    - 过滤器映射到servlet（ 配置在servlet下面 ）
    - 自定义filter（MyFilter）实现接口Filter 
    - ControlStaticResourcesFilter:控制静态资源
    - XXSFilter
    - SQLFilter
    - PreventDynamicCacheFilter:阻止存储动态页面
- interceptor和filter的区别
    - Filter是基于函数回调的，而Interceptor则是基于Java反射的。
    - Filter依赖于Servlet容器，而Interceptor不依赖于Servlet容器。
    - Filter对几乎所有的请求起作用，而Interceptor只能对action请求起作用。
    - Interceptor可以访问Action的上下文，值栈里的对象，而Filter不能。
    - 在action的生命周期里，Interceptor可以被多次调用，而Filter只能在容器初始化时调用一次。 
- 实现文件上传(file)
    - 使用servlet(FileUpload)
    - 使用servlet3.0的新特性(FileUpload_servlet_three)
    - 使用springmvc
- 实现文件下载
- io流
    - 字节流：8bit（FileInputOutputStream对应）
        - InputStream
        - OutputStream
    - 字符流：16bit(FileReaderWriter对应char)
        - Reader
        - Writer
    - 缓冲流：（Buffered，，，）
- 实现日志添加
    - 配置文件log4j2.xml
    - 在web.xml配置
    - 编写测试类Log4jTest
- 搭建web服务器（计网作业hhhh）
