package mvc.controller.servlets.account;

import mvc.model.Account;
import mvc.model.Skill;
import mvc.service.AccountService;

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

@WebServlet("/GetAllAccountsServlet")
public class GetAllAccountsServlet extends HttpServlet {

    private AccountService accountService;

    @Override
    public void init() throws ServletException {
        accountService = new AccountService();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Account> accounts = new ArrayList<>(accountService.getAll());
        accounts.sort(Comparator.comparing(Account::getId));
        response.setContentType("text/html");
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<html><body>");
        printWriter.println("<head><title>All Accounts List</title></head>");
        for (Account account : accounts
        ) {
            printWriter.println("<h3 align=\"center\">" + account + "</h3>");
        }
        printWriter.println("<br/> <br/>");
        printWriter.println("<footer>");
        printWriter.println("<a href=\"account.jsp\"><h3 align=\"center\">Back to Account Page</h3></a>");
        printWriter.println("</footer>");
        printWriter.println("</body></html>");
    }
}
