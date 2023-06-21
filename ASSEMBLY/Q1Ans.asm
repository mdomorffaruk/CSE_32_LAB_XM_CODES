.MODEL SMALL 
.STACK 100H 



.DATA     
    textString DB 'Enter Text',0DH,0AH,'$'  
    
    errorMessage DB 0DH, 0AH, 'No Capitals $'        
    
    capitalMessage   DB   0DH, 0AH, 'First Capital = ' 
    firstCapital DB '] ' 
     DB  0DH, 0AH,  'Last Capital = '   
    lastCapital  DB '@ $'          

                        
              
.CODE 

MAIN PROC   
    
     MOV AX, @DATA
     MOV DS, AX
     

     MOV AH, 9                  ;display string function
     LEA DX, textString             
     INT 21H                    ;display
     

     MOV AH, 1                  ;read char function
     INT 21H                    

WHILE:                            ;  lebel
     CMP AL, 0DH                
     JE END_WHILE                
     

     CMP AL, 'A'                
     JNGE END_IF                
     CMP AL, 'Z'                
     JNLE END_IF                
     

     CMP AL, firstCapital              
     JNL CHECK_LAST              
     
     MOV firstCapital, AL              


CHECK_LAST:
     
    
     CMP AL, lastCapital               
     JNG END_IF                 
     
                     

     MOV lastCapital, AL               
     
END_IF: 
      

     INT 21H                   ;store data in AL
     JMP WHILE                 ;go to while lebel  
     
     
     
      
     
END_WHILE:  


       
     MOV AH, 9                 
     

     CMP firstCapital, ']'             ;firstCapital  ']'
     JNE CAPS                   
     
     LEA DX, errorMessage          ;NO CAPITALS
     JMP DISPLAY
     
     CAPS:
          LEA DX, capitalMessage       ; load address of the string.
          
     DISPLAY:
            INT 21H            
             
            MOV AH, 4CH                  ; control goes to os from here.
            INT 21H
            
            
     MAIN ENDP
           END MAIN
