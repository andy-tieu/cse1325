#Matrix3 Makefile

info:
	@echo
main: main.o
	g++ --std=c++17 main.o
main.o: matrix3.cpp
	g++ --std=c++17 matrix3.cpp -o main.o
matrix3.o: matrix3.cpp
	g++ --std=c++17 matrix3.cpp -o matrix3.o
clean: 
	rm -f *.o *.gch a.out main
