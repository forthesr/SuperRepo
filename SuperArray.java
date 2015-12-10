/*
Lisa Shi
APCS1 pd5
HW45 -- Come Together
2015 - 12 - 09
*/

/*****************************
 * SKELETON for
 * class SuperArray --  A wrapper class for an array. 
 * Maintains functionality:
 *  access value at index
 *  overwrite value at index
 * Adds functionality to std Java array:
 *  resizability
 *  ability to print meaningfully
 *****************************/

/*(b) linSearch basically gets a comparable as an input and checks if it exists in the given instance of superArray.
 If it does returns the index of the first occuring, if it does not returns -1.
(c) isSorted() returns true if every index contains a comparable that is larger
 or equal to a comparable in the previous index. Otherwise returns false. */

public class SuperArray{

		//~~~~~INSTANCE VARS~~~~~
		private Object[] _data;
		private int _lastPos;//position of last meaningful value
		private int _size;//size of this instance of SuperArray

		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
    _data = new Object[10];
    _lastPos=-1;
    _size = 0; }

    public String toString() {
    String retS="[";
    for (int i=0; i<_size;i++){retS+=_data[i]+ ",";}
    if (retS.length()>1){retS=retS.substring(0, retS.length()-1);}
    retS+="]";
    return retS;}

    private void expand() {
    Object[] _data2=new Object[_data.length*2];
    for (int i =0; i < _data.length; i++){
      _data2[i]=_data[i];
    }_data=_data2;}

    public Object get( int index ) {
    	return _data[index];
    }

    public Comparable set( int index, Comparable newVal ) {
    Comparable temp = (Comparable)_data[index];
    _data[index]=newVal;
     return temp;
 }

  public void add( Comparable val ) {
  	add_at_index(_size, val);
  }
    //inserts an item at index
  public void add_at_index( int index, Comparable newVal ) {
       if(index>_size){_data[_size]=newVal;}
       else{
         if (_size+1>_data.length) {expand();}
         Comparable temp = newVal;
         for (int i=_size;i>=index;i--){
         	temp=set(index, temp);} }
        _size++;
        _lastPos++;
    }

  //removes the item at index
  //shifts elements left to fill in newly-empted slot
  public void remove( int index ) {
   if (index<_size ){
     for (int i=index;i<_lastPos;i++){_data[i]=_data[i+1];}
    _data[_lastPos]=0;
    _size--;
    _lastPos--;}}


    //linSearch
    //takes in comparable and finds it in array

    public int linSearch(Comparable insert){
    	int temp = 1;
    	for(int i = 0; i < _data.length; i++){
    			if (insert == _data[i]){
    				temp = 1;
    			}
    			else {temp = -1; }
    	}
    	return temp;   
    }


    //isSorted
    // checks if next slot of Array is larger than the one before
    	public boolean isSorted(){
    		boolean result = false;

    		for (int i = 0; i < _data.length; i++){

    			Comparable firstData = (Comparable) _data[i];
    			Comparable secondData = (Comparable) _data[i+1];
    			//if the first one is smaller, will yield -1
    			if(firstData.compareTo(secondData) == -1)
    			{
    				result = true;
    			}
    			else
    			{
    				result = false;
    				return result;
    			}
    		}
    		return result;
    	}

	//main method for testing
	public static void main( String[] args ) {

	SuperArray mixed = new SuperArray();
	mixed.add( new Hexadecimal(60) );
	mixed.add( new Binary("16") );
	mixed.add( new Hexadecimal(100) );
	mixed.add( new Rational(2, 1) );

	Hexadecimal a = new Hexadecimal(100);
	Rational b = new Rational(3, 6);
	System.out.println( mixed.linSearch(b) );
	System.out.println( mixed.linSearch(a) );

	System.out.println( mixed.isSorted() );

		}//end main
		
}//end class
