package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class activitySignup extends Model {

	@Required
	public long activityid;  //	活动id	
	@Required
	public String logname;  //	用户注册手机	
	public String state;  //	报名状态	0已经报名，1取消报名
	public String saysth;  //	参赛宣言	
	
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public activitySignup( long activityid,String logname) {
        this.activityid = activityid;
		this.logname = logname;
        create();
    }
    
    //根据 activityid 查找
	public static List<activitySignup> findByActivityid(long activityid) {
        return find("activityid", activityid).fetch(50);
    }
	
    //根据 logname 查找
	public static List<activitySignup> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }


    
}

