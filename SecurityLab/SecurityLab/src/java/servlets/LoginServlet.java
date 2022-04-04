package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import models.User;
import services.AccountService;

public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        session.invalidate(); // just by going to the login page the user is logged out :-) 
        
        getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String email = request.getParameter("email");
        String password = request.getParameter("password");
      
        
        AccountService as = new AccountService();
        User user = as.login(email, password);
        
        if (user == null || email == null || email.isEmpty() ||password == null || password.isEmpty()) {
            request.setAttribute("message", "email address and/or password is missing. ");
            getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
            return;
        }
       
        //assign role id to user that's login 
        Integer roleId =  user.getRole().getRoleId();
        
        //get user session and set role id to user 
        HttpSession session = request.getSession();
        session.setAttribute("email", email);
        session.setAttribute("role_id", roleId);
      
        //check if user logged in is admin or not redirect as appropriate 
        if (user.getRole().getRoleId() == 1) {
            response.sendRedirect("admin");
        } else {
            response.sendRedirect("notes");
        }
    }
}
