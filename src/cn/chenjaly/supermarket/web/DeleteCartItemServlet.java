package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Cart;
import cn.chenjaly.supermarket.bean.CartItem;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "DeleteCartItemServlet", value = "/DeleteCartItemServlet")
public class DeleteCartItemServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String pid=request.getParameter("pid");
        HttpSession session= request.getSession();
        Cart cart=(Cart) session.getAttribute("cart");
        Map<String, CartItem> cartItemMap=cart.getCartItems();
        cartItemMap.remove(pid);
        if (cartItemMap.size()==0){
            session.removeAttribute("cart");
        }
        response.sendRedirect("cart.jsp");
    }
}
