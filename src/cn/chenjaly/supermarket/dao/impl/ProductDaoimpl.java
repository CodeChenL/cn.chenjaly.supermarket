package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.bean.OrderItem;
import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.dao.OrdersDao;
import cn.chenjaly.supermarket.dao.ProductDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.ArrayList;
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

    @Override
    public List<Product> searchProduct(String search) {
        String sql="select * from product where pname like ? or pdesc like ?";
        return template.query(sql,new BeanPropertyRowMapper<>(Product.class),search,search);
    }
    @Override
    public String getOrderAssessByPid(String pid) {
        String sql = "select * from OrderItem where pid=?";
        List<OrderItem> orderItemList = template.query(sql, new BeanPropertyRowMapper<>(OrderItem.class), pid);
        String assess="";
        OrdersDao dao = new OrdersDaoimpl();
        for (int i = 0; i < orderItemList.size(); i++) {
            Order order = dao.getOrderByOid(orderItemList.get(i).getOid());
            if (order.getAssess()!=null){
                assess+="<tr class=\"warning\"><th>"+order.getName()+"："+order.getAssess()+"</th></tr>";
            }
        }
        return assess;
    }
}
