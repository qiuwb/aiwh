package models.advertiser;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class AdType extends Model {

	@Required
	public String typename;  //	广告模块名称	闪屏，轮播期，4:3 ，5:1等等多种形式的广告
	public Integer length;  //	广告长	
	public Integer width;  //	广告宽	
	public String state;  //	是否可用	只是个模板，为什么不可用?
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public AdType( String typename) {
		this.typename = typename;
        create();
    }
	
    //根据 typename 查找
	public static List<AdType> findByTypename(String typename) {
        return find("typename", typename).fetch(50);
    }	

    
}

