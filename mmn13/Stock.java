/**
 * @author Maya
 * @version 29/12/2019
 * This class represents a stock inventory
 */
public class Stock {
	
	//declarations
	private FoodItem [] _stock; // an array of all the stock 
	private int _noOfItems;
	private final int MAX_CAPACITY = 100;//MAX_ITEMS_IN_ARRAY
	
	/**
	 * reset the array to the maximum value
	 * Default constructor
	 */
	public Stock() { 
		_stock = new FoodItem[MAX_CAPACITY];
		_noOfItems = 0;
		
	}//end of Default constructor method
	
	/**
	 * add new foodItem to the stock
	 * @param newItem the new item to add to the stock
	 * @return true if an item has been added 
	 * and false if the stock is full and there is not place
	 * to add a new item.
	 */
	public boolean addItem(FoodItem newItem) { //Receive fooditem and add it to the stock
	       
        int locEqualItems = locSameItemsDifDate(newItem);//first location of same name and catalogue number item 
        int i = _noOfItems;// last index if array is occupied

        if (locEqualItems == -1) { 
            if (_noOfItems == MAX_CAPACITY) { // if the stock is full
                return false;
            } else {
                
            	for (;i > 0 && _stock[i - 1].getCatalogueNumber() > newItem.getCatalogueNumber();) {
                    _stock[i] = _stock[i - 1];
                    i--;
                }
                _stock[i] = new FoodItem(newItem);
                _noOfItems++;
                return true;
            }
        } else { //there is similar item in stock
            int equalItemsLoc = locOfEqualsItems(newItem, locEqualItems);
          
            if (equalItemsLoc == -1) {
                if (_noOfItems == MAX_CAPACITY) {
                    return false;
                } else {
                  
                    for (;i > locEqualItems;) {
                        _stock[i] = _stock[i - 1];
                        i--;
                    }
                    _stock[i] = new FoodItem(newItem);
                    _noOfItems++;
                    return true;
                }
            } else { 
                _stock[equalItemsLoc].setQuantity(_stock[equalItemsLoc].getQuantity() + newItem.getQuantity());
                return true;
            }
        }
    }//end of addItem method

	/**
	 * get the number of occupied cells in the stock
	 * @return noOfItems
	 */
	public int getNumOfItems() {//return the number of items in the array according to the _variable	
		
		return _noOfItems;
	}//end of method getNumOfItems
	
	/**
	 * gather the item that need to be order given an amount 
	 * @param amount number to check
	 * @return String that represent items to be order
	 */
	public String order(int amount) {

		String order= "";
		int sum = 0;
		int locSameItemsDifDate;
		
		for(int i = 0 ; i < _noOfItems ; i++) {
			sum = _stock[i].getQuantity();
			locSameItemsDifDate = i;
			
            for (int j=i+1; j<_noOfItems && _stock[j].getName().equals(_stock[i].getName()) 
            							 && _stock[j].getCatalogueNumber() == _stock[i].getCatalogueNumber();) {
            	sum += _stock[j].getQuantity();
                locSameItemsDifDate = j;
                j++;
            }
            i = locSameItemsDifDate;// eliminates already counted product
            
            if (sum < amount) {
                if (i==_noOfItems-1) {
                	order += _stock[i].getName();
                } else {
                	order += _stock[i].getName() + ", ";
                }
            }
        }
        return order;
    }//end of method order

	/**
	 * @param temp of the fridge
	 * @return how many items can move to the fridge given the temp
	 */
	public int howMany(int temp) {
		
		int itemsToMove = 0;
		for(int i=0; i<_noOfItems; i++) {
			if((_stock[i].getMinTemperature()<=temp)
					&&(_stock[i].getMaxTemperature()>=temp)) {
				itemsToMove+=_stock[i].getQuantity();
			}
		}
		return itemsToMove;
	}
			
	/**
	 * find expired items and remove them from the stock 
	 * @param d
	 */
	public void removeAfterDate (Date d) {
		
		if(_noOfItems > 0) {
            for(int i = 0; i < _noOfItems; i++) {
                if(_stock[i].getExpiryDate().before(d)) {
                    removeItem(i);
            		i--;
                }
            }
		}
	}//end of method removeAfterDate
		
