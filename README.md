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
<li>执行mvn install -DskipTests命令</li>
<li>执行mvn eclipse:eclipse命令</li>
<li>eclipse导入三个工程</li>
<li>项目右键->Configure->Convert to maven Project</li>
<li>Done!</li>
</ol>
<h3>启动应用</h3>
<li>新建一个数据库</li>
<li>拷贝studio-site-manager/src/main/resources/config/_jdbc.properties命名为jdbc.properties然后修改相应配置</li>
<li>拷贝studio-site-mobile/src/main/resources/config/_jdbc.properties命名为jdbc.properties然后修改相应配置</li>
<li>如果需要生成测试数据则执行以下步骤</li>
<li>拷贝studio-site-base/src/test/resources/config/_jdbc.properties命名为jdbc.properties然后修改相应配置</li>
<li>跑测试用例studio-site-base/src/test/java/net.shangtech.studio.test.AppTest</li>
