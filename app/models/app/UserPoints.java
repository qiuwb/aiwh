package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class UserPoints extends Model {
	
	@Required	
	public String logname;  //	用户名	和用户信息表关联
	@Required
	public Integer pointschange;  //	积分的数量	正数为增，负数为减(qq操作数)

	public String opreason;  //	日志的使用/领取说明	
	public String optime;  //	时间	
	public String oper;  //	操作人	
	public Integer afterpoints;  //	操作后积分数量	qqadd
		


	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public UserPoints( String logname,Integer pointschange) {
		this.logname = logname;
		this.pointschange = pointschange;
        create();
    }
	
    //根据 logname 查找
	public static List<UserPoints> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
    
}

