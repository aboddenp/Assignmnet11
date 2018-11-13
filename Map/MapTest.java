import com.sun.tools.javac.util.List;
import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import static org.junit.Assert.assertTrue;
import static org.junit.Assume.assumeTrue;

// methods for assersion and assuming
//runner
//Data points and theories


/** 
* @author Aster Bodden
* @author Abdullah Alaqeel
* By making general Junit Theories for the three relevant properties of the equals() contract in the Object class
* Running these test will show that **** need explanation on why equals is wrong 
* It was not necessary to include tests for the hashcode since the equals method was wrong 
* Contributions: 
*  Aster Bodden: Class Skeletons, Box equals() and hashcode(). 
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
public class MapTest {

    @DataPoints public static Object[] maps = {
        new HashMap<Integer,String>()
    };
    @DataPoints public static Object[] intrumentedMaps = {
            new InstrumentedMap<Integer,String>(new HashMap<>())
    };
//    @DataPoints public static Object[]  collections = {
//
//    };
//
//    @DataPoints public static Object[] lists = {
//
//    };
//    @DataPoints public static Object[] maps = {
//
//    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property 
    	assumeTrue(x != null);
    	Map m = (Map) x, t = new HashMap<Integer,String>();
    	m.put(0,"cat");
    	t.put(1,"fish");
    	t.put(2,"dog");
    	m.putAll(t);
    	System.out.println(x);
        assertTrue(x.equals(x));
    }

    @Theory
    public void SymmetryTest(Object x, Object y) { // general test for symmetric property 
        assumeTrue(x != null);
        assumeTrue(y != null);

        Map m1 = (Map) x, m2 = (Map) y, t = new HashMap<Integer,String>();

        t.put(1,"fish");
        t.put(2,"dog");

        m1.put(0,"cat");
        m1.putAll(t);
        m2.put(0,"cat");
        m2.putAll(t);

        assertTrue(y.equals(x) == x.equals(y));
    }

    @Theory
    public void transitiveTest(Object x, Object y , Object z){ // general test for transitive property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assumeTrue(z != null);
        Map m1 = (Map) x, m2 = (Map) y, m3 = (Map) z, t = new HashMap<Integer,String>();

        t.put(1,"fish");
        t.put(2,"dog");

        m1.put(0,"cat");
        m1.putAll(t);
        m2.put(0,"cat");
        m2.putAll(t);
        m3.put(0,"cat");
        m3.putAll(t);

        assumeTrue(x.equals(y));
        assumeTrue(y.equals(z));

        assertTrue(x.equals(z));
    }


    // my IDE does not run the Theories without atleast one @Test
    @Test
    public void test(){

    }

}