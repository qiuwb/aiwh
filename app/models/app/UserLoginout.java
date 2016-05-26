package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class UserLoginout extends Model {
	
	@Required	
	public String logname;  //	用户名	和用户信息表关联
	@Required
	public Integer actiontype;  //	动作分类	1=in ,0=out,2…
	//timestamp..public String time;  //	登录时间	服务器时间
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public UserLoginout( String logname,Integer actiontype) {
		this.logname = logname;
		this.actiontype = actiontype;
        create();
    }
	
    //根据 logname 查找
	public static List<UserLoginout> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
    
}

