package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class UserActionLog extends Model {
	
	@Required	
	public String logname;  //	用户名	和用户信息表关联，或者userid?	
	public String moduletypeid;  //	模块类型	广告，商户，优惠券，APP，电商，活动	
	public String moduleid;  //	模块ID	具体的操作模块的ID. 每类型中有多个不同实例，如广告有5个	
	public String objectid;  //	具体操作的对象	如广告id，或app-id,优惠券id,活动id	
	public String ownerid;  //	广告商或商户家id		
	public String tagid;  //	分类ID	属性标签（由超级管理员定义，上传时选择）	
	public Integer count;  //	次数	可能是一个小时3次这样的，然后一次性传过来	
	public String time;  //	操作时间	app的时间	

	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public UserActionLog( String logname) {
		this.logname = logname;
        create();
    }
	
    //根据 logname 查找
	public static List<UserActionLog> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
    
}

