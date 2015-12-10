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

public class SuperArray implements ListInt {

		//~~~~~INSTANCE VARS~~~~~
    private int[] _data;
		private int _lastPos;//position of last meaningful value
		private int _size;//size of this instance of SuperArray

		//~~~~~METHODS~~~~~
    //default constructor – initializes 10-item array
    public SuperArray() {
    _data = new int[10];
    _lastPos=-1;
    _size = 0; }

    public String toString() {
    String retS="[";
    for (int i=0; i<_size;i++){retS+=_data[i]+ ",";}
    if (retS.length()>1){retS=retS.substring(0, retS.length()-1);}
    retS+="]";
    return retS;}

    private void expand() {
    int[] _data2=new int[_data.length*2];
    for (int i =0; i < _data.length; i++){
      _data2[i]=_data[i];
    }_data=_data2;}

    public int get( int index ) {return _data[index];}

    public int set( int index, int newVal ) {
      int temp = _data[index];
    _data[index]=newVal;
  return temp;}

  public void add( int val ) {add_at_index(_size, val);}
    //inserts an item at index
  public void add_at_index( int index, int newVal ) {
       if(index>_size){_data[_size]=newVal;}
       else{
         if (_size+1>_data.length) {expand();}
         int temp = newVal;
         for (int i=_size;i>=index;i--){temp=set(index, temp);}}
        _size++;
        _lastPos++;}

/* public void add(int a) {
        _lastPos += 1;
        if (_lastPos >= _size) { //expand the array until the size is big enough
            expand();
        }
        _data[_lastPos] = a;
        _size += 1;
    }
    public void add(int a, int index) {
        if (index > _lastPos) {
            add(a);
        }
        else {
            for (int i = _size ; i>=index ; i--) {
                _data[i] = _data[i - 1];
            }
            _data[index] = a;
            _lastPos += 1;
            _size += 1;
        }
    }*/

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
	ListInt mayfield = new SuperArray();
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

	  /*
		SuperArray test = new SuperArray();

		//test set
		//fill array test with numbers
		test.set(0,1);
		test.set(1,2);
		test.set(2,3);
		test.set(3,4);
		test.set(4,5);
		test.set(5,6);
		test.set(6,7);
		test.set(7,8);
		test.set(8,9);
		test.set(9,10);

		//test toString
		System.out.println( test.toString() );

		//test get
		//return value at space called
		System.out.println("the 4rd value of this array is: ");
		System.out.println( test.get(3) );
		System.out.println("the 6th value of this array is: ");
		System.out.println( test.get(5) );
		System.out.println("the last value of this array is: ");
		System.out.println( test.get(9) );

		//test expand
		test.expand();

		//insert new values
		test.set(10,12);
		test.set(11,13);
		test.set(12,14);
		test.set(13,15);
		test.set(14,16);
		test.set(15,11);
		test.set(18,2);
		test.set(19,0);

		//test toString
		System.out.println( test.toString() );

		//test get
		System.out.println( "Every other new value: ");
		System.out.println( test.get(10) );
		System.out.println( test.get(12) );
		System.out.println( test.get(14) );
		System.out.println( test.get(16) ); //error?
											//no error, returns 0
		System.out.println( test.get(18) ); */


		}//end main
		
}//end class
