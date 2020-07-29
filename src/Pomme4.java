import javax.swing.*;
/**Classe qui crée une pomme qui retire un anneau*/
public class Pomme4 extends Pomme{
  /**Constructeur d'une pomme qui retire un anneau
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme4(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme3.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return -1 : effet qui retire un anneau a la chenille*/
  public int getTypePomme(){
    return -1;
  }
}
