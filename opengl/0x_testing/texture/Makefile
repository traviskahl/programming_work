GNUC=g++
WINC=i686-w64-mingw32-g++
CFLAGS=-Wall -std=c++17

# we've gotta find the library locations
# these first two are for everything except -lGL
SEARCHDIRS=-L/usr/lib/x86_64-linux-gnu -L/usr/local/lib -L/usr/i686-w64-mingw32/lib

UNUSED_DIRS=-L/usr/lib -L/lib/x86_64-linux-gnu -L/lib

CLIBS=-lGLU -lGL -lglfw3 -lX11 -lXxf86vm -lXrandr -lpthread -lXi -ldl -lXinerama -lXcursor -ldl

all:
	$(GNUC) $(CFLAGS) main.cpp glad.c -o main $(CLIBS)

clean:
	rm main