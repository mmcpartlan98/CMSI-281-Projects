/** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
* File name  :  TargetFile.java
* Purpose    :  Copies some files
* @author    :  Matt McPartlan
* Date       :  2018-09-10
*  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
**/

import java.util.Arrays;
import java.lang.Math;


public class TargetFile {

  public DynamicChangeMaker( int denominations[], int centValue ) {
    _indeces = new int[denominations.length];
    for (int i = 0; i < denominations.length; i++) {
      _indeces[i] = i;
    }
    _denominations = verifyDenominations(denominations);
    _changeValue = validateChangeValue(centValue);
    _table = new Tuple[this.getDenominations().length()][this.getChangeValue()];

    for( int i = 0; i < this.getDenominations().length(); i++ ) {
      for( int j = 0; j < this.getChangeValue(); j++ ) {
        int zeros[] = new int[this.getDenominations().length()];
        Arrays.fill(zeros, 0);
        _table[i][j] = new Tuple(zeros);
      }
    }
  }


  /** ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
  *  the main method redirects the user to the test class
  *  @param  args  String array which contains command line arguments
  *  note:  we don't really care about these
  *  ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~ */
  public static void main( String[] args ) {

  }
}
