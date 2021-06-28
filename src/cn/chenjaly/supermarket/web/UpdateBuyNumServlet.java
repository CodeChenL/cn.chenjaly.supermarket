package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Cart;
import cn.chenjaly.supermarket.bean.CartItem;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

@WebServlet("/UpdateBuyNumServlet")
public class UpdateBuyNumServlet extends HttpServlet {
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String pid = request.getParameter("pid");
        String buyNum = request.getParameter("buyNum");
        int i = Integer.parseInt(buyNum);
        HttpSession session = request.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        Map<String, CartItem> cartItemMap = cart.getCartItems();
        cartItemMap.get(pid).setBuyNum(i);
        response.sendRedirect("cart.jsp");
    }
}
