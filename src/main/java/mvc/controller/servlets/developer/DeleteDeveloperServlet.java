package mvc.controller.servlets.developer;

import mvc.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteDeveloperServlet")
public class DeleteDeveloperServlet extends HttpServlet {

    private DeveloperService developerService;

    @Override
    public void init() throws ServletException {
        developerService = new DeveloperService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("developerId"));
        if (id != 0) {
            developerService.delete(id);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<h3 align=\"center\">Developer with id: "+
                    request.getParameter("developerId")+
                    " was successfully deleted</h3>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"developer.jsp\"><h3 align=\"center\">Back to Developer Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
