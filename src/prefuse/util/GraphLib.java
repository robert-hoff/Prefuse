package prefuse.util;

import java.util.ArrayList;

import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Schema;
import prefuse.data.Tree;

/**
 * Library routines for creating various Graph structures. All Graphs generated
 * by methods of this class include a String-valued "label" field.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class GraphLib {

  private GraphLib() {
    // prevent instantiation
  }

  // ------------------------------------------------------------------------
  // Graph Creation Routines

  /**
   * Builds a completely unconnected (edge-free) graph with the given number of
   * nodes
   * 
   * @param n
   *          the number of nodes
   * @return a graph with n nodes and no edges
   */
  public static Graph getNodes(int n) {
    Graph g = new Graph();
    g.getNodeTable().addColumns(LABEL_SCHEMA);

    for (int i = 0; i < n; i++) {
      Node node = g.addNode();
      node.setString(LABEL, String.valueOf(i));
    }
    return g;
  }

  /**
   * Builds a "star" graph with one central hub connected to the given number of
   * satellite nodes.
   * 
   * @param n
   *          the number of points of the star
   * @return a "star" graph with n points, for a total of n+1 nodes
   */
  public static Graph getStar(int n) {
    Graph g = new Graph();
    g.getNodeTable().addColumns(LABEL_SCHEMA);

    Node r = g.addNode();
    r.setString(LABEL, "0");

    for (int i = 1; i <= n; ++i) {
      Node nn = g.addNode();
      nn.setString(LABEL, String.valueOf(i));
      g.addEdge(r, nn);
    }
    return g;
  }

  /**
   * Returns a clique of given size. A clique is a graph in which every node is a
   * neighbor of every other node.
   * 
   * @param n
   *          the number of nodes in the graph
   * @return a clique of size n
   */
  public static Graph getClique(int n) {
    Graph g = new Graph();
    g.getNodeTable().addColumns(LABEL_SCHEMA);

    Node nodes[] = new Node[n];
    for (int i = 0; i < n; ++i) {
      nodes[i] = g.addNode();
      nodes[i].setString(LABEL, String.valueOf(i));
    }
    for (int i = 0; i < n; ++i) {
      for (int j = i; j < n; ++j) {
        if (i != j) {
          g.addEdge(nodes[i], nodes[j]);
        }
      }
    }
    return g;
  }

  /**
   * Returns a graph structured as an m-by-n grid.
   * 
   * @param m
   *          the number of rows of the grid
   * @param n
   *          the number of columns of the grid
   * @return an m-by-n grid structured graph
   */
  public static Graph getGrid(int m, int n) {
    Graph g = new Graph();
    g.getNodeTable().addColumns(LABEL_SCHEMA);

    Node[] nodes = new Node[m * n];
    for (int i = 0; i < m * n; ++i) {
      nodes[i] = g.addNode();
      nodes[i].setString(LABEL, String.valueOf(i));

      if (i >= n) {
        g.addEdge(nodes[i - n], nodes[i]);
      }
      if (i % n != 0) {
        g.addEdge(nodes[i - 1], nodes[i]);
      }
    }
    return g;
  }

  public static Graph getHoneycomb(int levels) {
    Graph g = new Graph();
    g.getNodeTable().addColumns(LABEL_SCHEMA);
    ArrayList layer1 = halfcomb(g, levels);
    ArrayList layer2 = halfcomb(g, levels);
    for (int i = 0; i < (levels << 1); ++i) {
      Node n1 = (Node) layer1.get(i);
      Node n2 = (Node) layer2.get(i);
      g.addEdge(n1, n2);
    }
    return g;
  }

  private static ArrayList halfcomb(Graph g, int levels) {
    ArrayList top = new ArrayList();
    ArrayList layer = new ArrayList();

    int label = 0;

    for (int i = 0; i < levels; ++i) {
      Node n = g.addNode();
      n.setString(LABEL, String.valueOf(label++));
      top.add(n);
    }
    for (int i = 0; i < levels; ++i) {
      Node n = null;
      for (int j = 0; j < top.size(); ++j) {
        Node p = (Node) top.get(j);
        if (n == null) {
          n = g.addNode();
          n.setString(LABEL, String.valueOf(label++));
          layer.add(n);
        }
        g.addEdge(p, n);
        n = g.addNode();
        n.setString(LABEL, String.valueOf(label++));
        layer.add(n);
        g.addEdge(p, n);
      }
      if (i == levels - 1) {
        return layer;
      }
      top.clear();
      for (int j = 0; j < layer.size(); ++j) {
        Node p = (Node) layer.get(j);
        n = g.addNode();
        n.setString(LABEL, String.valueOf(label++));
        top.add(n);
        g.addEdge(p, n);
      }
      layer.clear();
    }
    // should never happen
    return top;
  }

  /**
   * Returns a balanced tree of the requested breadth and depth.
   * 
   * @param breadth
   *          the breadth of each level of the tree
   * @param depth
   *          the depth of the tree
   * @return a balanced tree
   */
  public static Tree getBalancedTree(int breadth, int depth) {
    Tree t = new Tree();
    t.getNodeTable().addColumns(LABEL_SCHEMA);

    Node r = t.addRoot();
    r.setString(LABEL, "0,0");

    if (depth > 0) {
      balancedHelper(t, r, breadth, depth - 1);
    }
    return t;
  }

  private static void balancedHelper(Tree t, Node n, int breadth, int depth) {
    for (int i = 0; i < breadth; ++i) {
      Node c = t.addChild(n);
      c.setString(LABEL, i + "," + c.getDepth());
      if (depth > 0) {
        balancedHelper(t, c, breadth, depth - 1);
      }
    }
  }

  /**
   * Returns a left deep binary tree
   * 
   * @param depth
   *          the depth of the tree
   * @return the generated tree
   */
  public static Tree getLeftDeepTree(int depth) {
    Tree t = new Tree();
    t.getNodeTable().addColumns(LABEL_SCHEMA);

    Node r = t.addRoot();
    r.setString(LABEL, "0,0");

    deepHelper(t, r, 2, depth, true);
    return t;
  }

  /**
   * Returns a right deep binary tree
   * 
   * @param depth
   *          the depth of the tree
   * @return the generated Tree
   */
  public static Tree getRightDeepTree(int depth) {
    Tree t = new Tree();
    t.getNodeTable().addColumns(LABEL_SCHEMA);

    Node r = t.addRoot();
    r.setString(LABEL, "0,0");

    deepHelper(t, r, 2, depth, false);
    return t;
  }

  /**
   * Create a diamond tree, with a given branching factor at each level, and depth
   * levels for the two main branches.
   * 
   * @param b
   *          the number of children of each branch node
   * @param d1
   *          the length of the first (left) branch
   * @param d2
   *          the length of the second (right) branch
   * @return the generated Tree
   */
  public static Tree getDiamondTree(int b, int d1, int d2) {
    Tree t = new Tree();
    t.getNodeTable().addColumns(LABEL_SCHEMA);

    Node r = t.addRoot();
    r.setString(LABEL, "0,0");

    Node left = t.addChild(r);
    left.setString(LABEL, "1,0");
    Node right = t.addChild(r);
    right.setString(LABEL, "1,1");

    deepHelper(t, left, b, d1 - 2, true);
    deepHelper(t, right, b, d1 - 2, false);

    while (left.getFirstChild() != null) {
      left = left.getFirstChild();
    }
    while (right.getLastChild() != null) {
      right = right.getLastChild();
    }

    deepHelper(t, left, b, d2 - 1, false);
    deepHelper(t, right, b, d2 - 1, true);

    return t;
  }

  private static void deepHelper(Tree t, Node n, int breadth, int depth, boolean left) {
    Node c = t.addChild(n);
    c.setString(LABEL, "0," + c.getDepth());
    if (left && depth > 0) {
      deepHelper(t, c, breadth, depth - 1, left);
    }

    for (int i = 1; i < breadth; ++i) {
      c = t.addChild(n);
      c.setString(LABEL, i + "," + c.getDepth());
    }
    if (!left && depth > 0) {
      deepHelper(t, c, breadth, depth - 1, left);
    }
  }


  // ------------------------------------------------------------------------

  /** Label data field included in generated Graphs */
  public static final String LABEL = "label";
  /** Node table schema used for generated Graphs */
  public static final Schema LABEL_SCHEMA = new Schema();
  static {
    LABEL_SCHEMA.addColumn(LABEL, String.class, "");
  }

} // end of class GraphLib
