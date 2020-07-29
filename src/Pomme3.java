import javax.swing.*;
/**Classe qui crée une pomme qui ajoute 2 anneaux*/
public class Pomme3 extends Pomme{
  /**Constructeur d'une pomme qui ajoute 2 anneaux
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme3(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return 2 : effet qui ajoute 2 anneaux a la chenille*/
  public int getTypePomme(){
    return 2;
  }
}
