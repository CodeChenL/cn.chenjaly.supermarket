package cn.chenjaly.supermarket.service.impl;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.dao.ProductDao;
import cn.chenjaly.supermarket.dao.impl.ProductDaoimpl;
import cn.chenjaly.supermarket.service.ProductService;

import java.util.List;

public class ProductServiceimpl implements ProductService {
    ProductDao dao = new ProductDaoimpl();

    @Override
    public List<Product> getProductList() {
        return dao.getProductList();
    }

    @Override
    public Product getProductByPid(String pid) {
        return dao.getProductByPid(pid);
    }

    @Override
    public List<Product> HotProductList() {
        return dao.HotProductList();
    }

    @Override
    public List<Product> NewestProductList() {
        return dao.NewestProductList();
    }

    @Override
    public List<Product> getProductListByCid(String cid) {
        return dao.getProductListByCid(cid);
    }

    @Override
    public List<Product> searchProduct(String search) {
        return dao.searchProduct(search);
    }

    @Override
    public String getOrderAssessByPid(String pid) {
        return dao.getOrderAssessByPid(pid);
    }
}
