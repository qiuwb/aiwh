package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class CouponUserGet extends Model {

	@Required	
	public String userid;  //	用户手机号码
	@Required
	public String couponid;  //	优惠卷ID
	//timestamp..public String time;  //	领取时间

       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public CouponUserGet( String userid,String couponid) {
        this.userid = userid;
		this.couponid = couponid;
        create();
    }
    
	public static CouponUserGet findByUserid(String userid) {
        return find("userid", userid).first();
    }
	

	public static CouponUserGet findByCouponid(String couponid) {
        return find("couponid", couponid).first();
    }

}

