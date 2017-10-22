all: httpServer

httpServer: HttpHandler.java Server.java
	javac *.java

run: httpServer
	java Server

clean:
	rm *.class
