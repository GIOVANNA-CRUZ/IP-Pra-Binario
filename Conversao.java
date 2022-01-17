import java.util.Scanner;

public class Binario {

	public static void main(String[] args) {
		Binario app = new Binario();

		Scanner leitorTeclado = new Scanner(System.in);
		System.out.println("Insira o número do IP:");
		String IP = leitorTeclado.nextLine();
		leitorTeclado.close();
		app.transformarDecimalEmBinario(IP);

	}

	public void transformarDecimalEmBinario(String IP) {

		String numerosIP[] = IP.split("\\.");/* Criando um array como String para receber o número do IP inserido no Scanner*/

		int[] resultadoDivisao = new int[numerosIP.length];
		int[] restoDivisao;
		restoDivisao = new int[8];

		for (int i = 0; i < numerosIP.length; i++) {
			try {
				resultadoDivisao[i] = Integer.parseInt(numerosIP[i]); /*
															 * Transforma o array numeros(string) em um
															 * arrayinteiro(int) passando para o intArray
															 */

			} catch (Exception e) {
				System.out.println("Unable to parse string to int: " + e.getMessage());
			}

			/* Lógica para mudar de decimal para binário */
			/* Divide por 2, e se tiver resto, vai ser 1, se não tiver resto, é 0 */

			do {
 
				for (int x = restoDivisao.length - 1; x >= 0; x--) { /* Inverte o array */
					restoDivisao[x] = resultadoDivisao[i] % 2;
					resultadoDivisao[i] = resultadoDivisao[i] / 2;
				}
				for (int y = 0; y < restoDivisao.length; y++) {/* Imprime o array invertido */
					System.out.print(restoDivisao[y]);
				}
				

			}while (resultadoDivisao[i] > 2);
			
			if(i < numerosIP.length - 1) {
			
			  System.out.print('.');
			}
			

		
			

		}

	}
}
