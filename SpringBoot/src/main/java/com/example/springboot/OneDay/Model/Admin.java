package com.example.springboot.OneDay.Model;

import com.example.springboot.Base.FonctionBase;

import java.util.Vector;

public class Admin {
    long idAdmin;
    String login;
    String pwd;

    public Admin(String login, String pwd) {
        this.login = login;
        this.pwd = pwd;
    }

    public Admin() {
    }

    public long getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(long idAdmin) {
        this.idAdmin = idAdmin;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
    public static Admin log(String login,String pwd) throws Exception {
        String sql="select idAdmin from admin where login='%s' and pwd='%s'";
        sql=String.format(sql,login,pwd);
        Vector<Object>[]all=FonctionBase.select(sql);
        for (int i = 0; i <all[0].size() ; i++) {
            Admin admin=new Admin();
            admin.setIdAdmin(Long.parseLong(all[0].elementAt(i).toString()));
            admin.setLogin(login);
            admin.setPwd(pwd);
            return admin;
        }
        return null;
    }
}
