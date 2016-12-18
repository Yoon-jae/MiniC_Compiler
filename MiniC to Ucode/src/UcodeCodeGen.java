import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class UcodeCodeGen {
	public static void main(String[] args) throws Exception {
        MiniCLexer lexer = new MiniCLexer(new ANTLRFileStream("./Test/test.c"));
//        MiniCLexer lexer = new MiniCLexer(new ANTLRFileStream("./Test/swap.c"));
//        MiniCLexer lexer = new MiniCLexer(new ANTLRFileStream("./Test/fibo.c"));
		CommonTokenStream tokens = new CommonTokenStream(lexer);
		MiniCParser parser = new MiniCParser(tokens);
		ParseTree tree = parser.program();

		ParseTreeWalker walker = new ParseTreeWalker();
		walker.walk(new UCodeGenListener(), tree);
	}
}