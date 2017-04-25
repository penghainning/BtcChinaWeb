package config;


import com.jfinal.config.Routes;

import Controller.HelloController;
import Controller.UserController;


public class AdminRoutes extends Routes {

	
	/**
	 * 后端路由禁止仅仅使用"/"作为路由转发
	 *  所有后端返回的errorCode：0表示未登陆
	 */
	@Override
	public void config() {
		
		
		
		/**
		 * 测试
		 */
		add("/hello",HelloController.class);
		add("/user",UserController.class);
	
		
	}

}
