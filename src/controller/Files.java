package controller;

import model.*;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;

import javax.xml.parsers.DocumentBuilderFactory;
import java.awt.font.ShapeGraphicAttribute;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Observable;


/**
 * Created by ferhat on 18/07/2015.
 */
public class Files extends Observer {

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
    final String ATTACK_VALUE = "value";
    final String LOG_ATTRIBUTE_TYPE = "type";
    final String LOG_ATTRIBUTE_DATETIME = "datetime";

    /**
     * Created by ferhat on 18/07/2015.
     * methodes qui permet de recuperer une sauvegarde ou les donnees d'initialisation du jeux a partir d'un fichier XML
     */

    public void readFile(String userName) throws JDOMException, IOException {

        Game game = (Game) get_subject();

        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(userName);
        Document document =saxBuilder.build(xmlFile);
        Element rootElem = document.getRootElement();

        /*USERNAME*/
        String username = rootElem.getChildText(USER_NAME);

        /*DINOS*/
        ArrayList<Dinosaure> dinos = new ArrayList<Dinosaure>();

        List<Element> listDinos = rootElem.getChild(DINOSAURE_LIST).getChildren();
        for(Element x : listDinos){
            String name = x.getChildText(DINO_NAME);
            Integer lifePoint = Integer.parseInt(x.getChildText(DINO_LIFE));
            Integer strenght = Integer.parseInt(x.getChildText(DINO_STRENGHT));
            Integer speed = Integer.parseInt(x.getChildText(DINO_SPEED));
            Integer defense = Integer.parseInt(x.getChildText(DINO_DEFENSE));
            Integer xp = Integer.parseInt(x.getChildText(DINO_XP));
            Family family = Family.valueOf(x.getChildText(DINO_FAMILY));

            ArrayList<DinoAction> attacks = new ArrayList<DinoAction>();
            List<Element> listActions = x.getChild(ATTACK_LIST).getChildren();
            for(Element y : listActions)
            {
                String aname = y.getChildText(ATTACK_NAME);
                TypeAction aType = TypeAction.valueOf(y.getChildText(ATTACK_TYPE));
                int aValue = Integer.parseInt(y.getChildText(ATTACK_VALUE));
                attacks.add(new DinoAction(aname, aType, aValue));
            }
            /*
            ArrayList<Attack> features = new ArrayList<Feature>();
            List<Element> listfeatures = x.getChild(ATTACK_LIST).getChildren();
            for(Element y : listAttacks)
            {
                String aname = y.getChildText(ATTACK_NAME);
                TypeAttack aType = TypeAttack.valueOf(y.getChildText(ATTACK_TYPE));
                int aValue = Integer.parseInt(y.getChildText(ATTACK_VALUE));
                attacks.add(new Attack(aname, aType, aValue));
            }
            */
            dinos.add(DinoFactory.construct(name, lifePoint, strenght, speed, defense, xp, family, attacks, null));
        }


        /*LOGS*/
        ArrayList<Log> logs = new ArrayList<Log>();
        List<Element> listLogs = rootElem.getChild(LOG_LIST).getChildren();
        for(Element x : listLogs)
        {
            Log l = Log.createEmptyLog();
            l.set_type(Integer.parseInt(x.getAttributeValue(LOG_ATTRIBUTE_TYPE)));
            try {
                l.set_date(new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").parse(x.getAttributeValue(LOG_ATTRIBUTE_DATETIME)));
            }catch (Exception e) {}
            l.set_value(x.getValue());
            logs.add(l);
        }

        /*ADD TO GAME*/
        game.set_userName(userName);
        game.set_dinos(dinos);
        game.set_logs(logs);
    }
    /**
     * Created by ferhat on 18/07/2015.
     * methodes qui permet de sauvegarder le jeux dans un fichier XML
     */
    public void update() {

        Game game = (Game) get_subject();

        /*RACINE*/
        Element racine = new Element(SAVEGAME);

        /*USER_NAME*/
        Element user = new Element(USER_NAME);
        user.setText(game.get_userName());
        racine.addContent(user);

        /*DINOSAURES*/
        Element Dinos = new Element(DINOSAURE_LIST);
        racine.addContent(Dinos);

        for (Dinosaure dino : game.get_dinos()) {
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
            for(DinoAction _attack : dino.getAttackList())
            {
                Element attack = new Element(SINGLE_ATTACK);
                Element attackName = new Element(ATTACK_NAME);
                attackName.setText(_attack.getActionName());
                Element attackType = new Element(ATTACK_TYPE);
                attackType.setText(String.valueOf(_attack.getActionAttack()));
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

        /*LOGS*/
        Element Logs = new Element(LOG_LIST);
        racine.addContent(Logs);

        for(Log l : game.get_logs())
        {
            Element log = new Element(SINGLE_LOG);
            log.setAttribute(LOG_ATTRIBUTE_TYPE, String.valueOf(l.get_type()));
            log.setAttribute(LOG_ATTRIBUTE_DATETIME, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(l.get_date()));
            log.setText(l.get_value());
            Logs.addContent(log);
        }

		/* Enregistrement */
        Document document = new Document(racine);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        try {
            sortie.output(document, new FileOutputStream(game.get_userName()));
        }catch (Exception e)
        {

        }
    }
}
