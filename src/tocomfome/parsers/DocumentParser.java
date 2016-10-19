package tocomfome.parsers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import tocomfome.Main;

public abstract class DocumentParser {
    private static final String DATA_FILE_PATH = "tocomfome/data/";
    private static final String FILE_NOT_FOUND_MESSAGE = "Could not find file: ";

    private final Document dataDocument;

    public DocumentParser(final String fileName) throws FileNotFoundException, ParserConfigurationException, IOException, SAXException {
        final File documentFile = this.getDocumentFile(fileName);
        final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();

        this.dataDocument = dBuilder.parse(documentFile);
        this.dataDocument.getDocumentElement().normalize();
    }

    private File getDocumentFile(final String fileName) throws FileNotFoundException {
        final String filePath = DATA_FILE_PATH + fileName + ".xml";
        File dataFile = null;

        try {
            final URL fileLocation = getClass().getClassLoader().getResource(filePath);
            dataFile = new File(fileLocation.toURI());
        } catch(URISyntaxException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }

        if (dataFile == null || !dataFile.exists()) {
            throw new FileNotFoundException(FILE_NOT_FOUND_MESSAGE + filePath);
        }

        return dataFile;
    }

    protected NodeList getElements(final String tagName) {
        return this.dataDocument.getElementsByTagName(tagName);
    }
}
