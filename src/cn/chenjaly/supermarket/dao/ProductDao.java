package cn.chenjaly.supermarket.dao;

import cn.chenjaly.supermarket.bean.Product;

import java.util.List;

public interface ProductDao {
    public List<Product> getProductList();

    public Product getProductByPid(String pid);
    public List<Product> HotProductList();
    public List<Product> NewestProductList();
    public List<Product> getProductListByCid(String cid);
}
