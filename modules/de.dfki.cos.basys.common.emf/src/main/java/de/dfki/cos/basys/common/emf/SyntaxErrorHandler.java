package de.dfki.cos.basys.common.emf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.xml.sax.ErrorHandler;
import org.xml.sax.SAXException;
import org.xml.sax.SAXParseException;


/**
 * A simple error handler for xml syntax validation
 * @author kirill
 *
 */
public class SyntaxErrorHandler implements ErrorHandler {
	static Logger logger = LoggerFactory.getLogger(SyntaxErrorHandler.class);
    public void warning(SAXParseException e) throws SAXException {
        logger.error(e.getMessage());
    }

    public void error(SAXParseException e) throws SAXException {
        logger.error(e.getMessage());
    }

    public void fatalError(SAXParseException e) throws SAXException {
        logger.error(e.getMessage());
    }
}