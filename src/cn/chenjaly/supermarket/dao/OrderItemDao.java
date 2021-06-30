package cn.chenjaly.supermarket.dao;

import cn.chenjaly.supermarket.bean.OrderItem;

import java.util.List;

public interface OrderItemDao {
    public int addOrderItem(OrderItem orderItem);
    public List<OrderItem> getOrderItemByOid(String oid);
}
