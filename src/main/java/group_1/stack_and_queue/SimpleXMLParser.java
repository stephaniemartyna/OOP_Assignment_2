package group_1.stack_and_queue;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * A simple XML parser that reads an XML file, parses for errors in the XML construction, and builds an XML tree.
 * The parser checks for unmatched opening tags, unmatched closing tags, and invalid self-closing tags.
 *
 * @version 1.0
 */
public class SimpleXMLParser {
    private MyStack<XMLNode> nodeStack;

    /**
     * Constructs a SimpleXMLParser with the given node stack.
     *
     * @param nodeStack The stack to use for tracking XML nodes during parsing.
     */
    public SimpleXMLParser(MyStack<XMLNode> nodeStack) {
        this.nodeStack = nodeStack;
    }

    /**
     * Parses an XML file, builds an XML tree, and returns the root node.
     *
     * @param xmlFile The XML file to parse.
     * @return The root node of the XML tree.
     * @throws IOException If an error occurs while reading the XML file.
     */
    public XMLNode parse(File xmlFile) throws IOException {
    try (FileReader reader = new FileReader(xmlFile)) {
        XMLNode root = null;
        XMLNode current = null;
        StringBuilder currentText = new StringBuilder();
        int character;
        int lineNumber = 1;

        while ((character = reader.read()) != -1) {
            char c = (char) character;

            if (c == '\n') {
                lineNumber++;
            }

            if (c == '<') {
                // Start of a new tag
                if (currentText.length() > 0) {
                    // If there was text, create a text node
                    XMLNode textNode = new XMLNode(currentText.toString().trim());
                    if (current != null) {
                        current.addChild(textNode);
                    } else {
                        System.out.println("Error: Text outside of any tag at line " + lineNumber);
                        return null;
                    }
                    currentText.setLength(0);
                }

                String tag = readTag(reader);
                boolean closingTag = false;

                if (tag.startsWith("/")) {
                    // Closing tag
                    tag = tag.substring(1);
                    closingTag = true;
                }

                XMLNode newNode = new XMLNode(tag);

                if (root == null) {
                    // First tag encountered, set it as the root
                    root = newNode;
                } else if (!closingTag) {
                    // Not a closing tag, add as child
                    if (current != null) {
                        current.addChild(newNode);
                        nodeStack.push(current);
                    } else {
                        System.out.println("Error: Invalid opening tag at line " + lineNumber);
                        return null;
                    }
                } else {
                    // Closing tag, move back to the parent node
                    if (current == null || !tag.equals(current.getName())) {
                        System.out.println("Error: Unmatched closing tag: " + tag + " at line " + lineNumber);
                        return null;
                    }
                    current = nodeStack.pop();
                }

                current = newNode;
            } else {
                // Inside a tag, accumulate text content
                currentText.append(c);
            }
        }

        if (root == null) {
            System.out.println("Error: Empty XML file");
            return null;
        }

        return root;
    }
}

    /**
     * Reads the characters of a tag from the provided reader until the '>' character is encountered.
     *
     * @param reader The reader to read characters from.
     * @return The tag as a string.
     * @throws IOException If an error occurs while reading characters.
     */
    private String readTag(FileReader reader) throws IOException {
        StringBuilder tag = new StringBuilder();
        int character;

        while ((character = reader.read()) != -1 && character != '>') {
            tag.append((char) character);
        }

        return tag.toString();
    }
}
