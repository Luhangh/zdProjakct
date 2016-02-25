package com.zdsoft.utils;

import java.security.MessageDigest;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONException;
import org.json.JSONObject;
import android.content.ContentValues;
/**
 * 字符串辅助类 <br>
 * Description: <br>
 * Date: 2013-4-25 <br>
 * Copyright (c) 2011 LEYISoft <br>
 * 
 * @author wwy
 */
public class StringUtil {

	public static char split = 0x01;// 分隔符

	public static char feed = 0x0A;// 换行
	
	public static String KEY = "zgpg";
	/**
	 * 判断字符串是否为 null/空/无内容
	 * 
	 * @param str
	 * @return
	 * @author wwy
	 */
	public static boolean isBlank(String str) {
		if (null == str)
			return true;
		if ("".equals(str.trim()))
			return true;
		if(str.equals("null"))
             return true;
		return false;
	}

	/**
	 * 字符串相等 null和空字符串认为相等，忽略字符串前后空格
	 * 
	 * @param str1
	 * @param str2
	 * @return
	 * @author wwy
	 */
	public static boolean compareString(String str1, String str2) {
		if (null == str1) {
			str1 = "";
		}
		if (null == str2) {
			str2 = "";
		}
		if (str1.trim().equals(str2.trim())) {
			return true;
		}
		return false;
	}

	/**
	 * 将对象转成String
	 * 
	 * @param obj
	 * @return
	 */
	public static String toString(Object obj) {
		if (obj == null) {
			return "";
		}
		return obj.toString().trim();
	}

	public static String encodePassword(String password, String algorithm) {
		if (algorithm == null)
			return password;
		byte unencodedPassword[] = password.getBytes();
		MessageDigest md = null;
		try {
			md = MessageDigest.getInstance(algorithm);
		} catch (Exception e) {
			return password;
		}
		md.reset();
		md.update(unencodedPassword);
		byte encodedPassword[] = md.digest();
		StringBuffer buf = new StringBuffer();
		for (int i = 0; i < encodedPassword.length; i++) {
			if ((encodedPassword[i] & 0xff) < 16)
				buf.append("0");
			buf.append(Long.toString(encodedPassword[i] & 0xff, 16));
		}
		return buf.toString();
	}

