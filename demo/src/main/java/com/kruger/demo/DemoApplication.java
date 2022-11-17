package com.kruger.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication  implements CommandLineRunner{

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("hola krugers start");
		
		//expresion Lambda and streams
		
		// ()  -> {..coding }  
		
		
		Sintaxis f = () ->{
			System.out.println("hola mundo funcion lambdas");
		};
		
		f.aceptar();
		
		
		//objeto tipo clase DemoApplication
		DemoApplication test =  new DemoApplication();
		test.metodo(f);
		
		
		//implementacion a traves de clases anonimas
			StringProcessor sPro = new StringProcessor() {
			@Override
			public String process(String x) {
				return x.toUpperCase();
			}
		};
		
		System.out.println("interface funcional" + sPro.process("hola") );
		
		
		//implementacion
		Operations op = (x,y) -> System.out.println(x*y);
		
	//	op.imprimeSuma(3, 4);
		
		DemoApplication obj =  new DemoApplication();
		obj.miMetodo((x,y)->{System.out.println(x/y);}, 40,5);
		
		
		//otra opcion
		
		multi((x,y) -> x +y);
		multi((x,y) -> x *y);
		multi((x,y) -> x /y);
		multi((x,y) -> x -y);
		
		
		} 
	
	public void metodo( Sintaxis parametro) {
		parametro.aceptar();
	}
		
	public void miMetodo(Operations op, int x, int y) {
		op.imprimeSuma(x, y);
	}
		
	
	public void multi(Calculadora c) {
		int x = 2, y =3;
		int resultado = c.calculo(x, y);
		System.out.println(resultado);
	}
	
	

}
