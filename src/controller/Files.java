package controller;
import model.Dinosaure;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import java.io.File;
import java.util.Observable;
import java.util.Observer;

/**
 * Created by ferhat on 18/07/2015.
 */
public class Files implements Observer {
    private String XMLFILE;
    private Unmarshaller unmarshaller;
    private JAXBContext jc ;
    public Files(String file){
        XMLFILE=file;
    }
    public Dinosaure readFiles() {
        Dinosaure O= new Dinosaure();
        try {
            jc = JAXBContext.newInstance("controller");


            unmarshaller = jc.createUnmarshaller();


            unmarshaller.setValidating(true);

            O=(Dinosaure) unmarshaller.unmarshal(new File(XMLFILE));
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return O;
    }

    @Override
    public void update(Observable o, Object arg) {
                if(o instanceof Dinosaure) {
                     o = readFiles();
                }
    }
}
