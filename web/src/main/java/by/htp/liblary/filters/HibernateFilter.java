package by.htp.liblary.filters;


import by.htp.liblary.dao.HibernateSessionManager;
import org.hibernate.Session;

import javax.servlet.FilterChain;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;

/**
 * Created by meco on 13.06.2016.
 */
public class HibernateFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) servletRequest;
        HttpServletResponse httpResponse = (HttpServletResponse) servletResponse;
        Session session = HibernateSessionManager.getSessionFactory().openSession();
        System.out.println(HibernateSessionManager.currentSession().isOpen());
        filterChain.doFilter(httpRequest, httpResponse);
        session.close();

    }

    @Override
    public void destroy() {


    }
}
