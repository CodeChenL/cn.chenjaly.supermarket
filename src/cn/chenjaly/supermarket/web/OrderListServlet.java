package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.bean.Product;
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
import java.util.ArrayList;
import java.util.List;

@WebServlet("/OrderListServlet")
public class OrderListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String s=req.getParameter("currentPage");
        int currentPage =Integer.parseInt(s);
        HttpSession session=req.getSession();
        User user = (User) session.getAttribute("user");
        OrderService service=new OrderServiceimpl();
        if (user==null){
            resp.sendRedirect("login.jsp");
        }else {
            List<Order> list=service.getOrdersByUid(user.getUid());
            ArrayList<Order> orderList = new ArrayList<>();
            int n = 5;
            for (int i = (currentPage - 1) * n; i < currentPage * n && i < list.size(); i++) {
                orderList.add(list.get(i));
            }
            int totalPage = (list.size() - 1) / n + 1;
            req.setAttribute("orderList", orderList);
            req.setAttribute("currentPage", currentPage);
            req.setAttribute("totalPage", totalPage);
            req.getRequestDispatcher("/order_list.jsp").forward(req, resp);
        }

    }
}
