package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ProductListServlet", value = "/ProductListServlet")
public class ProductListServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");
        String s = request.getParameter("currentPage");
        int currentPage = Integer.parseInt(s);

        String cid = request.getParameter("cid");
        ProductService service = new ProductServiceimpl();
        List<Product> productList = null;
        if (cid==null){
            productList= service.getProductList();
        }else {

            productList= service.getProductListByCid(cid);
            request.setAttribute("cid",cid);
        }
        ArrayList<Product> list = new ArrayList<>();
        int n = 12;
        for (int i = (currentPage - 1) * n; i < currentPage * n && i < productList.size(); i++) {
            list.add(productList.get(i));
        }
        int totalPage = (productList.size() - 1) / n + 1;
        request.setAttribute("productList", list);
        request.setAttribute("currentPage", currentPage);
        request.setAttribute("totalPage", totalPage);
        request.getRequestDispatcher("/product_list.jsp").forward(request, response);
    }
}
