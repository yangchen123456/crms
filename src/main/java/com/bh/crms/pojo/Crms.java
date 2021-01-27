package com.bh.crms.pojo;

import java.util.Date;

public class Crms {
     private String cid; //客户id
     private String cname; // 客户姓名
     private String gender; // 客户性别
     private Date birthday; // 客户生日
     private String cellphone; // 客户电话
     private String email; // 客户邮箱
     private String description;// 客户描述

     public String getCid() {
          return cid;
     }

     public void setCid(String cid) {
          this.cid = cid;
     }

     public String getCname() {
          return cname;
     }

     public void setCname(String cname) {
          this.cname = cname;
     }

     public String getGender() {
          return gender;
     }

     public void setGender(String gender) {
          this.gender = gender;
     }

     public Date getBirthday() {
          return birthday;
     }

     public void setBirthday(Date birthday) {
          this.birthday = birthday;
     }

     public String getCellphone() {
          return cellphone;
     }

     public void setCellphone(String cellphone) {
          this.cellphone = cellphone;
     }

     public String getEmail() {
          return email;
     }

     public void setEmail(String email) {
          this.email = email;
     }

     public String getDescription() {
          return description;
     }

     public void setDescription(String description) {
          this.description = description;
     }

     public Crms(String cid, String cname, String gender, Date birthday, String cellphone, String email, String description) {
          this.cid = cid;
          this.cname = cname;
          this.gender = gender;
          this.birthday = birthday;
          this.cellphone = cellphone;
          this.email = email;
          this.description = description;
     }
     public Crms(){

     }
}
