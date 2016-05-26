package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class ActivityPraise extends Model {

	@Required
	public String activityid;  //	活动id
	@Required
	public String logname;  //	用户注册手机
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public ActivityPraise( String activityid,String logname) {
        this.activityid = activityid;
		this.logname = logname;
        create();
    }
    
    //根据 activityid 查找
	public static List<ActivityPraise> findByActivityid(String activityid) {
        return find("activityid", activityid).fetch(50);
    }
	
    //根据 logname 查找
	public static List<ActivityPraise> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }


    
}

