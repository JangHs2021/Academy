<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>아이디 찾기</title>
<c:import url="../../template/common_css.jsp"></c:import>
</head>
<body>
<c:import url="../../template/header.jsp"></c:import>
<div class="container-fluid">
    <div class="row justify-content-center">
        <h1 class="col-md-7 my-5">아이디 찾기</h1>
    </div>
    
    <!-- 성공 메시지 출력 -->
    <c:if test="${not empty successMessage}">
        <div class="alert alert-success" role="alert">
            ${successMessage}
        </div>
    </c:if>

    <!-- 에러 메시지 출력 -->
    <c:if test="${not empty errorMessage}">
        <div class="alert alert-danger" role="alert">
            ${errorMessage}
        </div>
    </c:if>
    
    <div class="row justify-content-center my-5">
        <form class="col-md-7" action="./findId" method="post">
            <div class="mb-3">
                <label for="name" class="form-label">이름</label>
                <input type="text" class="form-control" id="name" name="name">
            </div>
            <div class="mb-3">
                <label for="email" class="form-label">이메일</label>
                <div class="input-group">
                    <input type="text" class="form-control" name="email" id="email" placeholder="이메일 입력">
                    <select class="form-control" name="emaildomain" id="emaildomain">
                        <option value="@naver.com">@naver.com</option>
                        <option value="@daum.net">@daum.net</option>
                        <option value="@gmail.com">@gmail.com</option>
                        <option value="@hanmail.com">@hanmail.com</option>
                        <option value="@yahoo.co.kr">@yahoo.co.kr</option>
                    </select>
                </div>
            </div>
            <button type="submit" class="btn btn-primary">아이디 찾기</button>
        </form>
    </div>
</div>
<c:import url="../../template/common_js.jsp"></c:import>
</body>
</html>