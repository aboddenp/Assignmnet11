import org.junit.Test;
import org.junit.experimental.theories.DataPoints;
import org.junit.experimental.theories.Theories;
import org.junit.experimental.theories.Theory;
import org.junit.runner.RunWith;

import java.util.LinkedList;
import java.util.List;

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
public class ListTest {

    @DataPoints public static Object[] lists = {
            new LinkedList<String>()
    };
    @DataPoints public static Object[] intrumentedLists = {
            new InstrumentedList<String>(new LinkedList<String>())
    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property 
    	assumeTrue(x != null);
    	List l = (List) x, t = new LinkedList<String>();

    	t.add("fish");
    	t.add("dog");

        l.add("cat");
    	l.addAll(0, t);
    	System.out.println(x);
        assertTrue(l.equals(l));
    }

    @Theory
    public void SymmetryTest(Object x, Object y) { // general test for symmetric property 
        assumeTrue(x != null);
        assumeTrue(y != null);

        List l1 = (List) x, l2 = (List) y, t = new LinkedList<String>();
        t.add("fish");
        t.add("dog");

        l1.add("cat");
        l1.addAll(t);
        l2.add("cat");
        l2.addAll(t);

        assertTrue(l2.equals(l1) == l1.equals(l2));
    }

    @Theory
    public void transitiveTest(Object x, Object y , Object z){ // general test for transitive property 
        assumeTrue(x != null);
        assumeTrue(y != null);
        assumeTrue(z != null);
        List l1 = (List) x, l2 = (List) y, l3 = (List) z, t = new LinkedList<String>();

        t.add("fish");
        t.add("dog");

        l1.add("cat");
        l1.addAll(t);
        l2.add("cat");
        l2.addAll(t);
        l3.add("cat");
        l3.addAll(t);

        assumeTrue(l1.equals(l2));
        assumeTrue(l2.equals(l3));

        assertTrue(l1.equals(l3));
    }


    // my IDE does not run the Theories without atleast one @Test
    @Test
    public void test(){

    }

}