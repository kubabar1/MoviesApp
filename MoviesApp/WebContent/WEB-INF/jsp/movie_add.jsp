<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="pl">
<head>
<meta charset="UTF-8">

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Movie app</title>

<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/main.css" />

<c:set var="contextPath" value="${pageContext.request.contextPath}" />

</head>
<body>
	<header>
	<div id="toplabel">MOVIE LIST</div>
	</header>

	<nav>
	<div id="leftnav">
		<div id="navigation">
			<ul>
				<li><a href="${contextPath}/movies"> <img
						src="${pageContext.request.contextPath}/img/list_icon.png" />
						<p>SHOW LIST</p>
				</a></li>
				<li><a href="${contextPath}/add_movie"> <img
						src="${pageContext.request.contextPath}/img/upload_icon.png" />
						<p>ADD MOVIE</p>
				</a></li>
			</ul>
		</div>
	</div>
	</div>
	</nav>

	<main>
		<div id="maincontainer">
			<form id="addform" method="POST" action = "${contextPath}/add_movie" enctype="multipart/form-data">
				<div id="container">
					<div class="tilecontainer">
						<label class="labelstyle" for="name">Name: </label>
						<input type="text" class="inputstyle" name="name" value=""/>
					</div>					
					
					<div class="tilecontainer">
						<label class="labelstyle" for="author">Author: </label>
						<input type="text" class="inputstyle" name="author" value=""/>
					</div>
					
					<div class="tilecontainer">
						<label class="labelstyle" for="genre">Genre: </label>
						<select class="inputstyle"  name="genre" id="genre" value="">
							<option value=""></option>
							<option value="Action">Action</option>
							<option value="Animation">Animation</option>
							<option value="Adventure">Adventure</option>
							<option value="Cartoon">Cartoon</option>
							<option value="Comedy">Comedy</option>
							<option value="Crime">Crime</option>
							<option value="Drama">Drama</option>
							<option value="Fantasy">Fantasy</option>
							<option value="Historical">Historical</option>
							<option value="Historical fiction">Historical fiction</option>
							<option value="Horror">Horror</option>
							<option value="Mystery">Mystery</option>
							<option value="Nature">Nature</option>
							<option value="Philosophical">Philosophical</option>
							<option value="Political">Political</option>
							<option value="Romance">Romance</option>
							<option value="Saga">Saga</option>
							<option value="Satire">Satire</option>
							<option value="Science fiction">Science fiction</option>
							<option value="Social">Social</option>
							<option value="Thriller">Thriller</option>
							<option value="Western">Western</option>
						</select>
					</div>
					
					<div class="tilecontainer">
						<label class="labelstyle" for="year">Production year: </label>
						<input type="text" class="inputstyle" name="year" value=""/>
					</div>
					
					<div class="tilecontainer">
						<label class="labelstyle" for="videofile">File: </label>
						<input type="file" class="inputstyle" name="videofile" accept="video/*" id="videofile"/>
					</div>
					
					<div class="buttoncontainer">
						<input type="submit" value="Add" id="addbutton"/>
					</div>
				</div>
			</form>
		</div>
	</main>


</body>
</html>