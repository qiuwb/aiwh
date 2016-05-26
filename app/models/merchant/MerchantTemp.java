package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class MerchantTemp extends Model {
	@Required	
	public String logname;  //	商户ID	
	@Required	
	public String password;  //	密码	
	public String nickname;  //	商户名称	登录账号
	public float longitude;  //	经度	
	public float latitude;  //	纬度	在地图上选择
	public Integer state;  //	商户的权限	活跃 1；冻结 0
	public String telphone;  //	商户电话	
	public String briefinfo;  //	商户简介	
	public String moreinfo;  //	商户的其他说明	
	public Integer score;  //	商户评分	
	public String mainpic;  //	商户展示图标	可以考虑存储在文件服务器中
	public String pic1;  //	图片一	
	public String pic2;  //	图片二	
	public String pic3;  //	图片三	
	public String pic4;  //	图片四	
	public String discountinfo;  //	全场折扣信息	可选
	public String havecoupon;  //	是否有可用的优惠券	
	public String tradeareaids;  //	管辖范围（商圈id列表）	主要是针对商户管理员和广告商.可以在哪些商圈进行活动。
	public String createtime;  //	注册时间	

	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public MerchantTemp( String logname,String password) {
        this.logname = logname;
		this.password = password;
        create();
    }
    
    //根据 logname 查找
	public static MerchantTemp findByLogname(String logname) {
        return find("logname", logname).first();
    }


    
}

