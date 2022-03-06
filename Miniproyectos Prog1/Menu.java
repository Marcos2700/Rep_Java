import java.util.Scanner;
public class Menu {
	private double popcChico=1.25;
	private double popcMediano=2.0;
	private double popcGrande=3.0;
	private double hotdog=2.5;
	private double refPeq=1.3;
	private double refMed=2.0;
	private double refGr=2.75;
	private double agua=1.5;
	private double chocol=1.75;
	private double combo1=4.5;
	private double combo2=5.0;
	private double combo3=6.8;
	private double[] total= new double[50];
	private int nPedido = 0
	private double[] registro= new double[1000];
	
	public void CalcularTotal(int a){
		try {
			switch(a) {
				case 1:
					total[nPedido] += popcChico;
					break;
				case 2:
					total[nPedido] += popcMediano;
					break;
				case 3:
					total[nPedido] += popcGrande;
					break;
				case 4:
					total[nPedido] += hotdog;
					break;
				case 5:
					total[nPedido] += refPeq;
					break;
				case 6:
					total[nPedido] += refMed;
					break;
				case 7:
					total[nPedido] += refGr;
					break;
				case 8: 
					total[nPedido] += agua;
					break;
				case 9:
					total[nPedido] += chocol;
					break;
				case 10:
					total[nPedido] += combo1;
					break;
				case 11: 
					total[nPedido] += combo2;
					break;
				case 12:
					total[nPedido] +=combo3;
					break;
				case 13:
					System.out.println("El total es de: "+total[nPedido]);
					nPedido += 1;
					break;
				default: 
					System.out.println("ERROR");
					break;
			}
		}
	}
	public static void main(String[] args) {
		int a;
		boolean salir=false;
		Scanner sc= new Scanner(System.in);
		Menu menu= new Menu();
		System.out.println("Bienvenido al cine universitario");
		
		while(!salir) {
			System.out.println("Menu de productos\n1.Popcorn chico\n2.Popcorn mediano\n3.Popcorn grande\n4.Hotdog");
			System.out.println("5.Refresco pequeño\n6.Refresco mediano\n7.Refresco grande\n8.Agua\n9.Chocolate");
			System.out.println("10.Combo 1 (Popcorn mediano y refresco grande)\n11.Combo 2 (Hotdog y refresco grande)\n12.Combo 3 (Popcorn grande y 2 refrescos medianos)\n13.Cerrar caja");
			System.out.println("Ingrese la opcion que corresponde al producto que se pide");
			a=sc.nextInt();
			menu.CalcularTotal(a);
			}
		}
	
	}
}
