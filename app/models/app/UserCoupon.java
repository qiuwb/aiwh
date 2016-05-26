package models.app;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class UserCoupon extends Model {
	
	@Required	
	public String logname;  //	用户名 	和用户信息表关联		
	@Required
	public String couponid;  //	优惠券的ID	和优惠券表相关联	UUID或由商家-日期生成	
	public String couponstate;  //	优惠券的状态	未使用，已使用，过期，已冻结 		
	public String gettime;  //	领取日期			
	public String usetime;  //	使用日期			


	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public UserCoupon( String logname,String couponid) {
		this.logname = logname;
		this.couponid = couponid;
        create();
    }
	
    //根据 logname 查找
	public static List<UserCoupon> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }	
	
	public static List<UserCoupon> findByCouponid(String couponid) {
        return find("couponid", couponid).fetch(50);
    }		
    
}

