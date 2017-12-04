package executer;

import java.util.List;

import businessLayer.CityHandler;
import dataLayer.City;

public class Test {

	public static void main(String[] args) {
		System.out.println("Start");
		
		CityHandler handler = new CityHandler();
		System.out.println("Instanced");
		List<City> lista = handler.ReadAll();
		
		for(City a : lista){
			System.out.println(a.getName());
		}
		
		
		System.out.println("Finish");
	}

}
