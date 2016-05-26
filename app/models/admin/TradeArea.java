package models.admin;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class TradeArea extends Model {
	@Required		
	public String name;  //	
	@Required
	public double left;  //	左经度,小
	@Required
	public double right;  //	右经度，大
	@Required
	public double top;  //	上纬度，大
	@Required
	public double bottom;  //	下纬度，小
	
	
	
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public TradeArea( String name,double left,double right,double top,double bottom) {
		this.name = name;
		this.left = left;
		this.right = right;
		this.top = top;
		this.bottom = bottom;
		
        create();
    }
	
    //根据 name 查找
	public static List<TradeArea> findByName(String name) {
        return find("name", name).fetch(50);
    }	
   
}

