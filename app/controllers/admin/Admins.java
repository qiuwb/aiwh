package controllers.admin;

import java.util.*;

import models.*;
import controllers.*;
import models.admin.*;

public class Admins extends Application {

    public static void AdminsListEdit(Integer page) {
        List admins = Admin.findAll(page == null ? 1 : page, 10);
        Long nbAdmins = Admin.count();
		renderArgs.put("qwb", "qqqqq");//往模板 AdminsListEdit.html 放入额外的变量  ${qwb}
        render(nbAdmins, admins, page);
    }

    public static void ShowOne(Long id) {
        Admin admin = Admin.findById(id);
        notFoundIfNull(admin);//Controller::  抛出 404 异常
        render(admin);
    }
}

