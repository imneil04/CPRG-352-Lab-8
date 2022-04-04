
package filters;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.*;
//import models.Role;
//import models.User;
//import services.AccountService;



/**
 *
 * @author Mark Del Rosario 
 */
public class AdminFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request; 
        HttpServletResponse httpResponse = (HttpServletResponse) response; 
        
        
        //if true call filter, if false redirect (check if user is admin or not) 
         HttpSession session = httpRequest.getSession();
        
        String email = (String) session.getAttribute("email");
        Integer roleId = (Integer) session.getAttribute("role_id"); 

       
        //check if user is login 
        if(email == null || email.isEmpty()) {
           
           httpRequest.setAttribute("message", "You are not login. ");
          // httpResponse.sendRedirect("login");
           request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);           
           return; 
        } 
        
        if(roleId == null || roleId != 1) {     
          // request.getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response); 
           httpResponse.sendRedirect("notes");
           return; 
        } 
        
        else {
         //if admin user, give them access   
          chain.doFilter(request, response);  
          return;
        }
               
    }

 
    /**
     * Destroy method for this filter
     */
    public void destroy() {        
    }

    /**
     * Init method for this filter
     */
    public void init(FilterConfig filterConfig) {        
        
    }

  
   
    
}
