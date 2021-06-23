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
}
