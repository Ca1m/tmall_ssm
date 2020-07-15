package com.how2java.tmall.pojo;

public class Page {

    private int start; // 每页第一行
    private int count; // 每页数量
    private int total; // 总数量
    private String param; // 参数

    private int default_count = 5;

    public Page(){
        count = default_count;
    }
    public Page(int start, int count) {
        this();
        this.start = start;
        this.count = count;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public String getParam() {
        return param;
    }

    public void setParam(String param) {
        this.param = param;
    }

    public boolean isHasPreviouse(){
        if (start == 0)
            return false;
        return true;
    }
    public boolean isHasNext() {
        if (start == getLast())
            return false;
        return true;
    }

    // 计算总页数
    public int getTotalPage(){
        int totalPage = total % count == 0 ? total / count : total / count + 1;
        if (totalPage == 0) {
            return 1;
        }
        return totalPage;
    }
    // 计算最后一页第一行
    public int getLast(){
        int last = total % count == 0 ? (total - count) : (total - total % count);
        return last < 0 ? 0 : last;
    }

}
