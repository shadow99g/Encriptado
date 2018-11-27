package encryptado;

/**
 *
 * @author jordy
 */
public class Vigenere {
    
    char[] mensaje;
	char[] clave;
	char[] resultado; //resultado cifrado
	char matriz[][];

	public Vigenere(String msg,String clave)
	{
		this.mensaje = msg.toCharArray();
		char[] claveTemp = clave.toCharArray();
		this.clave = new char[mensaje.length];
		int cont =0;
		for(int i=0;i<mensaje.length;i++)//For mete la clave multiples veces en 1 arreglo
		{
			this.clave[i]=claveTemp[cont];
			cont++;
			if(cont==claveTemp.length)
				cont=0;
		}
		//la clave ya se guardo en un arreglo de igual tamaño que del mensaje

		this.matriz = generarMatrizABC();//Generamos matriz del abecedarioç
		cifrar(); //ciframos el texto
	}

	public void cifrar() //Genera cifrado
	{
		char[] cifrado = new char[mensaje.length];
		int i;
		int j;
		for(int cont=0;cont<mensaje.length;cont++)
		{
			//Primero calculamos el indice de cada matriz "i" y "j"
			//el indice "i" correspondera al arreglo del mensaje
			//el indice "j" correspondera al arreglo de la clave 
			//luego ejecutaremos el calculo para cifrar utilizando "i" y "j" como cordenadas de la matriz
			i=(int)this.mensaje[cont]-97; //restamos 97 para pasar de codigo ascii a un numero entero
			j=(int)this.clave[cont]-97;
			cifrado[cont]=this.matriz[i][j];

		}

		this.resultado = cifrado;
		//for(int k = 0;k<26;k++)
		//	System.out.println(this.matriz[k]);

		System.out.println(this.mensaje);
		System.out.println(this.clave);
		System.out.println(cifrado);
	}

	public String getMensajeCifrado()
	{
		String result="";
		for(int i=0;i<resultado.length;++i)
			result=result+this.resultado[i];
		return result;
	}

	private char[][] generarMatrizABC()
	{
		int contador;
		char abcTemp[] = this.generarAbecedario();
		char abc[] = new char[abcTemp.length*2];
		for(int c=0;c<26;c++) {
			abc[c]=abcTemp[c];
			abc[c+26]=abcTemp[c];
		}
		char[][] matriz = new char[26][26];
		for(int i=0;i<26;i++)
		{
			contador=0;
			for(int j=0;j<26;j++)
			{
				matriz[i][j]=abc[contador+i];
				contador++;
			}
		}
		return matriz;
	}

	private char[] generarAbecedario()
	{
		char[] abc = new char[26];

		for(int i= 97; i<= 122;i++)
		{
			abc[i-97]=(char)i;

		}
		return abc;
	}
    
}
