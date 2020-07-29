import java.awt.event.*;
import java.util.ArrayList;
/**Classe Terrain qui permet de traverser les murs et d'aller de l'autre côté
*/
public class Terrain2 extends Terrain{
  /**Constructeur d'un Terrain Tore

  @param touches : tableau comportant les codes des touches utilisées
  @param chenille : code correspondant a la chenille choisit
  @param tab : tableau correspondant aux pommes selectionnées
  */
  public Terrain2(int[] touches,int chenille,ArrayList<Integer> tab){
    super(touches,chenille,tab);
  }
/**Methode qui gère la gestion des collisions entre les pommes et la chenille, la chenille elle même et fait avancer la chenille*/
  public void actionPerformed(ActionEvent actionEvent){
    /*Dit a la chenille que le terrain est Tore*/
    che.bouge(false);
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
