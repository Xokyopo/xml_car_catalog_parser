package xmlcarcatalogparser;

import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

public class ParserTasks {
    public int countUniqueProperty(String fileName, String tagName, String attributeName) throws ParseTaskException {
        Set<String> attributesNames = new HashSet<>();
        AtomicInteger counter = new AtomicInteger(0);

        Consumer<String> ifFountCallback = (attributeValue) -> {
            attributesNames.add(attributeValue);
            counter.incrementAndGet();
        };

        this.parse(fileName, new TagAttributePropertyInterceptor(tagName, attributeName, ifFountCallback));

        return attributesNames.size();
    }

    protected void parse(String uri, DefaultHandler handler) throws ParseTaskException {
        try {
            SAXParser parser = SAXParserFactory.newInstance().newSAXParser();
            parser.parse(uri, handler);
        } catch (Exception e) {
            throw new ParseTaskException(e);
        }
    }

}
