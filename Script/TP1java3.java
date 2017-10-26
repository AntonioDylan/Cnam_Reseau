import java.lang.Math;
import java.util.*;

class MonThreadLecture extends Thread {
      private MonTableau monTableau ;
      private MonThreadEcriture monAutreThread;
      public MonThreadLecture (MonTableau monTableau,MonThreadEcriture threadEcriture){
            this.monTableau=monTableau;
            this.monAutreThread = threadEcriture;
      }

      public void run() {
            try{
            monAutreThread.join();     
            }   
            catch (Exception e){
                  e.printStackTrace() ;
            }
            monTableau.lectureTab();
      }
}

class MonThreadEcriture extends Thread {
      private MonTableau monTableau ;

      public MonThreadEcriture (MonTableau monTableau){
            this.monTableau=monTableau;
      }

      public void run() {
            monTableau.ecritureTab();   

      }
}

class MonTableau{
      int max=10;
      int tableau []=new int[max];

      public MonTableau(int max){
            this.max=max;
            this.tableau =new int[max];
      }

      public void lectureTab(){
            try{
                  for (int i=0;i<max; i++){
                        System.out.println("lecture a l'indice "+i+" => "+tableau[i]);
                  }
            }
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }
      public void ecritureTab(){
            try{
                  for (int i=0;i<max; i++){
                        int nb= (int)(Math.round((Math.random())*10) ) ;
                        tableau[i]=nb;
                        System.out.println("ecriture a l'indice "+i+" => "+tableau[i]);
                  }
            }
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }

}

class MesThreads {

      public static void main(String args[]){
            try{

                  int max=10;
                  while (true){
                        Scanner keyboard = new Scanner(System.in);
                        System.out.print ("Entrez un max  : ");
                        String s=keyboard.nextLine();
                        try{
                              max = Integer.parseInt(s);
                              break;
                        }
                        catch (Exception e){
                              System.out.println ("Valeur entiere SVP ");
                              continue;
                        }
                  }
                  MonTableau monTableau=new MonTableau(max);

                  
                  MonThreadEcriture monThreadEcriture=new MonThreadEcriture(monTableau);
                  MonThreadLecture monThreadLecture=new MonThreadLecture(monTableau,monThreadEcriture) ;
                  monThreadLecture.start();
                  monThreadEcriture.start();
                 
                  
            }
            catch (Exception e){
                  e.printStackTrace() ;
            }
      }
}
