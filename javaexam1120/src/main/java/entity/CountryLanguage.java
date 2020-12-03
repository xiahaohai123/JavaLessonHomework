package entity;

import java.math.BigDecimal;

/**
 * @PackageName: entity
 * @ClassName: CountryLanguage
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/20 13:47
 */
public class CountryLanguage {
    private String countryCode;
    private String language;
    private String isOfficial;
    private BigDecimal percentage;

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getIsOfficial() {
        return isOfficial;
    }

    public void setIsOfficial(String isOfficial) {
        this.isOfficial = isOfficial;
    }

    public BigDecimal getPercentage() {
        return percentage;
    }

    public void setPercentage(BigDecimal percentage) {
        this.percentage = percentage;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("CountryLanguage{");
        sb.append("countryCode='").append(countryCode).append('\'');
        sb.append(", language='").append(language).append('\'');
        sb.append(", isOfficial=").append(isOfficial);
        sb.append(", percentage=").append(percentage);
        sb.append('}');
        return sb.toString();
    }
}
