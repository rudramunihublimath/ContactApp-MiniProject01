<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
    <h3>Save Contact Here<h3>
    <p><font color='green'>${succMsg}</font></p>
    <p><font color='red'>${errMsg}</font></p>
    <font color="blue">${msg}</font>

    <form:form action="saveContact?contactId=${contact.contactId}" method="POST" modelAttribute="contact">
        <table>
            <tr>
                <td>CONTACT NAME</td>
                <td><form:input path="contactNAME"/></td>
                <td><form:errors path="contactNAME"/></td>
            </tr>
            <tr>
                <td>CONTACT EMAIL</td>
                <td><form:input path="contactEMAIL"/></td>
                <td><form:errors path="contactEMAIL"/></td>
            </tr>
            <tr>
                 <td>CONTACT NUMBER</td>
                 <td><form:input path="contactNUMBER"/></td>
                 <td><form:errors path="contactNUMBER"/></td>
            </tr>
            <tr>
                <td></td>
                <td><input type="SUBMIT" value="Save" /></td>
            </tr>
        </table>
    </form:form>

    <a href="viewContacts">View All Contacts</a>

</body>
</html>