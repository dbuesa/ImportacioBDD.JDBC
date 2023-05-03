-- 1.  Volem veure els municipis de Barcelona que tenen el mateix ratio de participació
--     que un altre municipi de Barcelona (municipi, ratio)

WITH participacio AS (SELECT m1.nom, e1.vots_emesos / e1.cens AS ratio
                        FROM eleccions_municipis e1
                        INNER JOIN municipis m1 USING (municipi_id)
                        INNER JOIN provincies prov USING (provincia_id)
                      WHERE districte = 99 AND prov.nom = 'Barcelona')
SELECT p.nom, p.ratio
	FROM participacio p
    LEFT JOIN participacio p1 USING (ratio)
WHERE p.nom != p1.nom
ORDER BY p.ratio;


--2. Quants candidats tenim a Catalunya?

SELECT COUNT(*) AS num_candidats
    FROM candidats c
    INNER JOIN provincies p ON c.provincia_id = p.provincia_id
    INNER JOIN comunitats_autonomes ca ON ca.comunitat_aut_id = p.comunitat_aut_id
WHERE ca.nom = 'Catalunya';


-- 3. Quantes meses té cada comunitat autònoma? Volem veure el resultat ordenat de CAs amb més
--    meses a CAs amb menys meses

SELECT ca.nom AS comunitat_autonoma, SUM(e.num_meses) AS quantitat_meses
	FROM eleccions_municipis e
	INNER JOIN municipis m USING (municipi_id)
    INNER JOIN provincies p USING (provincia_id)
    INNER JOIN comunitats_autonomes ca USING (comunitat_aut_id)
GROUP BY ca.nom
ORDER BY quantitat_meses DESC;


-- 4. Volem saber de les ciutats que tenen districtes, la quantitat de districtes que tenen.
--    Ho volem ordenar alfabéticament pel nom de la ciutat

SELECT p.nom AS ciutat, COUNT(m.districte) AS q_districtes
	FROM municipis m
    INNER JOIN provincies p USING (provincia_id)
WHERE districte != '99'
GROUP BY m.codi_ine, provincia_id
ORDER BY 1;


-- 5. Volem saber el total de vots de la candidatura de PODEMOS per la província de Madrid

SELECT vots, c.nom_llarg, c.nom_curt
	FROM vots_candidatures_prov
	INNER JOIN candidatures c USING (candidatura_id)
    INNER JOIN provincies p USING (provincia_id)
WHERE p.nom = 'Madrid' AND (c.nom_curt LIKE '%PODEMOS%' OR nom_llarg LIKE '%PODEMOS%');