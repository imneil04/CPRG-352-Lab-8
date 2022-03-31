package filters;

import java.io.IOException;
//import java.io.PrintStream;
//import java.io.PrintWriter;
//import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class AuthenticationFilter implements Filter {
    
    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain)
            throws IOException, ServletException {

            // code that is executed before the servlet
            HttpServletRequest httpRequest = (HttpServletRequest)request;
            HttpServletResponse httpResponse = (HttpServletResponse)response;
            
            
            HttpSession session = httpRequest.getSession();
            String email = (String)session.getAttribute("email");
            
            if (email == null || email.isEmpty()) {
                httpRequest.setAttribute("message", "You are not login. Please login. ");
                //httpResponse.sendRedirect("login");
                request.getServletContext().getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);  
                return;
            }
            else {
                chain.doFilter(request, response); // execute the servlet
                return; 
            }
          
            
            // code that is executed after the servlet
            
        
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void destroy() {
       
    }
}
