package com.lj.business.cf.dto.taskSetShop;

import java.io.Serializable;

/**
 *
 *
 * 类说明：每天的销量和单位
 *
 *
 * <p>
 * 详细描述：
 *
 * @Company: 领居科技有限公司
 * @author 武鹏飞
 *
 *         CreateDate: 2017年7月24日
 */
public class NumDayAndTaskUnit implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 日均数量
     */
    private Long numDay;

    /**
     * 任务单位
     */
    private String taskUnit;

    public Long getNumDay() {
        return numDay;
    }

    public void setNumDay(Long numDay) {
        this.numDay = numDay;
    }

    public String getTaskUnit() {
        return taskUnit;
    }

    public void setTaskUnit(String taskUnit) {
        this.taskUnit = taskUnit;
    }
}
