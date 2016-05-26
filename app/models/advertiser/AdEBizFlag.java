package models.advertiser;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class AdEBizFlag extends Model {

	@Required	
	public String icon;  //	广告的链接图标		
	public String ownername;  //	电商名称		这个还要么？Logname/nickname?
	@Required
	public String URL;  //	连接地址	电商提供的URL	
	public String onlinetime;  //	上架时间	不填立即上架	
	public String offlinetime;  //	下架时间	不填永不下架	
	public String merchantstate;  //	电商状态	活跃，冻结，未上架	这个还要么？
	public Integer sortnumber;  //	排序	管理界面按次排序	
	public String tagids;  //	标签ID	应该是多个标签吧??	
	@Required
	public long advertiserid;  //	广告商id

	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public AdEBizFlag( String icon,String URL,long advertiserid) {
		this.icon = icon;
		this.URL = URL;
		this.advertiserid = advertiserid;
        create();
    }
	
    //根据 advertiserid 查找
	public static List<AdEBizFlag> findByAdvertiserid(long advertiserid) {
        return find("advertiserid", advertiserid).fetch(50);
    }	

    
}

