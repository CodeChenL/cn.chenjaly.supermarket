package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.User;
import cn.chenjaly.supermarket.service.UserService;
import cn.chenjaly.supermarket.service.impl.UserServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        UserService service = new UserServiceimpl();
        User user = service.getUserByUsername(username);
        if (user != null && user.getPassword().equals(password)) {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            response.sendRedirect(request.getContextPath() + "/index.jsp");
        } else {

            request.setAttribute("error", "密码错误");
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }
}
