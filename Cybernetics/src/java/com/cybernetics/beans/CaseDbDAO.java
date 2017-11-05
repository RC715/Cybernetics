/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package com.cybernetics.beans;


import com.cybernetics.jdbc.utilities.ConnectionPool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author RupaliBhatnagar
 */
public class CaseDbDAO {
      ConnectionPool c = null;
    Connection conn = null;


    public void create(CaseDb bean)
    {
        c = ConnectionPool.getInstance();
     c.initialize();
     conn= c.getConnection();
     try{
         String dataloc = "C:/Documents and Settings/Home/My Documents/My Pictures/image1.jpg";
         File img = new File(dataloc);
            FileInputStream fin = new FileInputStream(img);

     String sin="insert into casedb values(?,?,?)";
      PreparedStatement pstmt=  conn.prepareStatement(sin);
    pstmt.setString(1,bean.getCaseid());
    pstmt.setString(2,bean.getMmid());
    System.out.println(img.length());
    pstmt.setBinaryStream(3, fin, (int) img.length());
       pstmt.execute();
       c.putConnection(conn);
    }

    catch(Exception e){  e.printStackTrace();}
    finally{
    c.putConnection(conn);
    }

}

public void read(CaseDb bean) throws SQLException, FileNotFoundException, IOException
    { //String resultloc="/result/image1.jpg";
  String query = "select data from casedb where (caseid=? and mmid=? )";
  PreparedStatement pstmt=conn.prepareStatement(query);
  
  pstmt.setString(1, bean.getCaseid());
pstmt.setString(2,bean.getMmid());
ResultSet rs=pstmt.executeQuery();
rs.next();
FileOutputStream fos=new FileOutputStream("/results/image1");
Blob blob= rs.getBlob("data");
int len=(int) blob.length();
byte[] buf=blob.getBytes(1, len);
fos.write(buf);
    }


}

