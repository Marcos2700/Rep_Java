
import java.util.Scanner;

public class Compras {
//atributos
  //generar pedido
  private String[] proveedor = new String[10];
  private String[] producto = new String[10];
  private int[] cantPed = new int[10];              //cantidad de productos en pedido
  private double[] precioAcord = new double[10];    //precio acordado para pedido
  private int[] diaPed = new int[10];               //dia en que se hizo el pedido
  private String[] statusPed = new String[10];      //estatus del pedido
  //crear producto
  private int[] codigoProd = new int[10];          //codigo de un producto por crear
  private String[] nombreProd = new String[10];    //nombre del producto
  private double[] precio = new double[10];        //precio del producto
  private int[] codProve = new int[10];            //codigo del proveedor que ofrece el producto
  private double[] costProve = new double[10];     //costo del producto de acuerdo al proveedor
  //crear proveedor
  private int[] codigoProv = new int[10];          //codigo del proveedor
  private String[] nombreProv = new String[10];    //nombre del proveedor
  private String[] tipo = new String[10];          //tipo de proveedor
    
  //metodos
  public void GenerarPed(String prov, String prod, int cant, double precio, int dia, String status, int c){
	  proveedor[c] = prov;
	  producto[c] = prod;
	  cantPed[c] = cant;
	  precioAcord[c] = precio;
	  diaPed[c] = dia;
	  statusPed[c] = status;
  }
  public void ActualizarPrecios(int cod, double prec){
	  for(int i=0;i<10;i++) {
		  if(codigoProd[i] == cod) {
			  precio[i] = prec;
		  }
	  }
  }
  
  public void CrearProd(int cod, String nombre, double prec, int codProv, double costProv, int c){
	  codigoProd[c] = cod;
	  nombreProd[c] = nombre;
	  precio[c] = prec;
	  codProve[c] = codProv;
	  costProve[c] = costProv;
  }
  
  public void CrearProv(int cod, String nombre, String tip, int c){
	  codigoProv[c] = cod;
	  nombreProv[c] = nombre;
	  tipo[c] = tip;
  }
  
  public void RecibirPed(){}
  
  public String Dia(int dia) {
	  String day = null;
	  switch(dia) {
	  case 1:
		  day = "lunes";
		  break;
	  case 2:
		  day = "marte" ;
		  break;
	  case 3:
		  day = "miercoles";
		  break;
	  case 4:
		  day =  "jueves";
		  break;
	  case 5:
		  day =  "viernes";
		  break;
	  case 6:
		  day = "sabado";
		  break;
	  case 7:
		  day = "domingo";
		  break;
	  }
	  return day;
  }
  public void CambiarEstatus(int n, String newStatus) {
	 statusPed[n-1] = newStatus; 
  }
  
