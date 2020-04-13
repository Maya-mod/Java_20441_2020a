package mmn12;
/**
 * 
 * @author Maya
 * @version 14/12/2019
 * This class represents a FoodItem Object
 *
 */
public class FoodItem {
	
	//properties
	private final int MAX_CAT_NUM = 9999;
	private final int MIN_CAT_NUM = 1000;
	private final int CATALOGUE_DEFAULT = 9999;
	private final int FOR_NEGATIVE_AMOUNT = 0;
	private final int FOR_NEGATIVE_PRICE = 1;
	private final int ZERO = 0;
	private final String EMPTY = "item";
	private String _name; //Immutable
	private long _catalogueNumber; //Immutable
	private int _quantity;
	private Date _productionDate;
	private Date _expiryDate;
	private int _minTemperature; //Immutable
	private int _maxTemperature; //Immutable
	private int _price;
	
	//constructors:
	/**
	 * creates a new FoodItem object
     * Parameters:
	 * @param name name of food item
	 * @param catalogueNumber catalogue number of food item
	 * @param quantity quantity of food item 
	 * @param productionDate production date
	 * @param expiryDate expiry date
	 * @param minTemperature minimum storage temperature
	 * @param maxTemperature maximum storage temperature
	 * @param price unit price
	 */	
	public FoodItem(String name, 
					long catalogueNumber, 
					int quantity, 
					Date productionDate, 
					Date expiryDate, 
					int minTemperature, 
					int maxTemperature, 
					int price) {
		
		_name = name;
		_catalogueNumber = catalogueNumber;
		_quantity = quantity;
		_productionDate = new Date(productionDate);
		_expiryDate = new Date (expiryDate);
		_minTemperature = minTemperature;
		_maxTemperature = maxTemperature;
		_price = price;
		
		
		_name = (_name == "")? EMPTY : name;
		
		_catalogueNumber = (_catalogueNumber<MIN_CAT_NUM||_catalogueNumber>MAX_CAT_NUM)? CATALOGUE_DEFAULT : catalogueNumber;
		
		_quantity = (_quantity<ZERO)? ZERO : quantity;
		
		_expiryDate = (_expiryDate.before(_productionDate))? productionDate.tomorrow() : expiryDate ;
		
		_price = (_price<FOR_NEGATIVE_AMOUNT)? FOR_NEGATIVE_PRICE : price ;
		
		if (_minTemperature>_maxTemperature) {_minTemperature = maxTemperature; _maxTemperature = minTemperature;}
		
	}//end of method FoodItem

	/**
	 * Copy Constructor
	 * @param FoodItem to be copy
	 */
	public FoodItem(FoodItem other) { 
		
		_name = other._name;
		_catalogueNumber = other._catalogueNumber;
		_quantity = other._quantity;
		_productionDate = other._productionDate;
		_expiryDate = other._expiryDate;
		_minTemperature = other._minTemperature;
		_maxTemperature = other._maxTemperature;
		_price = other._price;
		
	}//end of method FoodItem other
	
	/**
	 * gets the catalogue number
	 * @return the catalogue number
	 */
	public long getCatalogueNumber() {
		
		return this._catalogueNumber;
		
	}//end of method getCatalogueNumber
	
	/**
	 * check if 2 food items are the same (excluding the quantity values)
	 * @param other the food item to compare this food item to
	 * @return true if the food items are the same
	 */
	public boolean equals(FoodItem other) {
		
		if(this._name.equals(other._name)
				&& this._catalogueNumber==other._catalogueNumber 
					&& this._productionDate.equals(other._productionDate) 
						&& this._expiryDate.equals(other._expiryDate) 
							&& this._minTemperature==other._minTemperature 
								&& this._maxTemperature==other._maxTemperature 
									&& this._price==other._price) {
										return true;
		}
		return false;
	}//end of method equals

	/**
	 * gets the name
	 * @return the name
	 */
	public String getName() {
		
		return _name;
		
	}//end of method getName
	
	/**
	 * gets the maximum storage temperature
	 * @return the maximum storage temperature
	 */
	public int getMaxTemperature() {
		return _maxTemperature;
	}//end of method getMaxTemperature
	
	/**
	 * gets the minimum storage temperature
	 * @return the minimum storage temperature
	 */
	public int getMinTemperature() {
		
		return _minTemperature;
		
	}//end of method getMinTemperature
	
