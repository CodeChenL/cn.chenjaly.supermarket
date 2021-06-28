package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Cart;
import cn.chenjaly.supermarket.bean.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "CleanCartServlet", value = "/CleanCartServlet")
public class CleanCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getSession().removeAttribute("cart");
        response.sendRedirect("cart.jsp");
    }
}
