package cn.zyq.domain;

import java.util.List;

/*
* 分页工具对象
* */
public class PageBean<T> {
    private int totalCount; //总记录数
    private int totalPage; // 总页码
    private List<User> list; //每页的数据
    private int currentPages; //当前页码
    private int rows; //每页显示的记录数

    @Override
    public String toString() {
        return "PageBean{" +
                "totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                ", list=" + list +
                ", currentPages=" + currentPages +
                ", rows=" + rows +
                '}';
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public List<User> getList() {
        return list;
    }

    public void setList(List<User> list) {
        this.list = list;
    }

    public int getCurrentPages() {
        return currentPages;
    }

    public void setCurrentPages(int currentPages) {
        this.currentPages = currentPages;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }
}
