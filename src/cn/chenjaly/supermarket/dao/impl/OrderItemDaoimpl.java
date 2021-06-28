package cn.chenjaly.supermarket.dao.impl;

import cn.chenjaly.supermarket.bean.OrderItem;
import cn.chenjaly.supermarket.dao.OrderItemDao;
import cn.chenjaly.supermarket.util.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

public class OrderItemDaoimpl implements OrderItemDao {
    JdbcTemplate jdbcTemplate=new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public int addOrderItem(OrderItem orderItem) {
        String sql="insert into OrderItem values(?,?,?,?,?)";
        return jdbcTemplate.update(sql,orderItem.getItemid(),
                orderItem.getCount(),
                orderItem.getSubtotal(),
                orderItem.getProduct().getPid(),
                orderItem.getOid());
    }
}
