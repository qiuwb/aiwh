package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Coupon extends Model {

	@Required	
	public String merchantid;  //	商户ID	
	@Required
	public String serialnumber;  //	优惠卷编号	最好带上商户ID便于识别
	@Required
	public String name;  //	优惠卷名称	
	public Integer money;  //	优惠金额	
	public String dateline;  //	有效期	截止到日期
	public Integer totalcount;  //	优惠卷数量	总数
	public Integer remaincount;  //	剩余数量	用户通过用积分领取优惠券后，减1.
	public Integer ausermaxcount;  //	发放条件	同一用户可领取最大张数
	public Integer auserminpoint;  //		同一用户满多少积分才可领取
	public String state;  //	状态	草稿，上架，冻结，下架
	public String remark;  //	备注	
	public String offlineremark;  //	下架说明	
	public String stopexchangeremark;  //	停止兑换说明	
	public String tagids;  //	标签	逗号分隔??
	public String type;  //	优惠券类型	0优惠券（折扣券）,1页面折扣

       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Coupon( String merchantid,String serialnumber,String name) {
        this.merchantid = merchantid;
		this.serialnumber = serialnumber;
		this.name = name;
        create();
    }
    
	public static Coupon findByMerchantid(String merchantid) {
        return find("merchantid", merchantid).first();
    }
	
    //根据 name 查找
	public static Coupon findByName(String name) {
        return find("name", name).first();
    }


	
	public static Coupon findBySerialnumber(String serialnumber) {
        return find("serialnumber", serialnumber).first();
    }	
    
}

