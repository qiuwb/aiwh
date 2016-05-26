package models.admin;

import javax.persistence.*;
import java.util.*;

import play.*;
import play.db.jpa.*;
import play.libs.*;
import play.data.validation.*;

@Entity
public class Admin extends Model {

    //@Email
    //@Required
    //public String email;

    @Required
    public String logname;
	
	public String nickname;
	
    @Required
    public String passwordHash;//password
	
	public String contact;
	public String jobid;
	public Integer type;
	public String creator;
	public String creattime; //????
	public String moduleids;
	public String remark;
	public Integer state;//0冻结，1可用
	//public String needConfirmation; 
	public play.db.jpa.Blob photo; //二进制数据

       
    // ~~~~~~~~~~~~ 
    //构造，入库：
    public Admin( String password, String logname) {
        this.passwordHash = Codec.hexMD5(password);
        this.logname = logname;
        //this.needConfirmation = Codec.UUID();
        create();
    }
    
    // ~~~~~~~~~~~~ 
	//登录时进行密码比较
    public boolean checkPassword(String password) {
        return passwordHash.equals(Codec.hexMD5(password));
    }

    //超级管理员 or 普通管理员
	public boolean isSuperAdmin() {
        return type==0;//email.equals(Play.configuration.getProperty("forum.adminEmail", ""));
    }
    
    // ~~~~~~~~~~~~ 
    
    //public List<Post> getRecentsPosts() {
    //    return Post.find("postedBy = ? order by postedAt", this).fetch(1, 10);
    //}

    //得到所有孩子：
	public List<Admin> getChildren() {
        return Admin.find("creator = ? order by logname", this).fetch(1, 10);
    }
	//得到所有孩子数量：
    public Long getChildCount() {
        //return Post.count("postedBy", this);
		return Admin.count("creator", this);
    }

    //public Long getTopicsCount() {
    //    return Post.count("select count(distinct t) from Topic t, Post p, User u where p.postedBy = ?1 and p.topic = t", this);
    //}
    
    // ~~~~~~~~~~~~ 
    
    //根据 logname 查找
	public static Admin findByLogname(String logname) {
        return find("logname", logname).first();
    }


	
    //public static User findByRegistrationUUID(String uuid) {
     //   return find("needConfirmation", uuid).first();
    //}

    //翻到下一页
	public static List<Admin> findAll(int page, int pageSize) {
        return Admin.all().fetch(page, pageSize);
    }

    //电话是否已被占用了。
	public static boolean isLognameAvailable(String logname) {
        return findByLogname(logname) == null;
    }
    
}

