package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class User extends Model {
	
	@Required	
	public String logname;  //	用户名	注册手机号，索引
	public String nickname;  //	昵称	默认手机号
	@Required
	public String password;  //	密码	MD5加密
	public Integer state;  //	用户状态	正常和冻结
	public String headimage;  //	头像	数据库中存文件服务器地址
	public String wifipsw;  //	wifi密码	
	public String idcard;  //	身份证号	16位或者18位
	public long waitersmerchantid;  //	服务员的商户id	qq这个字段，应该为是否服务员，并且如果是，填写商户id，否则为0.换言之，应该叫做：服务员所属商户的id
	public Integer rewardpoints;  //	用户积分	
	public String signuptime;  //	注册日期	
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public User( String logname,String password) {
		this.logname = logname;
		this.password = password;
        create();
    }
	
    //根据 logname 查找
	public static List<User> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
    
}

