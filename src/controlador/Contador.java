package controlador;

import vista.*;
import controlador.*;

/**
 * 
 * @author oier, ander, aintzane
 *
 */
public class Contador extends Thread {
	Metodoak m1;
	
	
	public void run()  {
		
    	for (int i=0;i<=5;i++) {
        	try {
				Thread.sleep(1000);

			}catch(InterruptedException e){
				e.printStackTrace();
			}
        	
        
    	}
    	
    }
    	
    		
    	
	
}



