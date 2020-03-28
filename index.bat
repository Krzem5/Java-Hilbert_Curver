echo off
echo NUL>_.class&&del /s /f /q *.class
cls
javac com/krzem/hilbert_curver/Main.java&&java com/krzem/hilbert_curver/Main
start /min cmd /c "echo NUL>_.class&&del /s /f /q *.class"