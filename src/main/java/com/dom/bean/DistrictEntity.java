/*
 * Welcome to use the TableGo Tools.
 * 
 * http://vipbooks.iteye.com
 * http://blog.csdn.net/vipbooks
 * http://www.cnblogs.com/vipbooks
 * 
 * Author:bianj
 * Email:edinsker@163.com
 * Version:5.0.0
 */
package com.dom.bean;

import java.util.Date;

/**
 * DISTRICT
 * 
 * @author chendom
 * @version 1.0.0 2018-03-30
 */
public class DistrictEntity implements java.io.Serializable {
    /** 版本号 */
    private static final long serialVersionUID = -3651949781184005005L;

    /**  */
    private String id;

    /**  */
    private String createdBy;

    /**  */
    private Date creationDate;

    /**  */
    private String updatedBy;

    /**  */
    private Date updationDate;

    /**  */
    private Boolean enabledFlag;

    /** 是否启用 */
    private Boolean isdisabled;

    /** 名称 */
    private String districtName;

    /** 主数据id */
    private String mdmid;

    /** 编号 */
    private String districtCode;

    /** 父id */
    private String parentId;

    /** 排序 */
    private Integer sort;

    /** 来源 */
    private Integer sourcesType;

    /** 京东地址编码 */
    private String sourcesCode;

    /**
     * 获取
     * 
     * @return 
     */
    public String getId() {
        return this.id;
    }

    /**
     * 设置
     * 
     * @param id
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public String getCreatedBy() {
        return this.createdBy;
    }

    /**
     * 设置
     * 
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public Date getCreationDate() {
        return this.creationDate;
    }

    /**
     * 设置
     * 
     * @param creationDate
     */
    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public String getUpdatedBy() {
        return this.updatedBy;
    }

    /**
     * 设置
     * 
     * @param updatedBy
     */
    public void setUpdatedBy(String updatedBy) {
        this.updatedBy = updatedBy;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public Date getUpdationDate() {
        return this.updationDate;
    }

    /**
     * 设置
     * 
     * @param updationDate
     */
    public void setUpdationDate(Date updationDate) {
        this.updationDate = updationDate;
    }

    /**
     * 获取
     * 
     * @return 
     */
    public Boolean getEnabledFlag() {
        return this.enabledFlag;
    }

    /**
     * 设置
     * 
     * @param enabledFlag
     */
    public void setEnabledFlag(Boolean enabledFlag) {
        this.enabledFlag = enabledFlag;
    }

    /**
     * 获取是否启用
     * 
     * @return 是否启用
     */
    public Boolean getIsdisabled() {
        return this.isdisabled;
    }

    /**
     * 设置是否启用
     * 
     * @param isdisabled
     *          是否启用
     */
    public void setIsdisabled(Boolean isdisabled) {
        this.isdisabled = isdisabled;
    }

    /**
     * 获取名称
     * 
     * @return 名称
     */
    public String getDistrictName() {
        return this.districtName;
    }

    /**
     * 设置名称
     * 
     * @param districtName
     *          名称
     */
    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    /**
     * 获取主数据id
     * 
     * @return 主数据id
     */
    public String getMdmid() {
        return this.mdmid;
    }

    /**
     * 设置主数据id
     * 
     * @param mdmid
     *          主数据id
     */
    public void setMdmid(String mdmid) {
        this.mdmid = mdmid;
    }

    /**
     * 获取编号
     * 
     * @return 编号
     */
    public String getDistrictCode() {
        return this.districtCode;
    }

    /**
     * 设置编号
     * 
     * @param districtCode
     *          编号
     */
    public void setDistrictCode(String districtCode) {
        this.districtCode = districtCode;
    }

    /**
     * 获取父id
     * 
     * @return 父id
     */
    public String getParentId() {
        return this.parentId;
    }

    /**
     * 设置父id
     * 
     * @param parentId
     *          父id
     */
    public void setParentId(String parentId) {
        this.parentId = parentId;
    }

    /**
     * 获取排序
     * 
     * @return 排序
     */
    public Integer getSort() {
        return this.sort;
    }

    /**
     * 设置排序
     * 
     * @param sort
     *          排序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * 获取来源
     * 
     * @return 来源
     */
    public Integer getSourcesType() {
        return this.sourcesType;
    }

    /**
     * 设置来源
     * 
     * @param sourcesType
     *          来源
     */
    public void setSourcesType(Integer sourcesType) {
        this.sourcesType = sourcesType;
    }

    /**
     * 获取京东地址编码
     * 
     * @return 京东地址编码
     */
    public String getSourcesCode() {
        return this.sourcesCode;
    }

    /**
     * 设置京东地址编码
     * 
     * @param sourcesCode
     *          京东地址编码
     */
    public void setSourcesCode(String sourcesCode) {
        this.sourcesCode = sourcesCode;
    }
}