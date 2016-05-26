package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Goods extends Model {

	@Required	
	public String merchantid;  //	商户ID		
	@Required
	public String name;  //	商品名称		
	public String briefintro;  //	简介		
	public String detailinfo;  //	详细资料	编辑器	
	public String state;  //	发布的状态：上架下架		
	public float discount;  //	商品折扣	数值，一位小数	如9.5折
	public String pics;  //	商品图片1		
	public String tagids;  //	标签ID		
	public Integer sortnumber;  //	顺序		
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Goods( String merchantid,String name) {
        this.merchantid = merchantid;
		this.name = name;
        create();
    }
    
	public static List<Goods> findByMerchantid(String merchantid) {
        return find("merchantid", merchantid).fetch(50);
    }
	

	public static Goods findByName(String name) {
        return find("name", name).first();
    }

}

