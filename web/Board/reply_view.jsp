<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title> Reply </title>
</head>
<body>
    <table width="500" cellpadding="0" cellspacing="0" border="3">
        <form action="reply.bo" method="post">
            <input type="hidden" name="bId" value="${reply_view.bId}">
            <input type="hidden" name="bGroup" value="${reply_view.bGroup}">
            <input type="hidden" name="bStep" value="${reply_view.bStep}">
            <input type="hidden" name="bIndent" value="${reply_view.bIndent}">
            <input type="hidden" name="userId" value="${reply_view.userId}">
            <tr>
                <td align="center" width="100"> 번호 </td>
                <td> ${reply_view.bId}</td>
            </tr>
            <tr>
                <td align="center" width="100"> 조회 </td>
                <td> ${reply_view.bHit}</td>
            </tr>
            <tr>
                <td align="center" width="100"> 이름 </td>
                <td>
                    <input type="text" name="bName" value="${reply_view.bName}">
                </td>
            </tr>
            <tr>
                <td align="center"> 제목 </td>
                <td>
                    <input type="text" name="bTitle" value="${reply_view.bTitle}">
                </td>
            </tr>
            <tr>
                <td align="center"> 내용 </td>
                <td>
                    <textarea rows="10" name="bContent"> ${reply_view.bContent} </textarea>
                </td>
            </tr>
            <tr>
                <td colspan="2" align="center">
                    <input type="submit" value="답글달기"> &nbsp;&nbsp;
                    <a href="list.bo"> 목록보기 </a>
                </td>
            </tr>
        </form>
    </table>
</body>
</html>
