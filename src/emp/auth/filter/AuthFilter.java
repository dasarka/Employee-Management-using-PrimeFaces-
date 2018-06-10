package emp.auth.filter;

import java.io.IOException;
import java.nio.file.DirectoryStream.Filter;

import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebFilter(filterName="authFilter",urlPatterns={"*.xhtml"})
public class AuthFilter implements javax.servlet.Filter {
	
	public AuthFilter() {
		super();
	}
	@Override
	public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
	    try{
		HttpServletRequest request = (HttpServletRequest) req;
	    HttpServletResponse response = (HttpServletResponse) res;
	    HttpSession session = request.getSession(false);
	    
	    String reqURI=request.getRequestURI();
	    
	    if (reqURI.indexOf("/index.xhtml")>=0 || (session!=null && session.getAttribute("usersBean")!=null) || reqURI.contains("java.faces.resource")) {
	    	 chain.doFilter(req, res);  
	    } else {
	    	response.sendRedirect(request.getContextPath()+"/index.xhtml");
	    }
	    }catch(Exception e){
	    	e.printStackTrace();
	    }
	}
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void init(FilterConfig arg0) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	
}
