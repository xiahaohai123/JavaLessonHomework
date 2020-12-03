import entity.CountryLanguage;
import service.CountryLanguageService;
import service.CountryLanguageServiceImpl;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.List;
import java.util.Properties;

/**
 * @PackageName: PACKAGE_NAME
 * @ClassName: TestCountryLanguage
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/20 14:30
 */
public class TestCountryLanguage {
    public static void main(String[] args) throws IOException {

        // 用classLoader加载resources下的文件
        // 配置文件载入
        Properties properties = new Properties();
        properties.load(( Thread.currentThread().getContextClassLoader().getResourceAsStream("application.properties")));

        // 使用service
        CountryLanguageService countryLanguageService = new CountryLanguageServiceImpl(properties);

        // 模糊查询
        System.out.println("根据%Engli%模糊查询");
        List<CountryLanguage> countryLanguages = countryLanguageService.lookupInfoByLanguage("%Engli%");
        for (CountryLanguage countryLanguage : countryLanguages) {
            System.out.println(countryLanguage);
        }

        System.out.println("根据official T查询");
        countryLanguages = countryLanguageService.lookupInfoByIsOfficial("T");
        for (CountryLanguage countryLanguage : countryLanguages) {
            System.out.println(countryLanguage);
        }

        System.out.println("insert 数据");
        CountryLanguage language = new CountryLanguage();
        language.setCountryCode("ABC");
        language.setLanguage("TestLanguage");
        language.setIsOfficial("F");
        language.setPercentage(new BigDecimal("51.2"));
        System.out.println(countryLanguageService.insertCountryLanguage(language));
    }
}
