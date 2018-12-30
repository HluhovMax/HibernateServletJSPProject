package mvc.controller.servlets.account;

import mvc.model.Account;
import mvc.service.AccountService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DeleteAccountServlet")
public class DeleteAccountServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = new AccountService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Integer id = Integer.parseInt(request.getParameter("accountId"));
        if (id != null) {
            accountService.delete(id);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<h3 align=\"center\">Account with id: "+
                    request.getParameter("accountId")+
                    " was successfully deleted</h3>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"account.jsp\"><h3 align=\"center\">Back to Account Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
