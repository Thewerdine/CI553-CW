package catalogue;

import java.io.Serializable;
import java.util.Collections;
import java.util.Comparator;

/**
 * Write a description of class BetterBasket here.
 * 
 * @author  Your Name 
 * @version 1.0
 */
public class BetterBasket extends Basket implements Serializable, Comparator<Product>
{
  private static final long serialVersionUID = 1L;
  

  // You need to add code here
  @Override
  public boolean add(Product p1) {
	  //search the existing products for a matching record
	  for(Product p2: this) {
		  if (p1.getProductNum().equals(p2.getProductNum())) {
			  //found matching record, now update quantity and return
			  p2.setQuantity(p2.getQuantity()+p1.getQuantity());
			  return(true);
		  }
	  }
	  //record not found and so add new product instead using superclass
	  super.add(p1);
	  Collections.sort(this, this);
	  return(true);  
 }
  
  public int compare(Product p1, Product p2)
  {
	  return p1.getProductNum().compareTo(p2.getProductNum());
  }
}
