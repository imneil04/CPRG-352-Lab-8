
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
 * @author neild
 */
public class AdminFilter implements Filter {
    
    
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {
        
        HttpServletRequest httpRequest = (HttpServletRequest) request; 
        HttpServletResponse httpResponse = (HttpServletResponse) response; 
        
        
        //if true call filter, if false redirect (check if user is admin or not) 
         HttpSession session = httpRequest.getSession();
        
        String email = (String) session.getAttribute("email");
     
      
        if(email == null || email.isEmpty()) {
            //Not login
            httpRequest.setAttribute("message", "You are not login. ");
           // httpResponse.sendRedirect("login");
            request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);           
            return; 
        } 
        if(!session.getId().equals(1)){
           // request.getServletContext().getRequestDispatcher("/WEB-INF/notes.jsp").forward(request, response); 
          httpRequest.setAttribute("message", "Test message only ");
           httpResponse.sendRedirect("notes");
        }
        else {
            //if email is not null or empty, means they are l  
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
