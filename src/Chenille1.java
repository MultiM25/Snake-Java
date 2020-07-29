import java.util.ArrayList;
/**Classe servant a la création de Chenille qui disparaisse peut importe l'anneau touché
*/
public class Chenille1 extends Chenille{
  /**Constructeur d'une chenille qui disparait peut importe l'anneau touché*/
  public Chenille1(){
    super();
  }
  /**Méthode qui gère la collision entre les différents anneaux de la chenille
  @return true si il ya collision*/
  public boolean collisionAnneau(){
    for(Anneau an: super.corps){
      if(an.estTouche(super.corps,super.corps.indexOf(an))){
        return true;
      }
    }
    return false;
  }
}
