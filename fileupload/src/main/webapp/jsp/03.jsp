<%--
  Created by IntelliJ IDEA.
  User: 86166
  Date: 2019/5/30
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <%--不加下面的就需要加上../--%>
    <%--<base href="<%=basePath%>">--%>
    <title>文件上传和下载</title>
    <link rel="stylesheet" type="text/css" href="../css/common.css">
    <script type="text/javascript" src="../js\jquery-1.11.1.js"></script>
    <script type="text/javascript">
        $(function(){
            $(".thumbs a").click(function () {
                var largePath = $(this).attr("href");
                var largeAlt = $(this).attr("title");
                $("#largeImage").attr(
                    {
                        src:largePath,
                        alt:largeAlt
                    });
                return false;
            });
        });

        function showpreview(obj) {
            var str = obj.value;
            console.log("str:"+str);
            console.log("<img src ='"+str+"'/>")
            document.getElementById("previewImg").innerHTML="<img src ='"+str+"'/>";
        }
    </script>


</head>
<body>
<form action = "">
    请选择图片<input type="file" name="myfile" id = "myfile" onchange="showpreview(this)">
</form>

<div id = "previewImg">
    <hr>
    1
    <img src ='G:\huaxia\资料\54bdfb6c00016d3c00000000\scxz\WebRoot\images\img2-lg.jpg'/>
    <img src="G:\huaxia\资料\54bdfb6c00016d3c00000000\scxz\WebRoot\images\img2-lg.jpg">
    12
</div>

<h1>图片预览</h1>
asdf
<p><img id = "largeImage" src = '../images/img1-lg.jpg' alt = "Large Image"/></p>
<p class="thumbs">
    <a href="../images/img2-lg.jpg" title="Image2"><img src="../images/img2-thumb.jpg"></a>
    <a href="../images/img3-lg.jpg" title="Image3"><img src="../images/img3-thumb.jpg"></a>
    <a href="../images/img4-lg.jpg" title="Image4"><img src="../images/img4-thumb.jpg"></a>
    <a href="../images/img5-lg.jpg" title="Image5"><img src="../images/img5-thumb.jpg"></a>
    <a href="../images/img6-lg.jpg" title="Image6"><img src="../images/img6-thumb.jpg"></a>
</p>
</body>
</html>
