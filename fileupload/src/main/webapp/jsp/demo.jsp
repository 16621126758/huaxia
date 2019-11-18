<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2019/6/4
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style type="text/css">
        .red{
            color: red;
            font-size: 12px;
        }
        .green{
            color: green;
            font-size: 19px;
        }
        #blue{
            color: blue;
            font-size: 19px;
            font-style : inherit;
            text-align: right;
        }
        .fense{
            color: #000;
        }

        .circle{
            list-style-type: circle;
            text-align: center;
        }

        .sequare{
            list-style-type: square;
        }

        .upper-roman{
            list-style-type: upper-roman;
        }
    </style>
</head>
<body>
<p class="red">2018俄罗斯世界杯</p>
<p class="green">中国不会有世界杯</p>

<p id="blue">韩货没有体育精神</p>
<p class="fense">俄罗斯世界杯小组赛第二轮后射手榜</p>
<p2>有序列表</p2>
<ol>
    <li>凯恩</li>
    <li>卢卡库</li>
    <li>罗纳尔多</li>
</ol>
<li>请问</li>
<li>请问</li>
<li>请问</li>
<hr>
<p1>无序列表</p1>
<p>样式一</p>
<ul class="circle">
    <li>入门模式</li>
    <li>初级模式</li>
    <li>中级模式</li>
</ul>

<p>样式二</p>
<ul class="sequare">
    <li>入门模式</li>
    <li>初级模式</li>
    <li>中级模式</li>
</ul>

<p>样式三</p>
<ol class="upper-roman">
    <li>入门模式</li>
    <li>初级模式</li>
    <li>中级模式</li>
</ol>
</body>
</html>
