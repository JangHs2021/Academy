<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>관리자 페이지</title>
<c:import url="../template/common_css.jsp"></c:import>
<link rel="stylesheet" href="/resources/css/adminPageSideBar.css">
</head>
<body>
	<c:import url="../template/header.jsp"></c:import>
	
	<div class="sideBar">
		<c:import url="../template/adminSideBar.jsp"></c:import>

		<div class="container admin_container">
			<div class="row lists">
				<!-- 리스트 들어갈 영역 -->
			</div>
		</div>
	</div>
	<!-- paging -->
		<div class="row col-md-7 mx-auto">
			<nav aria-label="Page navigation example">
				<ul class="pagination">
					<li class="page-item"><a class="page-link" href="#"
						aria-label="Previous" data-board-page="1"> <span
							aria-hidden="true">&laquo;</span>
					</a></li>


					<li class="page-item ${pager.before?'disabled':''}"><a
						class="page-link" href="#" aria-label="Previous"
						data-board-page="${pager.startNum-1}"> <span
							aria-hidden="true">&lsaquo;</span>
					</a></li>

					<c:forEach begin="${pager.startNum}" end="${pager.lastNum}" var="i">
						<li class="page-item"><a class="page-link" href="#"
							data-board-page="${i}">${i}</a></li>
					</c:forEach>

					<li class="page-item ${pager.after eq false ? 'disabled':''}">
						<%-- ${pager.after eq false ? 'disabled':''} --%> <a
						class="page-link" href="#" aria-label="Next"
						data-board-page="${pager.lastNum+1}"> <span aria-hidden="true">&rsaquo;</span>
					</a>
					</li>

					<li class="page-item">
						<%-- ${pager.after eq false ? 'disabled':''} --%> <a
						class="page-link" href="#" aria-label="Next"
						data-board-page="${pager.totalPage}"> <span aria-hidden="true">&raquo;</span>
					</a>
					</li>

				</ul>
			</nav>
		</div>


		<!-- 검색창 -->
		<div class="row col-md-7 mx-auto">
			<form class="row g-3" action="./list" method="get" id="searchForm">
				<input type="hidden" name="page" value="1" id="page">
				<div class="col-auto">
					<label for="kind" class="visually-hidden">Kind</label> <select
						class="form-select" name="kind" id="kind"
						aria-label="Default select example">
						<option value="title" ${pager.kind eq 'title'? 'selected':''}>Title</option>
						<%-- <option value="contents" ${pager.kind eq 'info'? 'selected':''}>info</option> --%>
						<%-- <option value="writer" ${pager.kind eq 'writer'? 'selected':''}>Writer</option> --%>
					</select>
				</div>
				<div class="col-auto">
					<label for="search" class="visually-hidden">Search</label> 
					<input type="text" class="form-control" value="${pager.search}"
						name="search" id="search" placeholder="검색어를 입력하세요">
				</div>
				<div class="col-auto">
					<button type="submit" class="btn btn-primary mb-3">검색</button>
				</div>
			</form>

			<c:if test="${not empty member}">

				<c:if test="${member.roleDTO.roleName eq 'ADMIN'}">
					<div class="row col-md-7 mx-auto">
						<a href="./productAdd" class="btn btn-primary col-5">상품등록</a>
					</div>
				</c:if>
			</c:if>

		</div>

	</div>
	<c:import url="../template/common_js.jsp"></c:import>
	<script src="/resources/js/adminPage.js"></script>
</body>
</html>