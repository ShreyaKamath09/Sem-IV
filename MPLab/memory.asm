.model small

.code
mov SI, 2000h
mov DI, 4000h
mov cl, 04h

l1:
mov al, [SI]
mov [DI], al
inc SI
inc DI
dec cl
jnz loop1
int 03h

end

to run: 
td memory.exe
view: dump
enter 4 numbers
press f9 or run
go to other memory location
