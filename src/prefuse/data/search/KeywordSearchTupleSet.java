package prefuse.data.search;



//import org.apache.lucene.document.Document;
//import org.apache.lucene.document.Field;
//import org.apache.lucene.queryParser.ParseException;
//import org.apache.lucene.search.Hits;

import prefuse.data.Tuple;

/**
 * <p>
 * SearchTupleSet implementation that performs text searches on indexed Tuple
 * data using the Lucene search engine.
 * <a href="http://lucene.apache.org/">Lucene</a> is an open source search
 * engine supporting full text indexing and keyword search. Please refer to the
 * Lucene web page for more information. Note that for this class to be used by
 * prefuse applications, the Lucene classes must be included on the application
 * classpath.
 * </p>
 *
 * @version 1.0
 * @author <a href="http://jheer.org">jeffrey heer</a>
 * @see prefuse.data.query.SearchQueryBinding
 */
public class KeywordSearchTupleSet extends SearchTupleSet {

  @Override
  public String getQuery() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void search(String query) {
    // TODO Auto-generated method stub

  }

  @Override
  public void index(Tuple t, String field) {
    // TODO Auto-generated method stub

  }

  @Override
  public void unindex(Tuple t, String field) {
    // TODO Auto-generated method stub

  }

  @Override
  public boolean isUnindexSupported() {
    // TODO Auto-generated method stub
    return false;
  }








  /*
   * private static final Logger s_logger =
   * Logger.getLogger(KeywordSearchTupleSet.class.getName());
   * 
   * protected IntObjectHashMap m_map = new IntObjectHashMap(); protected String
   * m_query = "";
   * 
   * protected LuceneSearcher m_lucene = null; protected boolean
   * m_storeTermVectors = false;
   * 
   * protected int m_id = 1;
   * 
   * /** Creates a new KeywordSearchFocusSet using an in-memory search index.
   */


  /*
   * public KeywordSearchTupleSet() { m_lucene = new LuceneSearcher(); }
   * 
   * 
   * public KeywordSearchTupleSet(LuceneSearcher searcher) { m_lucene = searcher;
   * }
   * 
   * @Override public String getQuery() { return m_query; }
   * 
   * 
   * @Override public void search(String query) { if ( query == null ) { query =
   * ""; }
   * 
   * query = query.trim(); if ( query.equals(m_query) ) { return; // no change }
   * 
   * Tuple[] rem = clearInternal(); m_query = query;
   * 
   * if ( query.length() == 0 ) { this.fireTupleEvent(null, DELETE); return; }
   * 
   * m_lucene.setReadMode(true); try { Hits hits = m_lucene.search(query); for (
   * int i=0; i < hits.length(); i++ ) { Tuple t = getMatchingTuple(hits.doc(i));
   * addInternal(t); } Tuple[] add = getTupleCount() > 0 ? toArray() : null;
   * fireTupleEvent(add, rem); } catch (ParseException e) {
   * s_logger.warning("Lucene query parse exception.\n"+
   * StringLib.getStackTrace(e)); } catch (IOException e) {
   * s_logger.warning("Lucene IO exception.\n"+ StringLib.getStackTrace(e)); }
   * 
   * }
   * 
   * 
   * protected Tuple getMatchingTuple(Document d) { int id =
   * Integer.parseInt(d.get(LuceneSearcher.ID)); return (Tuple)m_map.get(id); }
   * 
   * 
   * @Override public void index(Tuple t, String field) {
   * m_lucene.setReadMode(false); String s; if ( (s=t.getString(field)) == null )
   * { return; }
   * 
   * int id = m_id++; m_lucene.addDocument(getDocument(id, s)); m_map.put(id, t);
   * }
   * 
   * 
   * @Override public boolean isUnindexSupported() { return false; }
   * 
   * 
   * @Override public void unindex(Tuple t, String attrName) { throw new
   * UnsupportedOperationException(); }
   * 
   * protected Document getDocument(int id, String text) { Document d = new
   * Document(); d.add(Field.Text(LuceneSearcher.FIELD, text,
   * m_storeTermVectors)); d.add(Field.Keyword(LuceneSearcher.ID,
   * String.valueOf(id))); return d; }
   * 
   * 
   * public LuceneSearcher getLuceneSearcher() { return m_lucene; }
   * 
   * 
   * public IntObjectHashMap getTupleMap() { return
   * (IntObjectHashMap)m_map.clone(); }
   * 
   * @Override public void clear() { m_lucene = new LuceneSearcher();
   * super.clear(); }
   * 
   */

} // end of class KeywordSearchTupleSet
