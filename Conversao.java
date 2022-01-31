import java.util.Scanner;

public class Binario {

	public static void main(String[] args) {
		Binario app = new Binario();

		Scanner leitorTeclado = new Scanner(System.in);
		System.out.println("Insira o número do IP:");
		String ip = leitorTeclado.nextLine();
		System.out.println("Insira o número da subrede");
		String subrede = leitorTeclado.nextLine();
		leitorTeclado.close();

		// verificar se o IP pertence a subrede
		if (app.verificarIPnaSubrede(ip, subrede)) {
			System.out.println("Este IP pertence a esta subrede");
		} else {
			System.out.println("Este IP não pertence a esta subrede");
		}

	}

	private boolean verificarIPnaSubrede(String ip, String subrede) {

		// separar ip subrede do tamanho dela
		String[] estruturaSubrede = subrede.split("/");
		int tamanhoSubrede = Integer.parseInt(estruturaSubrede[1]);

		// tranformar ip decimal em ip binario
		String ipBinario = this.transformarIpDecimalEmBinario(ip);

		// transformar subrede decimal em binario
		String subredeBinario = this.transformarIpDecimalEmBinario(estruturaSubrede[0]);

		// comparar os n primeiros bits do ip com os n primeios bits da subrede
		String radicalIP = ipBinario.substring(0, tamanhoSubrede);
		String radicalSubRede = subredeBinario.substring(0, tamanhoSubrede);

		return radicalIP.equalsIgnoreCase(radicalSubRede);
	}

	private String transformarIpDecimalEmBinario(String ipDecimal) {

		String[] ip = ipDecimal.split("\\.");
		int[] restoDivisaoIP = new int[8];
		int divisor = 0;
		int contador = 0;
		String saida = "";

		for (int i = 0; i < 4; i++) {
			divisor = Integer.parseInt(ip[i]);
			restoDivisaoIP = new int[8];
			contador = 7;

			while (divisor >= 2) {
				restoDivisaoIP[contador] = divisor % 2;
				divisor = divisor / 2;
				contador--;
			}

			if (divisor == 1) {
				restoDivisaoIP[contador] = 1;
			}

			for (int k = 0; k < 7; k++) {
				saida += restoDivisaoIP[k];
			}
		}

		return saida;
	}

}
