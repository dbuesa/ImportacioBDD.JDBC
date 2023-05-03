-- 1. Quin o quins són els municipis amb el major número de votants?

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
								FROM municipis WHERE m1.provincia_id = m.provincia_id AND districte = 99),
						   (SELECT COUNT(*)
								FROM municipis m2
							WHERE m2.codi_ine = m.codi_ine AND districte != 99)) AS Quantitat
	FROM municipis m;


-- 3. Quin partit es el guanyador de les eleccions de 2016?

SELECT nom_curt
    FROM candidatures
WHERE candidatura_id = (SELECT candidatura_id
                            FROM vots_candidatures_mun vcm
                            INNER JOIN eleccions e ON e.eleccio_id = vcm.eleccio_id
                        WHERE e.nom = "Eleccions 2016"
                        ORDER BY vots DESC
                        LIMIT 1);

-- 4. Diguem en quina comunitat autònoma te més vots el partit de 'VOX'

SELECT ca.nom
    FROM comunitats_autonomes ca
WHERE ca.comunitat_autonoma_id = (SELECT m.comunitat_autonoma_id
                                        FROM municipis m
                                        INNER JOIN vots_candidatures_mun vcm ON vcm.municipi_id = m.municipi_id
                                        INNER JOIN candidatures c ON c.candidatura_id = vcm.candidatura_id
                                  WHERE c.nom_curt = "VOX"
                                  GROUP BY m.comunitat_autonoma_id
                                  ORDER BY SUM(vcm.vots) DESC
                                  LIMIT 1);


-- 5. Quina es la candidatura amb el nom més llarg?

SELECT nom_llarg
    FROM candidatures
WHERE LENGTH(nom_llarg) = (SELECT MAX(LENGTH(nom_llarg))
                                FROM candidatures);

-- 6. Quin o quins són el nom més repetit entre totes les persones?

SELECT DISTINCT nom
	FROM persones
WHERE nom = (SELECT nom
				FROM persones
			 GROUP BY nom
			 ORDER BY COUNT(nom) DESC
			 LIMIT 1);

--TODO: triar com és
-- 7. Quina és la mitjana de vots per comunitat autònoma?
-- Si partim dels vots emesos:
WITH vots_comunitat AS (SELECT SUM(vots_emesos) AS vots_comunitat
							FROM eleccions_municipis
							INNER JOIN municipis USING (municipi_id)
							INNER JOIN provincies USING (provincia_id)
							INNER JOIN comunitats_autonomes ca USING (comunitat_aut_id)
						GROUP BY ca.comunitat_aut_id)

SELECT ROUND(AVG(vots_comunitat)) AS mitjana_vots_per_comunitat
	FROM vots_comunitat;

-- Si partim dels vots per candidatura:
WITH vots_comunitat AS (SELECT SUM(vots) AS vots_comunitat
							FROM vots_candidatures_ca
						GROUP BY comunitat_autonoma_id)

SELECT ROUND(AVG(vots_comunitat)) AS mitjana_vots_per_comunitat
	FROM vots_comunitat;

-- 7. Quina és la provincia amb el major nombre de municipis?

SELECT nom
FROM provincies
WHERE provincia_id = (SELECT provincia_id
                            FROM municipis
                        GROUP BY provincia_id
                        ORDER BY COUNT(provincia_id) DESC
                        LIMIT 1);


-- 8. Quin és el partit amb més candidats?

SELECT nom_curt
    FROM candidatures
WHERE candidatura_id = (SELECT candidatura_id
                            FROM candidats
                         GROUP BY candidatura_id
                         ORDER BY COUNT(candidatura_id) DESC
                         LIMIT 1);

-- 9. Quin o quins són els partits (nom_llarg, nom_curt) que es presenten amb la llista
--    més llarga d'entre totes les candidatures? Ho volem ordenar per alfabéticament per les sigles del partit

SELECT nom_llarg, nom_curt
	FROM candidatures
    INNER JOIN candidats USING (candidatura_id)
WHERE num_ordre = (SELECT MAX(num_ordre)
					FROM candidats)
ORDER BY 2;