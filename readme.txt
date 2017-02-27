Files:
createdb.sql
dropdb.sql
populate.java
Hw3.java


Compilation:
$ javac populate.java

Running:
$ java –classpath .:ojdbc6.jar populate building.xy photographer.xy photo.xy

Compilation:
$ javac -classpath sdoapi.jar:ojdbc6.jar Hw3.java

Running:

$ java –classpath .:sdoapi.jar:ojdbc6.jar Hw3
