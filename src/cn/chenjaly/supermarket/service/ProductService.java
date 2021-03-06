package cn.chenjaly.supermarket.service;

import cn.chenjaly.supermarket.bean.Product;

import java.util.List;

public interface ProductService {
    public List<Product> getProductList();

    Product getProductByPid(String pid);

    public List<Product> HotProductList();

    public List<Product> NewestProductList();

    public List<Product> getProductListByCid(String cid);
    public List<Product> searchProduct(String search);
    public String getOrderAssessByPid(String pid);
}
