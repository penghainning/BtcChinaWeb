package Controller;
import java.io.IOException;
import java.util.HashMap;

import org.jsoup.Jsoup;

import com.jfinal.core.Controller;
import net.sf.json.JSONObject;
import util.JsqResult;
public class IndexController extends Controller{

	/**
	 * 首页
	 * @return void 
	 * @version 
	 * @throws Excetion
	 */
	public void index() {
		render("index.jsp");
	}
	
	public void htIndex() {
		render("ht_changepass.html");
	}
	
	public void hnIndex() {
		render("changepass.html");
	}
	
	public void getPrice(){
		 try {
			String etc = Jsoup.connect("http://api.chbtc.com/data/v1/ticker?currency=etc_cny")
					 	   .get().body().text();
			String ltc = Jsoup.connect("http://api.chbtc.com/data/v1/ticker?currency=ltc_cny")
				 	   .get()
				 	   .body().text();
			String eth = Jsoup.connect("http://api.chbtc.com/data/v1/ticker?currency=eth_cny")
				 	   .get()
				 	   .body().text();
			String etcPrice=JSONObject.fromObject(etc).getJSONObject("ticker").getString("last");
			String ethPrice=JSONObject.fromObject(eth).getJSONObject("ticker").getString("last");
			String ltcPrice=JSONObject.fromObject(ltc).getJSONObject("ticker").getString("last");
			HashMap<String,Object> map=new HashMap<String, Object>();
			map.put("ethPrice", ethPrice);
			map.put("etcPrice", etcPrice);
			map.put("ltcPrice", ltcPrice);
			renderJson(map);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			renderJson(JsqResult.returnFail());
		}
	}
	
}
