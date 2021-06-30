package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.dao.OrdersDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class OrdersDaoimpl implements OrdersDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int addOrders(Order order) {
        String sql="insert into orders values(?,now(),?,?,?,?,?,?,null)";
        return jdbcTemplate.update(sql,order.getOid(),
                String.valueOf(order.getTotal()),
                String.valueOf(order.getState()),
                order.getAddress(),order.getName(),
                order.getTelephone(),order.getUid());
    }

    @Override
    public List<Order> getOrdersListByUid(String uid) {
        String sql="select * from orders where uid=? order by ordertime desc";
        return jdbcTemplate.query(sql,new BeanPropertyRowMapper<>(Order.class),uid);
    }
}
