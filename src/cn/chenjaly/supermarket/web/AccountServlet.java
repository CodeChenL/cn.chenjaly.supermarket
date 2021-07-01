package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.bean.User;
import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/AccountServlet")
public class AccountServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String oid = req.getParameter("oid");
        String password = req.getParameter("password");
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        OrderService service = new OrderServiceimpl();
        if (password.equals(user.getPassword())) {
            service.updateOrdersState(oid);
            resp.sendRedirect("OrderListServlet?currentPage=1");
        } else {
            req.setAttribute("error", "密码错误");
            Order order = service.getOrderByOid(oid);
            req.setAttribute("order", order);
            req.getRequestDispatcher("account.jsp").forward(req, resp);
        }
    }
}
