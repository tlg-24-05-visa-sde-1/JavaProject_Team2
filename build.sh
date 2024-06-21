javac -d classes -classpath "lib/*" src/com/savage/blackjack/*.java src/com/savage/blackjack/client/*.java src/com/savage/blackjack/controller/*.java
jar --create --file blackjack-1.0.jar -C classes .
