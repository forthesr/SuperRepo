/*
Lisa Shi, Kathy Lau
Error - No team name found
APCS1 pd5
HW41 -- Array of Titanium
2015 - 12 - 05
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
    private Comparable _data;
	private Comparable _lastPos;//position of last meaningful value
	private Comparable _size;//size of this instance of SuperArray

		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
    _data = new Comparable[10];
    _lastPos=-1;
    _size = 0; }

    public String toString() {
    String retS="[";
    for (int i=0; i<_size;i++){retS+=_data[i]+ ",";}
    if (retS.length()>1){retS=retS.substring(0, retS.length()-1);}
    retS+="]";
    return retS;}

    private void expand() {
    Comparable[] _data2=new Comparable[_data.length*2];
    for (int i =0; i < _data.length; i++){
      _data2[i]=_data[i];
    }_data=_data2;}

    public Comparable get( Comparable index ) {
    	return _data[index];
    }

    public Comparable set( int index, Comparable newVal ) {
    Comparable temp = _data[index];
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

	//main method for testing
	public static void main( String[] args ) {

		//Given test calls
	Comparable mayfield = new SuperArray();
	System.out.println("Printing empty SuperArray mayfield...");
	System.out.println(mayfield);

	  mayfield.add(5);
	  mayfield.add(4);
	  mayfield.add(3);
	  mayfield.add(2);
	  mayfield.add(1);

	  System.out.println("Printing populated SuperArray mayfield...");
	  System.out.println(mayfield);

	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);
	  mayfield.remove(3);
	  System.out.println("Printing SuperArray mayfield post-remove...");
	  System.out.println(mayfield);

	  mayfield.add(3,99);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(2,88);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);
	  mayfield.add(1,77);
	  System.out.println("Printing SuperArray mayfield post-insert...");
	  System.out.println(mayfield);

		}//end main
		
}//end class
