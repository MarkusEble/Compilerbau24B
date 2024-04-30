package compiler.ast;

import compiler.SymbolTableIntf;
import java.io.OutputStreamWriter;

public class ASTVarDeclareStmtNode extends ASTStmtNode {

    String identifierSymbol;
    SymbolTableIntf symbolTable;

    public ASTVarDeclareStmtNode(String identifierSymbol, SymbolTableIntf symbolTable) {
        this.identifierSymbol = identifierSymbol;
        this.symbolTable = symbolTable;
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent + "DECLARE" + this.identifierSymbol);
        outStream.write("\n");
    }

    @Override
    public void execute() {
        this.symbolTable.createSymbol(this.identifierSymbol);
    }
}
