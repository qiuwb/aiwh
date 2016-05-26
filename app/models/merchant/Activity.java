package models.merchant;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Activity extends Model {

	public String isspecialtopic;  //	是否专题	
	public String iconURI;  //	图标	
	@Required
	public String title;  //	标题	
	public String briefintro;  //	活动简介	
	public String maintext;  //	活动正文	
	public String picURI;  //	海报	
	public String videoURL;  //	视频地址	
	public String createtime;  //	上传时间	
	public Integer praisecount;  //	点赞次数	
	public Integer sortnumber;  //	排序	
       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Activity( String title) {
        this.title = title;
        create();
    }
    
    //根据 logname 查找
	public static Activity findByLogname(String title) {
        return find("title", title).first();
    }


    
}

