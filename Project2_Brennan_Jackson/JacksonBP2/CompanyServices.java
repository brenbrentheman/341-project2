package JacksonBP2;

import javax.ws.rs.core.*;
import javax.ws.rs.*;

import companydata.*;

import java.util.List;
import java.util.Calendar;
import java.util.Date;
import java.sql.Timestamp;

/*
   Brennan Jackson
   Project 2
   ISTE 341
   November 2019
*/

@Path("CompanyServices")
public class CompanyServices {

   /*Instantiate a business layer*/
   BusinessLayer bl = new BusinessLayer();
   
   @Context
   UriInfo uriInfo;
   
   /*1. Deletes all Department, Employee and Timecard records in the database for the given company*/
   @Path("company")
   @DELETE
   @Produces("application/json")
   public Response deleteAllCompanies(@QueryParam("company") String company){
      DataLayer dl = null;
      String json = null;

      try {          
   	   dl = new DataLayer("btj9560");  
         List<Department> depts = dl.getAllDepartment(company);
         dl.deleteCompany(company);
         
         /*If there are departments then build json up*/
         if(depts.size() > 0) {
            
            
            /*Build JSON String*/
            json = "{success: "+company+"'s information deleted}[";
            for(Department dept : depts) {
               json += bl.departmentToJSON(dept);
               json += ",";//seperate json objects
            }
            /*Trim the trailing comma at the end of the deprtments*/
            json = json.replaceAll(",$", "");
            json += "]";//close the array
            
            return Response.ok(json).build();
         } else {
            /*Company exists but has no departments*/
            return Response.ok("success: company deleted").build();
         }
   	   
   	 
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 1
   
   /*2. Returns the requested Department as a JSON String*/
   @Path("department")
   @GET
   @Produces("application/json")
   public Response getDepartment(@QueryParam("company") String company, @QueryParam("dept_id") int id){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
   	   return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 2
   
   /*3. Returns the requested list of Departments*/
   @Path("departments")
   @GET
   @Produces("application/json")
   public Response getCompanyDepartments(@QueryParam("company") String company){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 3
   
   /*4. Returns the updated Department as a JSON String */
   @Path("department")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Response updateCompanyDepartment(Department companyIn){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 4
   
   /*5.  Returns the new Department as a JSON String.*/
   @Path("department")
   @POST
   @Produces("application/json")
   public Response createCompanyDepartment(@FormParam("company") String company, @FormParam("dept_name") String deptName, @FormParam("dept_no") String deptNo, @FormParam("location") String location){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 5
   
   /*6. Returns the number of rows deleted.*/
   @Path("department")
   @DELETE
   @Produces("application/json")
   public Response deleteCompanyDepartments(@QueryParam("company") String company, @QueryParam("dept_id") int deptId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 6   
   
   /*7. Returns the requested Employee as a JSON String*/
   @Path("employee")
   @GET
   @Produces("application/json")
   public Response getEmployee(@QueryParam("company") String company, @QueryParam("emp_id") int empId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 7
   
   /*8. Returns the requested list of Employees.*/
   @Path("employees")
   @GET
   @Produces("application/json")
   public Response getCompanyEmployees(@QueryParam("company") String company){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 8
   
   /*9. Returns the new Employee as a JSON String.*/
   @Path("employee")
   @POST
   @Produces("application/json")
   public Response createEmployee(@FormParam("company") String company, 
                                  @FormParam("emp_name") String name, 
                                  @FormParam("emp_no") String empNo, 
                                  @FormParam("hire_date") /*CHANGE ME!!!!*/ String date,
                                  @FormParam("job") String job,
                                  @FormParam("salary") double salary,
                                  @FormParam("dept_id") int deptId,
                                  @FormParam("mng_id") int mngId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 9
   
   /*10. Returns the updated Employee as a JSON String*/
   @Path("employee")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Response updateEmployee(Employee empIn){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 10
   
   /*11. Returns the that the employee deleted*/
   @Path("employee")
   @DELETE
   @Produces("application/json")
   public Response deleteEmployee(@QueryParam("company") String company, @QueryParam("emp_id") int empId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 11
   
   /*12. Returns the requested Timecard as a JSON String.*/
   @Path("timecard")
   @GET
   @Produces("application/json")
   public Response getTimecard(@QueryParam("company") String company, @QueryParam("timecard_id") int timecardId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 12
   
   /*13. Returns the requested list of Timecards*/
   @Path("timecards")
   @GET
   @Produces("application/json")
   public Response getEmployeetimecards(@QueryParam("company") String company, @QueryParam("emp_id") int empId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 13
   
   /*ASK ABOUT CONSUMES JSON AND INPUT FORM PARAMS?!?!?!*/
   /*14. Returns the new Timecard as a JSON String*/
   @Path("timecard")
   @POST
   @Consumes("application/json")
   @Produces("application/json")
   public Response createTimecard(@FormParam("company") String company, @FormParam("emp_id") int empId, @FormParam("start_time") /*CHANGE ME*/String start, @FormParam("end_time") /*CHANGE ME*/String end){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 14
   
   /*ASK ABOUT WHAT THIS CONSUMES*/
   /*15. Returns the updated Timecard as a JSON String*/
   @Path("timecard")
   @PUT
   @Consumes("application/json")
   @Produces("application/json")
   public Response updateTimecard(Timecard timecard){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 15
   
   /*16. Returns the number of rows deleted.*/
   @Path("timecard")
   @DELETE
   @Produces("application/json")
   public Response deleteTimecard(@QueryParam("company") String company, @QueryParam("timecard_id") int timecardId){
      DataLayer dl = null;
      String json = null;

      try {      
         dl = new DataLayer("btj9560");      
   	   
         
         return Response.ok(json).build();
      } catch (Exception e) {
      	return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("error: Something went wrong.").build();
      } finally {
      	 dl.close();
      }

   }//end 16

}//end class