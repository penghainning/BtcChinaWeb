package Controller;
import com.jfinal.core.Controller;

import service.UserService;
import util.JsqResult;
public class UserController extends Controller{

	/*
	 * 登录
	 * 
	 * */
	public void login(){
		try{
			String account = getPara("account")==null?"":getPara("account");
			String password = getPara("password")==null?"":getPara("password");
			renderJson(UserService.login(account,password));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	/*
	 * 登录
	 * 
	 * */
	public void regesit(){
		try{
			String account = getPara("account");
			String password = getPara("password");
			String name = getPara("name");
			renderJson(UserService.regesit(account, password, name));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
	/*
	 * 改值
	 * 
	 * */
	public void htChangeValue(){
		try{
			String etcLowValue = getPara("etcLowValue");
			String ethLowValue = getPara("ethLowValue");
			String ltcLowValue = getPara("ltcLowValue");
			String etcHighValue = getPara("etcHighValue");
			String ethHighValue = getPara("ethHighValue");
			String ltcHighValue = getPara("ltcHighValue");
			renderJson(UserService.ChangeValue(etcLowValue, ethLowValue, ltcLowValue, etcHighValue, ethHighValue, ltcHighValue, 2));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
	
	/*
	 * 取值
	 * 
	 * */
	public void htGetValue(){
		try{
			renderJson(UserService.getValue(2));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
	
	public void hnChangeValue(){
		try{
			String etcLowValue = getPara("etcLowValue");
			String ethLowValue = getPara("ethLowValue");
			String ltcLowValue = getPara("ltcLowValue");
			String etcHighValue = getPara("etcHighValue");
			String ethHighValue = getPara("ethHighValue");
			String ltcHighValue = getPara("ltcHighValue");
			renderJson(UserService.ChangeValue(etcLowValue, ethLowValue, ltcLowValue, etcHighValue, ethHighValue, ltcHighValue, 1));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
	public void hnGetValue(){
		try{
			renderJson(UserService.getValue(1));
		}catch(Exception e){
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
	

}
