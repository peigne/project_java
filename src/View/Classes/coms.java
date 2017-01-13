/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package View.Classes;

import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.scene.control.TextArea;

/**
 *
 * @author darwican
 */
public class coms {
    private Ivy bus;
    int i=0;
    public coms(TextArea textArea) throws IvyException {
        // initialize (set up the bus, name and ready message)
        bus = new Ivy("IvyTest", "IvyTest Ready", null);

        // subscribe to "Bye" messages
        bus.bindMsg("TrackMovedEvent Flight=(.*) CallSign=(.*) Ssr=(.*) Sector=(.*) Layers=(.*) X=(.*) Y=(.*) Vx=(.*) Vy=(.*) Afl=(.*) Rate=(.*) Heading=(.*) GroundSpeed=(.*) Tendency=(.*) Time=(.*)", new IvyMessageListener() {
            // callback
            @Override
            public void receive(IvyClient client, String[] strings) {
                try { 
                    Platform.runLater((Runnable)new Runnable(){
                        @Override
                        public void run() {
                            textArea.appendText("Flight "+strings[0]+" CallSign "+strings[1]+" Ssr "+strings[2]+" Sector "+strings[3]+" Layers "+strings[4]+
                            " X "+ strings[5]+" Y "+ strings[6]+" Vx "+ strings[7]+" Vy "+ strings[8]+" fl "+ strings[9]+" Rate "+ strings[10]
                            +" Heading "+ strings[11]+" GroundSpeed "+ strings[12]+" Tendency "+ strings[13]+" Time "+ strings[14]+"\n");
                        }
                    });  
                    
                   
                }
                catch (Exception ex)
                {
                    System.out.println("error");
                }
            }
        });
        
        // start the bus on the default domain
        bus.start(null);
        //bus.start("10.0.0.255:1234");
    }

            public void stop(){
            this.bus.stop();
            }

    
}
