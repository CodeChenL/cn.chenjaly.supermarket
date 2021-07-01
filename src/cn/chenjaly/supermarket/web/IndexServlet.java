package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Category;
import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.CategoryService;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.CategoryServiceimpl;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Index", value = "/Index")
public class IndexServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        ProductService service = new ProductServiceimpl();
        CategoryService categoryService = new CategoryServiceimpl();

        List<Category> categoryList = categoryService.getCategoryList();
        HttpSession session = request.getSession();
        session.setAttribute("categoryList", categoryList);
        session.setMaxInactiveInterval(1000 * 60 * 30);
        List<Product> list = service.HotProductList();
        request.setAttribute("hotProductList", list);
        List<Product> list1 = service.NewestProductList();
        request.setAttribute("newProductList", list1);
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
