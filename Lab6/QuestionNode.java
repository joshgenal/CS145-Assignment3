/*
Joshua Genal
CS&145
Lab 6: 20 Questions
QuestionNode
last edited 08/08/2023

Rrepresents a node in a binary tree that forms the foundation of a 20 Questions game. 
The nodes in this tree are either questions or answers, and the class helps in managing the 
relationships between parent and child nodes.
*/

public class QuestionNode {
    // Statement for the node, either a question or an answer.
    private final String statement;
    // Left child node representing the "Yes" answer. 
    private QuestionNode yesLeft;
    // Right child node representing the "No" answer.
    private QuestionNode noRight;

    // Constructor for leaf nodes (answers).
    // Initializes the statement and sets the child nodes to null.
    public QuestionNode(String newStatement) {
        if (newStatement == null) {
            throw new IllegalArgumentException("Statement cannot be null");
        }
        this.statement = newStatement;
        this.yesLeft = null;
        this.noRight = null;
    }

    // Constructor for non-leaf nodes (questions).
    // Initializes the question and child nodes.
    public QuestionNode(String newQuestion, QuestionNode left, QuestionNode right) {
        if (newQuestion == null || (left == null && right != null) || (right == null && left != 
        null)) {
            throw new IllegalArgumentException("Question and child nodes must be consistent");
        }
        this.statement = newQuestion;
        this.yesLeft = left;
        this.noRight = right;
    }

    // Returns the statement of the node.
    public String getStatement() {
        return statement;
    }

    // Returns the left child node ("Yes" answer).
    public QuestionNode getYesLeft() {
        return yesLeft;
    }

    // Sets the left child node ("Yes" answer).
    public void setYesLeft(QuestionNode yesLeft) {
        this.yesLeft = yesLeft;
    }

    // Returns the right child node ("No" answer).
    public QuestionNode getNoRight() {
        return noRight;
    }

    // Sets the right child node ("No" answer).
    public void setNoRight(QuestionNode noRight) {
        this.noRight = noRight;
    }
}
