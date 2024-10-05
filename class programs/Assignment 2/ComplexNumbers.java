// Carlos Polanco
// This program uses a class to simulate complex numbers.
// The complex numbers class does addition, subtraction
// division and multiplication.

class Program2 {

    public static class ComplexNum {
    
        private double real;
        private double imaginary;
        	
        // default constructor
        public ComplexNum()
        {
        	real = 1;
        	imaginary = 1;
        }
        	
        // parameterized constructor
        public ComplexNum(double r, double i)
        {
            real = r;
            imaginary = i;
      	}
        	
        // mutators
        public void setReal (double n)
        {
            real = n;
        }
        public void setImaginary (double i)
        {
            imaginary = i;
        }

        // accessors
        public double getReal()
        {
            return real;
        }
        public double getImaginary()
        {
            return imaginary;
        }
        
        
        // method to add two complex numbers and return
        // the resulting complex number
        public ComplexNum add(ComplexNum c)
        {
            ComplexNum temp = new ComplexNum();
            temp.real = this.real + c.real;
            temp.imaginary = this.imaginary + c.imaginary;
            return temp;
        }
        
        // method to subtract two complex numbers and return
        // the resulting complex number
        public ComplexNum sub(ComplexNum c)
        {
            ComplexNum temp = new ComplexNum();
            temp.real = this.real - c.real;
            temp.imaginary = this.imaginary - c.imaginary;
            return temp;
        }
        
        // method to multiply two complex numbers and return
        // the resulting complex number
        public ComplexNum mult(ComplexNum c)
        {
            ComplexNum temp = new ComplexNum();
            temp.real = this.real * c.real - this.imaginary * c.imaginary;
            temp.imaginary = this.real * c.imaginary + this.imaginary * c.real; 
            return temp;
        }
        
        // method to multiply a complex number by a scalar
        // doesn't necessaril return anything, just updates
        // the complex number
        public void scalarMult(double s)
        {
            real = real* s;
            imaginary = imaginary * s; 
        }
        
      	// method to divide two complex numbers and return
        // the resulting complex number
        public ComplexNum divide(ComplexNum c)
        {
        	ComplexNum temp = new ComplexNum();
            
            temp.real = ((this.real*c.real)+(this.imaginary * c.imaginary))/
                        ((c.real*c.real) + (c.imaginary*c.imaginary));
           
            temp.imaginary = ((this.imaginary*c.real)+ (this.real*c.imaginary))/
                             (((c.real*c.real) + (c.imaginary*c.imaginary)));
            return temp;
        }
        
        // method that copies another complex number into 
        // the one that calls it. Pretty much a copy constructor
        public void copy(ComplexNum c)
        {
          real = c.real;
          imaginary = c.imaginary;
        }

        // Method that converts the complex number into a string
        // in order to print it to the screen.
        public String to_String()
        {
        	String s = real + " + " + imaginary + "i";
        	return s;
        }
        	
    }

	public static void main(String[] args)
	{
        // creating with default constructor
		ComplexNum f1 = new ComplexNum();

        // creating with parameterized constructor
		ComplexNum f2 = new ComplexNum(1, 2);

        ComplexNum f7 = new ComplexNum();
		ComplexNum f3, f4, f5, f6;
		String s1, s2, s3, s4, s5, s6, s7;

        // testing every method
		f1.setReal(5);
		f1.setImaginary(9);
		s1 = f1.to_String(); 
		System.out.println(s1); 
		s2 = f2.to_String();
		System.out.println(s2); 
		f3 = f1.mult(f2);
		s3 = f3.to_String();
		System.out.println(s1 + " * " + s2 + " = " + s3);
		f4 = f1.divide(f2);
		s4 = f4.to_String();
		System.out.println(s1 + " / " + s2 + " = " + s4);
		f5 = f1.add(f2);
		s5 = f5.to_String();
		System.out.println(s1 + " + " + s2 + " = " + s5);
		f6 = f1.sub(f2);
		s6 = f6.to_String();
		System.out.println(s1 + " - " + s2 + " = " + s6);
        f7.copy(f2);
        f7.scalarMult(4);
        s7 = f7.to_String();
        System.out.println(s2 + " * scalar = " + s7);
	}
}