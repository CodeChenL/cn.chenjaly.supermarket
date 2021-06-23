package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        ProductService service = new ProductServiceimpl();
        List<Product> productList = service.getProductList();
        request.setAttribute("productList", productList);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
}
