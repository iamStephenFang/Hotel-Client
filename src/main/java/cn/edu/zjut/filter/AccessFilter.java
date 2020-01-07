package cn.edu.zjut.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class AccessFilter implements Filter {
    /**
     * @author 方宣淼
     * @param servletRequest 获取request作用域的值
     * @param servletResponse 获取response作用域的值
     * @param filterChain 转到下一个过滤器链
     * @throws IOException IO异常
     * @throws ServletException Servlet异常
     * 登录验证过滤器
     */
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("执行注册用户Filter...");
        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;
        HttpSession session = request.getSession();
        if (session.getAttribute("register") == null) {
            response.sendRedirect("sign_in.jsp");
            return;
        }
        filterChain.doFilter(servletRequest, servletResponse);
    }
}
