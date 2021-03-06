package top.summersea.entity;

import java.util.Date;
import java.util.StringJoiner;

/**
 * @PackageName: entity
 * @ClassName: UserInfo
 * @Description: description
 * @Version: V1.0
 * @Author: 夏浩海
 * @Date: 2020/12/2 14:54
 */
public class UserInfo {
    private String userId;
    private String username;
    private String password;
    private Boolean sex;
    private Date bornDate;
    private String userTel;
    private String userAddress;
    private String typeId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        if (!"".equals(userId)) {
            this.userId = userId;
        }
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        if (!"".equals(username)) {
            this.username = username;
        }
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        if (!"".equals(password)) {
            this.password = password;
        }
    }

    public Boolean getSex() {
        return sex;
    }

    public void setSex(Boolean sex) {
        this.sex = sex;
    }

    public void setSex(String sex) {
        if ("男".equals(sex)) {
            this.sex = true;
        } else if ("女".equals(sex)) {
            this.sex = false;
        }
    }

    public Date getBornDate() {
        return bornDate;
    }

    public void setBornDate(Date bornDate) {
        this.bornDate = bornDate;
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        if (!"".equals(userTel)) {
            this.userTel = userTel;
        }
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        if (!"".equals(userAddress)) {
            this.userAddress = userAddress;
        }
    }

    public String getTypeId() {
        return typeId;
    }

    public void setTypeId(String typeId) {
        if (!"".equals(typeId)) {
            this.typeId = typeId;
        }
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", UserInfo.class.getSimpleName() + "[", "]")
                .add("userId='" + userId + "'")
                .add("username='" + username + "'")
                .add("password='" + password + "'")
                .add("sex=" + sex)
                .add("bornDate=" + bornDate)
                .add("userTel='" + userTel + "'")
                .add("userAddress='" + userAddress + "'")
                .add("typeId='" + typeId + "'")
                .toString();
    }
}
