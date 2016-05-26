package controllers.admin;

import play.*;
import play.libs.Images;
import play.mvc.*;

import java.util.*;

import models.*;

public class Login extends Controller {

    public static void index() {
        render();
    }

	public static void captcha(){
	    Images.Captcha captcha=Images.captcha(); 
	    renderBinary(captcha);
	}
}