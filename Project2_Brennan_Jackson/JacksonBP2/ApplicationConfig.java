package JacksonBP2;

import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class ApplicationConfig extends Application
{
    public Set<Class<?>> getClasses() {
        return this.getRestResourceClasses();
    }
    
    private Set<Class<?>> getRestResourceClasses() {
        final Set<Class<?>> resources = new HashSet<Class<?>>();
        resources.add(JacksonBP2.CompanyServices.class);
        return resources;
    }
}