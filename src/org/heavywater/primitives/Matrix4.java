/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package org.heavywater.primitives;

import org.heavywater.util.FNotation;

public class Matrix4 extends Geom {
	private double[][] m = { { 1, 0, 0, 0 }, { 0, 1, 0, 0 }, { 0, 0, 1, 0 },
			{ 0, 0, 0, 1 } };
	public Matrix4() {
	}

	public Matrix4(double[][] m2) {
		this.setArray(m2);
	}

	public Matrix4 setArray(double[][] m) {
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				this.m[i][j] = m[i][j];
		return this;
	}

	public double[][] array() {
		return m;
	}

	public void setElement(int i, int j, double x) {
		m[i][j] = x;
	}

	public double Element(int i, int j) {
		return m[i][j];
	}

	public Matrix4 equal(Matrix4 m2) {
		this.setArray(m2.array());
		return this;
	}

	public Matrix4 setAsIdentity() {
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				if (i == j)
					this.m[i][j] = 1;
				else
					this.m[i][j] = 0;
		return this;
	}

	public String notation() {
		return FNotation.generate(this);
	}

	public Matrix4 mult(double s) {
		Matrix4 m1 = new Matrix4();
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				m1.setElement(i, j, this.Element(i, j) * s);
		return m1;
	}

	public double[] mult(Quaternion v) {
		double[] v2 = v.array();
		double[] v1 = new double[4];
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				v1[i] += this.Element(i, j) * v2[j];
		return v1;
	}

	public Matrix4 mult(Matrix4 m2) {
		double[][] a2 = m2.array();
		double[][] r2 = new double[4][4];
		for (int i = 0; i < 4; ++i)
			for (int j = 0; j < 4; ++j)
				for (int k = 0; k < 4; ++k)
					r2[i][j] += this.Element(i, j) * a2[k][j];
		return new Matrix4(r2);
	}

}
