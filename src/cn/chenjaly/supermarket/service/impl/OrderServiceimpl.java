package cn.chenjaly.supermarket.service.impl;

import cn.chenjaly.supermarket.bean.Order;
import cn.chenjaly.supermarket.bean.OrderItem;
import cn.chenjaly.supermarket.dao.OrderItemDao;
import cn.chenjaly.supermarket.dao.OrdersDao;
import cn.chenjaly.supermarket.dao.impl.OrderItemDaoimpl;
import cn.chenjaly.supermarket.dao.impl.OrdersDaoimpl;
import cn.chenjaly.supermarket.service.OrderService;

import java.util.List;

public class OrderServiceimpl implements OrderService {
    OrdersDao dao = new OrdersDaoimpl();
    OrderItemDao orderItemDao = new OrderItemDaoimpl();

    @Override
    public int addOrders(Order order) {
        int i = dao.addOrders(order);
        for (OrderItem orderItem : order.getOrderItems()) {
            orderItemDao.addOrderItem(orderItem);
        }
        return i;
    }

    @Override
    public List<Order> getOrdersByUid(String uid) {
        List<Order> orderList = dao.getOrdersListByUid(uid);
        for (Order order : orderList) {
            List<OrderItem> orderItemList = orderItemDao.getOrderItemByOid(order.getOid());
            order.setOrderItems(orderItemList);
        }
        return orderList;
    }

    public int deleteOrdersByOid(String oid) {
        orderItemDao.deleteOrderItemByOid(oid);
        return dao.deleteOrdersByOid(oid);
    }

    @Override
    public Order getOrderByOid(String oid) {
        Order order = dao.getOrderByOid(oid);
        order.setOrderItems(orderItemDao.getOrderItemByOid(oid));
        return order;
    }

    @Override
    public int updateOrders(Order order) {
        return dao.updateOrders(order);
    }

    @Override
    public int updateOrdersState(String oid) {
        return dao.updateOrdersState(oid);
    }

    @Override
    public int assessOrder(String oid, String assess) {
        return dao.assessOrder(oid,assess);
    }
}
