package cn.chenjaly.supermarket.dao;

import cn.chenjaly.supermarket.bean.Order;

import java.util.List;

public interface OrdersDao {
    public int addOrders(Order order);
    public List<Order> getOrdersListByUid( String uid);
}