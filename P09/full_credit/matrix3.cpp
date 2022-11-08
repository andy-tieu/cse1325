#include "matrix3.h"
#include <iostream>

Matrix3::Matrix3(int m00, int m10, int m20, int m01, int m11, int m21, int m02, int m12, int m22)
	   : data[0][0]{m00}, data[1][0]{m10}, data[2][0]{m20}, data[0][1]{m01}, data[1][1]{m11}, 
	     data[2][1]{m21}, data[0][2]{m02}, data[1][2]{m12}, data[2][2]{m22}
int Matrix3::get(int x, int y)
{
	if(0 > x || x > 2)
	{
		throw std::runtime_error{"Invalid x value"};
	}
	if(0 > y || y > 2)
	{
		throw std::runtime_error{"Invalid y value"};
	}
	return data[x][y];
}

Matrix3 Matrix3::operator+(Matrix3 rhs)
{
	
}
	
std::ostream& operator<<(std::ostream& out, Matrix3 m)
{
	out << m.m00 << " " << m.m10 << " " << m.m20 << "\n" << m.m01 << " " << m.m11 << " " << m.m21 << "\n" << m.m02 << " " << m.m12 << " " << m.m22 << "\n";
	return out;
}
std::istream& operator >>(std::istream& in, Matrix3 m)
{
	in >> m.m00 >> m.m10 >> m.m20 >> m.m01 >> m.m11 >> m.m21 >> m.m02 >> m.m12 >> m.m22;
	return in;
}
