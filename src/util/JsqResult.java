package util;

import java.util.HashMap;
import java.util.Map;

public class JsqResult {

	
	//通用失败情况的返回
	public static Map<String,Object> returnFail(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("result", false);
		map.put("error", "System Error");
		return map;
	}
	//通用失败情况的返回
	public static Map<String,Object> returnFail(String error){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("result", false);
		map.put("error", error);
		return map;
	}
	
	//通用成功情况的返回
	public static Map<String,Object> returnSuccess(){
		Map<String,Object> map=new HashMap<String, Object>();
		map.put("result", true);
		map.put("error", "");
		return map;
	}
}
