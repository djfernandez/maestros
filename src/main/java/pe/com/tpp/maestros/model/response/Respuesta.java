package pe.com.tpp.maestros.model.response;

import java.util.ArrayList;
import java.util.HashMap;

public class Respuesta {

	private ArrayList<HashMap<String, String>> metadata = new ArrayList<>();

	public ArrayList<HashMap<String, String>> getMetadata() {
		return metadata;
	}

	public void setMetadata(String tipo, String codigo, String date) {
		HashMap<String, String> mapa = new HashMap<String, String>();

		mapa.put("tipo", tipo);
		mapa.put("codigo", codigo);
		mapa.put("date", date);

		metadata.add(mapa);
	}

}
