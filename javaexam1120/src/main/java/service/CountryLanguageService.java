package service;

import entity.CountryLanguage;

import java.util.List;

public interface CountryLanguageService {
    List<CountryLanguage> lookupInfoByLanguage(String language);

    List<CountryLanguage> lookupInfoByIsOfficial(String isOfficial);

    Integer insertCountryLanguage(CountryLanguage countryLanguage);
}
