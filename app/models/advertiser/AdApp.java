package models.advertiser;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class AdApp extends Model {

	public String icon;  //	图标
	@Required	
	public String appname;  //	App名称

	public String URLandroid;  //	连接地址	android/ios两个
	public String URLios;  //	至少一个不为空	
	public String onlinetime;  //	上架时间	不填立即上架
	public String offlinetime;  //	下架时间	删除此字段
	public String state;  //	状态	活跃，冻结，未上架
	public Integer sortnumber;  //	排序	管理界面按次排序
	public String tagids;  //	标签ID	
	@Required	
	public long advertiserid;  //	广告商id
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public AdApp( String appname,long advertiserid) {
		this.appname = appname;
		this.advertiserid = advertiserid;
        create();
    }
	
    //根据 appname 查找
	public static List<AdApp> findByAppname(String appname) {
        return find("appname", appname).fetch(50);
    }

    //根据 advertiserid 查找
	public static List<AdApp> findByAdvertiserid(long advertiserid) {
        return find("advertiserid", advertiserid).fetch(50);
    }	

    
}

