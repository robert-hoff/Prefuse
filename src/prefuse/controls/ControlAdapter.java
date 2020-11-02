package prefuse.controls;

import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseWheelEvent;

import prefuse.visual.VisualItem;


/**
 * Adapter class for processing prefuse interface events. Subclasses can
 * override the desired methods to perform user interface event handling.
 * 
 * @author <a href="http://jheer.org">jeffrey heer</a>
 */
public class ControlAdapter implements Control {

  private boolean m_enabled = true;

  /**
   * @see prefuse.controls.Control#isEnabled()
   */
  @Override
  public boolean isEnabled() {
    return m_enabled;
  }

  /**
   * @see prefuse.controls.Control#setEnabled(boolean)
   */
  @Override
  public void setEnabled(boolean enabled) {
    m_enabled = enabled;
  }

  // ------------------------------------------------------------------------

  /**
   * @see prefuse.controls.Control#itemDragged(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemDragged(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemMoved(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemMoved(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemWheelMoved(prefuse.visual.VisualItem,
   *      java.awt.event.MouseWheelEvent)
   */
  @Override
  public void itemWheelMoved(VisualItem item, MouseWheelEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemClicked(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemClicked(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemPressed(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemPressed(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemReleased(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemReleased(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemEntered(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemEntered(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemExited(prefuse.visual.VisualItem,
   *      java.awt.event.MouseEvent)
   */
  @Override
  public void itemExited(VisualItem item, MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemKeyPressed(prefuse.visual.VisualItem,
   *      java.awt.event.KeyEvent)
   */
  @Override
  public void itemKeyPressed(VisualItem item, KeyEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemKeyReleased(prefuse.visual.VisualItem,
   *      java.awt.event.KeyEvent)
   */
  @Override
  public void itemKeyReleased(VisualItem item, KeyEvent e) {
  }

  /**
   * @see prefuse.controls.Control#itemKeyTyped(prefuse.visual.VisualItem,
   *      java.awt.event.KeyEvent)
   */
  @Override
  public void itemKeyTyped(VisualItem item, KeyEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseEntered(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseEntered(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseExited(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseExited(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mousePressed(java.awt.event.MouseEvent)
   */
  @Override
  public void mousePressed(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseReleased(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseReleased(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseClicked(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseClicked(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseDragged(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseDragged(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseMoved(java.awt.event.MouseEvent)
   */
  @Override
  public void mouseMoved(MouseEvent e) {
  }

  /**
   * @see prefuse.controls.Control#mouseWheelMoved(java.awt.event.MouseWheelEvent)
   */
  @Override
  public void mouseWheelMoved(MouseWheelEvent e) {
  }

  /**
   * @see prefuse.controls.Control#keyPressed(java.awt.event.KeyEvent)
   */
  @Override
  public void keyPressed(KeyEvent e) {
  }

  /**
   * @see prefuse.controls.Control#keyReleased(java.awt.event.KeyEvent)
   */
  @Override
  public void keyReleased(KeyEvent e) {
  }

  /**
   * @see prefuse.controls.Control#keyTyped(java.awt.event.KeyEvent)
   */
  @Override
  public void keyTyped(KeyEvent e) {
  }

} // end of class ControlAdapter
