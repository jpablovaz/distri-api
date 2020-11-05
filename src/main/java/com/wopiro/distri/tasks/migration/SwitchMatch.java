package com.wopiro.distri.tasks.migration;

import java.util.List;
import java.util.Map;

import com.wopiro.distri.tasks.migration.matcher.BankMatch;
import com.wopiro.distri.tasks.migration.matcher.BrandMatch;
import com.wopiro.distri.tasks.migration.matcher.ClassificationMatch;
import com.wopiro.distri.tasks.migration.matcher.CreditNoteMatch;
import com.wopiro.distri.tasks.migration.matcher.CustomerMatch;
import com.wopiro.distri.tasks.migration.matcher.DebitNoteMatch;
import com.wopiro.distri.tasks.migration.matcher.DetailsMatch;
import com.wopiro.distri.tasks.migration.matcher.DriverMatch;
import com.wopiro.distri.tasks.migration.matcher.ListMatch;
import com.wopiro.distri.tasks.migration.matcher.PaymentCashMatch;
import com.wopiro.distri.tasks.migration.matcher.PaymentChequeMatch;
import com.wopiro.distri.tasks.migration.matcher.PaymentMatch;
import com.wopiro.distri.tasks.migration.matcher.PaymentOtherMatch;
import com.wopiro.distri.tasks.migration.matcher.ProductMatch;
import com.wopiro.distri.tasks.migration.matcher.ReceiptMatch;
import com.wopiro.distri.tasks.migration.matcher.SalesMatch;
import com.wopiro.distri.tasks.migration.matcher.SellerMatch;
import com.wopiro.distri.tasks.migration.matcher.SupplierMatch;
import com.wopiro.distri.tasks.migration.matcher.ZoneMatch;

public class SwitchMatch {

	public static void match(String table, List<Map<String, Object>> rs) {

		switch (table) {
		case "bancos":
			BankMatch.persist(table, rs);
			break;
		case "marcas":
			BrandMatch.persist(table, rs);
			break;
		case "clasificaciones":
			ClassificationMatch.persist(table, rs);
			break;
		case "zonas":
			ZoneMatch.persist(table, rs);
			break;
		case "lista":
			ListMatch.persist(table, rs);
			break;
		case "productos":
			ProductMatch.persist(table, rs);
			break;
		case "proveedores":
			SupplierMatch.persist(table, rs);
			break;
		case "repartidores":
			DriverMatch.persist(table, rs);
			break;
		case "vendedores":
			SellerMatch.persist(table, rs);
			break;
		case "clientes":
			CustomerMatch.persist(table, rs);
			break;
		case "ventas":
			SalesMatch.persist(table, rs);
			break;
		case "nota_credito":
			CreditNoteMatch.persist(table, rs);
			break;
		case "nota_debito":
			DebitNoteMatch.persist(table, rs);
			break;
		case "recibos":
			ReceiptMatch.persist(table, rs);
			SaveDocuments.save();
			break;
		case "detalles":
		case "credito_detalles":
		case "debito_detalles":
			DetailsMatch.persist(table, rs);
			break;
		case "det_recibos":
			PaymentMatch.persist(table, rs);
			break;
		case "modo_efectivo":
			PaymentCashMatch.persist(table, rs);
			break;
		case "modo_cheque":
			PaymentChequeMatch.persist(table, rs);
			break;
		case "modo_otros":
			PaymentOtherMatch.persist(table, rs);
			break;
		default:
			break;
		}
	}

}
