package francescoribatti.esameengim.model.repository;

import francescoribatti.esameengim.model.Ordine;
import francescoribatti.esameengim.model.TariffaCorriere;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import static francescoribatti.esameengim.credenzialiDB.DBConfig.*;

/**
 * Classe che gestisce Le Tariffe dei Corrieri
 * @author Francesco Ribatti
 */
public class TariffaCorriereRepository {
    /**
     * Recupera dal DB tutte le Tariffe dei Corrieri nella Tabella "tariffa_coriere"
     * @return Lista di tutte le Tariffe dei Corrieri
     */
    public static List<TariffaCorriere> getTariffe(){
        List<TariffaCorriere> tariffe = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, nome_corriere, nome_tariffa, peso_massimo, costo FROM tariffa_coriere");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TariffaCorriere tariffa = new TariffaCorriere(
                        rs.getInt("id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tariffa"),
                        rs.getDouble("peso_massimo"),
                        rs.getDouble("costo")
                );
                tariffe.add(tariffa);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        //restituisco l'elenco delle tariffe
        return tariffe;
    }

    /**
     * Recupera dal DB le Tariffe dei Corrieri con condizione di peso Massimo
     * nella Tabella "tariffa_coriere"
     * @return Lista delle Tariffe dei Corrieri con peso amissibile
     */
    public static List<TariffaCorriere> getTariffePerPeso(double peso){
        List<TariffaCorriere> tariffe = new ArrayList<>();

        try {
            Connection conn = DriverManager.getConnection(URL, USER, PW);
            PreparedStatement stmt = conn.prepareStatement("select id, nome_corriere, nome_tariffa, peso_massimo, costo " +
                    "FROM tariffa_coriere WHERE peso_massimo > ?");
            stmt.setDouble(1, peso);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                TariffaCorriere tariffa = new TariffaCorriere(
                        rs.getInt("id"),
                        rs.getString("nome_corriere"),
                        rs.getString("nome_tariffa"),
                        rs.getDouble("peso_massimo"),
                        rs.getDouble("costo")
                );
                tariffe.add(tariffa);
            }
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return tariffe;
    }
}
