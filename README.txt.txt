Simple XML Parser

A simple XML parser that reads an XML file, parses for errors in the XML construction, and prints the lines with errors. The parser checks for unmatched opening tags, unmatched closing tags, and invalid self-closing tags.


Usage

java Stack_And_Queue <xml-file>

Replace <xml-file> with the path to your XML document.


Features

-Parses XML documents.
-Identifies errors in XML construction.
-Prints lines with syntax errors and details about the error.
-Checks for unmatched opening tags, unmatched closing tags, and invalid self-closing tags.


How to Run

-Compile the program:

javac Stack_And_Queue.java

-Run the program with your XML file:

java Stack_And_Queue <path-to-your-xml-file>

-Example

java Stack_And_Queue sample.xml


Error Messages

-If there is an error reading the XML file, an error message will be displayed.
-If there is a syntax error in the XML document, the program will print an error message along with the line number and details about the error.