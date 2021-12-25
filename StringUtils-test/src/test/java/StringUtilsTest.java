import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.vsu.cs.string.utils.StringUtils;

    public class StringUtilsTest {
        @Test
        public void testCreatingEmptyString(){
            String String = "";
            Assertions.assertEquals("", String);
        }
        @Test
        public void testContainsCharacterString(){
            String String = "Hello, world";
            Assertions.assertTrue(StringUtils.contains(String,'H'));
        }
        @Test
        public void testContainsStringString(){
            String String = "Hello, world";
            Assertions.assertTrue(StringUtils.contains(String,"ello, wo"));
        }
        @Test
        public void testIndexOfCharacterString(){
            String String = "Hello, world";
            Assertions.assertEquals(StringUtils.indexOf(String,'l'),2);
        }
        @Test
        public void testIndexOfStringString(){
            String String = "Hello, world";
            Assertions.assertEquals(StringUtils.indexOf(String,"ello, wo"),1);
        }
        @Test
        public void testEquals(){
            String String1 = "Hello, world";
            String String2 = "Hello, world";
            String String3 = "Hello, World";
            String String4 = "Hello, !world";
            Assertions.assertTrue(StringUtils.equals(String1,String2));
            Assertions.assertFalse(StringUtils.equals(String1,String3));
            Assertions.assertFalse(StringUtils.equals(String1,String4));
        }
        @Test
        public void testEqualsIgnoreCase(){
            String String1 = "Hello, world";
            String String2 = "Hello, world";
            String String3 = "Hello, World";
            String String4 = "Hello, World!";
            Assertions.assertTrue(StringUtils.equalsIgnoreCase(String1,String2));
            Assertions.assertTrue(StringUtils.equalsIgnoreCase(String1,String3));
            Assertions.assertFalse(StringUtils.equalsIgnoreCase(String1,String4));
        }
        @Test
        public void testSplitStringUtils(){
            String String1 = "Hello, world My name is Artem ";
            String regex = " ";
            String[] strings = StringUtils.split(String1,regex);
            Assertions.assertEquals(strings.length,6);
            Assertions.assertTrue(StringUtils.equals(strings[0],"Hello,"));
            Assertions.assertTrue(StringUtils.equals(strings[1],"world"));
            Assertions.assertTrue(StringUtils.equals(strings[2],"My"));
            Assertions.assertTrue(StringUtils.equals(strings[3],"name"));
            Assertions.assertTrue(StringUtils.equals(strings[4],"is"));
            Assertions.assertTrue(StringUtils.equals(strings[5],"Artem"));
            String regex2 = " world ";
            String[] strings2 = StringUtils.split(String1,regex2);
            Assertions.assertEquals(strings2.length,2);
            Assertions.assertTrue(StringUtils.equals(strings2[0],"Hello,"));
            Assertions.assertTrue(StringUtils.equals(strings2[1],"My name is Artem "));
        }
        @Test
        public void testConcatenate(){
            String String1 = "Hello, world";
            String String2 = " My name is Artem ";
            Assertions.assertEquals("Hello, world My name is Artem ", StringUtils.concatenate(String1, String2));
        }
        @Test
        public void testJoin(){
            String String1 = "Hello, world";
            String String2 = "My name is Artem";
            Assertions.assertEquals("Hello, world My name is Artem", StringUtils.join(" ", String1, String2));
        }
    }


