package com.example.pojo;

public class ZDYGoodsbean {
    private String sellerName;
    private double bargainPrice;
    private String createtime;
    private String detailUrl;
    private String images;
    private int num;
    private String pid;
    private double price;
    private String pscid;
    private String selected;
    private String sellerid;
    private boolean selectedchild;
    private String subhead;
    private String title;

    public ZDYGoodsbean(String sellerName, boolean selectedchild, double bargainPrice, String createtime, String detailUrl, String images, int num, String pid, double price, String pscid, String selected, String sellerid, String subhead, String title) {
        this.sellerName = sellerName;
        this.selectedchild = selectedchild;
        this.bargainPrice = bargainPrice;
        this.createtime = createtime;
        this.detailUrl = detailUrl;
        this.images = images;
        this.num = num;
        this.pid = pid;
        this.price = price;
        this.pscid = pscid;
        this.selected = selected;
        this.sellerid = sellerid;
        this.subhead = subhead;
        this.title = title;
    }

    public ZDYGoodsbean() {
        super();
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public double getBargainPrice() {
        return bargainPrice;
    }

    public void setBargainPrice(double bargainPrice) {
        this.bargainPrice = bargainPrice;
    }

    public String getCreatetime() {
        return createtime;
    }

    public void setCreatetime(String createtime) {
        this.createtime = createtime;
    }

    public String getDetailUrl() {
        return detailUrl;
    }

    public void setDetailUrl(String detailUrl) {
        this.detailUrl = detailUrl;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPscid() {
        return pscid;
    }

    public void setPscid(String pscid) {
        this.pscid = pscid;
    }

    public String getSelected() {
        return selected;
    }

    public void setSelected(String selected) {
        this.selected = selected;
    }

    public String getSellerid() {
        return sellerid;
    }

    public void setSellerid(String sellerid) {
        this.sellerid = sellerid;
    }

    public boolean isSelectedchild() {
        return selectedchild;
    }

    public void setSelectedchild(boolean selectedchild) {
        this.selectedchild = selectedchild;
    }

    public String getSubhead() {
        return subhead;
    }

    public void setSubhead(String subhead) {
        this.subhead = subhead;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Override
    public String toString() {
        return "ZDYGoodsbean{" +
                "sellerName='" + sellerName + '\'' +
                ", bargainPrice=" + bargainPrice +
                ", createtime='" + createtime + '\'' +
                ", detailUrl='" + detailUrl + '\'' +
                ", images='" + images + '\'' +
                ", num=" + num +
                ", pid='" + pid + '\'' +
                ", price=" + price +
                ", pscid='" + pscid + '\'' +
                ", selected='" + selected + '\'' +
                ", sellerid='" + sellerid + '\'' +
                ", selectedchild=" + selectedchild +
                ", subhead='" + subhead + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
