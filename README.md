# Command-Line-Interpreter-CLI-
An operating system interfaces with a user through a Command Line Interpreter
(CLI). A CLI is a software module capable of interpreting textual commands coming either from the 
user’s keyboard or from a script file. A CLI is often referred to as a shell.
###################################################################################
In this Project, I will write a Command Line Interpreter (CLI) for an operating 
system. My CLI should prompt the user to enter the input through the keyboard. After a sequence 
of characters is entered followed by a return, the string is parsed and the indicated command(s) 
executed. The user is then again prompted for another command.
###################################################################################
My program implements some built-in commands; the list of required commands is [clear, cd, ls, cp, mv, rm, mkdir, 
rmdir, cat, more, pwd]. 
This means that my program must implement these commands directly by using the system calls 
that implement them.The exit command is also a special case: it should simply cause termination of our program.

