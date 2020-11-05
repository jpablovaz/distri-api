package com.wopiro.distri.tasks.migration;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Dictionary {

	static public Map<String, List<String>> get() {
		Map<String, List<String>> dictionary = new LinkedHashMap<>();
		List<String> columns;
		String table;

		/////////////////////////////
		// BANCOS
		/////////////////////////////
		table = "bancos"; // Bank //
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("banco"); // name
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// CLASIFICACIONES
		/////////////////////////////
		table = "clasificaciones"; // Classification //
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("clasificacion"); // name
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// ZONAS
		/////////////////////////////
		table = "zonas"; // Zone //
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("zona"); // name
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// MARCAS
		/////////////////////////////
		table = "marcas"; // Brand //
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("marca"); // name
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// LISTA
		/////////////////////////////
		table = "lista"; // DefaultList
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("list"); // percent
		dictionary.put(table, columns);

		/////////////////////////////
		// PRODUCTOS
		/////////////////////////////
		table = "productos"; // Product
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("codigo"); // code
		columns.add("id_marca"); // brand
		columns.add("id_clasificacion"); // classification
		columns.add("descripcion"); // description
		columns.add("peso_pieza"); // unitWeight
		columns.add("costo"); // cost
		columns.add("lista_1"); // list1
		columns.add("lista_2"); // list2
		columns.add("lista_3"); // list3
		columns.add("lista_4"); // list4
		columns.add("lista_5"); // list5
		columns.add("lista_6"); // list6
		columns.add("lista_7"); // list7
		columns.add("lista_8"); // list8
		columns.add("oferta"); // sale
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// PROVEEDORES
		/////////////////////////////
		table = "proveedores"; // Provider
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("nombre"); // name
		columns.add("domicilio"); // address
		columns.add("cuit"); // cuit
		columns.add("telefono"); // phone
		columns.add("telefono1"); // phone1
		columns.add("email"); // email
		columns.add("plazo"); // term
		columns.add("facturacion"); // billing // Make a ENUMM CLASS
		columns.add("observaciones"); // observation
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// REPARTIDORES
		/////////////////////////////
		table = "repartidores"; // Driver
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("nombre"); // name
		columns.add("apellido"); // lastName
		columns.add("n_doc"); // docNumber
		columns.add("direccion"); // address
		columns.add("telefono"); // phone
		columns.add("telefono1"); // phone1
		columns.add("email"); // email
		columns.add("com_1"); // com1
		columns.add("com_2"); // com2
		columns.add("com_3"); // com3
		columns.add("com_4"); // com4
		columns.add("com_5"); // com5
		columns.add("com_6"); // com6
		columns.add("com_7"); // com7
		columns.add("com_8"); // com8
		columns.add("observaciones"); // observation
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// VENDEDORES
		/////////////////////////////
		table = "vendedores"; // Seller
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("nombre"); // name
		columns.add("apellido"); // lastName
		columns.add("n_doc"); // docNumber
		columns.add("direccion"); // address
		columns.add("telefono"); // phone
		columns.add("telefono1"); // phone1
		columns.add("email"); // email
		columns.add("com_1"); // com1
		columns.add("com_2"); // com2
		columns.add("com_3"); // com3
		columns.add("com_4"); // com4
		columns.add("com_5"); // com5
		columns.add("com_6"); // com6
		columns.add("com_7"); // com7
		columns.add("com_8"); // com8
		columns.add("observaciones"); // observation
		columns.add("alta"); // active
		dictionary.put(table, columns);

		/////////////////////////////
		// CLIENTES
		/////////////////////////////
		table = "clientes"; // Customer
		columns = new ArrayList<String>();
		columns.add("id"); // id
		columns.add("Apellido"); // lastName
		columns.add("Nombre"); // name
		columns.add("razon_social"); // businessName
		columns.add("n_doc"); // docNumber
		columns.add("cuit"); // cuit
		columns.add("domicilio"); // address
		columns.add("saldo_max"); // maximumAllowed
		columns.add("id_vendedor"); // seller
		columns.add("telefono"); // phone
		columns.add("telefono1"); // phone1
		columns.add("email"); // email
		columns.add("hora_visita"); // visitingHour
		columns.add("id_zona"); // zone
		columns.add("facturacion"); // Make a ENUMM CLASS
		columns.add("observaciones"); // observation
		columns.add("alta"); // active
		columns.add("lista"); // list
		
		dictionary.put(table, columns);

		/////////////////////////////
		// CLIENTES_DIAS
		/////////////////////////////
		table = "clientes_dias";
		columns = new ArrayList<String>();
		columns.add("id_cliente");
		columns.add("dia");
		dictionary.put(table, columns);

		/////////////////////////////
		// VENTAS
		/////////////////////////////
		table = "ventas";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_cliente");
		columns.add("id_vendedor");
		columns.add("id_repartidor");
		columns.add("id_usuario");
		columns.add("com_repartidor");
		columns.add("com_vendedor");
		columns.add("fecha_hora");
		columns.add("alta");
		columns.add("tipo");
		columns.add("lista");
		dictionary.put(table, columns);

		/////////////////////////////
		// VENTA_CDO
		/////////////////////////////
		table = "venta_cdo";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_venta");
		columns.add("alta");
		dictionary.put(table, columns);

		/////////////////////////////
		// NOTA_CREDITO
		/////////////////////////////
		table = "nota_credito";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_cliente");
		columns.add("id_vendedor");
		columns.add("id_repartidor");
		columns.add("id_usuario");
		columns.add("com_repartidor");
		columns.add("com_vendedor");
		columns.add("fecha_hora");
		columns.add("alta");
		columns.add("tipo");
		columns.add("lista");
		dictionary.put(table, columns);

		/////////////////////////////
		// NOTA_DEBITO
		/////////////////////////////
		table = "nota_debito";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_cliente");
		columns.add("id_vendedor");
		columns.add("id_repartidor");
		columns.add("id_usuario");
		columns.add("com_repartidor");
		columns.add("com_vendedor");
		columns.add("fecha_hora");
		columns.add("alta");
		columns.add("tipo");
		columns.add("lista");
		dictionary.put(table, columns);

		/////////////////////////////
		// RECIBOS
		/////////////////////////////
		table = "recibos";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_cliente");
		columns.add("fecha_hora");
		columns.add("alta");
		dictionary.put(table, columns);

		/////////////////////////////
		// DETALLES
		/////////////////////////////
		table = "detalles";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_producto");
		columns.add("peso");
		columns.add("cantidad");
		columns.add("precio");
		columns.add("costo");
		columns.add("alta");
		columns.add("id_venta");
		dictionary.put(table, columns);

		/////////////////////////////
		// CREDITO_DETALLES
		/////////////////////////////
		table = "credito_detalles";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_producto");
		columns.add("peso");
		columns.add("cantidad");
		columns.add("precio");
		columns.add("costo");
		columns.add("alta");
		columns.add("id_venta");
		dictionary.put(table, columns);

		/////////////////////////////
		// DEBITO_DETALLES
		///////////////////////////
		table = "debito_detalles";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_producto");
		columns.add("peso");
		columns.add("cantidad");
		columns.add("precio");
		columns.add("costo");
		columns.add("alta");
		columns.add("id_venta");
		dictionary.put(table, columns);

		/////////////////////////////
		// DET_RECIBOS = PAYMENT
		/////////////////////////////
		table = "det_recibos";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_recibo");
		columns.add("id_forma");
		columns.add("alta");
		dictionary.put(table, columns);

		/////////////////////////////
		// MODO_EFECTIVO
		/////////////////////////////
		table = "modo_efectivo";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_det_rec");
		columns.add("monto");
		columns.add("alta");
		dictionary.put(table, columns);

		/////////////////////////////
		// MODO_CHEQUE
		/////////////////////////////
		table = "modo_cheque";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_det_rec");
		columns.add("numero");
		columns.add("id_banco");
		columns.add("apellido");
		columns.add("nombre");
		columns.add("vencimiento");
		columns.add("monto");
		columns.add("alta");
		dictionary.put(table, columns);

		/////////////////////////////
		// MODO_OTROS
		/////////////////////////////
		table = "modo_otros";
		columns = new ArrayList<String>();
		columns.add("id");
		columns.add("id_det_rec");
		columns.add("forma");
		columns.add("observaciones");
		columns.add("monto");
		columns.add("alta");
		dictionary.put(table, columns);

		return dictionary;
	}

}
