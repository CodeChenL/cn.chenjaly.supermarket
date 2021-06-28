package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.dao.OrdersDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

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
}
