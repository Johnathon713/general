package org.john.general.auth.user.entity;

import com.baomidou.mybatisplus.annotation.EnumValue;

import java.util.HashMap;
import java.util.Map;

public enum CountryCallingCode {
    CHINA("CN", "China", "中国", "+86", "86"),
    UNITED_STATES("US", "United States", "美国", "+1", "1"),
    UNITED_KINGDOM("GB", "United Kingdom", "英国", "+44", "44"),
    JAPAN("JP", "Japan", "日本", "+81", "81"),
    GERMANY("DE", "Germany", "德国", "+49", "49"),
    FRANCE("FR", "France", "法国", "+33", "33"),
    INDIA("IN", "India", "印度", "+91", "91"),
    BRAZIL("BR", "Brazil", "巴西", "+55", "55"),
    RUSSIA("RU", "Russia", "俄罗斯", "+7", "7"),
    SOUTH_KOREA("KR", "South Korea", "韩国", "+82", "82");

    private final String isoCode;
    private final String englishName;
    private final String chineseName;
    @EnumValue
    private final String callingCodeWithPlus;
    private final String callingCode;

    private static final Map<String, CountryCallingCode> BY_CODE = new HashMap<>();
    private static final Map<String, CountryCallingCode> BY_ISO_CODE = new HashMap<>();

    static {
        for (CountryCallingCode c : values()) {
            BY_CODE.put(c.callingCode, c);
            BY_CODE.put(c.callingCodeWithPlus, c);
            BY_ISO_CODE.put(c.isoCode, c);
        }
    }

    CountryCallingCode(String isoCode, String englishName, String chineseName,
                       String callingCodeWithPlus, String callingCode) {
        this.isoCode = isoCode;
        this.englishName = englishName;
        this.chineseName = chineseName;
        this.callingCodeWithPlus = callingCodeWithPlus;
        this.callingCode = callingCode;
    }

    // 根据国家码查找（带+或不带+都可以）
    public static CountryCallingCode fromCallingCode(String code) {
        CountryCallingCode country = BY_CODE.get(code);
        if (country == null) {
            throw new IllegalArgumentException("未知的国家电话码: " + code);
        }
        return country;
    }

    // 根据ISO代码查找
    public static CountryCallingCode fromIsoCode(String isoCode) {
        CountryCallingCode country = BY_ISO_CODE.get(isoCode);
        if (country == null) {
            throw new IllegalArgumentException("未知的ISO国家代码: " + isoCode);
        }
        return country;
    }

    // getters...
}
