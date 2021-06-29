package xmlcarcatalogparser;

import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;

public class XmlCarCatalogParser {
    private static final ParserTasks PARSER_TASKS = new ParserTasks();

    public static void main(String[] args) {
        (new XmlCarCatalogParser()).run(args);
    }

    private String extractFileName(String[] args) throws IOException {
        if (args == null || args.length < 1) {
            throw new IllegalArgumentException(
                    "Command line Argument not found. I wait 1 argument as file name template:{appName youFileName}");
        }

        String fileName = args[0];

        try {
            if (Files.notExists(Path.of(fileName)))
                throw new IllegalArgumentException(String.format("File {%s} not fount", fileName));

            if (!Files.isReadable(Path.of(fileName)))
                throw new UncheckedAccessDeniedException(String.format("Cant permission wor read file {%s}", fileName));
        } catch (InvalidPathException e) {
            try {
                URI.create(fileName).toURL().openStream().close();
            } catch (Exception ab) {
                throw new IllegalArgumentException(String.format("File {%s} not fount", fileName));
            }
        }

        return fileName;
    }

    public void run(String[] args) {
        try {
            String fileName = this.extractFileName(args);

            System.out.println(PARSER_TASKS.countUniqueProperty(fileName, "modification", "name"));

        } catch (Exception e) {
            System.err.println("Application terminated with error");
            e.printStackTrace();
        }
    }
}
