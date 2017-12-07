import java.rmi.*;
import java.io.Serializable;
import java.rmi.*;
import java.net.*;
import java.rmi.registry.*;
import java.rmi.server.UnicastRemoteObject;




interface PersonneInterface extends Remote{
    public void vieillir() throws RemoteException;
    public void afficherAge() throws RemoteException;
}

public abstract class PetitClient implements TraitementsInterface{
    public static void main(String args[]){
        try {

            if (args.length<1){
                System.out.println("Nom d'hôte SVP");
                return;
            }
            String nom_hote=args[0];

            PersonneInterface p=new Personne ("Lucky", "Luke", 30);

            TraitementsInterface traitementsInterface =(TraitementsInterface)Naming.lookup("rmi://"+nom_hote+":1099/traitements");
            traitementsInterface.vieillirPersonne(p);

            p.afficherAge();

        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}


class Personne extends UnicastRemoteObject implements  PersonneInterface{
    private String nom;
    private String prenom;
    private int age;

    public Personne(String nom, String prenom, int age)  throws RemoteException{
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
    }

    public void vieillir()  throws RemoteException{
        age++;
    }

    public void afficherAge() throws RemoteException{
        System.out.println(prenom+" "+nom+" a "+age+ "ans");
    }
}
