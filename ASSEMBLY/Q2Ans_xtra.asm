.MODEL SMALL
.STACK 100H    

.DATA	
    str DB 80 DUP (?)
    textString DB 'Enter text',0DH,0AH,'$'
    printVowel DB 10,13,'Vowels=$'
    printCons DB 10,13,'Consonants=$'
    vowelCount DB '0'
    consonentCount DB '0' 
    
    

.CODE   
MAIN PROC
    MOV AX, @DATA
	MOV DS, AX
	
	MOV AH,9              ; display string function
	LEA DX, textString    ; load effective address of the string
	INT 21H               ; wait untill display function exit
	
	MOV BL, '0'          
	MOV CL, '0'
	MOV SI,0
	
    MOV AH,1 	          ; Read char function
    next:
    	INT 21H
    	CMP AL, 0DH       ; is it equal to newline?
    	JE print
    	MOV str[SI], AL   ; indexing the inputs
    	
    upper: 
        CMP str[SI],'A'
        JL special
        CMP str[SI],'Z'
        JG lower
        JMP count 
        
    lower: 
        CMP str[SI],'a'
        JL special
        CMP str[SI],'z'
        JG special
    
    count:
    	CMP str[SI],'A'  
    	JZ vowel
    	CMP str[SI],'a'
    	JZ vowel
    	CMP str[SI],'E'
    	JZ vowel
    	CMP str[SI],'e'
    	JZ vowel
    	CMP str[SI],'I'
    	JZ vowel
    	CMP str[SI],'i'
    	JZ vowel
    	CMP str[SI],'O'
    	JZ vowel       
    	CMP str[SI],'o'
    	JZ vowel
    	CMP str[SI],'U'
    	JZ vowel
    	CMP str[SI],'u'
    	JZ vowel       
    	JMP cons   
    	
    vowel:
    	ADD vowelCount,1 
    	jmp special    
    	
    cons:
    	ADD consonentCount,1  
    	
    
    special:  
        CMP str[SI], ' '
        JMP ignore   ;unconditional jump
   
        
    ignore:        
        INC SI
        JMP NEXT
        
    print:   
        ;output vowel
    	MOV AH,9
    	LEA DX, PrintVowel  ; load address of the string.. 
    	INT 21H 
    	
    	MOV AH,2
    	MOV DL,vowelCount
    	INT 21H  
    	
    	;output consonants
    	MOV AH,9
    	LEA DX, PrintCons
    	INT 21H
    	
    	MOV AH, 2
    	MOV DL,consonentCount
    	INT 21H
    
    	
    Exit:
        MOV AH, 4CH   ; control goes to os from here. 
	INT 21H
        MAIN ENDP
END MAIN