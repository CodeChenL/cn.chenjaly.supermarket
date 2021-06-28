package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "ProductInfoServlet", value = "/ProductInfoServlet")
public class ProductInfoServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取id
        String pid = req.getParameter("pid");
        //调用
        ProductService service = new ProductServiceimpl();
        Product productByPid = service.getProductByPid(pid);

        //将查询出来的数据转发给前端
        req.setAttribute("product",productByPid);


        //跳转
        req.getRequestDispatcher("product_info.jsp").forward(req,resp);
    }
}
