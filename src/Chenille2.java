import java.util.ArrayList;
/**Classe servant a la création de Chenille qui fait disparaitre le dernier anneau si c'est l'anneau touché
*/
public class Chenille2 extends Chenille{
  /**Constructeur d'une chenille qui fait disparaitre le dernier anneau si c'est l'anneau touché*/
  public Chenille2(){
    super();
  }
  /**Méthode qui gère la collision entre les différents anneaux de la chenille
  @return true si il ya collision hormis le dernier anneau*/
  public boolean collisionAnneau(){
    for(Anneau an: super.corps){
      if(an.estTouche(super.corps,super.corps.indexOf(an))){
        /**Vérifie si l'anneau touché est le dernier et le supprimer si c'est le cas*/
        if(super.corps.indexOf(an) == super.corps.size()-1){
          retireAnneau(-1);
          return false;
        }else{
          return true;
        }
      }
    }
    return false;
  }
}