	/**
	 * return the most expansive item in the stock
	 * @return mostExpensiveFoodItem or null if the stock is empty
	 */
	public FoodItem mostExpensive() {
		
		if (_noOfItems == 0) {
		    return null;
		}
		FoodItem mostExpensiveFoodItem = _stock[0];
		int price = 0;
		
        for(int i = 0; i < _noOfItems; i++){
            if(_stock[i] != null && _stock[i].getPrice() > price){
                price = _stock[i].getPrice();
                mostExpensiveFoodItem = new FoodItem(_stock[i]);
            }
        }
        return mostExpensiveFoodItem;
	}//end of method mostExpensive

	/**
	 * calculate and sum how many items in the array
	 * @return the quantity of all items 
	 */
	public int howManyPieces() {
		
		int pieces = 0;	
		
		for(int i=0; i<_noOfItems; i++) {
			if(_stock[i]!=null) {
				pieces+=_stock[i].getQuantity();
			}	
		}return pieces;	
	}//end of method howManyPieces
	
	/**
	 * update the array after receiving a list of items that need to be removed
	 * @param itemsList string list of items that were sold
	 */
	public void updateStock(String[] itemsList) {
	
        boolean updateItem;

        for (int i = 0; i < itemsList.length; i++) {
            updateItem = false;
            for (int j = 0; j < _noOfItems && !updateItem; j++) {
                if (itemsList[i].equals(_stock[j].getName())) {
                    _stock[j].setQuantity(_stock[j].getQuantity() - 1);
                    if (_stock[j].getQuantity() == 0) {
                        removeItem(j);
                    }
                    updateItem = true;
                }
            }
        }
    }//end of method updateStock
		
	/**
	 * calculate the tempMin the refrigerator need to be in order to contain items
	 * @return tempMin  
	 * if their isn't an ideal tempMin or the array is empty then he return Integer.MAX_VALUE
	 */
	public int getTempOfStock() {
		
		if(_noOfItems==0) {
			return Integer.MAX_VALUE;
		}
		int tempMin=_stock[0].getMinTemperature();  
		int tempMax=_stock[0].getMaxTemperature(); 
		
		for(int i=1; i<_noOfItems; i++) {
			FoodItem thisItem = _stock[i];
			tempMin = Math.max(thisItem.getMinTemperature(), tempMin);//assign the smallest maxTemp in array
			tempMax = Math.min(thisItem.getMaxTemperature(), tempMax);//assign the biggest minTemp in array
			
			if(_stock[i].getMinTemperature()>tempMax) {
				return Integer.MAX_VALUE;
			}
		}
		return tempMin;
	}//end of method getTempOfStock
	
	/**
	 *@return String of the stock
	 */
	public String toString() {
		 
		String str = "";
		
		for(int i=0 ; i<MAX_CAPACITY && _stock[i]!=null ; i++) {
			str +=_stock[i]+"\n";
		}
		return str;
	}//end of method String
	
	//remove item from the array and prevent holl's
	
	private void removeItem(int loc) {
		
	       for (int i = loc; i < _noOfItems - 1; i++) {
	            _stock[i] = _stock[i + 1];
	        }
	        _stock[_noOfItems - 1] = null;
	        _noOfItems--;
	}//end of method removeItem
	
	//locate equals items with different dates and return the location
	private int locSameItemsDifDate(FoodItem newItem) {

		for (int i = 0; i < _noOfItems; i++) {

            if (newItem.getName().equals(_stock[i].getName())) {
            	if(newItem.getCatalogueNumber() == _stock[i].getCatalogueNumber()) {
				return i;
            	}
            }
		}
		return -1;
	}//end of private method locSameItemsDifDate
	
	//locate equals items and return the location
	private int locOfEqualsItems(FoodItem newItem, int loc) {
       
        for ( int i = loc;i < _noOfItems;i++) {
            if (_stock[i].equals(newItem)) {
                return i;
            }
        }
        return -1;
    }//end of private method locOfEqualsItems
	
}//end of class Stock
