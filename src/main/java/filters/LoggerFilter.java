package filters;

import org.apache.log4j.Logger;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;

/**
 * Created by 1 on 22.07.2015.
 */
public class LoggerFilter implements Filter {
    Logger logger = Logger.getLogger(LoggerFilter.class);
    private FilterConfig filterConfig;

    public void setFilterConfig(FilterConfig fc) {
        filterConfig = fc;
    }

    public FilterConfig getFilterConfig() {
        return filterConfig;
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        request = ((HttpServletRequest) request);
        logger.warn("-----------------------------------------");
//        HttpSession httpSession = ((HttpServletRequest) request).getSession();
//        int role = (Integer) httpSession.getAttribute("role");
//        if (role == 1) {
//            chain.doFilter(request, response);
//        }
//        if (role == 2) {
//            String url = ((HttpServletRequest) request).getRequestURI();
//        }
//        if (role == 3) {
//            String url = ((HttpServletRequest) request).getRequestURI();
//        } else {
//            request.getRequestDispatcher("/WEB-INF/JSP/login.jsp").forward(request, response);
//        }
        chain.doFilter(request, response);
        logger.warn("++++++++++++++++++++++++++++++++++++++++++");

    }

    public void init(FilterConfig config) throws ServletException {
        this.filterConfig = config;
    }

    public void destroy() {
    }
}
