package cn.chenjaly.supermarket.bean;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Cart {
    //购物车项目
    private Map<String, CartItem> cartItems = new HashMap<>();
    //总价
    private double total;

    public Map<String, CartItem> getCartItems() {
        return cartItems;
    }

    public void setCartItems(Map<String, CartItem> cartItems) {
        this.cartItems = cartItems;
    }

    public double getTotal() {
        total = 0;
        Set<Map.Entry<String, CartItem>> entries = cartItems.entrySet();
        for (Map.Entry<String, CartItem> entry : entries) {
            //通过遍历循环获得小计价格
            total += entry.getValue().getSubTotal();

        }
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "cartItems=" + cartItems +
                ", total=" + total +
                '}';
    }
}

