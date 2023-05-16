# ImportacioBDD.JDBC
Pràctica de la UF6 de M03 (programació): introducció a la persistència en BD

Hem usat "Isard" per a poder treballar de manera conjunta. Per a poder executar el projecte hauràs d'anar al paquet "connexio" i dins de la classe DBMySQLManager hauràs de canviar la part de la ip, que veuràs que és anomenada en this.url (és tota la connexió).

Hem fet uns canvis a nivell de DDL perquè la base de dades no tingui nulls i es puguin fer totes les execucions CRUD sense problemes:
- Hem eliminat les columnes de data de naixement i sexe de la taula de persones.
- Hem modificat les foreign keys de les taules i els hem afegit on delete/*on update cascade/set null (depenent de la taula) perquè ens permeti eliminar-los o modificar-los.

Hem decidit treballar sobre 3 taules per a poder optimitzar el temps tan bé com sigui possible i fer que el projecte sigui el més òptim possible amb les mínimes fallades. (candidatures, personis, comunitats autonomes).

En la interficie DAODB hem implementat el CRUD amb la particularitat que en el "read" hem substituït com a paràmetre d'entrada l'objecte per un long, per a passar-li directament un ID.

El menú l'hem divideixo en dues classes, "vista.Vista" aquí estarà el menú visual al costat de les opcions que anomenaran les funcions de "opcionsMenu.OpcionsMenu". En aquesta última hem tractat les excepcions d'introducció de dades invàlides.



Ressenyes extres:
-En el paquet de "recursos" hem afegit l'usuari i contrasenya principal del Isard, amb el qual hem fet el treball conjunt.
-En "llibreries" t'hem adjuntat totes les librerias usades/necessitades per al projecte
-En el paquet de "importacio" estan les classes que usem en el projecte de base de dades per a poder fer totes les importacions correctament, les hem hagut de modificar per a adaptar-les a l'esquema proporcionat pel professor.
-A l'hora de fer dues o més execucions consecutives (com fer un UPDATE) ens trobavem amb l'inconvenient de que, al obrir-se i tancar-se la connexió desrprés no la podiem tornar a obrir. Per a solventar l'error hem decidit no tancar la connexió.
