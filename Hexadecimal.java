/*
Lisa Shi
APCS1 PD5
HW45 Come Together
2015-12-08
 */

 public class Hexadecimal implements Comparable {
  private int _decNum;
  private String _hexNum;
  private final static String HEXDIGITS = "0123456789ABCDEF";
  private final static String [] HexDigits = {"0", "1", "2", "3","4","5","6","7","8","9","A","B","C","D","E","F"};
 
         /*=====================================
      default constructor
      pre:  n/a
      post: initializes _decNum to 0
      =====================================*/
  public Hexadecimal(){
    _decNum = 0;
    _hexNum = "0";
  }
          /*=====================================
      overloaded constructors
      pre:  s is String representing non-negative hexadecimal number
      post: sets  _decNum to decimal equiv
      =====================================*/
  public Hexadecimal(int n){
    _decNum = n;
    _hexNum = decToHex(n);
  }
  
  public Hexadecimal(String s){
    _decNum = hexToDec(s);
    _hexNum = s;
  } 
  
      /*=====================================
      String toString() -- returns String representation of this Object
      pre:  n/a
      post: returns String representing value of this Object
      =====================================*/
    public String toString() { 
     return _hexNum;
    }
  
  public static int hexToDec(String str){
    int ans = 0;
    int len = str.length();
    while (len > 0){
      ans = 16*ans + HEXDIGITS.indexOf(str.substring(0,1));
      str = str.substring(1);
      len--;
    }
    return ans;
  }
      /*=====================================
      String HexToDecR(String) -- converts base-10 input to Hexadecimal, recursively
      pre:  s represents non-negative Hexadecimal number
      post: returns decimal equivalent as int
      eg  
      HexToDecR("0") -> 0
      HexToDecR("1") -> 1
      HexToDecR("A") -> 10
      HexToDecR("10") -> 16
      =====================================*/
  public static int hexToDecR(String str){
    if(str.length() == 0) return 0;
    return 16*hexToDecR(str.substring(0,str.length()-1)) + (HEXDIGITS.indexOf(str.substring(str.length()-1)));
  }
  
       /*=====================================
      String decToHex(int) -- converts base-10 input to hexadecimal
      pre:  n >= 0
      post: returns String of bits
      eg  decToHex(0) -> "0"
      decToHex(1) -> "1"
      decToHex(10) -> "A"
      decToHex(16) -> "10"
      =====================================*/
  public static String decToHex(int n){
    String ans = "";
    int temp = 0;
    while(n>0){
      temp = n%16;
      n = n/16;
      ans = HexDigits[temp] + ans; 
    }
    return ans;
  }
    /*=====================================
      String decToHexR(int) -- converts base-10 input to Hexadecimal, recursively
      pre:  n >= 0
      post: returns String of bits
      eg  decToHexR(0) -> "0"
      decToHexR(1) -> "1"
      decToHexR(10) -> "A"
      decToHexR(16) -> "10"
      =====================================*/
  public static String decToHexR(int n){
    if(n==0) return "";
    return decToHexR(n/16) + HexDigits[n%16];
  } 
  
          /*=============================================
      boolean equals(Object) -- tells whether 2 Objs are equivalent
      pre:  other is an instance of class Hexadecimal
      post: Returns true if this and other are aliases (pointers to same 
      Object), or if this and other represent equal Hexary values
      =============================================*/

    public boolean equals( Object other ) { 
       boolean aliasCheck = this == other;
       if ( !aliasCheck ){
         aliasCheck = other instanceof Hexadecimal
          && this._hexNum.equals(((Hexadecimal)other)._hexNum);
           }
       return aliasCheck;
     }

    /*=============================================
      int compareTo(Object) -- tells which of two Hexadecimal objects is greater
      pre:  other is instance of class Hexadecimal
      post: Returns 0 if this Object is equal to the input Object,
      negative integer if this<input, positive integer otherwise
      =============================================*/

    public int compareTo( Object other ) {
          if (other == null){
        throw new NullPointerException("null object");
      }
      else if (!(other instanceof Comparable) ){
        throw new ClassCastException("not same class");
      }
      else if(this._decNum == ((Hexadecimal)other)._decNum){
           return 0;
            }
       else if(this._decNum > ((Hexadecimal)other)._decNum){
            return 1;
             }
       else{
            return -1;
             }
          }


  public static void main(String [] args){
    System.out.println(Hexadecimal.hexToDec("2E6"));
    System.out.println(Hexadecimal.hexToDecR("2E6"));
    System.out.println(Hexadecimal.decToHex(742));
    System.out.println(Hexadecimal.decToHexR(742));
    
  }
}
