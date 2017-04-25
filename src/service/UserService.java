package service;

import java.util.HashMap;
import java.util.Map;

import com.jfinal.plugin.activerecord.Db;
import com.jfinal.plugin.activerecord.Record;

import constant.JsqName;
import util.CheckFormat;
import util.JsqResult;
import util.MD5;

public class UserService {

		//登录接口
		public static Map<String,Object>  login(String account,String password){
			HashMap<String,Object> map=new HashMap<String, Object>();
			try{
				String safePassword=MD5.MD5Encode(password);
				String SQL = "SELECT * FROM "
							+ JsqName.TABLE_USER 
							+" WHERE account = ? and password= ? and state = '1'";
				//System.out.println(safePassword);
				Record record=Db.findFirst(SQL,new Object[]{account,safePassword});
				if(record!=null){
			         map.put("id", record.get("id"));
			         map.put("name", record.get("name"));//昵称
			         map.put("role", record.get("role"));//权限
			         map.put("account", record.get("account"));//账号
			         map.put("error", "");
			         map.put("result", true);
				}
					
				else{
			        map.put("error", "用户名或密码错误");
			        map.put("result", false);
				}
			}catch(Exception e){
				e.printStackTrace();
				return JsqResult.returnFail();
			}
			return map;		
		}
		
		//登录接口
		public static Map<String,Object>  regesit(String account,String password,String name){
			try{
				if(CheckFormat.isNull(account)){
					return JsqResult.returnFail("账号不能为空");
				}
				if(CheckFormat.isNull(password)){
					return JsqResult.returnFail("密码不能为空");
				}
				if(CheckFormat.isNull(name)){
					return JsqResult.returnFail("昵称不能为空");
				}
				Record r=new Record();
				r.set("account", account);
				r.set("password", MD5.MD5Encode(password));
				r.set("name", name);
				r.set("state", 1);
				r.set("role", 0);
				Db.use(JsqName.TABLE_DATABASE).save(JsqName.TABLE_USER, r);
				return JsqResult.returnSuccess();
			}catch(Exception e){
				e.printStackTrace();
				return JsqResult.returnFail();
			}

		}
		
		//登录接口
		public static Map<String,Object>  getValue(int id){
			HashMap<String,Object> map=new HashMap<String, Object>();
			try{
				String SQL = "SELECT * FROM "
							+ "`warm_value`" 
							+" WHERE userid = ? ";
				//System.out.println(safePassword);
				Record record=Db.findFirst(SQL,id);
				if(record!=null){
			         map.put("id", record.get("id"));
			         if(id==1){
			        	 map.put("name", "PHN");
			         }else
			        	 map.put("name", "LHT");
			         map.put("EtcHighValue", record.get("etc_high_value"));
			         map.put("EthHighValue", record.get("eth_high_value"));
			         map.put("LtcHighValue", record.get("ltc_high_value"));
			         map.put("EtcLowValue", record.get("etc_low_value"));
			         map.put("EthLowValue", record.get("eth_low_value"));
			         map.put("LtcLowValue", record.get("ltc_low_value"));
				}
					
				else{
			        map.put("error", "无信息");
			        map.put("result", false);
				}
			}catch(Exception e){
				e.printStackTrace();
				return JsqResult.returnFail();
			}
			return map;		
		}
		//更改valued接口
		public static Map<String,Object>  ChangeValue(String etcLowValue,String ethLowValue,String ltcLowValue,String etcHighValue,String ethHighValue,String ltcHighValue,int id){
			try{
				if(CheckFormat.isNull(etcLowValue)){
					return JsqResult.returnFail("etc最低值不能为空");
				}
				if(CheckFormat.isNull(ethLowValue)){
					return JsqResult.returnFail("eth最低值不能为空");
				}
				if(CheckFormat.isNull(ltcLowValue)){
					return JsqResult.returnFail("ltc最低值不能为空");
				}
				if(CheckFormat.isNull(etcHighValue)){
					return JsqResult.returnFail("etc最高值不能为空");
				}
				if(CheckFormat.isNull(ethHighValue)){
					return JsqResult.returnFail("eth最高值不能为空");
				}
				if(CheckFormat.isNull(ltcHighValue)){
					return JsqResult.returnFail("ltc最高值不能为空");
				}
				String sql="Update `warm_value` set etc_high_value = '"
						+ Double.valueOf(etcHighValue)
						+ "' , eth_high_value= '"
						+ Double.valueOf(ethHighValue)
						+ "' , ltc_high_value = '"
						+ Double.valueOf(ltcHighValue)
						+ "' , etc_low_value= '"
						+ Double.valueOf(etcLowValue)
						+ "' , eth_low_value = '"
						+ Double.valueOf(ethLowValue)
						+ "' , ltc_low_value = '"
						+ Double.valueOf(ltcLowValue)
						+ "' where userid = '"
						+ id
						+"'";
				//System.out.println(sql);
				Db.use(JsqName.TABLE_DATABASE).update(sql);
				return JsqResult.returnSuccess();
			}catch(NumberFormatException e){
				e.printStackTrace();
				return JsqResult.returnFail("数值的格式不正确！应该为小数");
			}

		}
	
}
