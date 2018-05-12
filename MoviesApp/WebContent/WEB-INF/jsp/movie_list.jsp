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
		<div id="movielistcontainer">
				
				<c:forEach items="${moviesList}" var="element">
					<a href="${contextPath}/movies/${element.id}">
						<div class="moviepanel">
							<video id="movie_img" > <source src="uploads/${element.filename}" type="video/mp4"></video>
							<p>${element.name}</p>
						</div>
					</a>
				</c:forEach>

		</div>
	</div>
	</main>


</body>
</html>