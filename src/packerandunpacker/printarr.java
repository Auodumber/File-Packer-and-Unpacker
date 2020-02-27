/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package packerandunpacker;

import java.util.ArrayList;

/**
 *
 * @author Hp
 */
public class printarr {
    
    
    printarr()
    {   ArrayList<userdata> udata = new ArrayList<userdata>();
        for(int i = 0;i<udata.size();i++)
        {
            userdata obj = udata.get(i);
            System.out.println(obj.filename);
             System.out.println(obj.filedata);

        }
    }

}     
