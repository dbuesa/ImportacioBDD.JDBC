-- Volem saber la quantitat de candidats que hi ha per cada posició de llista del partit PACMA
-- Ho volem ordenar per posició de la llista.

WITH RECURSIVE count_candidats_llista(n_ordre)
AS (
	SELECT MIN(num_ordre)
		FROM candidats
		INNER JOIN candidatures c2 USING (candidatura_id)
	WHERE c2.nom_curt = 'PACMA'
    UNION ALL
    SELECT n_ordre + 1
		FROM count_candidats_llista
    WHERE n_ordre < (SELECT MAX(num_ordre)
						FROM candidats
                        INNER JOIN candidatures c1 USING (candidatura_id)
					WHERE c1.nom_curt = 'PACMA')
)
SELECT n.n_ordre AS posicio_llista, COUNT(c.candidat_id) AS quantitat_candidats
	FROM count_candidats_llista n
    INNER JOIN candidats c ON c.num_ordre = n.n_ordre
    INNER JOIN candidatures ca USING (candidatura_id)
WHERE ca.nom_curt = 'PACMA'
GROUP BY n.n_ordre
ORDER BY 1 DESC;