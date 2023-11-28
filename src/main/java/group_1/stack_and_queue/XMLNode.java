package group_1.stack_and_queue;

/**
 * Represents a node in an XML tree, storing information about the node's name, text content, and children.
 *
 * @version 1.0
 */
public class XMLNode {
   String name;
    private String textContent;
    private MyArrayList<XMLNode> children;

    /**
     * Constructs an XMLNode with the given name.
     *
     * @param name The name of the XML node.
     */
    public XMLNode(String name) {
        this.name = name;
        this.children = new MyArrayList<>();
    }

    /**
     * Adds a child node to the current XML node.
     *
     * @param child The child node to add.
     */
    public void addChild(XMLNode child) {
        children.add(child);
    }
    
    /**
     * Gets the name of the XML node.
     *
     * @return The name of the XML node.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of children nodes for the current XML node.
     *
     * @return The list of children nodes.
     */
    public MyArrayList<XMLNode> getChildren() {
        return children;
    }

    /**
     * Returns a string representation of the XML node and its children in a tree-like structure.
     *
     * @return The string representation of the XML node.
     */
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        toStringHelper(result, 0);
        return result.toString();
    }

    /**
     * Helper method to build the string representation of the XML node and its children with proper indentation.
     *
     * @param result The StringBuilder to append the result to.
     * @param depth The depth of the current node in the XML tree.
     */
    private void toStringHelper(StringBuilder result, int depth) {
        for (int i = 0; i < children.size(); i++) {
            XMLNode child = children.get(i);

            for (int j = 0; j < depth; j++) {
                result.append("  "); // Indentation for depth
            }

            result.append(child.name);

            if (child.textContent != null && !child.textContent.isEmpty()) {
                result.append(": ").append(child.textContent);
            }

            result.append("\n");

            child.toStringHelper(result, depth + 1);
        }
    }
}
