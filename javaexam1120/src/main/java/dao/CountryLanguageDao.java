package dao;

import entity.CountryLanguage;

import java.util.List;

public interface CountryLanguageDao {
    // 根据language模糊查询
    List<CountryLanguage> getListByLanguage(String language);

    // 根据isOfficial获取信息
    List<CountryLanguage> getListByIsOfficial(String isOfficial);

    // 添加一条信息
    Integer insertInfo(CountryLanguage countryLanguage);
}
