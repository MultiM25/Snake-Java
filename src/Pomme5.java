import javax.swing.*;
/**Classe qui crée une pomme qui retire 2 anneaux*/
public class Pomme5 extends Pomme{
  /**Constructeur d'une pomme qui retire 2 anneaux
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme5(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme4.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return -2 : effet qui retire 2 anneaux a la chenille*/
  public int getTypePomme(){
    return -2;
  }
}
