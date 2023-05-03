package Exercicis.Importacio;

import java.sql.SQLException;


public class Execute {
    public static void main(String[] args) {
        try {
            // 0. Inserim manualment el registre de la taula ELECCIONS
            InsertQuery.insertIntoEleccions();

            // 1. Inserim dades a la taula COMUNITATS
            Import.importarComunitatsAutonomes();

            // 2. Inserim dades a la taula PROVINCIES
            Import.importarProvincies();

            // 3. Inserim dades a la taula MUNICIPIS i ELECCIONS_MUNICIPIS
            Import.importarMunicipisAndEleccionsMunicipis();

            // 4. Inserim dades a la taula CANDIDATURES
            Import.importarCandidatures();

            // 5. Inserim dades a la taula PERSONES i CANDIDATS
            Import.importarPersonesAndCandidats();

            // 6. Inserim dades a la taula VOTS_CANDIDATURES_MUN
            Import.importVotsMunicipals();

            // 7. Inserim dades a la taula VOTS_CANDIDATURES_PROV
            Import.importVotsProvincials();

            // 8. Inserim dades a la taula VOTS_CANDIDATURES_CA
            Import.importVotsAutonomiques();

            // Tanquem connexió
            DBMySQLManager.closeConnection();

        } catch (SQLException e) {
            System.out.println(e);

        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
