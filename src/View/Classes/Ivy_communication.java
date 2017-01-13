
package View.Classes;

import data.param.VisualParameters;
import fr.dgac.ivy.Ivy;
import fr.dgac.ivy.IvyApplicationListener;
import fr.dgac.ivy.IvyClient;
import fr.dgac.ivy.IvyException;
import fr.dgac.ivy.IvyMessageListener;
import javafx.application.Platform;
import View.Classes.Flight;
import View.Classes.Point;

import View.Classes.coms;
import fr.dgac.ivy.IvyException;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ivy_communication {
    
    // Interface de communication avec Rejeu
    private static coms communicationManager;
    public static TextArea textArea;
    
    
    public Ivy_communication (ArrayList<Flight> list_flight){
        
        // Créer et paraméter une zone de texte pour afficher les messages de Rejeu
        textArea = new TextArea("Messages de Rejeu :\n");
        textArea.setPrefSize(2000,2000);
        textArea.setWrapText(true);
        textArea.setEditable(false);
        ScrollPane scrollPane = new ScrollPane(textArea);
        
        // Créer et paraméter la racine du graphe de scène (contiendra tous les autres composants graphiques)
        StackPane root = new StackPane();
        root.getChildren().add(scrollPane);
        
        // Créer et paraméter la scène
        
        // créer la scène
        Scene scene = new Scene(root,500,500); 
        Stage primaryStage= new Stage();
        
        // attacher la scène
        primaryStage.setScene(scene);  
        primaryStage.setTitle("Ivy, Rejeu et JavaFX");
        
        // Afficher l'application JavaFX
        primaryStage.show();           
        
        // Lancement de la communication avec Rejeu
        try {
            communicationManager = new coms(textArea,list_flight);
            //javafx.application.Platform.runLater((Runnable) communicationManager);
        } catch (IvyException e) {
            throw new RuntimeException("Echec de connexion Ivy");
        }
    }
    
    
    public void stop() {
        // La méthode stop() est appelée par l'application JavaFX au moment de quitter.
        // On peut la redéfinir pour y préparer une extinction propre,
        // comme ici, arrêter le client Ivy
        communicationManager.stop();
    }


    
}

/*
public class Ivy_communication {
    
    private Ivy bus = new Ivy("VisuRadar", "VisuRadar Ready", null);
    
    public Ivy_communication() throws IvyException {
        bus.bindMsg("^TrackMovedEvent Flight=(.*) CallSign=(.*) Ssr=(.*) Sector=(.*) X=(.*) Y=(.*) Vx=(.*) Vy=(.*) Afl=(.*) Rate=(.*) Heading=(.*) GroundSpeed=(.*) Tendency=(.*) Time", new IvyMessageListener(){

            public void receive(IvyClient client, String[] args) {
                int num_vol = Integer.parseInt(args[0]);
                String nom = args[1];
                String sector=args[3];
                double x = Double.parseDouble(args[4]);
                double y = Double.parseDouble(args[5]);
                double Vx = Double.parseDouble(args[6]);
                double Vy = Double.parseDouble(args[7]);
                int fl = Integer.parseInt(args[8]);
                int heading = Integer.parseInt(args[9]);
                int groundspeed = Integer.parseInt(args[10]);
                if (Ivy_communication.this.model.getFlightList().haveFlight(flightNumber).booleanValue()) {
                    Platform.runLater((Runnable)new Runnable(){

                        @Override
                        public void run() {
                            Flight flight = CommunicationManager.this.model.getFlightList().getFlight(flightNumber);
                            flight.update(new Point(x, - y), groundspeed, heading, tendency, afl);
                        }
                    });
                } else {
                    final Flight flight = new Flight(flightNumber, callsign, groundspeed, afl, heading, tendency, "0", new Point(x, - y));
                    Platform.runLater((Runnable)new Runnable(){

                        @Override
                        public void run() {
                            CommunicationManager.this.model.getFlightList().addFlight(flight);
                        }
                    });
                    try {
                        CommunicationManager.this.bus.sendMsg("GetPln MsgName=Pln4Me Flight=" + flightNumber + " From=now");
                    }
                    catch (IvyException e) {
                        e.printStackTrace();
                    }
                }
            }

        });
        this.bus.bindMsg("^Pln Pln4Me Flight=(.*) Time.*Dep=(.*) Arr=(.*) List=(.*)", new IvyMessageListener(){

            public void receive(IvyClient client, String[] args) {
                final int flightNumber = Integer.parseInt(args[0]);
                final String dep = args[1];
                final String arr = args[2];
                String list = args[3];
                if (!list.equals("")) {
                    String[] listTable = list.split(" ");
                    int n = listTable.length / 4;
                    final String[] route = new String[n];
                    for (int i = 0; i < n; ++i) {
                        route[i] = listTable[i * 4];
                    }
                    Platform.runLater((Runnable)new Runnable(){

                        @Override
                        public void run() {
                            Flight flight = CommunicationManager.this.model.getFlightList().getFlight(flightNumber);
                            flight.setFlightPlan(new FlightPlan(dep, arr, route));
                        }
                    });
                }
            }

        });
        this.bus.bindMsg("^TrackDiedEvent Flight=(.*)", new IvyMessageListener(){

            public void receive(IvyClient client, String[] args) {
                final int flightNumber = Integer.parseInt(args[0]);
                if (CommunicationManager.this.model.getFlightList().haveFlight(flightNumber).booleanValue()) {
                    Platform.runLater((Runnable)new Runnable(){

                        @Override
                        public void run() {
                            CommunicationManager.this.model.getFlightList().removeFlight(flightNumber);
                        }
                    });
                }
            }

        });
        this.bus.start(this.model.param.getIvyBus());
    }

    public void stop() {
        this.bus.stop();
    }
}
*/