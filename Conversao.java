import java.util.Scanner;

public class Binario {

	public static void main(String[] args) {
		Binario app = new Binario();

		Scanner lerIP = new Scanner(System.in);
		System.out.println("Insira o número do IP:");
		String IP = lerIP.nextLine();
		app.transformarDecimalEmBinario(IP);

	}

	public void transformarDecimalEmBinario(String IP) {

		String numeros[] = IP
				.split("\\.");/* Criando um array como String para receber o número do IP inserido no Scanner*/

		int[] intArray = new int[numeros.length];
		int[] b;
		b = new int[8];

		for (int i = 0; i < numeros.length; i++) {
			try {
				intArray[i] = Integer.parseInt(numeros[i]); /* Transforma o array numeros(string) em um arrayinteiro(int) passando para o intArray */
				
				
			} catch (Exception e) {
				System.out.println("Unable to parse string to int: " + e.getMessage());
			}

			/* Lógica para mudar de decimal para binário */
			/* Divide por 2, e se tiver resto, vai ser 1, se não tiver resto, é 0 */

			while (intArray[i] > 0 && intArray[i] <= 255) {

				for (int x = b.length - 1; x >= 1; x--) { /*Inverte o array*/
					b[x] = intArray[i] % 2;
					intArray[i] = intArray[i] / 2;
				}
				for (int y = 0; y < b.length; y++) {/*Imprime o array invertido*/
					System.out.print(b[y]);
				}

			}

			System.out.print('.');

		}

	}
}
