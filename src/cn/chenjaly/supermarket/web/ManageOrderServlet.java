package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/ManageOrderServlet")
public class ManageOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String oid=req.getParameter("oid");
        String s =req.getParameter("state");
        int state=Integer.parseInt(s);
        OrderService service = new OrderServiceimpl();
        Order order=service.getOrderByOid(oid);
        req.setAttribute("order",order);
        if (state==0){
            req.getRequestDispatcher("account.jsp").forward(req,resp);
        }else if (state==1){
            resp.sendRedirect("OrderListServlet?currentPage=1");
        }else if (state==2){
            service.updateOrdersState(oid);
            resp.sendRedirect("OrderListServlet?currentPage=1");
        }else if (state==3){
            service.updateOrdersState(oid);
            req.getRequestDispatcher("assess.jsp").forward(req,resp);
        }else {
            req.getRequestDispatcher("order.jsp").forward(req,resp);
        }
    }
}