  public static void main(String[] args){
    int opc=0, cant, dia, cod, codProv, contPed=0, contProd=0, contProv=0;
    String prov, prod, status, nombre, tipo, diaf;
    double precio, costProv;

    Scanner sc = new Scanner(System.in);
    Compras compras = new Compras();
    
    System.out.println("-------------Suministros de Utiles XYZ-------------");
    
 		while(opc!=14){
    	System.out.println("*****MENU*****\n1. Generar pedido al proveedor\n2. Actualizar ofertas\n3. Crear producto\n4. Crear proveedor");
    	System.out.println("5. Recibir pedidos\n 6. Listado de proveedores\n 7. Listasdo de productos por proveedor\n8. Listado de proveedores segun tipo");
    	System.out.println("9. Listado de productos y costos\n10. Listado de productos nuevos.\n11. Listado de pedidos pendientes");
    	System.out.println("12. Listado de pedidos despachados en la semana\n13. Cambiar estatus de algun pedido\n14. Salir");
    	opc = sc.nextInt();
    	switch(opc) {
    	case 1:
    		System.out.println("\nGenerar pedido");
    		System.out.println("Ingrese el nombre del proveedor");
    		prov = sc.next();
    		System.out.println("Ingrese el nombre del producto");
    		prod = sc.next();
    		System.out.println("Ingrese la cantidad de productos");
    		cant = sc.nextInt();
    		System.out.println("Ingrese el precio del producto");
    		precio = sc.nextDouble();
    		System.out.println("Ingrese un numero correspondiente al dia (lunes = 1)");
    		dia = sc.nextInt();
    		System.out.println("Ingrese el estatus del pedido (activo, cancelado, recibido)");
    		status = sc.next();
    		compras.GenerarPed(prov, prod, cant, precio, dia, status, contPed);
    		contPed++;
    		break;
    	case 2:
    		System.out.println("\nActualizar precio de producto");
    		System.out.println("Ingrese el codigo del producto al que desea cambiar el precio");
    		int codPrec = sc.nextInt();
    		System.out.println("Ingrese el nuevo precio del producto");
    		double newPrec = sc.nextDouble();
    		compras.ActualizarPrecios(codPrec, newPrec);
    		break;
    	case 3:
    		System.out.println("\nCrear producto");
    		System.out.println("\nIngrese el codigo del producto");
    		cod = sc.nextInt();
    		System.out.println("\nIngrese el nombre del producto");
    		nombre = sc.next();
    		System.out.println("\nIngrese el precio del producto");
    		precio = sc.nextDouble();
    		System.out.println("\nIngrese el codigo del proveedor");
    		codProv = sc.nextInt();
    		System.out.println("\nIngrese el costo que el preveedor le da al producto");
    		costProv = sc.nextDouble();
    		compras.CrearProd(cod, nombre, precio, codProv, costProv, contProd);
    		contProd++;
    		break;
    	case 4:
    		System.out.println("\nCrear proveedor");
    		System.out.println("Ingrese el codigo del proveedor");
    		cod = sc.nextInt();
    		System.out.println("Ingrese el nombre del proveedor");
    		nombre = sc.next();
    		System.out.println("Ingrese el tipo de proveedor (local o extranjero)");
    		tipo = sc.next();
    		compras.CrearProv(cod, nombre, tipo, contProv);
    		contProv++;
    		break;
    	case 5:
    		System.out.println("\nRecibir los pedidos");
    		for(int c=0;c<10;c++) {
          if(compras.proveedor[c] != null){
            System.out.println("\nPedido #"+(c+1));
            System.out.println("Proveedor: "+compras.proveedor[c]+"\nProducto: "+compras.producto[c]);
            diaf = compras.Dia(compras.diaPed[c]);
            compras.statusPed[c] = "recibido";
            double monto = compras.cantPed[c] * compras.precioAcord[c];
            System.out.println("Dia: "+diaf+"\nMonto total: $"+monto+"\nEstatus: "+compras.statusPed[c]);
          }
    		}
    		break;
    	case 6:
          System.out.println("\nListado de proveedores");
    		for(int d=0;d<10;d++) {
    			if(compras.proveedor[d] != null) {
    				System.out.println("\nProveedor #"+(d+1)+"\nNombre: "+compras.nombreProv[d]);
    				System.out.println("Codigo: "+compras.codigoProv[d]+"\nTipo: "+compras.tipo[d]);
    			}
    		}
    		break;
    	case 7:
          System.out.println("\nListado de productos por proveedor");
    		for(int e=0;e<10;e++) {
    			if(compras.nombreProv[e] != null) {
    				System.out.println("Proveedor: "+compras.nombreProv[e]);
    				System.out.println("Productos:");
    				for(int f=0;f<10;f++) {
		    			if(compras.codigoProv[e] == compras.codProve[e]) {
		    				System.out.println(compras.nombreProd);
		    			}
    				}
    			}
    		}
    		break;
    	case 8:
          System.out.println("\nListado de proveedores segun tipo de proveedor");
    		System.out.println("Proveedores locales:");
    		for(int g=0;g<10;g++) {
    			if(compras.tipo[g].equals("local")) {
    				System.out.println(compras.nombreProv[g]);
    			}
    		}
    		System.out.println("Proveedores extranjeros");
    		for(int h=0;h<10;h++) {
    			if(compras.tipo[h].equals("extranjero")) {
    				System.out.println(compras.nombreProv[h]);
    			}
    		}
    		break;
    	case 9:
          System.out.println("\nListado de productos y sus costos");
    		for(int i=0;i<10;i++) {
    			if(compras.nombreProd[i] != null) {
    				System.out.println("Producto #"+(i+1)+"\nNombre: "+compras.nombreProd[i]+"\nPrecio: "+compras.precio[i]);
    			}
    		}
    		break;
    	case 10:
          System.out.println("\nListado de productos nuevos");
    		for(int j=9;j>0;j--) {
    			if(compras.nombreProd[j] != null) {
    				System.out.println("Producto #"+(j+1)+"\nNombre: "+compras.nombreProd[j]+"\nPrecio: "+compras.precio[j]);
    				System.out.println("Codigo: "+compras.codigoProd[j]);
    			}
    		}
    		break;
    	case 11:
          System.out.println("\nListado de pedidos pendientes");
    		for(int k=0; k<10; k++) {
    			if(compras.statusPed[k].equals("activo")) {
	    			System.out.println("Proveedor: "+compras.proveedor[k]+"\nProducto: "+compras.producto[k]);
	    			diaf = compras.Dia(compras.diaPed[k]);
	    			double monto = compras.cantPed[k] * compras.precioAcord[k];
	    			System.out.println("Dia: "+diaf+"\nMonto total: $"+monto+"\nEstatus: "+compras.statusPed[k]);
    			}
    		}
    		break;
    	case 12:
          System.out.println("\nLista de pedidos despachados en la semana");
    		for(int l=0;l<10;l++) {
    			if(compras.statusPed[l].equals("recibido")) {
    				System.out.println("Proveedor: "+compras.proveedor[l]+"\nProducto: "+compras.producto[l]);
	    			diaf = compras.Dia(compras.diaPed[l]);
	    			double monto = compras.cantPed[l] * compras.precioAcord[l];
	    			System.out.println("Dia: "+diaf+"\nMonto total: $"+monto+"\nEstatus: "+compras.statusPed[l]);
    			}
    		}
    		break;
      case 13:
    		System.out.println("\nCambiar estatus de un pedido");
    		System.out.println("Ingrese el numero de pedido");
    		int nPed = sc.nextInt();
    		System.out.println("Ingrese el nuevo estatus (activo, cancelado, recibido)");
    		String newStatus = sc.next();
    		compras.CambiarEstatus(nPed, newStatus);
    		break;
    	default:
    		break;
    	}
    }
  }
}
