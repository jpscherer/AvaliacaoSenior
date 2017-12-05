package src.main.java;

import java.util.HashSet;
import java.util.Set;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("/rest")
public class WebApplication extends Application{
	@Override
	public Set<Class<?>> getClasses() {	    
	    final Set<Class<?>> classes = new HashSet<Class<?>>();
	    // register root resource
	    classes.add(WebComunicator.class);
	    return classes;
	}
}
