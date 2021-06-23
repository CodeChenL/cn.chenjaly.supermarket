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
}