@256
D=A
@SP
M=D
// C_PUSH constant 111
@111
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 333
@333
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 888
@888
D=A
@SP
AM=M+1
A=A-1
M=D
// C_POP static 8
@StaticTest.8
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_POP static 3
@StaticTest.3
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_POP static 1
@StaticTest.1
D=A
@R13
M=D
@SP
AM=M-1
D=M
@R13
A=M
M=D
// C_PUSH static 3
@StaticTest.3
D=M
@SP
AM=M+1
A=A-1
M=D
// C_PUSH static 1
@StaticTest.1
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
// C_PUSH static 8
@StaticTest.8
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
