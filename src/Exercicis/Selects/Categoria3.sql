-- 1. Quin o quins són els municipis amb la candidatura municipal que té més vots?

SELECT m.municipi_id, m.nom
	FROM municipis m
    INNER JOIN vots_candidatures_mun v ON v.municipi_id = m.municipi_id
WHERE vots = (SELECT MAX(vots)
					FROM vots_candidatures_mun)
GROUP BY m.municipi_id;


-- 2.  Una select que mostri de la taula municipis si és un municipi o un districte
--     i en cas de ser un districte: quants districtes hi ha del municipi al qual pertany el districte;
--     i si és un municipi: quants municipis hi ha a la província on pertany el municipi.

SELECT 	IF(districte = 99, 'Municipi', 'Districte') AS 'Muncipi o districte',
		nom,
        IF(districte = 99, (SELECT COUNT(*)
								FROM municipis m1
							WHERE m1.provincia_id = m.provincia_id AND districte = 99),
						   (SELECT COUNT(*)
								FROM municipis m2
							WHERE m2.codi_ine = m.codi_ine AND districte != 99)) AS Quantitat
	FROM municipis m;


-- 3. Quin partit es el guanyador de les eleccions de 2016?

SELECT nom_curt, nom_llarg
    FROM candidatures
WHERE candidatura_id = (SELECT candidatura_id
                            FROM vots_candidatures_mun vcm
                            INNER JOIN eleccions e ON e.eleccio_id = vcm.eleccio_id
                        WHERE e.nom = "Eleccions 2016"
                        ORDER BY vots DESC
                        LIMIT 1);


-- 4. Quina es la candidatura amb el nom més llarg?

SELECT nom_llarg
    FROM candidatures
WHERE LENGTH(nom_llarg) = (SELECT MAX(LENGTH(nom_llarg))
                                FROM candidatures);


-- 5. Quina és la mitjana de vots per comunitat autònoma?

WITH vots_comunitat AS (SELECT SUM(vots_emesos) AS vots_comunitat
							FROM eleccions_municipis
							INNER JOIN municipis USING (municipi_id)
							INNER JOIN provincies USING (provincia_id)
							INNER JOIN comunitats_autonomes ca USING (comunitat_aut_id)
						GROUP BY ca.comunitat_aut_id)

SELECT ROUND(AVG(vots_comunitat)) AS mitjana_vots_per_comunitat
	FROM vots_comunitat;


-- 6. Quina és la provincia amb el major nombre de municipis?

SELECT nom
    FROM provincies
WHERE provincia_id = (SELECT provincia_id
                            FROM municipis
                        GROUP BY provincia_id
                        ORDER BY COUNT(provincia_id) DESC
                        LIMIT 1);


-- 7. Quin o quins són els partits (nom_llarg, nom_curt) que es presenten amb la llista
--    més llarga d'entre totes les candidatures? Ho volem ordenar per alfabéticament per les sigles del partit

SELECT nom_llarg, nom_curt
	FROM candidatures
    INNER JOIN candidats USING (candidatura_id)
WHERE num_ordre = (SELECT MAX(num_ordre)
					FROM candidats)
ORDER BY 2;