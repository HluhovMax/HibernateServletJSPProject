package mvc.controller.servlets.developer;

import mvc.model.Account;
import mvc.model.Developer;
import mvc.model.Skill;
import mvc.service.AccountService;
import mvc.service.DeveloperService;
import mvc.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@WebServlet("/UpdateDeveloperServlet")
public class UpdateDeveloperServlet extends HttpServlet {

    private Developer developer;
    private DeveloperService developerService;

    @Override
    public void init() throws ServletException {
        developer = new Developer();
        developerService = new DeveloperService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        AccountService accountService = new AccountService();
        SkillService skillService = new SkillService();
        developer.setId(Integer.parseInt(request.getParameter("developerId")));
        developer.setFirstName(request.getParameter("firstName"));
        developer.setLastName(request.getParameter("lastName"));
        developer.setSpecialty(request.getParameter("specialty"));
        List<String> list = Arrays.asList(request.getParameterValues("skillId"));
        Set<Skill> skills = new HashSet<>();
        for (String s : list
        ) {
            Skill skill = skillService.getById(Integer.parseInt(s));
            skills.add(skill);
        }
        developer.setSkills(skills);
        Account account = accountService.getById(Integer.parseInt(request.getParameter("accountId")));
        developer.setAccount(account);
        if (developer != null) {
            developerService.update(developer);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<head><title>Success</title></head>");
            printWriter.println("<h3 align=\"center\">Developer successfully updated.</h3> ");
            printWriter.println("<br/> <br/>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"developer.jsp\"><h3 align=\"center\">Back to Developer Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
