package models.govaffair;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class GovAffairMgr extends Model {

	@Required	
	public String logname;  //	登录名
	public String nickname;  //	昵称
	public String creator;  //	创建者
	public String createtime;  //	创建时间
	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public GovAffairMgr( String logname) {
        this.logname = logname;
        create();
    }
    
	public static GovAffairMgr findByLogname(String logname) {
        return find("logname", logname).first();
    }

}

