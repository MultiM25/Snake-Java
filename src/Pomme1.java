import javax.swing.*;
/**Classe qui crée une pomme qui accélère*/
public class Pomme1 extends Pomme{
  /**Constructeur d'une pomme qui accélère
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme1(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme1.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return 0 : effet qui augmente la vitesse de la chenille*/
  public int getTypePomme(){
    return 0;
  }
}
