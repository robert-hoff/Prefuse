package prefuse.data.tuple;

import java.util.Iterator;

import prefuse.data.Edge;
import prefuse.data.Graph;
import prefuse.data.Node;
import prefuse.data.Table;

/**
 * Node implementation that reads Node data from a backing node table.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class TableNode extends TableTuple implements Node {

  /**
   * The backing graph.
   */
  protected Graph m_graph;

  /**
   * Initialize a new Node backed by a node table. This method is used by the
   * appropriate TupleManager instance, and should not be called directly by
   * client code, unless by a client-supplied custom TupleManager.
   * 
   * @param table
   *          the node Table
   * @param graph
   *          the backing Graph
   * @param row
   *          the row in the node table to which this Node instance corresponds.
   */
  @Override
  protected void init(Table table, Graph graph, int row) {
    m_table = table;
    m_graph = graph;
    m_row = m_table.isValidRow(row) ? row : -1;
  }

  /**
   * @see prefuse.data.Node#getGraph()
   */
  @Override
  public Graph getGraph() {
    return m_graph;
  }

  // ------------------------------------------------------------------------
  // Graph Methods

  /**
   * @see prefuse.data.Node#getInDegree()
   */
  @Override
  public int getInDegree() {
    return m_graph.getInDegree(this);
  }

  /**
   * @see prefuse.data.Node#getOutDegree()
   */
  @Override
  public int getOutDegree() {
    return m_graph.getOutDegree(this);
  }

  /**
   * @see prefuse.data.Node#getDegree()
   */
  @Override
  public int getDegree() {
    return m_graph.getDegree(this);
  }

  /**
   * @see prefuse.data.Node#inEdges()
   */
  @Override
  public Iterator inEdges() {
    return m_graph.inEdges(this);
  }

  /**
   * @see prefuse.data.Node#outEdges()
   */
  @Override
  public Iterator outEdges() {
    return m_graph.outEdges(this);
  }

  /**
   * @see prefuse.data.Node#edges()
   */
  @Override
  public Iterator edges() {
    return m_graph.edges(this);
  }

  /**
   * @see prefuse.data.Node#inNeighbors()
   */
  @Override
  public Iterator inNeighbors() {
    return m_graph.inNeighbors(this);
  }

  /**
   * @see prefuse.data.Node#outNeighbors()
   */
  @Override
  public Iterator outNeighbors() {
    return m_graph.outNeighbors(this);
  }

  /**
   * @see prefuse.data.Node#neighbors()
   */
  @Override
  public Iterator neighbors() {
    return m_graph.neighbors(this);
  }


  // ------------------------------------------------------------------------
  // Tree Methods

  /**
   * @see prefuse.data.Node#getParent()
   */
  @Override
  public Node getParent() {
    return m_graph.getSpanningTree().getParent(this);
  }

  /**
   * @see prefuse.data.Node#getParentEdge()
   */
  @Override
  public Edge getParentEdge() {
    return m_graph.getSpanningTree().getParentEdge(this);
  }

  /**
   * @see prefuse.data.Node#getChildCount()
   */
  @Override
  public int getChildCount() {
    return m_graph.getSpanningTree().getChildCount(m_row);
  }

  /**
   * @see prefuse.data.Node#getChildIndex(prefuse.data.Node)
   */
  @Override
  public int getChildIndex(Node child) {
    return m_graph.getSpanningTree().getChildIndex(this, child);
  }

  /**
   * @see prefuse.data.Node#getChild(int)
   */
  @Override
  public Node getChild(int idx) {
    return m_graph.getSpanningTree().getChild(this, idx);
  }

  /**
   * @see prefuse.data.Node#getFirstChild()
   */
  @Override
  public Node getFirstChild() {
    return m_graph.getSpanningTree().getFirstChild(this);
  }

  /**
   * @see prefuse.data.Node#getLastChild()
   */
  @Override
  public Node getLastChild() {
    return m_graph.getSpanningTree().getLastChild(this);
  }

  /**
   * @see prefuse.data.Node#getPreviousSibling()
   */
  @Override
  public Node getPreviousSibling() {
    return m_graph.getSpanningTree().getPreviousSibling(this);
  }

  /**
   * @see prefuse.data.Node#getNextSibling()
   */
  @Override
  public Node getNextSibling() {
    return m_graph.getSpanningTree().getNextSibling(this);
  }

  /**
   * @see prefuse.data.Node#children()
   */
  @Override
  public Iterator children() {
    return m_graph.getSpanningTree().children(this);
  }

  /**
   * @see prefuse.data.Node#childEdges()
   */
  @Override
  public Iterator childEdges() {
    return m_graph.getSpanningTree().childEdges(this);
  }

  /**
   * @see prefuse.data.Node#getDepth()
   */
  @Override
  public int getDepth() {
    return m_graph.getSpanningTree().getDepth(m_row);
  }

} // end of class TableNode
