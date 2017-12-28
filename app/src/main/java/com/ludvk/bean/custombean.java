package com.ludvk.bean;

import java.io.Serializable;

import android.os.Parcel;
import android.os.Parcelable;


public class custombean implements Parcelable{
	
	public String qq;
	public String phone;
	public String city;
	public String sex;
	public String wrokname;
	public String times;
	public String froms;
	public String other;
	public String id;
	public String name;
	public String adress;
	public String info;
	
	public custombean() {  
	    }  
	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getWrokname() {
		return wrokname;
	}

	public void setWrokname(String wrokname) {
		this.wrokname = wrokname;
	}

	public String getFroms() {
		return froms;
	}

	public void setFroms(String froms) {
		this.froms = froms;
	}

	public String getOther() {
		return other;
	}

	public void setOther(String other) {
		this.other = other;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	
	public String getTimes() {
		return times;
	}

	public void setTimes(String times) {
		this.times = times;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	@Override
	public int describeContents() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public void writeToParcel(Parcel dest, int flags) {
		// TODO Auto-generated method stub
		 dest.writeString(name); 
		 dest.writeString(qq); 
		 dest.writeString(sex); 
		 dest.writeString(adress); 
		 dest.writeString(wrokname); 
		 dest.writeString(other); 
		 dest.writeString(info); 
		 dest.writeString(phone); 
		 dest.writeString(city); 
		 dest.writeString(froms); 		 
	}
	
	protected custombean(Parcel in) {  
        name = in.readString();  
         qq=in.readString();
         sex=in.readString();
         adress=in.readString();
         wrokname=in.readString();
         other=in.readString();
         info=in.readString();
         phone=in.readString();
         city=in.readString();
         froms=in.readString();
    }  
  
    public static final Creator<custombean> CREATOR = new Creator<custombean>() {  
        @Override  
        public custombean createFromParcel(Parcel in) {  
            return new custombean(in);  
        }  
  
        @Override  
        public custombean[] newArray(int size) {  
            return new custombean[size];  
        }  
    };  
}