	public static String getEncryptPassword(String password) {
		try {
			//return Des.encrypt(password, KEY);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return password;
	}
	
	public static String getEncryptPasswordMD5(String password) {
		return encodePassword(password, "MD5");
	}

	/**
	 * 获取json节点值
	 * 
	 * @param jsonObject
	 * @param jsonNode
	 * @return
	 */
	public static String getJSONObject(JSONObject jsonObject, String jsonNode) {
		try {

			if (jsonObject.has(jsonNode))
				return jsonObject.get(jsonNode).toString();
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return "";
	}
	
	public static JSONObject getJSONNode(JSONObject jsonObject, String jsonNode) {
		try {
			if (jsonObject.has(jsonNode))
				return jsonObject.getJSONObject(jsonNode);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * 像数据库插入字段
	 */
	public static ContentValues pubValues(ContentValues values, String cloumn, String str_value) {
		if (str_value != null) {
			values.put(cloumn, str_value);
		}
		return values;
	}

	/**
	 * 字符串转整数
	 * 
	 * @param l_ser
	 * @return
	 */

	public static int strToInt(String l_ser) {
		int covs = 0;
		try {
			covs = new Integer(l_ser);
		} catch (Exception e) {
		}
		return covs;
	}

	/**
	 * 字符串转double
	 * 
	 * @param gis
	 * @return
	 */

	public static double strToDouble(String gis) {
		double covs = 0d;
		try {
			covs = new Double(gis).doubleValue();
		} catch (Exception e) {
		}
		return covs;
	}

	/**
	 * 字符串转long
	 * 
	 * @param time
	 * @return
	 */

	public static long strToLong(String time) {
		long covs = 0l;
		try {
			covs = new Long(time).longValue();
		} catch (Exception e) {
		}
		return covs;
	}

	/**
	 * 验证手机电话号码
	 * 
	 * 手机号码 移动：134[0-8],135,136,137,138,139,150,151,157,158,159,182,187,188
	 * 联通：130,131,132,152,155,156,185,186 电信：133,1349,153,180,189
	 * 
	 * @param Mobilephone需要验证的手机号码
	 * @return
	 */
	public static boolean checkMobilephone(String mobilephone) {
		String cm = "^1(34[0-8]|(3[5-9]|5[017-9]|8[278]|7[0-9])\\d)\\d{7}$";// 中国移动正则
		String cu = "^1(3[0-2]|5[256]|8[56])\\d{8}$";// 中国联通正则
		String ct = "^1((33|53|8[09])[0-9]|349)\\d{7}$";// 中国电信正则
		if (Pattern.matches(cm, mobilephone) || Pattern.matches(cu, mobilephone) || Pattern.matches(ct, mobilephone)) {
			return true;
		}
		return false;
	}

	public static boolean isIDcard(String text) {
		String regx = "[0-9]{17}x";
		String reg1 = "[0-9]{15}";
		String regex = "[0-9]{18}";
		return text.matches(regx) || text.matches(reg1) || text.matches(regex);
	}
	
	
	/**
	 * 返回原型图
	 * @param thumbnial
	 * @return
	 */
	public static String convertPrototype(String thumbnial) {
		try {
			if (null == thumbnial) return "";
			return (new StringBuilder()).append(
					thumbnial.substring(0, thumbnial.lastIndexOf('.'))).append("_prototype")
						.append(thumbnial.substring(thumbnial.lastIndexOf('.'))).toString();
		} catch (Exception e) {
			 return thumbnial;
		}
	}

	/**
	 * 将多个对象进行组装<br>
	 * 
	 * @param parts
	 * @return
	 * @author wwy
	 */
	// public static String assemblingString(Object... parts) {
	// StringBuilder builder = new StringBuilder();
	// if (CollectionUtil.isEmpty(parts)) {
	// return null;
	// }
	// for (Object part : parts) {
	// if(part == null){
	// part = Constant.EMPTY_STRING;
	// }
	// builder.append(part);
	// }
	// return builder.toString();
	// }
	/**
	 * 转化时间字符转
	 * 类型：\/Date(1395396358000)\/
	 * */
	public static String date(String date){
		String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？Date]";   
		try {
			
			if(null==date||date.equals("")){
				return "";
			}else{
				
				 Pattern   p   =   Pattern.compile(regEx);      
				 Matcher   m   =   p.matcher(date);
				 System.out.println(m.replaceAll(""));
				 SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
				 String sd = sdf.format(new Date(Long.parseLong(m.replaceAll("").trim())));				 
				 return sd;
				 
			}
			   
			
		} catch (Exception e) {
			return "";
		}	
		
	}
	
	/**
	 * 是否包含特殊字符
	 * */
	public static boolean containsAny(String str){
		
		String regEx="[`~!@#$%^&*()+=|{}':;',//[//].<>/?~！@#￥%……&*（）——+|{}【】‘；：”“’。，、？]"; 
		
		//System.out.println("++++++++++++++++++++++++++++++++"+str.contains(regEx));
        if(str!=null){
        	Pattern p= Pattern.compile(regEx, Pattern.CASE_INSENSITIVE);
    		Matcher m=p.matcher(str);
    		return m.find();
        }else{
        	return false;
        }
		
	}
  public static boolean isCardId(String str){
	  if(str!=null&&!str.equals("")){
		  Pattern idNumPattern = Pattern.compile("(\\d{14}[0-9a-zA-Z])|(\\d{17}[0-9a-zA-Z])"); 
			Matcher idNumMatcher = idNumPattern.matcher(str);
			return idNumMatcher.matches(); 
	  }else{
		  return false;
	  }
	  
		
  }
  /** 
   * 半角转换为全角 
   *  
   * @param input 
   * @return 
   */  
  public static String ToDBC(String input) {  
      char[] c = input.toCharArray();  
      for (int i = 0; i < c.length; i++) {  
          if (c[i] == 12288) {  
              c[i] = (char) 32;  
              continue;  
          }  
          if (c[i] > 65280 && c[i] < 65375)  
        	  
              c[i] = (char) (c[i] - 65248);  
      }  
      return new String(c);  
  }  
    
  
}

