package ast;

import org.mozilla.javascript.CompilerEnvirons;
import org.mozilla.javascript.Parser;
import org.mozilla.javascript.ast.AstNode;
import org.mozilla.javascript.ast.AstRoot;
import org.mozilla.javascript.ast.FunctionCall;
import org.mozilla.javascript.ast.NodeVisitor;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class JavaScriptAstParser {
    String javaScriptFile;

    public JavaScriptAstParser(String javaScriptFile) {
        this.javaScriptFile = javaScriptFile;
    }


    public List<String> getLocalImports() throws IOException {

        List<String> localDependencies = new ArrayList<>();

        class Printer implements NodeVisitor {
            //Stack<AstNode> stack = new Stack<AstNode>();
            public boolean visit(AstNode node) {
                String indent = "%1$Xs".replace("X", String.valueOf(node.depth() + 1));
                System.out.format(indent, "").println(node.getClass());

                if (node.getClass().equals(FunctionCall.class)){
                    List<AstNode> imports = ((FunctionCall)node).getArguments();

                    // todo : implement logic here
                    localDependencies.add("");
                }
                //System.out.format(indent, "").println(((AstRoot) node).getSymbols().get(0).getName());
                return true;
            }
        }
        String file = javaScriptFile;
        Reader reader = new FileReader(file);
        try {
            CompilerEnvirons env = new CompilerEnvirons();
            env.setRecordingLocalJsDocComments(true);
            env.setAllowSharpComments(true);
            env.setRecordingComments(true);
            AstRoot node = new Parser(env).parse(reader, file, 1);
            node.visitAll(new Printer());
        } finally {
            reader.close();
        }


        return null;
    }
}
