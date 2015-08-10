package filters;

import javax.servlet.*;
import java.io.IOException;
import java.util.logging.LogRecord;
import javax.servlet.Filter;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by 1 on 27.07.2015.
 */
public class SystemAccessFilter implements javax.servlet.Filter {

    private FilterConfig filterConfig;

    public void setFilterConfig(FilterConfig fc) {

        filterConfig = fc;

    }

    public FilterConfig getFilterConfig() {

        return filterConfig;

    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)

            throws IOException, ServletException {

        if (filterConfig == null) {

            return;

        }

        ServletContext ctx = filterConfig.getServletContext();

        String logged = (String) ((HttpServletRequest) request).getSession().getAttribute("isLogged");

        if (!"true".equals(logged)) {

            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/login.jsp");

            dispatcher.forward(request, response);

        } else {

            RequestDispatcher dispatcher = ctx.getRequestDispatcher("/successLogin.jsp");

            dispatcher.forward(request, response);

        }

    }

    public void init(FilterConfig config) throws ServletException {

        this.filterConfig = config;

    }

    public void destroy() {
    }

}
