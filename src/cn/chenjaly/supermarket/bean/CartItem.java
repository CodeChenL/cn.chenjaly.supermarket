package cn.chenjaly.supermarket.bean;

public class CartItem {
    //商品
    private Product product;
    //数量
    private int buyNum;
    //小计
    private double subTotal;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public int getBuyNum() {
        return buyNum;
    }

    public void setBuyNum(int buyNum) {
        this.buyNum = buyNum;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
    }

    @Override
    public String toString() {
        return "Cartltem{" +
                "product=" + product +
                ", buyNum=" + buyNum +
                ", subTotal=" + subTotal +
                '}';
    }
}
