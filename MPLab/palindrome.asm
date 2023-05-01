.model small
.stack 100h

.data
string db 'aabbaa', '$'
string1 db 'String is a Palindrome', '$'
string2 db 'String is not a Palindrome', '$'

.code
mov ax, @data
mov ds, ax

call palindrome
mov ah, 4ch
int 21h
endp

palindrome proc
mov SI, offset string

l1:
mov ax, [SI]
cmp al, '$'
je label1
inc SI
jmp l1

label1:
mov DI, offset string
dec SI

l2:
cmp SI, DI
jl op1
mov ax, [SI]
mov bx, [DI]
cmp al, bl
jne op2
inc DI
dec SI
jmp l2

op1:
lea dx, string1
mov ah, 09h
int 21h
ret

op2:
lea dx, string2
mov ah, 09h
int 21h
ret

palindrome endp
end