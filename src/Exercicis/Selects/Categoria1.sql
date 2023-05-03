-- 1. Volem obtenir els noms que s'utilitzen de primer nom per la gent que té més d'un nom

SELECT DISTINCT SUBSTR(nom, 1, (INSTR(nom, ' ') - 1)) AS primer_nom
	FROM persones
WHERE nom RLIKE ' '
ORDER BY primer_nom;


-- 2. Quants candidats titulars (‘T') i quants candidats suplents (‘S’) té cada candidatura?

SELECT  candidatura_id,
        SUM(IF(tipus = 'T', 1, 0)) AS titulars,
        SUM(IF(tipus = 'S', 1, 0)) AS suplents
    FROM candidats
GROUP BY candidatura_id;


-- 3. Quin és el  percentatge de participació, de vots blancs i de nuls, de les eleccions municipals?

SELECT CONCAT(ROUND((SUM(vots_emesos) / SUM(cens) * 100),2), ' %') AS participacio,
       CONCAT(ROUND((SUM(vots_blanc) / SUM(vots_emesos) * 100), 2), ' %') AS percentatge_vots_blancs,
       CONCAT(ROUND((SUM(vots_nuls) / SUM(vots_emesos) * 100),2), ' %') AS percentatge_vots_nuls
    FROM eleccions_municipis;


-- 4. Hi ha persones que tenen els dos cognoms iguals. Quins són els cognoms que tenen repetits la gent?

SELECT cog1 AS cognom_repetit
	FROM persones
WHERE cog1 = cog2
GROUP BY cog1
ORDER BY cognom_repetit;


-- 5. A la taula eleccions_municipis hem d'introduïr 86899 registres. Al ser una quantitat tant gran,
--    la importació triga molta estona. Volem saber el percentatge d'importació i la quantitat de registres
--    que portem, mentres s'està executant la importació.

SELECT 	ROUND(COUNT(*) / 86899 * 100, 2) AS '%',
		CONCAT(COUNT(*), '/ 86899') AS quantitat_registres
	FROM vots_candidatures_mun;


