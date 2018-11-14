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

import java.util.HashSet;
import java.util.Set;


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
public class SetTest{

    @DataPoints public static Object[] sets = {
        new HashSet<String>()
    };
    @DataPoints public static Object[] intrumentedSets = {
            new InstrumentedSet<String>(new HashSet<>())
    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property 
    	assumeTrue(x != null);
    	Set s = (Set) x, t = new HashSet<String>();
        t.add("fish");
        t.add("dog");

    	s.add("cat");
    	s.addAll(t);
    	System.out.println(x);
        assertTrue(s.equals(s));
    }

    @Theory
    public void SymmetryTest(Object x, Object y) { // general test for symmetric property 
        assumeTrue(x != null);
        assumeTrue(y != null);

        Set s1 = (Set) x, s2 = (Set) y, t = new HashSet<String>();
        t.add("fish");
        t.add("dog");

        s1.add("cat");
        s1.addAll(t);
        s2.add("cat");
        s2.addAll(t);


        assertTrue(s2.equals(s1) == s1.equals(s2));
    }

    @Theory
    public void transitiveTest(Object x, Object y , Object z){ // general test for transitive property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assumeTrue(z != null);
        Set s1 = (Set) x, s2 = (Set) y, s3 = (Set) z, t = new HashSet<String>();
        t.add("fish");
        t.add("dog");

        s1.add("cat");
        s1.addAll(t);
        s2.add("cat");
        s2.addAll(t);
        s3.add("cat");
        s3.addAll(t);

        assumeTrue(s1.equals(s2));
        assumeTrue(s2.equals(s3));

        assertTrue(s1.equals(s3));
    }


    // my IDE does not run the Theories without atleast one @Test
    @Test
    public void test(){

    }

}