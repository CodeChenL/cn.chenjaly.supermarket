package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.*;
import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;
import org.ietf.jgss.Oid;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "SubmitOrderServlet", value = "/SubmitOrderServlet")
public class SubmitOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("user");
        if (user == null) {
            response.sendRedirect("login.jsp");
        } else {
            Cart cart = (Cart) session.getAttribute("cart");
            Order order = new Order();
            order.setOid(UUID.randomUUID().toString());
            order.setAddress(user.getAddress());
            order.setName(user.getName());
            order.setState(0);
            order.setTelephone(user.getTelephone());
            order.setUid(user.getUid());
            List<OrderItem> orderItems = new ArrayList<>();
            order.setOrderItems(orderItems);
            Set<Map.Entry<String, CartItem>> entries = cart.getCartItems().entrySet();

            for (Map.Entry<String, CartItem> entry : entries) {
                OrderItem orderItem = new OrderItem();
                orderItem.setItemid(UUID.randomUUID().toString());
                orderItem.setCount(entry.getValue().getBuyNum());
                orderItem.setOid(order.getOid());
                orderItem.setProduct(entry.getValue().getProduct());
                orderItems.add(orderItem);
            }
            OrderService service = new OrderServiceimpl();
            service.addOrders(order);
            session.removeAttribute("cart");
            session.setAttribute("order", order);
            request.getRequestDispatcher("order_info.jsp").forward(request, response);

        }
    }
}
