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



/** 
* @author Aster Bodden
* @author Abdullah Alaqeel
* By making general Junit Theories for the three relevant properties of the equals() contract in the Object class
* Running these test will show which wrapping class does not work  with equals and why:
* Contributions: 
*  Aster Bodden: Class Skeletons, Collections, List and Map into instrumented / forwarded pair  
*  Abdullah Alaqee: JunitTests and Problem explanations 
*  The tests are recycled from assignment 10.
*
* Explanations:
*  In AnswerSheet File 
*/


@RunWith(Theories.class)
public class CompositionTest{

    // Sets
    public static HashSet<Integer> s1 = new HashSet<Integer>();
    public static HashSet<Integer> s2 = new HashSet<Integer>(Arrays.asList(3,1));
    public static HashSet<Integer> s3 = new HashSet<Integer>(Arrays.asList(1,3));

    // Lists
    public static List<Integer> l1 = new ArrayList<Integer>();
    public static List<Integer> l2 = new ArrayList<Integer>(Arrays.asList(3,1));
    public static List<Integer> l3 = new ArrayList<Integer>(Arrays.asList(1,3));

    // Maps
    public static Map<Integer, Integer> m1 = new HashMap<>();
    public static Map<Integer, Integer> m2 = new HashMap<>();
    public static Map<Integer, Integer> m3 = new HashMap<>();

    {
        m1.put(0,1);
        m1.put(1,3);
        m2.put(0,3);
        m2.put(1,1);
    }

    // Test dataPoints 

    @DataPoints public static Object[] sets = {
            s1, s2, s3,
            new InstrumentedSet<>(s1),
            new InstrumentedSet<>(s2),
            new InstrumentedSet<>(s3)
    };

    @DataPoints public static Object[]  collections = {
            new InstrumentedCollection<>(s1),
            new InstrumentedCollection<>(s2),
            new InstrumentedCollection<>(s3)
    };

    @DataPoints public static Object[] lists = {
            l1, l2, l3,
            new InstrumentedList<>(l1),
            new InstrumentedList<>(l2),
            new InstrumentedList<>(l3)
    };
    @DataPoints public static Object[] maps = {
            m1, m2, m3,
            new InstrumentedMap<>(m1),
            new InstrumentedMap<>(m2),
            new InstrumentedMap<>(m3)
    };

    @Theory
    public void reflexiveTest(Object x){  // general test for reflexive property
    	assumeTrue(x != null);
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