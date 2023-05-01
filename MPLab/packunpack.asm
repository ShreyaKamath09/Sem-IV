.model small

.data
a db 49h

.code
mov ax, @data
mov ds, ax

mov al, a
and al, 0f0h
mov cl, 04h

rcr al, cl
mov bh, al

call disp
mov al, a
and al, 0fh
mov bh, al

call disp
mov ah, 4ch
int 21h

disp proc near
mov ch, 02h
mov cl, 04h

l2:
rol bh, cl
mov dl, bh
and dl, 0fh
cmp dl, 09
jbe l4
add dl, 07

l4:
add dl, 30h
mov ah, 02
int 21h
dec ch
jnz l2

mov ah, 02h
mov dl, ' '
int 21h
endp
ret
end





