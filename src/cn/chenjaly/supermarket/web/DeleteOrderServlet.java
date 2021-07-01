package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/DeleteOrderServlet")
public class DeleteOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String oid = req.getParameter("oid");
        OrderService service = new OrderServiceimpl();
        service.deleteOrdersByOid(oid);

        resp.sendRedirect("OrderListServlet?currentPage=1");
    }
}
