package cn.chenjaly.supermarket.web;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.service.ProductService;
import cn.chenjaly.supermarket.service.impl.ProductServiceimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/SearchProductServlet")
public class SearchProductServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        String search=req.getParameter("search");
        String s=req.getParameter("currentPage");
        int currentPage=Integer.parseInt(s);
        ProductService service=new ProductServiceimpl();
        List<Product> productList = service.searchProduct("%"+search+"%");
        ArrayList<Product> list = new ArrayList<>();
        int n = 12;
        for (int i = (currentPage - 1) * n; i < currentPage * n && i < productList.size(); i++) {
            list.add(productList.get(i));
        }
        int totalPage = (productList.size() - 1) / n + 1;
        req.setAttribute("productList",list);
        req.setAttribute("currentPage",currentPage);
        req.setAttribute("totalPage",totalPage);
        req.setAttribute("search",search);
        req.getRequestDispatcher("search.jsp").forward(req,resp);

    }
}