	/**
	 * gets the expiry date
	 * @return the expiry date
	 */
	public Date getExpiryDate() {
		
		Date getExpiryDate = new Date(_expiryDate);
		return getExpiryDate;
		
	}//end of method getExpiryDate
	
	/**
	 * gets the unit price
	 * @return the unit price
	 */
	public int getPrice() {
		
		_price = (_price<=FOR_NEGATIVE_AMOUNT)? FOR_NEGATIVE_PRICE : _price;
		
		return _price;
		
	}//end of method getPrice
	
	/**
	 * gets the production date
	 * @return the production date
	 */
	public Date getProductionDate() {
		
		Date getProductionDate = new Date(_productionDate);
		
		return getProductionDate;
		
	}//end of method getProductionDate
	
	/**
	 * gets the quantity
	 * @return the quantity
	 */
	public int getQuantity() {
		
		_quantity = (_quantity<ZERO)? ZERO : _quantity;
		
		return _quantity;
		
	}//end of method getQuantity
	
	/**
	 * set the expiry date (only if not before production date )
	 * @param d expiry date value to be set
	 */
	public void setExpiryDate(Date d) {
		
		_expiryDate = (!d.before(_productionDate))? new Date(d) : _expiryDate;
		
	}//end of method setExpiryDate
	
	/**
	 * set the price (only if positive)
	 * @param n - price value to be set
	 */
	public void setPrice(int n) {
		
		_price = (n>ZERO)? n: _price;//	if (n>ZERO) {_price = n;}
	
	}//end of method setPrice
	
	/**
	 * set the production date (only if not after expiry date )
	 * @param d - production date value to be set
	 */ 
	public void setProductionDate(Date d) {
		
		_productionDate = (d.before(_expiryDate)||d.equals(_expiryDate))? new Date(d) : _productionDate;
		
	}//end of method setProductionDate
	
	/**
	 * set the quantity (only if not negative)
	 * @param n - the quantity value to be set
	 */
	public void setQuantity(int n) { 
		
		_quantity = (n>=ZERO)? n : _quantity;
		
	}//end of method setQuantity
	
	/**
	 * returns a String that represents this food item
	 * @return String that represents this food item in the following format:
	 * FoodItem: milk CatalogueNumber: 1234 ProductionDate: 14/12/2019 ExpiryDate: 21/12/2019 Quantity: 3
	 */
	public String toString() {
		
		return "FoodItem: "+_name+"\tCatalogueNumber: "+_catalogueNumber+"\tProductionDate: "+_productionDate+"\tExpiryDate: "+_expiryDate+"\tQuantity: "+_quantity;	
	
	}//end of method toString

	/**
	 * check if this food item is fresh on the date d
	 * @param d - date to check
	 * @return true if this food item is fresh on the date d
	 */
	public boolean isFresh(Date d) {
		
		if ((d.after(this._productionDate) && (d.before(this._expiryDate) || d.equals(this._expiryDate)))
				||(d.equals(this._productionDate) && d.before(this._expiryDate) || d.equals(this._expiryDate))) {
			return true;
		}
		return false;
	}//end of method isFresh
	
	/**
	 * returns the number of units of products that can be purchased for a given amount
	 * @param amount - amount to purchase
	 * @return the number of units can be purchased
	 */
	public int howManyItems(int amount) {
		
		int x = (_quantity<=(amount/_price))? _quantity : amount/_price; //if((amount/_price)>=_quantity){return _quantity;}
			
		return x;
		
	}//end of method howManyItems
	
	/**
	 * check if this food item is cheaper than other food item
	 * @param other - food item to compare this food item to
	 * @return true if this food item is cheaper than other date
	 */
	public boolean isCheaper(FoodItem other) {//if(this._price<other._price) {return true;} return false;
		
		return this._price<other._price;
			
	}//end of method isCheaper

	/**
	 * check if this food item is older than other food item
	 * @param other - food item to compare this food item to
	 * @return true if this food item is older than other date
	 */
	public boolean olderFoodItem(FoodItem other) {
		
		return other._productionDate.after(this._productionDate);//	if  {return true;} return false;
			
	}//end of method olderFoodItem
}//end of class FoodItem

