<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Image Shop</title>
<!-- <script type="text/javascript" src="/js/test.js"></script> -->
<link rel="stylesheet" href="/css/codegroup.css">
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/header.jsp" />
	<jsp:include page="/WEB-INF/views/common/menu.jsp" />
	<div align="center">
		<h2>
  <spring:message code="codedetail.header.list" />
</h2>
<a href="register"><spring:message code="action.new" /></a>
<table border="1">
  <tr>
    <th align="center" width="160">
      <spring:message code="codedetail.groupCode" />
    </th>
    <th align="center" width="160">
      <spring:message code="codedetail.codeValue" />
    </th>
    <th align="center" width="160">
      <spring:message code="codedetail.codeName" />
    </th>
    <th align="center" width="160">
      <spring:message code="codedetail.sortSeq" />
    </th>
    <th align="center" width="180">
      <spring:message code="codedetail.regdate" />
    </th>
  </tr>
  <c:choose>
    <c:when test="${empty list}">
      <tr>
        <td colspan="5">
          <spring:message code="common.listEmpty" />
        </td>
      </tr>
    </c:when>
    <c:otherwise>
      <c:forEach items="${list}" var="codeDetail">
        <tr>
          <td align="center">${codeDetail.groupCode}</td>
          <td align="center">${codeDetail.codeValue}</td>
          <td align="left">
            <a href="/codedetail/read?groupCode=${codeDetail.groupCode}&codeValue=${codeDetail.codeValue}">
              ${codeDetail.codeName}
            </a>
          </td>
          <td align="center">${codeDetail.sortSeq}</td>
          <td align="center">
            <fmt:formatDate value="${codeDetail.regDate}" pattern="yyyy-MM-dd HH:mm" />
          </td>
        </tr>
      </c:forEach>
    </c:otherwise>
  </c:choose>
</table>
	
	<jsp:include page="/WEB-INF/views/common/footer.jsp" />
	
	<script>
		$(document).ready(function() {
			var formObj = $("#codeGroup");
			$("#btnRegister").on("click", function() {
				formObj.submit();
			});
			$("#btnList").on("click", function() {
				self.location = "list";
			});
		});
	</script>
</body>
</html>