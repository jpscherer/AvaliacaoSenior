package executer;

import java.util.List;

import businessLayer.CityHandler;
import dataLayer.City;

public class Test {

	public static void main(String[] args) {
		System.out.println("Start");
		CityHandler handler = new CityHandler();		
	
		System.out.println("Instanced");
		
		/*List<City> lista = handler.ReadAll();
		for(City a : lista){
			System.out.println(a.getIbge_id());
		}*/
		
		/*City city = handler.ReadByIBGEId(1400407);
		System.out.println(city.getUf());*/
		
		//System.out.println(handler.StateWithHigherQtdOfCities());
		//System.out.println(handler.StateWithLowerQtdOfCities());
		handler.HigherDistance();
		
		System.out.println("Finish");
	}

}
