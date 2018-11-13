import org.junit.*;
// methods for assersion and assuming
import static org.junit.Assert.*;
import static org.junit.Assume.*;

//runner
import org.junit.runner.RunWith;

//Data points and theories
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.DataPoint;

import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;

import java.util.*;

// import all of the other files
import Sets.*;
import Maps.*;
import Lists.*;
import Collections.*;




/** 
* @author Aster Bodden
* @author Abdullah Alaqeel
* By making general Junit Theories for the three relevant properties of the equals() contract in the Object class
* Running these test will show that **** need explanation on why equals is wrong 
* It was not necessary to include tests for the hashcode since the equals method was wrong 
* Contributions: 
*  Aster Bodden: Class Skeletons, Collections, List and Map into instrumented / forwarded pair  
*  Abdullah Alaqee: MatchBox equals() and hashcode().
 *  The tests are recycled from assignment 10.
 *
 *  After running the tests, we found that the symmetry property was violated.
 *  Box.equals(MatchBox) will not see the values in MatchBox, but MatchBox.equals(Box) will.
 *  So, if a MatchBox instance had anything other that null in the name field, the symmetry will be violated.
 *
 *  Bloch had another recipie for equals that violated the transitivity property.
 *
*/


@RunWith(Theories.class)
public class CompositionTest{

    public static HashSet<Integer> s1 = new HashSet<Integer>(Arrays.asList());
    public static HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(3,1));
    public static HashSet<Integer> s3 = new HashSet<Integer>(Arrays.asList(1,3));

    public static InstrumentedSet<Integer> fs1 = new InstrumentedSet<>(s1);
    public static InstrumentedSet<Integer> fs2 = new InstrumentedSet<>(s2);
    public static InstrumentedSet<Integer> fs3 = new InstrumentedSet<>(s3);


    @DataPoints public static Object[] sets = {
        s1,
        s2,
        s3,
        fs1,
        fs2,
        fs3
    };

    @DataPoints public static Object[]  collections = {
 
    };

    @DataPoints public static Object[] lists = {

    };
    @DataPoints public static Object[] maps = {

    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property 
    	assumeTrue(x != null);
    	System.out.println(x);
        assertTrue(x.equals(x));
    }

    @Theory
    public void SymmetryTest(Object x, Object y) { // general test for symmetric property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assertTrue(y.equals(x) == x.equals(y));
    }

    @Theory
    public void transitiveTest(Object x, Object y , Object z){ // general test for transitive property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assumeTrue(z != null);

        assumeTrue(x.equals(y));
        assumeTrue(y.equals(z));

        assertTrue(x.equals(z));
    }


    // my IDE does not run the Theories without atleast one @Test
    @Test
    public void test(){

    }

}