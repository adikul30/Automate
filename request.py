import json,requests
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BOARD)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(12,GPIO.OUT)
GPIO.setwarnings(False)
while True :
        r = requests.get('http://192.168.43.10/script.php')

        data = json.loads(r.text)
 	#print data       
        if data["message"][0]["light"]=="1" :
		print "light"
                print data["message"][0]["light"]
                GPIO.output(12,1)
        else :	
		print "light"
        	print data["message"][0]["light"]
        	GPIO.output(12,0)


        if data["message"][0]["fan"]=="1" : 
              	print "fan"
		print data["message"][0]["fan"]
                GPIO.output(18,1)
        else :
		print "fan"
        	print data["message"][0]["fan"]
                GPIO.output(18,0)

