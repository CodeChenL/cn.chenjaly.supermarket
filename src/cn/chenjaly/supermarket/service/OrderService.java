package cn.chenjaly.supermarket.service;

import cn.chenjaly.supermarket.bean.Order;

import java.util.List;

public interface OrderService {
    public int addOrders(Order order);
    public List<Order> getOrdersByUid( String uid);
    public int deleteOrdersByOid(String oid);
    public Order getOrderByOid(String oid);
    public int updateOrders(Order order);
}

