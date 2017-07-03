package qibo.org.myapptools.ui.welcome.bean;

/**
 * Created by qibo on 2017/6/27.
 */

public class ShowUserBean {

    /**
     * result : 0
     * msg : 有了
     * data : {"createTime":{"date":15,"day":5,"hours":23,"minutes":38,"month":6,"seconds":56,"time":1468597136000,"timezoneOffset":-480,"year":116},"id":1,"isDelete":0,"modifyTime":{"date":15,"day":5,"hours":23,"minutes":39,"month":6,"seconds":9,"time":1468597149000,"timezoneOffset":-480,"year":116},"pwdSalt":"KJUYT5","userEmail":"1045221654@qq.com","userName":"赵大宝","userPhone":"13285250574","userPwd":"05126a423a9379d529e4ee61a212fa55"}
     */

    private String result;
    private String msg;
    private DataBean data;

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * createTime : {"date":15,"day":5,"hours":23,"minutes":38,"month":6,"seconds":56,"time":1468597136000,"timezoneOffset":-480,"year":116}
         * id : 1
         * isDelete : 0
         * modifyTime : {"date":15,"day":5,"hours":23,"minutes":39,"month":6,"seconds":9,"time":1468597149000,"timezoneOffset":-480,"year":116}
         * pwdSalt : KJUYT5
         * userEmail : 1045221654@qq.com
         * userName : 赵大宝
         * userPhone : 13285250574
         * userPwd : 05126a423a9379d529e4ee61a212fa55
         */

        private CreateTimeBean createTime;
        private int id;
        private int isDelete;
        private ModifyTimeBean modifyTime;
        private String pwdSalt;
        private String userEmail;
        private String userName;
        private String userPhone;
        private String userPwd;

        public CreateTimeBean getCreateTime() {
            return createTime;
        }

        public void setCreateTime(CreateTimeBean createTime) {
            this.createTime = createTime;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getIsDelete() {
            return isDelete;
        }

        public void setIsDelete(int isDelete) {
            this.isDelete = isDelete;
        }

        public ModifyTimeBean getModifyTime() {
            return modifyTime;
        }

        public void setModifyTime(ModifyTimeBean modifyTime) {
            this.modifyTime = modifyTime;
        }

        public String getPwdSalt() {
            return pwdSalt;
        }

        public void setPwdSalt(String pwdSalt) {
            this.pwdSalt = pwdSalt;
        }

        public String getUserEmail() {
            return userEmail;
        }

        public void setUserEmail(String userEmail) {
            this.userEmail = userEmail;
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

        public String getUserPwd() {
            return userPwd;
        }

        public void setUserPwd(String userPwd) {
            this.userPwd = userPwd;
        }

        public static class CreateTimeBean {
            /**
             * date : 15
             * day : 5
             * hours : 23
             * minutes : 38
             * month : 6
             * seconds : 56
             * time : 1468597136000
             * timezoneOffset : -480
             * year : 116
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            @Override
            public String toString() {
                return "CreateTimeBean{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }
        }

        public static class ModifyTimeBean {
            /**
             * date : 15
             * day : 5
             * hours : 23
             * minutes : 39
             * month : 6
             * seconds : 9
             * time : 1468597149000
             * timezoneOffset : -480
             * year : 116
             */

            private int date;
            private int day;
            private int hours;
            private int minutes;
            private int month;
            private int seconds;
            private long time;
            private int timezoneOffset;
            private int year;

            public int getDate() {
                return date;
            }

            public void setDate(int date) {
                this.date = date;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getHours() {
                return hours;
            }

            public void setHours(int hours) {
                this.hours = hours;
            }

            public int getMinutes() {
                return minutes;
            }

            public void setMinutes(int minutes) {
                this.minutes = minutes;
            }

            public int getMonth() {
                return month;
            }

            public void setMonth(int month) {
                this.month = month;
            }

            public int getSeconds() {
                return seconds;
            }

            public void setSeconds(int seconds) {
                this.seconds = seconds;
            }

            public long getTime() {
                return time;
            }

            public void setTime(long time) {
                this.time = time;
            }

            public int getTimezoneOffset() {
                return timezoneOffset;
            }

            public void setTimezoneOffset(int timezoneOffset) {
                this.timezoneOffset = timezoneOffset;
            }

            public int getYear() {
                return year;
            }

            public void setYear(int year) {
                this.year = year;
            }

            @Override
            public String toString() {
                return "ModifyTimeBean{" +
                        "date=" + date +
                        ", day=" + day +
                        ", hours=" + hours +
                        ", minutes=" + minutes +
                        ", month=" + month +
                        ", seconds=" + seconds +
                        ", time=" + time +
                        ", timezoneOffset=" + timezoneOffset +
                        ", year=" + year +
                        '}';
            }
        }
    }

    @Override
    public String toString() {
        return "ShowUserBean{" +
                "result='" + result + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
