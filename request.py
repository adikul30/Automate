
import json,requests
import RPi.GPIO as GPIO
GPIO.setmode(GPIO.BCM)
GPIO.setup(18,GPIO.OUT)
GPIO.setup(24,GPIO.OUT)
GPIO.setwarnings(False)
while True :
        r = requests.get('http://10.0.9.158/script.php')

        data = json.loads(r.text)
        #print data       
        if data["message"][0]["light"]=="1" :
                print "light"
                print data["message"][0]["light"]
                GPIO.output(24,1)
        else :
                print "light"
                print data["message"][0]["light"]
                GPIO.output(24,0)


        if data["message"][0]["fan"]=="1" :
                print "fan"
                print data["message"][0]["fan"]
                GPIO.output(18,1)
        else :
                print "fan"
                print data["message"][0]["fan"]
                GPIO.output(18,0)


