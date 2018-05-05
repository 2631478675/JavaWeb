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

- 实现文件上传(file)
    - 使用servlet(FileUpload)
    - 使用servlet3.0的新特性(FileUpload_servlet_three)
    - 使用springmvc
- 实现文件下载
- 实现日志添加
    - 配置文件log4j2.xml
    - 在web.xml配置
    - 编写测试类Log4jTest
- 搭建web服务器（计网作业hhhh）