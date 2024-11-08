@256
D=A
@SP
M=D
// C_PUSH constant 3030
@3030
D=A
@SP
AM=M+1
A=A-1
M=D
// C_POP pointer 0
@R3
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_PUSH constant 3040
@3040
D=A
@SP
AM=M+1
A=A-1
M=D
// C_POP pointer 1
@R3
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_PUSH constant 32
@32
D=A
@SP
AM=M+1
A=A-1
M=D
// C_POP this 2
@@THIS
D=M
@2
A=D+A
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_PUSH constant 46
@46
D=A
@SP
AM=M+1
A=A-1
M=D
// C_POP that 6
@@THAT
D=M
@6
A=D+A
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_PUSH pointer 0
@R3
D=M
@SP
AM=M+1
A=A-1
M=D
// C_PUSH pointer 1
@R3
D=M
@SP
AM=M+1
A=A-1
M=D
// add
@SP
AM=M-1
D=M
@SP
A=M-1
M=D+M
// C_PUSH this 2
@@THIS
D=M
@2
A=D+A
D=M
@SP
AM=M+1
A=A-1
M=D
// sub
@SP
AM=M-1
D=M
@SP
A=M-1
M=M-D
// C_PUSH that 6
@@THAT
D=M
@6
A=D+A
D=M
@SP
AM=M+1
A=A-1
M=D
// add
@SP
AM=M-1
D=M
@SP
A=M-1
M=D+M
