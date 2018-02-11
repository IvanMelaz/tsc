CREATE TABLE IF NOT EXISTS ks_tsc.allarme_tecnico(
	id_allarme text,
	ab_codi text,
	data_arrivo timestamp,
	giorno_intervento text,
	data_intervento timestamp,
	note text,
	anomalia_riscontrata text,
  	user text,
  	update_user text,
  	update_date timestamp
  	PRIMARY KEY (id_allarme)
);

--DROP TABLE IF EXISTS ks_tsc.allarme_tecnico;


