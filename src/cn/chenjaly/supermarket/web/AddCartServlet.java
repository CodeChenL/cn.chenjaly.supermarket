package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Cart;
import cn.chenjaly.supermarket.bean.CartItem;
import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.Map;

@WebServlet(name = "AddCartServlet", value = "/AddCartServlet")
public class AddCartServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String pid = req.getParameter("pid");
        String i = req.getParameter("buyNum");

        int buyNum = Integer.parseInt(i);

        ProductService service = new ProductServiceimpl();

        Product product = service.getProductByPid(pid);

        CartItem cartItem = new CartItem();

        cartItem.setBuyNum(buyNum);
        cartItem.setProduct(product);
        //创建购物车
        HttpSession session = req.getSession();
        Cart cart = (Cart) session.getAttribute("cart");
        if (cart == null){
            //空的购物车
            cart = new Cart();
        }
        Map<String,CartItem> cartItems = cart.getCartItems();
        cartItems.put(pid,cartItem);
        //把购物车保存在session中
        session.setAttribute("cart",cart);
        //重定向
        resp.sendRedirect(req.getContextPath()+"/cart.jsp");
    }
}
