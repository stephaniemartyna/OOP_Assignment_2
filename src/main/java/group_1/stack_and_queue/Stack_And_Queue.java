/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package group_1.stack_and_queue;

import java.io.File;
import java.io.IOException;

/**
 * A simple XML parser that reads an XML file, parses for errors in the XML construction, and prints the lines with errors.
 * The parser checks for unmatched opening tags, unmatched closing tags, and invalid self-closing tags.
 */
public class Stack_And_Queue {
      public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java Stack_And_Queue <path_to_xml_file>");
            return;
        }

        String filePath = args[0];
        MyStack<XMLNode> nodeStack = new MyStack<>();
        SimpleXMLParser xmlParser = new SimpleXMLParser(nodeStack);

        try {
            File xmlFile = new File(filePath);
            XMLNode root = xmlParser.parse(xmlFile);

            if (root != null) {
                // Do something with the parsed XML tree
                System.out.println("XML Tree:\n" + root.toString());
            } else {
                System.out.println("Error parsing the XML file.");
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }
}
