package models.govaffair;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class GovAffair extends Model {

	@Required	
	public String title;  //	标题		
	public String from;  //	来源		
	public String URI;  //	URI	引用链接，或者是本地文档存放位置。	
	public String managerid;  //	管理员ID	根据当前账号	
	public String state;  //	下架/上架	1上架，0下架	
	public String istop;  //	置顶		
	public String type;  //	类型	0自主类，1引用类	
//	public String time;  //	文章创建或修改时间		
	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public GovAffair( String title) {
        this.title = title;
        create();
    }
    
	public static GovAffair findByTitle(String title) {
        return find("title", title).first();
    }

}

