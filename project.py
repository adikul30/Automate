import RPi.GPIO as GPIO
import time
i=0
j=0
k=0
l=0
t=0
c1=0

c2=0

c3=0

c4=0

GPIO.setwarnings(False)

GPIO.setmode(GPIO.BOARD)

GPIO.setup(7, GPIO.IN) 

GPIO.setup(16, GPIO.IN)

GPIO.setup(12, GPIO.OUT)
GPIO.setup(18, GPIO.OUT)
while True:                         

                  print (GPIO.input(7))
                  
                  print (GPIO.input(16))
                 
		  if GPIO.input(7) == 0: 
                            while i==0:
                                       i=GPIO.input(7)
                            time.sleep(0.25)
                            c1=c1+1
			    t=1
                            i=0
                            
		  elif GPIO.input(16) == 0:
                               while j==0:
                                                  j=GPIO.input(16)
                               time.sleep(0.25)  

                               c2=c2+1
			       t=2
                               j=0
      		  if c1==c2 and t==2:                               
                                 
                                c3=c3+1   
                                t=0
                               # print ("c3 is ",c3) 
		  elif c1==c2 and t==1:
                                                                        
                                t=0      
                                c4=c4+1                               
                               # print ("c4 is ",c4) 
                  #print ("c1 is ",c1)
                  #print ("c2 is ",c2)                       
                  if c3<>c4:
                       GPIO.output(18,True)
                       print "Fan is on"
                       GPIO.output(12,True)                     #Light is on
                       print ("Bulb is on")
                  else:
                       GPIO.output(18,False)
                       print "Fan is off"
                       GPIO.output(12,False)                    #Light is off
                       print ("Bulb is off")
                  i=0
                  j=0
                  k=0
                  l=0

                  if c1-c2>1:
                     c1=c1-1
                  if c2-c1>1:
                     c2=c2-1                      

