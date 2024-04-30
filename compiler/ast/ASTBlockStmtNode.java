package compiler.ast;

import java.io.OutputStreamWriter;
import java.util.List;

public class ASTBlockStmtNode extends ASTStmtNode{

    public List<ASTStmtNode> listeMitStatements;

    public ASTBlockStmtNode(List<ASTStmtNode> listeMitStatements){
        this.listeMitStatements = listeMitStatements;
    }

    @Override
    public void execute() {
        listeMitStatements.forEach(ASTStmtNode::execute);
    }

    @Override
    public void print(OutputStreamWriter outStream, String indent) throws Exception {
        outStream.write(indent);
        outStream.write("BlockStmt ");
        outStream.write("\n");
        outStream.write(indent);
        outStream.write("LBrace ");
        outStream.write("\n");
        for (ASTStmtNode node : listeMitStatements){
            node.print(outStream, indent+" ");
        }
        outStream.write(indent);
        outStream.write("RBrace ");
        outStream.write("\n");
    }
}
