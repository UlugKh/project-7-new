import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class CodeWriter {
    private String filename;
    private PrintWriter writeOut;
    private int labelNumber;

    private void out(String line) {
        writeOut.println(line);
    }

    private String nextLabel() {
        return String.valueOf(labelNumber++);
    }

    public CodeWriter(File output) throws FileNotFoundException {
        try {
            writeOut = new PrintWriter(output);
            labelNumber = 0;
        } catch (FileNotFoundException fnf) {
            throw new FileNotFoundException("File not found: " + fnf.getMessage());
        }
    }

    public void setFileName(String filename) {
        this.filename = filename;
    }

    public void writeInit() {
        // TODO: set SP to 256
        out("@256");
        out("D=A");
        out("@SP");
        out("M=D");

        // uncomment in project 8
        // writeCall("Sys.init", 0);
    }

    public void writeArithmetic(String operation) {
        out("// " + operation);

        switch (operation.toLowerCase()) {
            case "add":
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("M=D+M");
                break;

            case "sub":
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("M=M-D");
                break;

            case "and":
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("M=D&M");
                break;

            case "or":
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("M=D|M");
                break;

            case "eq":
                String eqLabel = nextLabel();
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("D=M-D");
                out("M=-1");
                out("@" + eqLabel);
                out("D;JEQ");
                out("@SP");
                out("A=M-1");
                out("M=0");
                out("(" + eqLabel + ")");
                break;

            case "lt":
                String ltLabel = nextLabel();
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("D=M-D");
                out("M=-1");
                out("@" + ltLabel);
                out("D;JLT");
                out("@SP");
                out("A=M-1");
                out("M=0");
                out("(" + ltLabel + ")");
                break;

            case "gt":
                String gtLabel = nextLabel();
                out("@SP");
                out("AM=M-1");
                out("D=M");
                out("@SP");
                out("A=M-1");
                out("D=M-D");
                out("M=-1");
                out("@" + gtLabel);
                out("D;JGT");
                out("@SP");
                out("A=M-1");
                out("M=0");
                out("(" + gtLabel + ")");
                break;

            case "not":
                out("@SP");
                out("A=M-1");
                out("M=!M");
                break;

            case "neg":
                out("@SP");
                out("A=M-1");
                out("M=-M");
                break;
        }
    }


    public void writePushPop(CommandType command, String segment, int index) {
        out("// " + command + " " + segment + " " + index);

        if (command == CommandType.C_PUSH) {
            switch (segment.toLowerCase()) {
                case "pointer":
                    out("@R3");
                    out("D=M");
                    break;
                case "static":
                    out("@" + filename + "." + index);
                    out("D=M");
                    break;
                case "constant":
                    out("@" + index);
                    out("D=A");
                    break;
                case "temp":
                    out("@R5");
                    out("D=M");
                    break;
                default:
                    // Handle "local", "argument", "this", "that"
                    String segmentLabel = getLabel(segment);
                    out("@" + segmentLabel);
                    out("D=M");
                    out("@" + index);
                    out("A=D+A");
                    out("D=M");
                    break;
            }
            finishPush();
        } else if (command == CommandType.C_POP) {
            switch (segment.toLowerCase()) {
                case "pointer":
                    out("@R3");
                    break;
                case "static":
                    out("@" + filename + "." + index);
                    break;
                case "temp":
                    out("@R5");
                    break;
                default:
                    String segmentLabel = getLabel(segment);
                    out("@" + segmentLabel);
                    out("D=M");
                    out("@" + index);
                    out("A=D+A");
                    break;
            }
            out("D=A");
            out("@R13");
            out("M=D");

            // pop value to address stored in R13
            out("@SP");
            out("AM=M-1");
            out("D=M");
            out("@R13");
            out("A=M");
            out("M=D");
        }
    }


    private void finishPush() {
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");
    }


    public void writeLabel(String label) {
        out("(" + label + ")");
    }


    public void writeGoto(String label) {
        out("@" + label);
        out("0;JMP");
    }


    public void writeIf(String label) {
        out("@SP");
        out("AM=M-1");
        out("D=M");
        out("@" + label);
        out("D;JNE");
    }


    public void writeCall(String functionName, int numArgs) {
        String returnLabel = "RETURN_" + nextLabel();
        out("// call " + functionName + " " + numArgs);

        // push return address
        out("@" + returnLabel);
        out("D=A");
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");

        // push LCL
        out("@LCL");
        out("D=M");
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");

        // push ARG
        out("@ARG");
        out("D=M");
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");

        // push THIS
        out("@THIS");
        out("D=M");
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");

        // push THAT
        out("@THAT");
        out("D=M");
        out("@SP");
        out("AM=M+1");
        out("A=A-1");
        out("M=D");

        // ARG = SP - numArgs - 5
        out("@SP");
        out("D=M");
        out("@" + numArgs);
        out("D=D-A-5");
        out("@ARG");
        out("M=D");

        // LCL = SP
        out("@SP");
        out("D=M");
        out("@LCL");
        out("M=D");

        // goto functionName
        out("@" + functionName);
        out("0;JMP");

        // declare return address label
        out("(" + returnLabel + ")");
    }


    public void writeReturn() {
        out("// return");

        // Store return address in R13 = LCL - 5
        out("@LCL");
        out("D=M");
        out("@5");
        out("A=D-A");
        out("D=M");
        out("@R13");
        out("M=D");

        // Store return value *(SP-1) in *ARG
        out("@SP");
        out("A=M-1");
        out("D=M");
        out("@ARG");
        out("A=M");
        out("M=D");

        // Restore SP = ARG + 1
        out("@ARG");
        out("D=M+1");
        out("@SP");
        out("M=D");

        // Restore THAT = *(LCL - 1); LCL--
        out("@LCL");
        out("D=M-1");
        out("A=D");
        out("D=M");
        out("@THAT");
        out("M=D");

        // Restore THIS = *(LCL - 2); LCL--
        out("@LCL");
        out("D=M-2");
        out("A=D");
        out("D=M");
        out("@THIS");
        out("M=D");

        // Restore ARG = *(LCL - 3); LCL--
        out("@LCL");
        out("D=M-3");
        out("A=D");
        out("D=M");
        out("@ARG");
        out("M=D");

        // Restore LCL = *(LCL - 4)
        out("@LCL");
        out("D=M-4");
        out("A=D");
        out("D=M");
        out("@LCL");
        out("M=D");

        // Jump to return address
        out("@R13");
        out("A=M");
        out("0;JMP");
    }


    public void writeFunction(String functionName, int numLocals) {
        out("// function " + functionName + " " + numLocals);

        // Declare label for function entry
        out("(" + functionName + ")");

        // Initialize local variables to 0
        for (int i = 0; i < numLocals; i++) {
            out("@LCL");
            out("D=M");    // D = LCL
            out("@SP");
            out("A=M");    // A = SP (top of stack)
            out("M=0");    // Set the value at SP to 0 (initialize local variable)
            out("@SP");
            out("M=M+1");  // Move SP up
        }
    }


    private String getLabel(String segment) {
        switch (segment.toLowerCase()) {
            case "local":
                return "@LCL";
            case "argument":
                return "@ARG";
            case "this":
                return "@THIS";
            case "that":
                return "@THAT";
            default:
                return null;
        }
    }

    public void close() {
        writeOut.close();
    }
}
