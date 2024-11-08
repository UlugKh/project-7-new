@256
D=A
@SP
M=D
// C_PUSH constant 17
@17
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 17
@17
D=A
@SP
AM=M+1
A=A-1
M=D
// eq
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@0
D;JEQ
@SP
A=M-1
M=0
(0)
// C_PUSH constant 17
@17
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 16
@16
D=A
@SP
AM=M+1
A=A-1
M=D
// eq
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@1
D;JEQ
@SP
A=M-1
M=0
(1)
// C_PUSH constant 16
@16
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 17
@17
D=A
@SP
AM=M+1
A=A-1
M=D
// eq
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@2
D;JEQ
@SP
A=M-1
M=0
(2)
// C_PUSH constant 892
@892
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 891
@891
D=A
@SP
AM=M+1
A=A-1
M=D
// lt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@3
D;JLT
@SP
A=M-1
M=0
(3)
// C_PUSH constant 891
@891
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 892
@892
D=A
@SP
AM=M+1
A=A-1
M=D
// lt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@4
D;JLT
@SP
A=M-1
M=0
(4)
// C_PUSH constant 891
@891
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 891
@891
D=A
@SP
AM=M+1
A=A-1
M=D
// lt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@5
D;JLT
@SP
A=M-1
M=0
(5)
// C_PUSH constant 32767
@32767
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 32766
@32766
D=A
@SP
AM=M+1
A=A-1
M=D
// gt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@6
D;JGT
@SP
A=M-1
M=0
(6)
// C_PUSH constant 32766
@32766
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 32767
@32767
D=A
@SP
AM=M+1
A=A-1
M=D
// gt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@7
D;JGT
@SP
A=M-1
M=0
(7)
// C_PUSH constant 32766
@32766
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 32766
@32766
D=A
@SP
AM=M+1
A=A-1
M=D
// gt
@SP
AM=M-1
D=M
@SP
A=M-1
D=M-D
M=-1
@8
D;JGT
@SP
A=M-1
M=0
(8)
// C_PUSH constant 57
@57
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 31
@31
D=A
@SP
AM=M+1
A=A-1
M=D
// C_PUSH constant 53
@53
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
// C_PUSH constant 112
@112
D=A
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
// neg
@SP
A=M-1
M=-M
// and
@SP
AM=M-1
D=M
@SP
A=M-1
M=D&M
// C_PUSH constant 82
@82
D=A
@SP
AM=M+1
A=A-1
M=D
// or
@SP
AM=M-1
D=M
@SP
A=M-1
M=D|M
// not
@SP
A=M-1
M=!M
