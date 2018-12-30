<%@ page import="java.util.List" %>
<%@ page import="mvc.service.SkillService" %>
<%@ page import="mvc.model.Skill" %>
<%@ page import="java.util.Comparator" %>

<html>
<head><title>Update Developer</title></head>
<body>
<form action="UpdateDeveloperServlet" method="get">
    <h3 align="center">Enter id: <input type="text" name="developerId"/></h3>
    <h3 align="center">Enter first name: <input type="text" name="firstName"/></h3>
    <h3 align="center">Enter last name: <input type="text" name="lastName"/></h3>
    <h3 align="center">Enter specialty: <input type="text" name="specialty"/></h3>
    <h3 align="center">
        <%
            SkillService skillService = new SkillService();
            List<Skill> skills = skillService.getAll();
            skills.sort(Comparator.comparing(Skill::getId));
            for (Skill skill : skills
            ) { %>

        <input type="checkbox" name="skillId" value="<%= skill.getId() %>"><%= skill.getId() %>, <%= skill.getName()%>
        <%
            }
        %>
    </h3>
    <h3 align="center">Enter account id: <input type="text" name="accountId"/></h3>
    <h3 align="center"><input type="submit" value="Update"/></h3>
    <br/> <br/>
</form>
</body>
<footer>
    <a href="skill.jsp"><h3 align="center">Back to Skill Page</h3></a>
    <br/><br/>
    <a href="index.jsp"><h3 align="center">Back to Main Menu</h3></a>
</footer>
</html>