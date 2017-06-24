package qibo.org.myapptools.ui.bean;

/**
 * Created by 17210 on 2017/6/25.
 */

public class UserBean {

    /**
     * id : 1
     * userName : 赵大宝
     * userPhone : 13285250574
     * userEmail : 1045221654@qq.com
     * userPwd : 05126a423a9379d529e4ee61a212fa55
     * pwdSalt : KJUYT5
     * createTime : 1468597136000
     * modifyTime : 1468597149000
     * isDelete : 0
     */

    private int id;
    private String userName;
    private String userPhone;
    private String userEmail;
    private String userPwd;
    private String pwdSalt;
    private long createTime;
    private long modifyTime;
    private int isDelete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public String getPwdSalt() {
        return pwdSalt;
    }

    public void setPwdSalt(String pwdSalt) {
        this.pwdSalt = pwdSalt;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }

    public int getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(int isDelete) {
        this.isDelete = isDelete;
    }
}
