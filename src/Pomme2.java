import javax.swing.*;
/**Classe qui crée une pomme qui ajoute un anneau*/
public class Pomme2 extends Pomme{
  /**Constructeur d'une pomme qui ajoute un anneau
  @param ter : Terrain sur lequel sera posé la pomme
  */
  public Pomme2(Terrain ter){
    super(new ImageIcon(Pomme.class.getResource("images/Pomme2.png")),ter);
  }
  /**Méthode qui retourne le type de la pomme
  @return 1 : effet qui ajoute un anneau a la chenille*/
  public int getTypePomme(){
    return 1;
  }
}
