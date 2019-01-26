<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Job Application | Dashboard</title>
<link rel="stylesheet" type="text/css" media="screen" href="css/style.css" />
</head>

<body>

	<div class="header">
		<h1>Dojo Job Application</h1>
		<h2>Welcome to your dashboard, <c:out value="${ firstName }"/></h2>
	</div>
	
	<div class="nav_contain">
		<div class="nav">
			<a href="/profile">Profile</a>
			<a href="/dashboard">Dashboard</a>
			<a href="/createJob">Create Job Posting</a>
			<a href="/logout">Logout</a>
		</div>
	</div>
	
	<div class="box_contain">
		<div class="box">
			<h2>Job Postings</h2>
			<div class="table_contain">
			<table>
			
				<c:forEach items="${ jobs }" var="truck">
				<tr>
					
					<div class="t1">
						<h3><c:out value="${ job.jobName }"/></h3>
						<p><c:out value="${ job.jobCompany }"/></p>
						<p><c:out value="${ job.jobPosition }"/></p>
						<p><c:out value="${ job.createdAt }"/></p>
					</div>
				
					<div class="t2">
						<c:if test="${ jobs.user.id != id}">
							<p class="edit"><a href="/applyJob/${ job.id }">apply</a></p>
							<p class="edit"><a href="/showJob/${ job.id }">show</a></p>
							<p class="edit"><a href="/ignoreJob/${ job.id }">ignore</a></p>
						</c:if>
							
						<c:if test="${ jobs.user.id == id}">
							<p class="edit"><a href="/editJob/${ job.id }">edit</a></p>
							<p class="edit"><a href="/showJob/${ job.id }">show</a></p>
							<p class="edit"><a href="/ignoreJob/${ job.id }">ignore</a></p>
						</c:if>
					</div>	
				
				</tr>
				</c:forEach>	
				
			</table>
			</div>
		</div>
	</div>
	
</body>
</html>