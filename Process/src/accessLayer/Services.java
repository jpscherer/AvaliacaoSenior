package accessLayer;

import java.util.List;

import businessLayer.CityHandler;
import dataLayer.City;

//import javax.ws.rs.GET;

public class Services {
	CityHandler handler = new CityHandler();
	
	public List<City> getAll(){
		return handler.ReadAll();
	}
	
	public City getByIBGEId(Integer pId){
		return handler.ReadByIBGEId(pId);
	}
	
	public List<City> getByUF(String pUF){
		return handler.ReadByState(pUF);
	}
}