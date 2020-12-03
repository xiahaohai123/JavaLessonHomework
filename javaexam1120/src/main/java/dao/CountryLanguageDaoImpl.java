package dao;

import entity.CountryLanguage;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @PackageName: dao
 * @ClassName: CountryLanguageDaoImpl
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/11/20 13:57
 */
public class CountryLanguageDaoImpl implements CountryLanguageDao {

    private JDBCUtil jdbcUtil;

    public CountryLanguageDaoImpl(Properties properties) {
        this.jdbcUtil = new JDBCUtil(properties);
    }

    public List<CountryLanguage> getListByLanguage(String language) {
        List<CountryLanguage> resList = new ArrayList<CountryLanguage>();
//        String sql = "SELECT * FROM countrylanguage WHERE Language LIKE ? ;";
        String sql = "CALL select_rows_like_language(?) ;";
        try {
            Connection connection = jdbcUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, language);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.setCountryCode(resultSet.getString("CountryCode"));
                countryLanguage.setLanguage(resultSet.getString("Language"));
                countryLanguage.setIsOfficial(resultSet.getString("IsOfficial"));
                countryLanguage.setPercentage(resultSet.getBigDecimal("Percentage"));
                resList.add(countryLanguage);
            }
            jdbcUtil.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        return resList;
    }

    public List<CountryLanguage> getListByIsOfficial(String isOfficial) {
        List<CountryLanguage> resList = new ArrayList<CountryLanguage>();
//        String sql = "SELECT * FROM countrylanguage WHERE isOfficial = ? ;";
        String sql = "CALL select_rows_by_isofficial(?);";
        try {
            Connection connection = jdbcUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, isOfficial);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                CountryLanguage countryLanguage = new CountryLanguage();
                countryLanguage.setCountryCode(resultSet.getString("CountryCode"));
                countryLanguage.setLanguage(resultSet.getString("Language"));
                countryLanguage.setIsOfficial(resultSet.getString("IsOfficial"));
                countryLanguage.setPercentage(resultSet.getBigDecimal("Percentage"));
                resList.add(countryLanguage);
            }
            jdbcUtil.close(connection, statement);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resList;
    }


    public Integer insertInfo(CountryLanguage countryLanguage) {
        String sql = "CALL insert_countrylanguage(?,?,?,?) ;";
        try {
            Connection connection = jdbcUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            statement.setString(1, countryLanguage.getCountryCode());
            statement.setString(2, countryLanguage.getLanguage());
            statement.setString(3, countryLanguage.getIsOfficial());
            statement.setBigDecimal(4, countryLanguage.getPercentage());
            return statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        return 0;
    }
}
