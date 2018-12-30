package mvc.controller.servlets.developer;

import mvc.model.Developer;
import mvc.service.DeveloperService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@WebServlet("/GetAllDevelopersServlet")
public class GetAllDevelopersServlet extends HttpServlet {

    private DeveloperService developerService;

    @Override
    public void init() throws ServletException {
        developerService = new DeveloperService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Developer> developers = developerService.getAll();
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<head><title>All Developers List</title></head>");
        for (Developer developer : developers
        ) {
            printWriter.println("<h3 align=\"center\">" + developer + "</h3>");
        }
        printWriter.println("<br/> <br/>");
        printWriter.println("<footer>");
        printWriter.println("<a href=\"developer.jsp\"><h3 align=\"center\">Back to Developer Page</h3></a>");
        printWriter.println("</footer>");
        printWriter.println("</body></html>");
    }
}
