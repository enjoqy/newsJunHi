package org.zhh.util;

/**
 * 分页工具类
 *
 * @Author junhi
 * @Date 2019/5/30 9:03
 */
public class PageUtils {

    /**
     * 1、当前页
     * 2、数据总数
     * 3、每页显示的数据量
     * 4、总页数
     */

    private Integer pageIndex;
    private Integer count;
    private Integer pageSize;
    private Integer pageCount;

    public Integer getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(Integer pageIndex) {
        this.pageIndex = pageIndex;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageCount() {
        return pageCount;
    }

    public void setPageCount(Integer pageCount) {
        if((count % pageSize) == 0){
            this.pageCount = count/pageSize;
        }else {
            this.pageCount = count/pageSize + 1;
        }
    }


}
