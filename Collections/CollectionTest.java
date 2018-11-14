import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.Collection;
import java.util.HashSet;

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
public class CollectionTest {

    @DataPoints public static Object[] collections = {
        new HashSet<String>()
    };
    @DataPoints public static Object[] intrumentedCollections = {
            new InstrumentedCollection<String>(new HashSet<String>())
    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property 
    	assumeTrue(x != null);
    	Collection c = (Collection) x, t = new HashSet<String>();
    	t.add("fish");
    	t.add("dog");

    	c.add("cat");
    	c.addAll(t);

    	System.out.println(c);
        assertTrue(c.equals(c));
    }

    @Theory
    public void SymmetryTest(Object x, Object y) { // general test for symmetric property 
        assumeTrue(x != null);
        assumeTrue(y != null);

        Collection c1 = (Collection) x, c2 = (Collection) y, t = new HashSet<String>();
        t.add("fish");
        t.add("dog");

        c1.add("cat");
        c1.addAll(t);
        c2.add("cat");
        c2.addAll(t);

        assertTrue(c1.equals(c2) == c2.equals(c1));
    }

    @Theory
    public void transitiveTest(Object x, Object y , Object z){ // general test for transitive property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assumeTrue(z != null);
        Collection c1 = (Collection) x, c2 = (Collection) y, c3 = (Collection) z, t = new HashSet<String>();
        t.add("fish");
        t.add("dog");

        c1.add("cat");
        c1.addAll(t);
        c2.add("cat");
        c2.addAll(t);
        c3.add("cat");
        c3.addAll(t);


        assumeTrue(c1.equals(c2));
        assumeTrue(c2.equals(c3));

        assertTrue(c1.equals(c2));
    }


    // my IDE does not run the Theories without atleast one @Test
    @Test
    public void test(){

    }

}