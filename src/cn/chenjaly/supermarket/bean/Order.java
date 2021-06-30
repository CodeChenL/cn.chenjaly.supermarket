package cn.chenjaly.supermarket.bean;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Order {
    private String oid;
    private String orderTime;
    private String name;
    private String address;
    private String telephone;
    private double total;

    public String getOid() {
        return oid;
    }

    public void setOid(String oid) {
        this.oid = oid;
    }

    public String getorderTime() {
        return orderTime;
    }

    public void setorderTime(String otime) {
        this.orderTime = otime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public double getTotal() {
        total = 0;
        for (OrderItem item:orderItems) {
            //通过遍历循环获得小计价格
            total += item.getSubtotal();

        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAssess() {
        return assess;
    }

    public void setAssess(String assess) {
        this.assess = assess;
    }

    public List<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    private int state = 0;
    private String uid;
    private String assess;
    private List<OrderItem> orderItems = new ArrayList<>();

    public Order() {

    }
}
