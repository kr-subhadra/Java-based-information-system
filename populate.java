import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;

public class populate {
public static void main(String args[]) throws SQLException, IOException
{

    Connection conn=null;
  
    try{
          Class.forName("oracle.jdbc.driver.OracleDriver");
    }catch(ClassNotFoundException e) {
          System.err.println("The driver is not loaded properly");
    }

    try
    {

        System.out.println("Trying to connect to database");
        conn=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:db11g","sramakri","password");
        System.out.println("Connected");
        
             
    }
    catch(SQLException e)
    {
        e.printStackTrace();
        System.err.println("Error while connecting!");
    }
    
    try
    {
        File building_file = new File(args[0]);
        File photographer_file = new File(args[1]);
        File photo_file = new File(args[2]);
        
        BufferedReader br1 = new BufferedReader (new FileReader(building_file));
        BufferedReader br2 = new BufferedReader (new FileReader(photographer_file));
        BufferedReader br3 = new BufferedReader (new FileReader(photo_file));
        
      String[] Building_Array =null;
      Statement statement1 = conn.createStatement();
      String building_sql_delete = "delete from building";
      statement1.execute(building_sql_delete);
      
      while (br1.ready())
    {
    Building_Array = br1.readLine().split(", ");
   
    String building_sql =
     "insert into building " + "values('" + Building_Array[0] + "'" + ", '" + Building_Array[1] + "' ," + Building_Array[2] +
     "," + "sdo_geometry(2003,null,null,sdo_elem_info_array(1,1003,1),\n" + "sdo_ordinate_array(";
     for (int i = 3; i < Building_Array.length; i++) {
     building_sql = building_sql + Building_Array[i] + ",";
     }
     building_sql = building_sql + Building_Array[3] + "," + Building_Array[4] + ")))";
     //System.out.println(building_sql);
                //execute the building table insert
     statement1.execute(building_sql);
    }
    
      String[] Photographer_Array = null;
    
    Statement statement2 = conn.createStatement();
    String photographer_sql_delete = "delete from PHOTOGRAPHER";
    statement2.execute(photographer_sql_delete); 
     
    while (br2.ready())
    {
    Photographer_Array = br2.readLine().split(", ");
   
    String photographer_sql =
                    "insert into photographer " + "values('" + Photographer_Array[0] + "'" +
                    "," + "sdo_geometry(2001,null,sdo_point_type(";
                    
    photographer_sql = photographer_sql + Photographer_Array[1] + "," + Photographer_Array[2] + ",null),null,null))";
    //System.out.println(photographer_sql);
    //execute the photographer table insert
    statement2.execute(photographer_sql);
                
    }
   
    String[] Photo_Array = null;
    Statement statement3 = conn.createStatement();
    
    String photo_sql_delete = "delete from PHOTO";
    statement3.execute(photo_sql_delete); 
     
    while (br3.ready())
    {
    Photo_Array = br3.readLine().split(", ");
       
    String photo_sql =
                    "insert into photo " + "values('" + Photo_Array[0] + "'" +
                    "," + "lower('" + Photo_Array[1] + "')," + "sdo_geometry(2001,null,sdo_point_type("; 
                    
    photo_sql = photo_sql + Photo_Array[2] + "," + Photo_Array[3] + ",null),null,null))";
    //System.out.println(photo_sql);
    
    //execute the photo table insert
    statement3.execute(photo_sql);
                
    }
}
    
    catch(FileNotFoundException e)
    {
        e.printStackTrace();
        System.err.println("File not found!");
    }
    
}
}