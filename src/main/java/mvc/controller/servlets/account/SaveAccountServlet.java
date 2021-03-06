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

@WebServlet("/SaveAccountServlet")
public class SaveAccountServlet extends HttpServlet {

    private Account account;
    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        account = new Account();
        accountService = new AccountService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        account.setAccountData(request.getParameter("accountData"));
        if (account != null) {
            accountService.save(account);
            response.setContentType("text/html");
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<html><body>");
            printWriter.println("<head><title>Success</title></head>");
            printWriter.println("<h3 align=\"center\">Account: "+request.getParameter("accountData")+
                    " successfully saved.</h3> ");
            printWriter.println("<br/> <br/>");
            printWriter.println("<footer>");
            printWriter.println("<a href=\"account.jsp\"><h3 align=\"center\">Back to Account Page</h3></a>");
            printWriter.println("</footer>");
            printWriter.println("</body></html>");
        }
    }
}
