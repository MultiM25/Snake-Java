import javax.swing.*;
/**Classe qui crée une pomme qui ralentit*/
public class Pomme6 extends Pomme{
  /**Constructeur d'une pomme qui ralentit
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme6(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme5.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return 3 : effet qui ralentit la chenille*/
  public int getTypePomme(){
    return 3;
  }
}
