package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet("/AssessOrderServlet")
public class AssessOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String oid=req.getParameter("oid");
        String assess=req.getParameter("assess");
        OrderService service=new OrderServiceimpl();
        service.assessOrder(oid,assess);
        service.updateOrdersState(oid);
        resp.sendRedirect("OrderListServlet?currentPage=1");
    }
}
