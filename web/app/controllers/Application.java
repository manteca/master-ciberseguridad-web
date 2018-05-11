package controllers;

import models.Constants;
import models.User;
import play.i18n.Messages;
import play.mvc.*;

import java.util.List;

public class Application extends Controller {

    private static boolean checkTeacher(){
        checkUser();

        User u = (User) renderArgs.get("user");
        if (u.getType().equals(Constants.User.TEACHER)){
            return true;
        }
        return false;
    }

    private static void checkUser(){
        if (session.contains("username")){
            User u = User.loadUser(session.get("username"));
            if (u != null){
                renderArgs.put("user", u);
                return;
            }
        }
        Secure.login();
    }

    public static void index() {
        checkUser();

        User u = (User) renderArgs.get("user");

        if (u.getType().equals(Constants.User.TEACHER)){
            List<User> students = User.loadStudents();
            render("Application/teacher.html", u, students);
        }else{
            render("Application/student.html", u);
        }
    }


    public static void removeStudent(String student) {
        if(checkTeacher()){
          User.remove(student);
          index();
        }
        flash.put("error", Messages.get("Public.validation.wrong.teacher"));
        index();
    }


    public static void setMark(String student) {

        if(checkTeacher()){
          User u = User.loadUser(student);
          render(u);
        }
        flash.put("error", Messages.get("Public.validation.wrong.teacher"));
        index();
    }

    public static void doSetMark(String student, Integer mark) {
        if(checkTeacher()){
          User u = User.loadUser(student);
          u.setMark(mark);
          u.save();
          index();
        }
        flash.put("error", Messages.get("Public.validation.wrong.teacher"));
        index();
    }
}
