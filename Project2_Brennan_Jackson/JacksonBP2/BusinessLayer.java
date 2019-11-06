package JacksonBP2;

import companydata.*;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

public class BusinessLayer {

   public String departmentToJSON(Department dept) {
      String json = "{";
      
      json += "\"dept_id\": " + dept.getId() + ",";
      json += "\"company\": " + dept.getCompany() + ",";
      json += "\"dept_name\": " + dept.getDeptName() + ",";
      json += "\"dept_no\": " + dept.getDeptNo() + ",";
      json += "\"location\": " + dept.getLocation();
      
      
      json += "}";
      
      return json;
   }

}