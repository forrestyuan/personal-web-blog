<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ page import="com.yfc.valueBean.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
pageContext.setAttribute("ctx",path);
%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--[if IE]-->
    <script src=”http://html5shiv.googlecode.com/svn/trunk/html5.js”></script>
    <!--[endif]-->
    <title>就你</title>
    <link href="${ctx}/outercss/style.css" rel="stylesheet">
    <script>
        alert("请用方向键浏览！")
    </script>
</head>
<body data-rendering="true">
<!--幻灯-->
<div id="impress" class="impress-not-supported">

    <div class="fallback-message">
        <p>你的浏览器太古老<b>，缺少必要的运行本程序的特征</b>，你只能看到一个简单表现的版本。</p>
        <p>为了达到最佳的体验效果，请使用最新的<b>谷歌浏览器</b> 或 苹果<b>Safari</b>浏览器，或最新版的火狐浏览器 10 和 IE 10 也可以。</p>
    </div>

    <div class="step slide" data-x="-2000" data-y="-1500">
       <q><img style="width: 800px;height: 500px;" src="picture/weapon.jpg"></q>
    </div>
    <div class="step slide" data-x="-1000" data-y="-1500">
        <q><b>now!</b>I am not a real programmer yet,I am still<b> on my road,</b>Lots of difficulties come to me.</q>
    </div>

    <div class="step slide" data-x="0" data-y="-1500">
        <q><strong>However</strong>,I learn a lot from it.<strong> language</strong> like JAVA、C、JAVASCRIPT、PHP,etc.All is interest me a lot.<strong>and you</strong>？</q>
    </div>

    <div class="step slide" data-x="1000" data-y="-1500">
        <q>I didn't build a project yet!<br/><strong>what a pity</strong> I have get ready to accept the suffer of coding,<br/><strong>This</strong> might be my first project!</q>
    </div>

    <div id="title" class="step" data-x="0" data-y="0" data-scale="4">
        <span class="try">what I try to build!</span>
        <h1>success<sup></sup>?</h1>
        <span class="footnote"><sup>*</sup> no rhyme intended</span>
    </div>

    <div id="its" class="step" data-x="850" data-y="3000" data-rotate="90" data-scale="5">
        <p>这是一个<strong>展现工具</strong> <br>
            是受<a href="http://prezi.com/">prezi.com</a>的启发 <br>
            使用了现代浏览器里支持的<strong>CSS3 transforms 和 transitions</strong>功能。</p>
    </div>

    <div id="big" class="step" data-x="3500" data-y="2100" data-rotate="180" data-scale="6">
        <p>把你的<b>雄伟</b> <span class="thoughts">思想</span>可视化</p>
    </div>

    <div id="tiny" class="step" data-x="2825" data-y="2325" data-z="-600" data-rotate="300" data-scale="1">
        <p>你的<b>小小</b>点子立体化</p>
    </div>

    <div id="ing" class="step" data-x="3500" data-y="-850" data-rotate="270" data-scale="6">
        <p>在无限的画布上通过<b class="positioning">定位</b>，<b class="rotating">旋转</b>和<b class="scaling">缩放</b>把它们表现出来</p>
    </div>

    <div id="imagination" class="step" data-x="6700" data-y="-300" data-scale="6">
        <p>唯一的<b>限制</b>是你的<br><b class="imagination">想象力</b></p>
    </div>

    <div id="source" class="step" data-x="6300" data-y="2000" data-rotate="20" data-scale="4">
        <p>如魔法般</p>
        <q><a href="#">showing
        </a></q>
    </div>

    <div id="one-more-thing" class="step" data-x="6000" data-y="4000" data-scale="2">
        <p>还有一点...</p>
    </div>

    <div id="its-in-3d" class="step" data-x="6200" data-y="4300" data-z="-100" data-rotate-x="-40" data-rotate-y="10" data-scale="2">
        <p><span class="have">是否</span><span class="you">你</span><span class="noticed">注意到</span><span class="its">它是</span> <span class="in">有</span> <b>3D效果的<sup>*</sup></b>?</p>
        <span class="footnote">* beat that, prezi ;)</span>
    </div>

    <div id="overview" class="step" data-x="3000" data-y="1500" data-scale="10">
    </div>

</div>

</script><script src="${ctx}/outerjs/impress.js"></script>

<!-- social, tracking etc, ignore -->

<div style="position: fixed; top: 10px; left: 50%; margin-left:-50px">
    <b>请用键盘上的方向键。</b> <br>



</div>

<div>
    <style>
        #share_bar { background: none repeat scroll 0 0 #FFFFFF;/*#F5F8FD*/ border: 1px solid #CBD5ED; border-radius: 5px; color: #000000; font-size: 13px; text-align: center;z-index: 999; position: fixed;
            right: 0px;
            top: 50%;
            margin-top: -140px;
        }
        #share_bar ul li{list-style:none;display: block;}
        #share_bar ul, #share_bar ul li{ margin:0; padding:0}
        #share_bar > ul > li > a {width: 45px; height: 35px; display: inline-block; text-align: center; position: relative;}
        #s_t, #s_c{line-height: 25px; vertical-align: middle;text-align: center;  }
        #share_bar > ul > li > a > span{height: 28px; width: 28px; display: inline-block; position:absolute; top:50%; left: 50%; margin-left: -14px; margin-top:-14px; background-repeat: no-repeat; background-image: url(picture/brand.png); }
        #tsina > span { background-position: 0 -91px;}
        #qzone > span { background-position: 0 -61px;}
        #tqq > span { background-position: 0 -121px;}
        #renren > span { background-position: 0 -151px;}
        #twitter > span { background-position: 0 -31px;}

        #tsina:hover{background-color: #e6162c;}
        #qzone:hover{background-color: #2980d7;}
        #tqq:hover{background-color: #4388c6;}
        #renren:hover{background-color: #f8f8f8;}
        #twitter:hover{background-color: #00aced;}

        .heng_share #share_bar{position: relative; margin-top: 0; right: 0; top: 0; display: inline-block;}
        .heng_share #share_bar ul li{float: left;width: 35px;}

        .left_share #share_bar{right: inherit;left: 0}
    </style>

</div>
<div style="font-size: 1.2em;font-family: Microsoft YaHei,'宋体' , Tahoma, Helvetica, Arial, sans-serif;"><a href="${ctx}/index.jsp"><p>点我进入！</p></a></div>
<script src="${ctx}/outerjs/util.js"></script>
<script src="${ctx}/outerjs/ga.js"></script>
<script src="${ctx}/outerjs/wb.js"></script>
</body>
</html>