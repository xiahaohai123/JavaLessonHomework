package service;

import dao.CountryLanguageDao;
import dao.CountryLanguageDaoImpl;
import entity.CountryLanguage;

import java.util.List;
import java.util.Properties;

/**
 * @PackageName: service
 * @ClassName: CountryLanguageServiceImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/20 14:31
 */
public class CountryLanguageServiceImpl implements CountryLanguageService {
    private CountryLanguageDao countryLanguageDao;

    public CountryLanguageServiceImpl(Properties properties) {
        this.countryLanguageDao = new CountryLanguageDaoImpl(properties);
    }

    // 根据language查找
    public List<CountryLanguage> lookupInfoByLanguage(String language) {
        List<CountryLanguage> listByLanguage = countryLanguageDao.getListByLanguage(language);
        return listByLanguage;
    }

    public List<CountryLanguage> lookupInfoByIsOfficial(String isOfficial) {
        return countryLanguageDao.getListByIsOfficial(isOfficial);
    }

    public Integer insertCountryLanguage(CountryLanguage countryLanguage) {
        return countryLanguageDao.insertInfo(countryLanguage);
    }
}
