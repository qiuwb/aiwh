package models;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class BizManOpLog extends Model {
	@Required
	public String managertypeid;  //	管理员类型	2商户	3服务员
	@Required
	public String managerid;  //	操作者		
	public String sysmoduleid;  //	操作模块	类似：1广告,2商品,3优惠券,4APP,5商户,6活动,11管理员管理,12商户管理,13用户管理,	
	public String opobjectid;  //	操作对象id		
	@Required
	public String op;  //	操作	未分类整理，先直接写操作名吧，，对于广告有（增，删，改，上架，下架，扣分，加分），优惠券有（制作，上架，下架，停止兑换，领取，激活）	
//	public String optime;  //	操作的时间	now	

	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public BizManOpLog(String managertypeid, String managerid,String op) {
		this.managertypeid = managertypeid;
		this.managerid = managerid;
		this.op = op;
        create();
    }
	
    //根据 managerid 查找 managertypeid ???
	public static List<BizManOpLog> findByManagerid(String managertypeid,String managerid) {
        return find("managerid", managerid).fetch(50);
    }	

    //根据 op 查找
	public static List<BizManOpLog> findByOp(String op) {
        return find("op", op).fetch(50);
    }		
    
}

