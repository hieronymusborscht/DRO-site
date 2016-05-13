<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<!-- Website template by freewebsitetemplates.com -->

<jsp:scriptlet> 
 
rg.obj.MenuState menu = (rg.obj.MenuState)session.getAttribute("menuobject");
  
</jsp:scriptlet>

<html>
<head>

	<title>Blog - Astronomy Website Template</title>
	<link rel="stylesheet" href="css/style.css" type="text/css">
</head>
<body>
	<div id="header">
		<div class="wrapper clearfix">
			<div id="logo">
				<a href="index.html"><img src="images/royalty-ffffff.png" alt="LOGO"></a>
			</div>
			<%  out.println(menu.renderMenu());  %>
		</div>
	</div>
	<div id="contents">
		<div class="wrapper clearfix">
			<div id="sidebar">
				<ul>
					<li>
						<a href="blog.html"><img src="images/earth-small.jpg" alt="Img" height="154" width="213"></a>
					</li>
					<li>
						<a href="blog.html"><img src="images/spaceshuttle-closeup.jpg" alt="Img" height="154" width="213"></a>
					</li>
				</ul>
				<div class="click-here">
					<h1>Lorem Ipsum Dolor!</h1>
					<a href="index.html" class="btn1">Click Here!</a>
				</div>
			</div>
			<div class="main">
			<!--  H1 -->
				<%=menu.getPH1() %>
				
				
				
				<ul class="list">
			
			 <!--  general content items (Position 0) -->
			    <%=menu.generalAreaContent() %>
			
	
				<ul class="pagination">
					<li>
						<a href="blog.html">&lt;&lt;</a>
					</li>
					<li>
						<a href="blog.html">First</a>
					</li>
					<li class="selected">
						<a href="blog.html">1</a>
					</li>
					<li>
						<a href="blog.html">2</a>
					</li>
					<li>
						<a href="blog.html">3</a>
					</li>
					<li>
						<a href="blog.html">4</a>
					</li>
					<li>
						<a href="blog.html">5</a>
					</li>
					<li>
						<a href="blog.html">6</a>
					</li>
					<li>
						<a href="blog.html">7</a>
					</li>
					<li>
						<a href="blog.html">8</a>
					</li>
					<li>
						<a href="blog.html">9</a>
					</li>
					<li>
						<a href="blog.html">10</a>
					</li>
					<li>
						<a href="blog.html">11</a>
					</li>
					<li>
						<a href="blog.html">12</a>
					</li>
					<li>
						<a href="blog.html">13</a>
					</li>
					<li>
						<a href="blog.html">14</a>
					</li>
					<li>
						<a href="blog.html">15</a>
					</li>
					<li>
						<a href="blog.html">16</a>
					</li>
					<li>
						<a href="blog.html">17</a>
					</li>
					<li>
						<a href="blog.html">18</a>
					</li>
					<li>
						<a href="blog.html">19</a>
					</li>
					<li>
						<a href="blog.html">20</a>
					</li>
					<li>
						<a href="blog.html">Last</a>
					</li>
					<li>
						<a href="blog.html">&gt;&gt;</a>
					</li>
				</ul>
				<!-- /.pagination -->
			</div>
		</div>
	</div>
	<div id="footer">
		<ul id="featured" class="wrapper clearfix">
			<li>
			<!-- Position 1   -->
				
				<%=menu.getContentAtPosition(1) %>
				<%=menu.getContentAtPosition(5) %>
			</li>
			<li>
				<!-- Position 2 [default : img src="images/earth.jpg" alt="Img" height="204" width="220" ]  -->
				
				
				<%=menu.getContentAtPosition(2) %>
				
				<!--  Position 6  -->
				<%=menu.getContentAtPosition(6) %>
				
			</li>
			<li>
				<!-- 	Position 3  -->
				<%=menu.getContentAtPosition(3) %>
				
				<!--  Position 7 -->
				<%=menu.getContentAtPosition(7) %>
			</li>
			<li>
				<!--  Position 4 -->
				<%=menu.getContentAtPosition(4) %>
				
				<!--  Position 8 -->
				<%=menu.getContentAtPosition(8) %>
			</li>
		</ul>
		<div class="body">
			<div class="wrapper clearfix">
				<div id="links">
					<div>
						<h4>Social</h4>
						<ul>
							<li>
								<a href="http://freewebsitetemplates.com/go/googleplus/" target="_blank">Google +</a>
							</li>
							<li>
								<a href="http://freewebsitetemplates.com/go/facebook/" target="_blank">Facebook</a>
							</li>
							<li>
								<a href="http://freewebsitetemplates.com/go/youtube/" target="_blank">Youtube</a>
							</li>
						</ul>
					</div>
					<div>
						<h4>Heading placeholder</h4>
						<ul>
							<li>
								<a href="index.html">Link Title 1</a>
							</li>
							<li>
								<a href="index.html">Link Title 2</a>
							</li>
							<li>
								<a href="index.html">Link Title 3</a>
							</li>
						</ul>
					</div>
				</div>
				<div id="newsletter">
					<h4>Newsletter</h4>
					<p>
						Sign up for Our Newsletter
					</p>
					<form action="index.html" method="post">
						<input type="text" value="">
						<input type="submit" value="Sign Up!">
					</form>
				</div>
				<p class="footnote">
					© Copyright © 2016. Royalty Group Realty all rights reserved
				</p>
			</div>
		</div>
	</div>
</body>
</html>