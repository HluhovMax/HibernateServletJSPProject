package mvc.controller.servlets.skill;

import mvc.model.Skill;
import mvc.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SaveSkillServlet")
public class SaveSkillServlet extends javax.servlet.http.HttpServlet {

    private Skill skill;
    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        skill = new Skill();
        skillService = new SkillService();
    }

    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        skill.setName(request.getParameter("skillName"));

        if (skill != null) {
            skillService.save(skill);

            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<head><title>Success</title></head>");
            printWriter.println("<h3 align=\"center\">Skill: "+request.getParameter("skillName")+
                    " successfully saved.</h3> ");
            printWriter.println("<br/> <br/>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"skill.jsp\"><h3 align=\"center\">Back to Skill Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
