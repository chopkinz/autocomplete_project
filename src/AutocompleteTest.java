import org.junit.Assert;
import java.util.Arrays;
import java.util.Collections;
import org.junit.Before;
import org.junit.Test;

public class AutocompleteTest {
   private Autocomplete.Autocompletor instance;
   @Before public void setUp() {
      String[] terms = {"ape", "app", "ban", "bat", "bee", "car", "cat"};
      double[] weights = {6, 4, 2, 3, 5, 7, 1};
      instance = new Autocomplete.TrieAutocomplete(terms, weights);
   }

    /* TopMatch Tests */
   @Test public void testTopMatch0() {
      String query = " ";
      String expected = "";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch1() {
      String query = "";
      String expected = "car";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch2() {
      String query = "a";
      String expected = "ape";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch3() {
      String query = "b";
      String expected = "bee";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch4() {
      String query = "c";
      String expected = "car";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch5() {
      String query = "d";
      String expected = "";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch6() {
      String query = "ap";
      String expected = "ape";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch7() {
      String query = "ba";
      String expected = "bat";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch8() {
      String query = "ca";
      String expected = "car";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatch9() {
      String query = "cat";
      String expected = "cat";
      String actual = instance.topMatch(query);
      Assert.assertEquals(expected, actual);
   }

   /* topMatches tests */
   @Test public void testTopMatches10() {
      int k = 8;
      String query = "";
      Iterable<String> expected = Arrays.asList("car", "ape", "bee", "app", "bat", "ban", "cat");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches11() {
      int k = 1;
      String query = "";
      Iterable<String> expected = Collections.singletonList("car");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches12() {
      int k = 2;
      String query = "";
      Iterable<String> expected = Arrays.asList("car", "ape");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches13() {
      int k = 3;
      String query = "";
      Iterable<String> expected = Arrays.asList("car", "ape", "bee");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches14() {
      int k = 1;
      String query = "a";
      Iterable<String> expected = Collections.singletonList("ape");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches15() {
      int k = 1;
      String query = "ap";
      Iterable<String> expected = Collections.singletonList("ape");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches16() {
      int k = 2;
      String query = "b";
      Iterable<String> expected = Arrays.asList("bee", "bat");
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }

   @Test public void testTopMatches17() {
      int k = 100;
      String query = "d";
      Iterable<String> expected = Collections.emptyList();
      Iterable<String> actual = instance.topMatches(query, k);
      Assert.assertEquals(expected, actual);
   }
}

//***passed all test cases***//