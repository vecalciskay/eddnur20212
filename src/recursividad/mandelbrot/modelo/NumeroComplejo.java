package recursividad.mandelbrot.modelo;

public class NumeroComplejo {

	private double pReal;
	private double pImg;

	public NumeroComplejo(double cx, double cy) {
		this.pReal = cx;
		this.pImg = cy;
	}
	
	public NumeroComplejo sumar(NumeroComplejo z) {
		return new NumeroComplejo(pReal + z.getpReal(), pImg + z.getpImg());
	}
	
	public NumeroComplejo multiplicar(NumeroComplejo z) {
		double rx = this.pReal*z.getpReal() - this.pImg * z.getpImg();
		double ry = this.pImg*z.getpReal() + this.pReal*z.getpImg();
		
		return new NumeroComplejo(rx, ry);
	}

	public double getpReal() {
		return pReal;
	}

	public void setpReal(double pReal) {
		this.pReal = pReal;
	}

	public double getpImg() {
		return pImg;
	}

	public void setpImg(double pImg) {
		this.pImg = pImg;
	}

	public double modulo() {
		return Math.sqrt(pReal*pReal + pImg*pImg);
	}

	
}
