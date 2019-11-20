package info.johnzhou.DO;

import java.util.Date;

/**
 * @Author Lingjue Zhou
 * @Date 2019/11/20
 */
public class FolderDO {
    private String name;
    private double size;
    private Date createTime;

    public String getName() {
        return name;
    }

    public double getSize() {
        return size;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSize(double size) {
        this.size = size;
    }
}
