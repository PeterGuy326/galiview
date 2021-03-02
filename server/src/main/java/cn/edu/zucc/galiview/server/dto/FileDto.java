package cn.edu.zucc.galiview.server.dto;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class FileDto {

    /**
    * id
    */
    private String id;

    /**
    * 相对路径
    */
    private String path;

    /**
    * 文件名
    */
    private String name;

    /**
    * 后缀
    */
    private String suffix;

    /**
    * 大小|字节B
    */
    private Integer size;

    /**
    * 用途|枚举[FileUseEnum]：COURSE("C", "讲师"), TEACHER("T", "课程")
    */
    private String use;

    /**
    * 创建时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createdAt;

    /**
    * 修改时间
    */
    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date updatedAt;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSuffix() {
        return suffix;
    }

    public void setSuffix(String suffix) {
        this.suffix = suffix;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getUse() {
        return use;
    }

    public void setUse(String use) {
        this.use = use;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", path=").append(path);
        sb.append(", name=").append(name);
        sb.append(", suffix=").append(suffix);
        sb.append(", size=").append(size);
        sb.append(", use=").append(use);
        sb.append(", createdAt=").append(createdAt);
        sb.append(", updatedAt=").append(updatedAt);
        sb.append("]");
        return sb.toString();
    }

}