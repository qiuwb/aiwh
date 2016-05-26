package models.sysfunc;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Tag extends Model {

	@Required	
	public long moduleid;  //	系统模块id	类似这样的：1广告，2商品，3优惠券，4APP，5电商，6活动	以表数据为准
	public String tagname;  //	标签名	比如：生活,家电,旅游,数码等	

	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Tag( long moduleid,String tagname) {
        this.moduleid = moduleid;
		this.tagname = tagname;
        create();
    }
    
	public static Tag findByTagname(String tagname) {
        return find("tagname", tagname).first();
    }

}

