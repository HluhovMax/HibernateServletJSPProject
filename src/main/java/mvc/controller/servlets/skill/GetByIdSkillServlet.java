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

@WebServlet("/GetByIdSkillServlet")
public class GetByIdSkillServlet extends HttpServlet {

    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        skillService = new SkillService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Skill skill = skillService.getById(Integer.parseInt(request.getParameter("skillId")));

        if (skill != null) {
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<h3 align=\"center\">" + skill.toString() + "</h3>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"skill.jsp\"><h3 align=\"center\">Back to Skill Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
