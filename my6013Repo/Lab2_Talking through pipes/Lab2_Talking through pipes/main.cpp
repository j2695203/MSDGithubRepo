//
//  main.cpp
//  Lab2_Talking through pipes
//
//  Created by Jinny Jeng on 2/8/23.
//

#include <iostream>
#include <unistd.h>

int main(int argc, const char * argv[]) {
    
    char buffer[30]; // array to save input string
    
    // create pipe and handle error
    int fd[2];
    pipe(fd);
    if( pipe(fd) != 0 ){
        perror("pipe failed \n");
        exit(1);
    }
    
    printf("I'm parent (pid:%d), pipe built! \n", (int)getpid());
    
    // create fork, handle error, and talk through pipe
    int rc = fork();
    
    if(rc < 0){
        // fork failed, exit
        fprintf(stderr, "fork failed \n");
        exit(1);
        
    }else if(rc == 0){
        // child
        printf("I'm child (pid:%d) \n",(int)getpid());
        
        // read
        close(fd[1]);
        read(fd[0], buffer, sizeof(buffer));
        printf("%s \n", buffer);
        
    }else{
        // parent
        printf("I'm parent (pid:%d) before write \n",(int)getpid());
        
        // write
        close(fd[0]);
        write(fd[1], argv[1], sizeof(buffer));
        
        // wait for child
        wait(NULL);
        printf("I'm parent (pid:%d) after write \n",(int)getpid());
    }

    return 0;
}
