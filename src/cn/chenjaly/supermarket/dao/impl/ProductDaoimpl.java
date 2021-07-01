package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.dao.ProductDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class ProductDaoimpl implements ProductDao {
    private JdbcTemplate template = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public List<Product> getProductList() {
        String sql = "select * from product";
        List<Product> list = template.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return list;
    }

    @Override
    public Product getProductByPid(String pid) {
        String sql = "select * from product where pid=?";

        return template.queryForObject(sql, new BeanPropertyRowMapper<>(Product.class), pid);
    }

    @Override
    public List<Product> HotProductList() {
        String sql = "select * from product where is_hot = ? limit 0,12";
        List<Product> list = template.query(sql, new BeanPropertyRowMapper<>(Product.class), 1);
        return list;
    }

    @Override
    public List<Product> NewestProductList() {
        String sql = "select * from product order by pdate desc limit 0,12";
        List<Product> list = template.query(sql, new BeanPropertyRowMapper<>(Product.class));
        return list;
    }

    @Override
    public List<Product> getProductListByCid(String cid) {
        String sql = "select * from product where cid=?";
        return template.query(sql, new BeanPropertyRowMapper<>(Product.class), cid);
    }
}
