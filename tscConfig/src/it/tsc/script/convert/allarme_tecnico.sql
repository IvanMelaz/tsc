CREATE TABLE IF NOT EXISTS ks_tsc.tb_allarme_tecnico(
	id_allarme varchar,
	ab_codi varchar,
	data_arrivo timestamp,
	giorno_intervento varchar,
	data_intervento timestamp,
	note varchar,
	anomalia_riscontrata varchar,
  	user varchar,
  	update_user varchar,
  	update_date timestamp
  	PRIMARY KEY (id_allarme)
);

--DROP TABLE IF EXISTS ks_tsc.allarme_tecnico;


