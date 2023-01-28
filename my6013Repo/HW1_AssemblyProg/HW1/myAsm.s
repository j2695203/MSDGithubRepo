
extern puts

section .text  ; this says that we're about to write code (as opposed to data)

global sayHello, myPuts ; this says that "sayHello" is a symbol that the linker needs to know about

sayHello:           ;and here we go...

push rbp ;push rbp onto the stack, making it 8 byte aligned
mov edi, helloString
call puts  
pop rbp ;pop it off the stack so that the caller's return address is now on top of the stack
ret                 ; just return


myPuts:

;push rbp

mov rax, 1 ; syscall number for write

mov rdx, rsi ; put size into write's 3rd parameter
mov rsi, rdi ; put string into write's 2nd parameter
mov rdi, 1; unsigned int fd (file descriptor) 1 means stdout

syscall

;pop rbp
ret


section .rodata  ; this is the read only data (hello is a constant) 
helloString: db "hello",0 ; hellostring is the name of our symbol
; db is the directive to put data in our object file
; the 0 is the null terminator that puts is expecting.  
; nasm does NOT null terminate our string automatically


