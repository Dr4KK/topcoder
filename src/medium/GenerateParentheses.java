package medium;

/**
 * Created by kekai on 16/11/10.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

 For example, given n = 3, a solution set is:

 [
 "((()))",
 "(()())",
 "(())()",
 "()(())",
 "()()()"
 ]
 */
public class GenerateParentheses {
    public static  List<String> generateParenthesis(int n) {
        List<String> values = new ArrayList<>();
        Node node = new Node(1);
        addChildren(node, values, n);
        return values;
    }

    public static void addChildren(Node node, List<String> values, int n) {
        if(node.count == n * 2) {
            values.add(node.combin.toString());
            return;
        }
        List<Node> childrens = new ArrayList<>();
        if(node.sum > 0) {
            if(node.trueCount < n) {
                childrens.add(new Node(1, node));
            }
            if(node.falseCount < n) {
                childrens.add(new Node(-1, node));
            }
        }else {
            if(node.trueCount < n) {
                childrens.add(new Node(1, node));
            }
        }
        for(Node tmp : childrens) {
            addChildren(tmp, values, n);
        }
    }

    public static void main(String[] args) {
        List<String> values = generateParenthesis(3);
        for (String s : values) {
            System.out.println(s);
        }
    }
}

class Node{
    public int value;
    public int sum;
    public StringBuilder combin;
    public int count;
    public int trueCount;
    public int falseCount;

    public Node(int value) {
        this.value = value;
        this.sum = value;
        this.combin = new StringBuilder(value == 1 ? "(" : ")");
        this.count = 1;
        this.trueCount = 1;
    }
    public Node(int value, Node node) {

        this.value = value;
        this.combin = new StringBuilder(node.combin.toString());
        combin.append(value == 1 ? "(" : ")");
        this.count = node.count + 1;
        sum = node.sum + value;
        if(value == 1) {
            trueCount = node.trueCount + 1;
            falseCount = node.falseCount;
        } else {
            falseCount = node.falseCount + 1;
            trueCount = node.trueCount;
        }
    }
}
