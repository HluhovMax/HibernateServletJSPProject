package mvc.controller.servlets.skill;

import mvc.model.Skill;
import mvc.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@WebServlet("/GetAllSkillsServlet")
public class GetAllSkillsServlet extends HttpServlet {

    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        skillService = new SkillService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Skill> skills = new ArrayList<>(skillService.getAll());
        skills.sort(Comparator.comparing(Skill::getId));
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<head><title>All Skills List</title></head>");
        for (Skill skill : skills
        ) {
            printWriter.println("<h3 align=\"center\">" + skill + "</h3>");
        }
        printWriter.println("<br/> <br/>");
        printWriter.println("<footer>");
        printWriter.println("<a href=\"skill.jsp\"><h3 align=\"center\">Back to Skill Page</h3></a>");
        printWriter.println("</footer>");
        printWriter.println("</body></html>");
    }
}
