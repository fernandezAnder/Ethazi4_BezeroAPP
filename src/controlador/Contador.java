package controlador;

import vista.Amaiera;

/**
 * 
 * @author oier, ander, aintzane
 *
 */
public class Contador extends Thread {

	
	@Override
    public void run(){
		Amaiera ventana7= new Amaiera();
		ventana7.setVisible(true);
    	for (int i=0;i<=5;i++) {
        	try {
				Thread.sleep(1000);

			}catch(InterruptedException e){
				e.printStackTrace();
			}	
    	}
    	ventana7.dispose();
    	Metodoak.lehenengoLehioa();
    }
    	
	
}



