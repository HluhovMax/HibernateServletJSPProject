package mvc.controller.servlets.skill;

import mvc.service.SkillService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteSkillServlet")
public class DeleteSkillServlet extends HttpServlet {

    private SkillService skillService;

    @Override
    public void init() throws ServletException {
        skillService = new SkillService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("skillId"));
        if (id != 0) {
            skillService.delete(id);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<h3 align=\"center\">Skill with id: "+
                    request.getParameter("skillId")+
                    " was successfully deleted</h3>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"skill.jsp\"><h3 align=\"center\">Back to Skill Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
