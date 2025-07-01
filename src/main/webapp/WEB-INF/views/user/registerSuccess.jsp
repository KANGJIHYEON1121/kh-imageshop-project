<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> 
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8" />
    <title>Image Shop</title>
    <!-- <script type="text/javascript" src="/js/test.js"></script> -->
    <link rel="stylesheet" href="/css/codegroup.css" />
  </head>
  <body>
    <jsp:include page="/WEB-INF/views/common/header.jsp" />
    <jsp:include page="/WEB-INF/views/common/menu.jsp" />
    <div align="center">
        <h2><spring:message code="common.joinMemberSuccess" arguments="${userName}" /></h2>
        <a href="/auth/login"><spring:message code="action.login" /></a>
    </div>
      <jsp:include page="/WEB-INF/views/common/footer.jsp" />

    
  </body>
</html>
