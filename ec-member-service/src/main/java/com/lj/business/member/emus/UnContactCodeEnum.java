package com.lj.business.member.emus;

import com.lj.base.core.util.DateUtils;

import java.util.*;

/**
 * 类说明：未联系编码枚举
 * <p>
 * <p>
 * <p>
 * 详细描述：
 *
 * @author 武鹏飞
 * <p>
 * CreateDate: 2017年7月22日
 * @Company: 领居科技有限公司
 */
public enum UnContactCodeEnum {

    ONE_WEEK_ONE_MONTH("yizhouYiyue", "1周到1月未联系") {
        @Override
        public String getStartDate() {
            return getDate(30) + DAY_BEGIN;
        }

        @Override
        public String getEndDate() {
            return getDate(7) + DAY_END;
        }
    },

    ONE_MONTH_THREE_MONTH("yiyueSanyue", "1月到3月未联系") {
        @Override
        public String getStartDate() {
            return getDate(90) + DAY_BEGIN;
        }

        @Override
        public String getEndDate() {
            return getDate(30) + DAY_BEGIN;
        }
    },

    THREE_MONTH_SIX_MONTH("sanyueLiuyue", "3月到6月未联系") {
        @Override
        public String getStartDate() {
            return getDate(180) + DAY_BEGIN;
        }

        @Override
        public String getEndDate() {
            return getDate(90) + DAY_BEGIN;
        }
    },

    SIX_MONTH("liuyueEnd", "6月以上未联系") {
        @Override
        public String getStartDate() {
            return null;
        }

        @Override
        public String getEndDate() {
            return getDate(180) + DAY_BEGIN;
        }
    };

    UnContactCodeEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

    private static final String DAY_BEGIN = " 00:00:00";
    private static final String DAY_END = " 23:59:59";
    private static Map<String, UnContactCodeEnum> enumMap = new HashMap<>();

    static {
        EnumSet<UnContactCodeEnum> unContactCodes = EnumSet.allOf(UnContactCodeEnum.class);
        for (UnContactCodeEnum each : unContactCodes) {
            enumMap.put(each.getCode(), each);
        }
    }

    private String code;

    private String desc;

    /**
     * @return 获取开始日期
     */
    public abstract String getStartDate();

    /**
     * @return 获取结束日期
     */
    public abstract String getEndDate();

    /**
     * @param code 编码
     * @return 未联系编码枚举
     */
    public static UnContactCodeEnum getUnContactCodeEnum(String code) {
        return enumMap.get(code);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    private static String getDate(Integer minusDay) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(new Date());
        cal.add(Calendar.DATE, -minusDay);
        return DateUtils.formatDate(cal.getTime(), DateUtils.PATTERN_yyyy_MM_dd);
    }

}
