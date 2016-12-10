package View;

import java.util.List;

public interface ICartographyManager {
	
	/**
	 * Charger les balises
	 * @return liste des balises publiées, avec les coordonnées au format cautra
	 */
	public List<IBeacon> loadBeacons();
	
	/**
	 * Charger les secteurs
	 * @return liste des secteurs au format xanthane, filtrée pour le bon FL, avec les coordonnées au format Cautra
	 */
	public List<ISector> loadSectors();
	
	/**
	 * Charger le fond de carte
	 * @return Une instance d'un objet implémentant IBaseMap, décrivant le fond de carte au format cautra
	 */
	public IBaseMap loadBaseMap();

}