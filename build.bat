@echo off
cls
if exist build rmdir /s /q build
mkdir build
cd src
javac -d ../build com/krzem/hilbert_curver/Main.java&&jar cvmf ../manifest.mf ../build/hilbert_curver.jar -C ../build *&&goto run
cd ..
goto end
:run
cd ..
pushd "build"
for /D %%D in ("*") do (
	rd /S /Q "%%~D"
)
for %%F in ("*") do (
	if /I not "%%~nxF"=="hilbert_curver.jar" del "%%~F"
)
popd
cls
java -jar build/hilbert_curver.jar
:end
