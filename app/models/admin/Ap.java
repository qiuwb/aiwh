package models.admin;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Ap extends Model {
	@Required		
	public String apmac;  //	APMAC		
	public String apname;  //	APName		
	public float longitude;  //	经度		可选
	public float latitude;  //	纬度		可选
	public long tradeareaid;  //	所属商圈ID		
	
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Ap( String apmac) {
		this.apmac = apmac;
        create();
    }
	
    //根据 apmac 查找
	public static List<Ap> findByApmac(String apmac) {
        return find("apmac", apmac).fetch(50);
    }	

    //根据 op 查找
	public static List<Ap> findByOp(String op) {
        return find("op", op).fetch(50);
    }		
    
}

