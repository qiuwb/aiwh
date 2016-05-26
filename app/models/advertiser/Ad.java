package models.advertiser;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Ad extends Model {

	@Required	
	public long adtypeid;  //	广告类型ID	
	public String tradeareaids;  //	所属商圈	多个？
	@Required
	public String adname;  //	广告名称	
	public String peroids;  //	时段	多个？
	public String adURL;  //	链接地址	外部页面
	public String posterURL;  //	海报链接	这两个URL有何不同??
	public String admaintext;  //	正文	编辑器
	public String state;  //	审核状态：	0草稿；1提交审核；2已审核-失败(回到草稿）；3已审核-成功，4上架；5下架
	public String tagids;  //	标签	逗号分隔
	public Integer clickcount;  //	点击次数	
	@Required
	public long advertiserid;  //	广告商id

	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Ad( long adtypeid,String adname,long advertiserid) {
        this.adtypeid = adtypeid;
		this.adname = adname;
		this.advertiserid = advertiserid;
        create();
    }
    
    //根据 adtypeid 查找
	public static List<Ad> findByAdtypeid(long adtypeid) {
        return find("adtypeid", adtypeid).fetch(50);
    }
	
    //根据 adname 查找
	public static List<Ad> findByAdname(String adname) {
        return find("adname", adname).fetch(50);
    }

    //根据 advertiserid 查找
	public static List<Ad> findByAdvertiserid(long advertiserid) {
        return find("advertiserid", advertiserid).fetch(50);
    }	

    
}

