package controller;

import model.Dinosaure;
import model.Log;
import org.jdom.JDOMException;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.xml.sax.SAXException;

import javax.xml.bind.JAXBException;
import javax.xml.parsers.ParserConfigurationException;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.Assert.assertTrue;

/**
 * Created by ferhat on 19/07/2015.
 */
public class FilesTest {

    Files monFichier;
    String XMLinit;
    String XMLsave;
    Log log;

    @Rule
    public final ExpectedException exception = ExpectedException.none();

    @Before
    public void setup()
    {
        monFichier = new Files();
        XMLinit="example.xml";
        log=new Log(0,"2015-07-20 14:59:30.252","Alexandre");
        XMLsave="save.xml";


    }

    @Test
    public void testInitDino() throws JAXBException, JDOMException, IOException, ParserConfigurationException, SAXException {
        ArrayList<Dinosaure> dinos = monFichier.readFiles(XMLinit);
        assertTrue(dinos.size() > 0);
    }
    @Test
    public void testSave_and_LoadDino() throws Exception {
        ArrayList<Dinosaure> Dino=new ArrayList<Dinosaure>() ;
        Dino.add(new Dinosaure("rex"));
        Dino.add(new Dinosaure("bronto"));
        Dino.add(new Dinosaure("dilo"));
        monFichier.writeFiles(XMLsave,Dino,log);




    }
}