import java.awt.event.*;
import java.util.ArrayList;
/**Classe Terrain qui permet le rebond de la chenille
*/
public class Terrain1 extends Terrain{
  /**Constructeur d'un Terrain avec rebonds

  @param touches : tableau comportant les codes des touches utilisées
  @param chenille : code correspondant a la chenille choisit
  @param tab : tableau correspondant aux pommes selectionnées
  */
  public Terrain1(int[] touches,int chenille,ArrayList<Integer> tab){
    super(touches,chenille,tab);
  }

  /**Methode qui gère la gestion des collisions entre les pommes et la chenille, la chenille elle même et fait avancer la chenille*/
  public void actionPerformed(ActionEvent actionEvent){
    /*Dit a la chenille que le terrain autorise les rebonds*/
    che.bouge(true);
    for(Pomme pomme : pom){
      if(che.collisionPomme(pomme)){
        if(pomme.getTypePomme() == 0 && timer.getDelay() > 50){
          timer.setDelay(timer.getDelay()-5);
        }
        if(pomme.getTypePomme() == 3 && timer.getDelay() < 150){
          timer.setDelay(timer.getDelay()+5);
        }
        changePomme(pomme);
        super.mangees++;
        break;
      }
    }
    if(che.collisionAnneau()){
      if(super.chenille == 1){
        super.che = new Chenille1();
      }else{
        super.che = new Chenille2();
      }
      ratee = 0;
      mangees = 0;
    }

    this.repaint();
  }
}
