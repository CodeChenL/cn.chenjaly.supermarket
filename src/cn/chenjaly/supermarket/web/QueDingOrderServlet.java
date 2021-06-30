package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.service.OrderService;
import cn.chenjaly.supermarket.service.impl.OrderServiceimpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

@WebServlet("/QueDingOrderServlet")
public class QueDingOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String oid =req.getParameter("oid");
        Map<String,String[]>map=req.getParameterMap();
        Order order=new Order();
        try {
            BeanUtils.populate(order,map);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        OrderService service=new OrderServiceimpl();
        service.updateOrders(order);
        order=service.getOrderByOid(oid);
        req.setAttribute("order",order);

        req.getRequestDispatcher("account.jsp").forward(req,resp);

    }
}
