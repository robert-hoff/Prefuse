package prefuse.data.expression;

import prefuse.data.Schema;
import prefuse.data.Tuple;

/**
 * Literal expression of a boolean value.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class BooleanLiteral extends Literal implements Predicate {
  /** The true boolean literal. */
  public static final BooleanLiteral TRUE = new BooleanLiteral(true);
  /** The false boolean literal. */
  public static final BooleanLiteral FALSE = new BooleanLiteral(false);

  private final boolean m_value;

  /**
   * Create a new BooleanLiteral.
   * 
   * @param b
   *          the boolean value
   */
  public BooleanLiteral(boolean b) {
    m_value = b;
  }

  /**
   * @see prefuse.data.expression.Expression#getBoolean(prefuse.data.Tuple)
   */
  @Override
  public boolean getBoolean(Tuple tuple) {
    return m_value;
  }

  /**
   * @see prefuse.data.expression.Expression#getType(prefuse.data.Schema)
   */
  @Override
  public Class getType(Schema s) {
    return boolean.class;
  }

  /**
   * @see prefuse.data.expression.Expression#get(prefuse.data.Tuple)
   */
  @Override
  public Object get(Tuple t) {
    return (getBoolean(t) ? Boolean.TRUE : Boolean.FALSE);
  }

  /**
   * @see java.lang.Object#toString()
   */
  @Override
  public String toString() {
    return String.valueOf(m_value).toUpperCase();
  }

} // end of class BooleanLiteral
