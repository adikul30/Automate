int Relay1 = D6;
int pir1 = D1;
int pir2 = D2;
int state1;
int state2;


void setup() {
  // put your setup code here, to run once:
  Serial.begin(115200);
  pinMode(Relay1, OUTPUT);
  pinMode(pir1, INPUT);
  pinMode(pir2, INPUT);
  digitalWrite(Relay1,LOW);
}

void loop() {
  // put your main code here, to run repeatedly:
  state1 = digitalRead(pir1);
  state2 = digitalRead(pir2);

  if (state1 == HIGH) {
    Serial.println("motion detected in pir 1");

  } else {
    Serial.println("motion still in pir 1");

  }

  if (state2 == HIGH) {
    Serial.println("Motion detected in pir 2");
  } else {==
    Serial.println("Motion still in pir 2");
  }

  if (state1 == HIGH && state2 == HIGH)
  {
    digitalWrite(Relay1, HIGH);
  }
  else
  {
    digitalWrite(Relay1, LOW);
  }
 /* digitalWrite(Relay1,HIGH);
  delay(1000);
  digitalWrite(Relay1,LOW);*/
}
