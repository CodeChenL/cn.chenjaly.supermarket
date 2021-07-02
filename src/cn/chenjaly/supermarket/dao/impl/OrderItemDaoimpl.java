package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.bean.OrderItem;
import cn.chenjaly.supermarket.bean.Product;
import cn.chenjaly.supermarket.dao.OrderItemDao;
import cn.chenjaly.supermarket.dao.OrdersDao;
import cn.chenjaly.supermarket.dao.ProductDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrderItemDaoimpl implements OrderItemDao {
    JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());

    @Override
    public int addOrderItem(OrderItem orderItem) {
        String sql = "insert into OrderItem values(?,?,?,?,?)";
        return jdbcTemplate.update(sql, orderItem.getItemid(),
                orderItem.getCount(),
                orderItem.getSubtotal(),
                orderItem.getProduct().getPid(),
                orderItem.getOid());
    }

    @Override
    public List<OrderItem> getOrderItemByOid(String oid) {
        String sql = "select * from OrderItem where oid=?";
        List<OrderItem> orderItemList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(OrderItem.class), oid);
        List<Product> productList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Product.class), oid);
        ProductDao dao = new ProductDaoimpl();
        for (int i = 0; i < orderItemList.size(); i++) {
            Product product = dao.getProductByPid(productList.get(i).getPid());
            orderItemList.get(i).setProduct(product);
        }
        return orderItemList;
    }

    @Override
    public int deleteOrderItemByOid(String oid) {
        String sql = "delete from orderitem where oid=? ";
        return jdbcTemplate.update(sql, oid);
    }


}
