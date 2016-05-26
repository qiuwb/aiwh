package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class UserTagSum extends Model {
	
	@Required	
	public String logname;  //	用户名	和用户信息表关联	
	@Required
	public Integer moduletypeid;  //	模块类型	广告，商户，优惠券，APP，电商，活动	
	@Required
	public Integer tagid;  //	分类ID	属性标签（由超级管理员定义，上传时选择）	
	public Integer count;  //	次数		
	public String time;  //	操作时间	app的时间	



	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public UserTagSum( String logname,Integer moduletypeid) {
		this.logname = logname;
		this.moduletypeid = moduletypeid;
        create();
    }
	
    //根据 logname 查找
	public static List<UserTagSum> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
    
}

