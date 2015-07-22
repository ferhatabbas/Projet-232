package controller;

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
public class Files extends Observable {
    private boolean etat;

    final DocumentBuilderFactory factory= DocumentBuilderFactory.newInstance();

    /**
     * Created by ferhat on 18/07/2015.
     * methodes qui permet de recuperer une sauvegarde ou les donnees d'initialisation du jeux a partir d'un fichier XML
     */

    public ArrayList<Dinosaure> readFiles(String XMLFILE) throws JDOMException, IOException {
        SAXBuilder saxBuilder = new SAXBuilder();
        File xmlFile = new File(XMLFILE);
        Document document =saxBuilder.build(xmlFile);
        Element rootElem = document.getRootElement();

        ArrayList<Dinosaure> dinos = new ArrayList<Dinosaure>();

        String user = rootElem.getChildText("username");
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
    public void writeFiles(String XMLFILE, ArrayList<Dinosaure> dino, Log log) throws IOException {
     /* Cr�ation de tous les �l�ments */
        Element racine = new Element("savegame");
        Element user = new Element("username");
        user.setText(log.get_user());
        Element Dinos = new Element("dinosaures");
        racine.addContent(user);
        racine.addContent(Dinos);

        for (int i = 0; i < dino.size(); i++) {
            Element Dino1 = new Element("dinosaure");
            Element name = new Element("name");
            name.setText(dino.get(i).getName());
            Element life = new Element("lifepoint");
            life.setText(String.valueOf(dino.get(i).getLifePoint()));
            Element strenght = new Element("strenght");
            strenght.setText(String.valueOf(dino.get(i).getStrenght()));
            Element  speed = new Element("speed");
            speed.setText(String.valueOf(dino.get(i).getSpeed()));
            Element  defense = new Element("defense");
            defense.setText(String.valueOf(dino.get(i).getDefense()));
            Element  xp = new Element("xp");
            xp.setText(String.valueOf(dino.get(i).getXp()));
            Dinos.addContent(Dino1);
            Dino1.addContent(name);
            Dino1.addContent(life);
            Dino1.addContent(strenght);
            Dino1.addContent(speed);
            Dino1.addContent(defense);
            Dino1.addContent(xp);
        }

		/* Enregistrment */
        Document document = new Document(racine);
        XMLOutputter sortie = new XMLOutputter(Format.getPrettyFormat());

        sortie.output(document, new FileOutputStream(XMLFILE));
    }
    public void setEtat(boolean etat) {
        this.etat = etat;
        setChanged();
        notifyObservers(this.etat);
    }
}
