package models.advertiser;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Advertiser extends Model {

	@Required
	public String logname;  //	登录名		
	public String companyname;  //	广告商(公司)名称		
	public String owner;  //	负责人真名名称		
	public String telphone;  //	电话		
	public String tradeareaids;  //	商圈ids	逗号分隔	1,2,22
	public String adtypeids;  //	广告类型ids	逗号分隔	1,2,3
	public String adperiods;  //	广告时段s	逗号分隔	0-6,11-13,22-4
	public String creator;  //	创建者		
	public String createtime;  //	创建时间		
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Advertiser( String logname) {
        this.logname = logname;
        create();
    }

	
    //根据 logname 查找
	public static List<Advertiser> findByLogname(String logname) {
        return find("logname", logname).fetch(50);
    }

    //根据 companyname 查找
	public static List<Advertiser> findByCompanyname(String companyname) {
        return find("companyname", companyname).fetch(50);
    }
    
}

