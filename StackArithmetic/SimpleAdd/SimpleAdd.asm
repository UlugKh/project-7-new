@256
D=A
@SP
M=D
// C_PUSH constant 7
@7
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 8
@8
D=A
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
