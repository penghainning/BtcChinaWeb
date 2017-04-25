package config;



import com.jfinal.config.Routes;

import Controller.IndexController;


/**
 * 此类为前端转路由 
 *
 */
public class FrontRoutes extends Routes {
	
	private final String INDEX_PAGE = "/page";                 //首页
 
	 
	@Override
	public void config() {
		
		
		add("/",IndexController.class,INDEX_PAGE);          //首页
		

	}

}
