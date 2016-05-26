package models.sysfunc;
 
import play.jobs.*;
 
/*每天早上1：00执行*/
@On("0 0 1 * * ?") 
public class StatsJob extends Job {
    
    public void doJob() {
        // 执行一些业务逻辑
    }
}