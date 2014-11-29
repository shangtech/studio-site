studio-site
===========

<h2>导入eclipse步骤</h2>
<h3>软件要求</h3>
<ol class="task-list">
<li>java8</li>
<li>maven3.x</li>
<li>tomcat8</li>
<li>推荐使用eclipse4.4.1</li>
</ol>
<h3>下载shangtech-fromework</h3>
<ol class="task-list">
<li>fork and clone <a href="https://github.com/shangtech/shangtech-framework">shangtech-framework</a></li>
<li>命令行到shangtech-framework目录</li>
<li>执行mvn install命令</li>
<li>如果要导入shangtech-framework就继续执行下面的步骤</li>
<li>执行mvn eclipse:eclipse命令</li>
<li>eclipse import</li>
<li>项目右键->Configure->Convert to maven Project</li>
</ol>
<h3>studio-site</h3>
<ol class="task-list">
<li>clone studio-site代码</li>
<li>命令行到studio-site所在路径</li>
<li>执行mvn install命令</li>
<li>执行mvn eclipse:eclipse命令</li>
<li>eclipse导入三个工程</li>
<li>项目右键->Configure->Convert to maven Project</li>
<li>数据库新建一个库,应用启动后会自动建表</li>
<li>拷贝studio-site-manager/src/main/resources/config/_jdbc.properties命名为jdbc.properties然后修改相应配置</li>
<li>拷贝studio-site-mobile/src/main/resources/config/_jdbc.properties命名为jdbc.properties然后修改相应配置</li>
<li>启动应用如果没有自动建表,修改spring.xml中hibernate.hbm2ddl.auto的值为create,建好再改回来</li>
<li>Done!</li>
</ol>