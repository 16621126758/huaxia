package cn.com.chnsys.Batch;

/**
 * @Class: UserEntity
 * @description:
 * @Author: hongzhi.zhao
 * @Date: 2019-08-20 11:02
 */
public class UserEntity {
    private String userId;
    private String userName;

    public UserEntity(String userId, String userName) {
        this.userId = userId;
        this.userName = userName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}
