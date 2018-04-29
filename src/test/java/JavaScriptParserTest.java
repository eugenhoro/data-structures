import ast.JavaScriptAstParser;
import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Paths;
import java.util.List;

public class JavaScriptParserTest {

        @Test
        public void testLocalImports() {

        String jsFile = Paths.get(System.getProperty("user.dir"),"src\\test\\resources\\sample.js").toAbsolutePath().toString();

        JavaScriptAstParser javaScriptParser = new JavaScriptAstParser(jsFile);

        try {
            List<String> localImports = javaScriptParser.getLocalImports();

        } catch (Exception ex) {
            Assert.assertTrue(false);
        }
    }
}
