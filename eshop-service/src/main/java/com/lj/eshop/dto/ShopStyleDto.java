package com.lj.eshop.dto;

import java.io.Serializable;

public class ShopStyleDto implements Serializable { 

    /**
	 * 
	 */
	private static final long serialVersionUID = -5239406511989606857L;

	/**
     *  .
     */
    private String code;

    /**
     * 店铺风格名称 .
     */
    private String name;

    /**
     * 店铺风格说明 .
     */
    private String spe;

    /**
     * 状态 0:启用  1:停用 .
     */
    private String status;

    /**
     *  .
     *
     */
    public String getCode() {
        return code;
    }

    /**
     *  .
     *
     */
    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    /**
     * 店铺风格名称 .
     *
     */
    public String getName() {
        return name;
    }

    /**
     * 店铺风格名称 .
     *
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 店铺风格说明 .
     *
     */
    public String getSpe() {
        return spe;
    }

    /**
     * 店铺风格说明 .
     *
     */
    public void setSpe(String spe) {
        this.spe = spe == null ? null : spe.trim();
    }

    /**
     * 状态 0:启用  1:停用 .
     *
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态 0:启用  1:停用 .
     *
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 输出BEAN数据信息
     * @author LeoPeng
     */
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("ShopStyle [code=").append(code);
        builder.append(",name=").append(name); 
        builder.append(",spe=").append(spe); 
        builder.append(",status=").append(status); 
        builder.append("]");
        return builder.toString();
    }
}
