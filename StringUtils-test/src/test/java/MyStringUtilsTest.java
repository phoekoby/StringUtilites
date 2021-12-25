import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.string.MyString;
import ru.vsu.cs.string.utils.MyStringUtils;

public class MyStringUtilsTest {
    @Test
    public void testCreatingMyString(){
        MyString myString = new MyString("Hello, world");
        Assertions.assertEquals("Hello, world", myString.toString());
    }
    @Test
    public void testCreatingEmptyMyString(){
        MyString myString = new MyString("");
        Assertions.assertEquals("", myString.toString());
    }
    @Test
    public void testContainsCharacterMyString(){
        MyString myString = new MyString("Hello, world");
        Assertions.assertTrue(MyStringUtils.contains(myString,'H'));
    }
    @Test
    public void testContainsStringMyString(){
        MyString myString = new MyString("Hello, world");
        Assertions.assertTrue(MyStringUtils.contains(myString,new MyString("ello, wo")));
    }
    @Test
    public void testIndexOfCharacterMyString(){
        MyString myString = new MyString("Hello, world");
        Assertions.assertEquals(MyStringUtils.indexOf(myString,'l'),2);
    }
    @Test
    public void testIndexOfStringMyString(){
        MyString myString = new MyString("Hello, world");
        Assertions.assertEquals(MyStringUtils.indexOf(myString,new MyString("ello, wo")),1);
    }
    @Test
    public void testEquals(){
        MyString myString1 = new MyString("Hello, world");
        MyString myString2 = new MyString("Hello, world");
        MyString myString3 = new MyString("Hello, World");
        MyString myString4 = new MyString("Hello, !world");
        Assertions.assertTrue(MyStringUtils.equals(myString1,myString2));
        Assertions.assertFalse(MyStringUtils.equals(myString1,myString3));
        Assertions.assertFalse(MyStringUtils.equals(myString1,myString4));
    }
    @Test
    public void testEqualsIgnoreCase(){
        MyString myString1 = new MyString("Hello, world");
        MyString myString2 = new MyString("Hello, world");
        MyString myString3 = new MyString("Hello, World");
        MyString myString4 = new MyString("Hello, World!");
        Assertions.assertTrue(MyStringUtils.equalsIgnoreCase(myString1,myString2));
        Assertions.assertTrue(MyStringUtils.equalsIgnoreCase(myString1,myString3));
        Assertions.assertFalse(MyStringUtils.equalsIgnoreCase(myString1,myString4));
    }
    @Test
    public void testSplitMyStringUtils(){
        MyString myString1 = new MyString("Hello, world My name is Artem ");
        MyString regex = new MyString(" ");
        MyString[] strings = MyStringUtils.split(myString1,regex);
        Assertions.assertEquals(strings.length,6);
        Assertions.assertTrue(MyStringUtils.equals(strings[0],new MyString("Hello,")));
        Assertions.assertTrue(MyStringUtils.equals(strings[1],new MyString("world")));
        Assertions.assertTrue(MyStringUtils.equals(strings[2],new MyString("My")));
        Assertions.assertTrue(MyStringUtils.equals(strings[3],new MyString("name")));
        Assertions.assertTrue(MyStringUtils.equals(strings[4],new MyString("is")));
        Assertions.assertTrue(MyStringUtils.equals(strings[5],new MyString("Artem")));
        MyString regex2 = new MyString(" world ");
        MyString[] strings2 = MyStringUtils.split(myString1,regex2);
        Assertions.assertEquals(strings2.length,2);
        Assertions.assertTrue(MyStringUtils.equals(strings2[0],new MyString("Hello,")));
        Assertions.assertTrue(MyStringUtils.equals(strings2[1],new MyString("My name is Artem ")));
    }
    @Test
    public void testConcatenate(){
        MyString myString1 = new MyString("Hello, world");
        MyString myString2 = new MyString(" My name is Artem ");
        Assertions.assertTrue(MyStringUtils.concatenate(myString1,myString2).
                equals(new MyString("Hello, world My name is Artem ")));
    }
    @Test
    public void testJoin(){
        MyString myString1 = new MyString("Hello, world");
        MyString myString2 = new MyString("My name is Artem");
        Assertions.assertTrue(MyStringUtils.join(new MyString(" "),myString1,myString2).
                equals(new MyString("Hello, world My name is Artem")));
    }
    @Test
    public void testReplace(){
        MyString myString1 = new MyString("Hello, world");
        myString1.replace('l','s');
        Assertions.assertTrue(myString1.equals(new MyString("Hesso, worsd")));
    }
}
