 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packerandunpacker;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Hp
 */
class userdata implements Serializable
{
        public String verification = "456789";
        public String filedata;
	public String filename;

	userdata(String d,String f)  // constructor
	{
		 setFiledata(d);
                  setFilename(f);
                 //setVerification(verification);
         }

    public String getFiledata() {
        return filedata;
    }

    public void setFiledata(String filedata) {
        this.filedata = filedata;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    //@Override
   /* public String toString() {
        return   filedata  + filename ;
    }*/

    public String getVerification() {
        return verification;
    }

    /*public void setVerification(String verification) {
        this.verification = verification;
    }*/

    
    
	
        
}

/*class userdata implements Serializable
{
    public String filename;
    public String filedata;
    
    userdata(String f,String d)
    {
        setFilename(f);
        setFiledata(d);
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public String getFiledata() {
        return filedata;
    }

    public void setFiledata(String filedata) {
        this.filedata = filedata;
    }
    

    @Override
    public String toString() {
        return "userdata{" + "filename=" + filename + ", filedata=" + filedata + '}';
    }
   
}*/

/*class contains method to create pack file*/

public class packer
{
    
    // this method read whole file as string please see imports carefully ;)
	public static String ReadTextAsstring(String filename)
	{
		String data = "";
		try
		{
			data = new String(Files.readAllBytes(Paths.get(filename)));
		}
		
		catch(IOException e)
		{
			e.printStackTrace();
		}
		return data;
	}
        
        public int process(File files[],String pckfilename)
        {
            ArrayList<userdata> udata = new ArrayList<>();
            String pckfile = pckfilename + ".pck";
            
            for(int i = 0;i<files.length;i++)
            {
              String datainfile = ReadTextAsstring(files[i].toString()); // getting all data of file in string dt (plese see ReadTextAsstring() method)
              udata.add(new userdata(datainfile,files[i].getName()));
            }
            
            try
            {
                FileOutputStream file = new FileOutputStream(pckfile);
		ObjectOutputStream out = new ObjectOutputStream(file);
                
                  out.writeObject(udata);
		 out.close();
                  file.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
            
            System.out.println(udata);
            return 1;
        }

        
   
        
        
        
        
        
        
        
        
        
        
        
        
        
      /*public int process(File files[],String pckfilename)
     {
         Vector<userdata> v = new Vector<>();
         String pckfile = pckfilename+".pck";
         for(int i = 0;i<files.length;i++)
         {
            String datainfile = ReadTextAsstring(files[i].toString()); // getting all data of file in string dt (plese see ReadTextAsstring() method)
            v.add(new userdata(datainfile,files[i].getName()));
         }
         try
            {
                FileOutputStream file = new FileOutputStream(pckfile);
		ObjectOutputStream out = new ObjectOutputStream(file);
                
                 out.writeObject(v);
		 out.close();
		file.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }
          System.out.println(v);
         return 1;
     }*/
        
   
        
        
        
        
        
        
        
        
        /*public int process(File files[],String pckfilename)
    {
        

        for(int i=0;i<files.length;i++)
        {
            String filename = files[i].getName(); //getting filename 
            String datainfile = ReadTextAsstring(files[i].toString()); // getting all data of file in string dt (plese see ReadTextAsstring() method)

            userdata d = new userdata(datainfile,filename); // created object d of class data wich stores the filename and data of that file
	    String pckfile = pckfilename + ".pck"; //new file which contains object data
            
            //Serialization
            try
            {
                FileOutputStream file = new FileOutputStream(pckfile ,true);
		ObjectOutputStream out = new ObjectOutputStream(file);
                
                 out.writeObject(d);
		out.close();
		file.close();
            }
            catch(IOException e)
            {
		e.printStackTrace();
                return 0;
            }
            
               
            
        }
      return 1;      
     }*/
}
