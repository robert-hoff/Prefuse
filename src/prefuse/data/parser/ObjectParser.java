package prefuse.data.parser;

/**
 * DataParser instance that handles arbitrary Objects. The parse method throws
 * an exception and the format method simply returns the Object's toString()
 * method.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class ObjectParser implements DataParser {

  /**
   * Returns Object.class.
   * 
   * @see prefuse.data.parser.DataParser#getType()
   */
  @Override
  public Class getType() {
    return Object.class;
  }

  /**
   * @see prefuse.data.parser.DataParser#format(java.lang.Object)
   */
  @Override
  public String format(Object value) {
    return value == null ? null : value.toString();
  }

  /**
   * @see prefuse.data.parser.DataParser#canParse(java.lang.String)
   */
  @Override
  public boolean canParse(String text) {
    return false;
  }

  /**
   * @see prefuse.data.parser.DataParser#parse(java.lang.String)
   */
  @Override
  public Object parse(String text) throws DataParseException {
    throw new UnsupportedOperationException();
  }

} // end of class ObjectParser
