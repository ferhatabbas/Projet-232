package controller;

import model.Attack;
import model.Dinosaure;
import model.Log;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import javax.xml.parsers.DocumentBuilderFactory;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Observable;


/**
 * Created by ferhat on 18/07/2015.
 */
public class Files {

    final String SAVEGAME = "savegame";
    final String USER_NAME = "username";
    final String DINOSAURE_LIST = "dinosaures";
    final String LOG_LIST = "logs";
    final String SINGLE_DINOSAURE = "dinosaure";
    final String SINGLE_LOG = "log";
    final String DINO_NAME = "name";
    final String DINO_LIFE = "lifepoint";
    final String DINO_STRENGHT = "strenght";
    final String DINO_SPEED = "speed";
    final String DINO_DEFENSE = "defense";
    final String DINO_XP = "xp";
    final String DINO_FAMILY = "family";
    final String ATTACK_LIST = "attacks";
    final String SINGLE_ATTACK = "attack";
    final String ATTACK_NAME = "name";
    final String ATTACK_TYPE = "type";
    final String ATTACK_VALUE = value;

    /**
     * Created by ferhat on 18/07/2015.
     * methodes qui permet de recuperer une sauvegarde ou les donnees d'initialisation du jeux a partir d'un fichier XML
     */

    public ArrayList<Dinosaure> readDinos(String userName) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(userName);
        Document document =saxBuilder.build(xmlFile);
        Element rootElem = document.getRootElement();

        ArrayList<Dinosaure> dinos = new ArrayList<Dinosaure>();

        List<Element> listelem = rootElem.getChild("dinosaures").getChildren();

        for(Element x : listelem){
            Dinosaure dino = new Dinosaure();
            dino.setName(x.getChildText("name"));
            dino.setLifePoint(Integer.parseInt(x.getChildText("lifepoint")));
            dino.setStrenght(Integer.parseInt(x.getChildText("strenght")));
            dino.setSpeed(Integer.parseInt(x.getChildText("speed")));
            dino.setDefense(Integer.parseInt(x.getChildText("defense")));
            dino.setXp(Integer.parseInt(x.getChildText("xp")));
            dinos.add(dino);
        }

        return dinos;
    }
    /**
     * Created by ferhat on 18/07/2015.
     * methodes qui permet de sauvegarder le jeux dans un fichier XML
     */
    public void writeFile(String userName, ArrayList<Dinosaure> dinos) throws IOException {
     /* Création de tous les éléments */
        Element racine = new Element(SAVEGAME);
        Element user = new Element(USER_NAME);
        user.setText(userName);
        Element Dinos = new Element(DINOSAURE_LIST);
        racine.addContent(user);
        racine.addContent(Dinos);

        for (Dinosaure dino : dinos) {
            Element Dino1 = new Element(SINGLE_DINOSAURE);
            Element name = new Element(DINO_NAME);
            name.setText(dino.getName());
            Element life = new Element(DINO_LIFE);
            life.setText(String.valueOf(dino.getLifePoint()));
            Element strenght = new Element(DINO_STRENGHT);
            strenght.setText(String.valueOf(dino.getStrenght()));
            Element  speed = new Element(DINO_SPEED);
            speed.setText(String.valueOf(dino.getSpeed()));
            Element  defense = new Element(DINO_DEFENSE);
            defense.setText(String.valueOf(dino.getDefense()));
            Element  xp = new Element(DINO_XP);
            xp.setText(String.valueOf(dino.getXp()));
            Element family = new Element(DINO_FAMILY);
            family.setText(String.valueOf(dino.getFamily()));
            Element attacks = new Element(ATTACK_LIST);
            for(Attack _attack : dino.getAttackList())
            {
                Element attack = new Element(SINGLE_ATTACK);
                Element attackName = new Element(ATTACK_NAME);
                attackName.setText(_attack.getAttackName());
                Element attackType = new Element(ATTACK_TYPE);
                attackType.setText(String.valueOf(_attack.getTypeAttack()));
                Element value = new Element(ATTACK_VALUE);
                value.setText(String.valueOf(_attack.getValue()));
                attacks.addContent(attack);
                attack.addContent(attackName);
                attack.addContent(attackType);
                attack.addContent(value);
            }
            Dinos.addContent(Dino1);
            Dino1.addContent(name);
            Dino1.addContent(life);
            Dino1.addContent(strenght);
            Dino1.addContent(speed);
            Dino1.addContent(defense);
            Dino1.addContent(xp);
            Dino1.addContent(family);
            Dino1.addContent(attacks);
        }

		/* Enregistrment */
        Document document = new Document(racine);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        sortie.output(document, new FileOutputStream(userName));
    }
}
