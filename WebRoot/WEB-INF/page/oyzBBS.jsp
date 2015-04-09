<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/tags/taglibs.jsp"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
    <link rel="stylesheet" href="<%=path%>/resources/css/oyzBBS.css">
    <title>My JSP 'oyzBBS.jsp' starting page</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="bbs论坛,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <div class="container" id="container">
        <div class="row" id="row">
            <div  id="nav">
                <a href="./" id="nvhm" title="首页">360安全社区</a>
                <em>»</em>
                <a  id="lt" href="forum.php?mod=digestlist&amp;page=1">论坛</a>
            </div>
        </div>
        <div class="row" id="statistic">
            <div class="col-md-3">
                <span>今日发帖数</span>
                <div><em>3403</em> </div>
            </div>
            <div class="col-md-3">
                <span>昨日发帖数</span>
                <div><em>17460</em></div>
            </div>
            <div class="col-md-3">
                <span>总帖数</span>
                <div><em>30788940</em></div>
            </div>
            <div class="col-md-3" id="last">
                <span>会员总数</span>
                <div><em>22560276</em></div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-9" id="themeList">
           		<c:forEach items="${articles}" var="article">
                <div  class="item">
                    <span class="pic">
                        <a href="home.php?mod=space&amp;uid=17639332" c="1" target="_blank">
                            <img src="../img/32_avatar_small.jpg">
                        </a>
                    </span>
                    <div class="themeInfo">
                        <div class="upInfo">
                            <a href="forum.php?mod=viewthread&amp;tid=&amp;extra=" title="分类置顶主题 - 新窗口打开" target="_blank" class="thread-type">
                                <img src="http://bbs.360safe.com/static/image/common/pin_new_2.gif" alt="分类置顶">
                            </a>
                            <a href="thread-5375863-1-1.html" 41="" target="_blank" class="xst thread-con">${article.title}</a>
                            <img src="http://bbs.360safe.com/static/image/common/digest_1.gif" align="absmiddle" alt="digest" title="精华 1">
                            <em class="view-num ">1130</em>
                        </div>
                        <div class="downInfo">
                            <cite class="thread-author">
                                <a href="home.php?mod=space&amp;uid=17639332">${article.author}</a>
                            </cite>
                            <em>于 <span><span title="2015-2-6">${article.publishDateDescribe}</span></span> 发表</em><span class="pipe">|</span>
                            <cite class="thread-author">
                                <a href="home.php?mod=space&amp;username=" c="1">${article.lastReplyer}</a></cite>
                            <em>&nbsp;于&nbsp;<a href="forum.php?mod=redirect&amp;tid=5375863&amp;goto=lastpost#lastpost" class="lastpost-time"><span title="2015-2-7 18:14">${article.lastReplyDateDesribe }</span></a>&nbsp;最后回复</em>
                            <a href="thread-5375863-1-1.html" class="reply-num">161</a>
                        </div>
                    </div>
                </div>
                </c:forEach>
            </div>
            <div class="col-md-3" id="listSlider">
                <div class="addNew">
                    <a onclick="" title="快速发帖"  style="cursor:pointer"  data-text="快速发帖"  class="quickFt">我要发帖</a>
                </div>
                <div class="hottopic">
                        <h4>热门板块</h4>
                        <a href="forum.php" target="_blank" class="more">更多&gt;&gt;</a>
                    <div>
                        <ul class="">
                            <li class="firstline">
                                <img src="http://p1.qhimg.com/t01697935d162d44559.png" alt="360奇酷" width="35">
                                <a href="http://bbs.360safe.com/forum-1907-1.html">360奇酷</a>
                            </li>
                            <li class="even firstline">
                                <img src="http://p5.qhimg.com/t010a24c1f8da4610dd.png" alt="好搜搜索" width="35">
                                <a href="http://bbs.360safe.com/forum-137-1.html">好搜搜索</a>
                            </li>
                            <li class="">
                                <img src="http://p9.qhimg.com/t011873f775becf745f.png" alt="免费wifi" width="35">
                                 <a href="http://bbs.360safe.com/forum-2198-1.html">免费wifi</a>
                            </li>
                            <li class="even">
                                <img src="http://p7.qhimg.com/t01db15c81ff254b005.png" alt="360杀毒" width="35">
                                <a href="http://bbs.360safe.com/forum-175-1.html">360杀毒</a>
                            </li>
                            <li class="">
                                <img src="http://p1.qhimg.com/t017e0618df79b04c69.png" alt="手机卫士" width="35">
                                <a href="http://bbs.360safe.com/forum-226-1.html">手机卫士</a>
                            </li>
                            <li class="even">
                                <img src="http://p1.qhimg.com/t0145412543c56740ba.png" alt="手机助手" width="35">
                                <a href="http://bbs.360safe.com/forum-108-1.html">手机助手</a>
                            </li>
                            <li class=""><img src="http://p7.qhimg.com/t0151727822e9ca6835.png" alt="安全卫士" width="35">
                                  <a href="http://bbs.360safe.com/forum-140-1.html">安全卫士</a>
                            </li>
                            <li class="even">
                                <img src="http://p7.qhimg.com/t012a3436d1611ca64a.png" alt="儿童卫士" width="35">
                                <a href="http://bbs.360safe.com/forum-1955-1.html">儿童卫士</a>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </div>
  </body>
</html>
