package filters;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


/**
 * Created by 1 on 03.08.2015.
 */
public class SecuretyFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
//        HttpServletRequest req = (HttpServletRequest) request;
//        HttpServletResponse resp = (HttpServletResponse) response;
//        String uri = req.getRequestURI();
//        String context = req.getContextPath();
//
//        if (context == null || context.equals("")){
//            context = "qwerty";
//        }
//
//        if (uri.endsWith("/admin")||uri.endsWith(context)){
//            chain.doFilter(req, resp);
//            return;
//        }
//        Integer role = (Integer)req.getSession().getAttribute ("role");
//        if (role == null) {
//            resp.sendRedirect (context+"/login");
//            return;
//        }
//            chain.doFilter(req, resp);
    }

    @Override
    public void destroy() {

    }
}
