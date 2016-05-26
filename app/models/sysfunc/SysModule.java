package models.sysfunc;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class SysModule extends Model {

	@Required	
public String modulename;  //	模块名称
	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public SysModule( String modulename) {
        this.modulename = modulename;
        create();
    }
    
	public static SysModule findByModuleName(String modulename) {
        return find("modulename", modulename).first();
    }

}

