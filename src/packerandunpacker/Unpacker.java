/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packerandunpacker;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.Vector;

/**
 *
 * @author Auodumber
 */
public class Unpacker 
{
    //Deserlization
   // userdata unpck = null;  //object "unpack" of 'userdata' class to read object data from ".pck" file
     
    public int unpackeractivity(String packfile,String folder) throws IOException
    {
        try
        {
         FileInputStream file = new FileInputStream(packfile);
         
         ArrayList<userdata> udata;
         
         ObjectInputStream in = new ObjectInputStream(file);
         udata = (ArrayList<userdata>)in.readObject();
         System.out.println(udata);
            
            
         
         
         /*try (ObjectInputStream in = new ObjectInputStream(file)) {
                 
                udata = (ArrayList<userdata>)in.readObject();
                System.out.println(udata);
            }*/
         for(int i = 0;i<udata.size();i++)
         {
             
             userdata unpck = udata.get(i);
             String chk = unpck.verification;
             if(!chk.equals("456789"))
             {
                 return -1;    
             }
             String fname = folder + "\\" + unpck.filename;
             String userdata = unpck.filedata;
             
             File obj = new File(fname);
             
             try
             {
                obj.createNewFile();
             }
             catch(IOException e)
             {
                System.out.println("file creation fail");
             }
             
             FileWriter myfilewrite = new FileWriter(fname);
             
             try
             {
                 myfilewrite.write(userdata);
                 myfilewrite.close();
             }
             catch(IOException e)
             {
             }
         }//for loop ends
        }//try block end//try block end
       catch(FileNotFoundException e)
       {
           return -2; //error code need implementation
       }
       catch(IOException | ClassNotFoundException e)
       {
           return -1;
       }
   return 0;
    }
      
    
    
    
    
    
    
    
    /*public void unpackeractivity(String packfile,String folder) throws IOException
   {
       try
       {
         FileInputStream file = new FileInputStream(packfile);
         ObjectInputStream in = new ObjectInputStream(file);
         
         //in.readObject();
         //in.close();
         
         
         Vector<userdata> udata = (Vector<userdata>)in.readObject();
         System.out.println(udata);
         in.close();
         
         Iterator<userdata> iter = udata.iterator();
         while(iter.hasNext())
         {
             userdata s = iter.next();
             String fname = folder + "\\" + s.filename;
             String str = s.filedata;
             File obj = new File(fname);
             try
             {
                obj.createNewFile(); 
             }
             catch(IOException e)
             {
                 e.printStackTrace();
             }
             
             FileWriter myfilewrite = new FileWriter(fname);
             
             try
             {
                 /*if(obj.createNewFile())
                 {
                     System.out.println("sucess");
                 }*/
                /* myfilewrite.write(str);
                 myfilewrite.close();
             }
             catch(IOException e)
             {
                 e.printStackTrace();
             }
         }
       }
       catch(FileNotFoundException e)
       {
           e.printStackTrace();
       }
       catch(IOException e)
       {
           e.printStackTrace();
       }
       catch(ClassNotFoundException ex)
       {
           ex.printStackTrace();
       }*/
   


    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    /*public void unpackeractivity(String packfile,String folder) throws IOException, ClassNotFoundException
    {
       ArrayList<userdata> objects = new ArrayList<userdata>();
       FileInputStream file = new FileInputStream(packfile);
       boolean flag = true;
       
       try
       {
                           
          ObjectInputStream in = new ObjectInputStream(file);
          while(flag)
          { 
              if(file.available()!=0)
              {
                unpck = (userdata)in.readObject();    //typecasting return of readObject() into userdata class
                objects.add(unpck);
              }
              else{
                  flag = false;
              }
              
          }
        }
       catch(Exception e)
       {
           e.printStackTrace();
       }
       in.close();
       file.close();
        String temp = unpck.filename;
      String fname = folder+"\\"+temp;
              System.out.println(fname);
      
     }*/
}
