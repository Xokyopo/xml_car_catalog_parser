package xmlcarcatalogparser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.function.Consumer;

public class TagAttributePropertyInterceptor extends DefaultHandler {
    private final String tagName;
    private final String attributeName;
    private final Consumer<String> ifFoundCallback;

    public TagAttributePropertyInterceptor(String tagName, String attributeName, Consumer<String> ifFoundCallback) {
        this.tagName = tagName;
        this.attributeName = attributeName;
        this.ifFoundCallback = ifFoundCallback;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
        if (tagName.equals(qName)) {
            String attributesValues = attributes.getValue(attributeName);
            if (!(attributesValues == null || attributesValues.isBlank())) {
                this.ifFoundCallback.accept(attributesValues);
            }
        }
    }
}
