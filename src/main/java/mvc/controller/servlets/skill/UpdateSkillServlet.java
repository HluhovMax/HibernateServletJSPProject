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

@WebServlet("/UpdateSkillServlet")
public class UpdateSkillServlet extends HttpServlet {

    private Skill skill;
    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        skill = new Skill();
        skillService = new SkillService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        skill.setId(Integer.parseInt(request.getParameter("skillId")));
        skill.setName(request.getParameter("skillName"));
        if (skill != null) {
            skillService.update(skill);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<head><title>Success</title></head>");
            printWriter.println("<h3 align=\"center\">"
                    + skillService.getById(Integer.parseInt(request.getParameter("skillId")))
                    + "</h3>");
            printWriter.println("<br/> <br/>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"skill.jsp\"><h3 align=\"center\">Back to Skill Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
