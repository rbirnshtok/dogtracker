<%--
  Created by IntelliJ IDEA.
  User: rbirnshtok
  Date: 11/12/2021
  Time: 5:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Registration</title>
    <style>
        .error{
            color: #ff0000;
        }
        .errorblock{
            color: #000;
            backgroun-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }
    </style>
</head>
<body>
<h1>New Dog Owner Registration</h1>
<form:form modelAttribute="registration">
    <form:errors path="*" cssClass="errorblock" element="div" />
    <table>
        <tr>
            <td>
                <spring:message code="name"/>:
            </td>
            <td>
                <form:input path="name" />
            </td>
            <td>
                <form:errors path="name" cddClass="error"/>
            </td>
        </tr>
        <tr>
            <td>
                <spring:message code="wantsToBeTracked"/>:
            </td>
            <td colspan="3">
                <form:checkbox path="tracked" />
            </td>
            <td>
                <form:errors path="tracked" cddClass="error"/>
            </td>
        </tr>
        <tr>

            <td colspan="3">
                <button>Add Dog</button>
            </td>

        </tr>
        <tr>
            <td colspan="3">
                <input type="submit" value="Add Registration">
            </td>
        </tr>
    </table>
</form:form>

</body>
</html>
