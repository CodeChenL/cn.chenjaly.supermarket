package cn.chenjaly.supermarket.dao;

import cn.chenjaly.supermarket.bean.Order;

import java.util.List;

public interface OrdersDao {
    public int addOrders(Order order);

    public List<Order> getOrdersListByUid(String uid);

    public int deleteOrdersByOid(String oid);

    public Order getOrderByOid(String oid);
    public Order getOrderAssessByOid(String oid);

    public int updateOrders(Order order);

    public int updateOrdersState(String oid);
    public int assessOrder(String oid,String assess);
}
