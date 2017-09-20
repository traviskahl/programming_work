GNUC=g++
WINC=i686-w64-mingw32-g++
CFLAGS=-Wall -std=c++17

# we've gotta find the library locations
# these first two are for everything except -lGL
SEARCHDIRS=-L/usr/lib/x86_64-linux-gnu -L/usr/local/lib -L/usr/i686-w64-mingw32/lib

UNUSED_DIRS=-L/usr/lib -L/lib/x86_64-linux-gnu -L/lib

CLIBS=-lGLU -lGL -lglfw -lX11 -lXxf86vm -lXrandr -lpthread -lXi -ldl -lXinerama -lXcursor -ldl

linux:
	$(GNUC) $(CFLAGS) main.cpp glad.c -o main $(CLIBS)

windows:
	$(WINC) --static $(CFLAGS) $(SEARCHDIRS) main.cpp glad.c -o main.exe $(CLIBS)

clean:
	rm main main.exe