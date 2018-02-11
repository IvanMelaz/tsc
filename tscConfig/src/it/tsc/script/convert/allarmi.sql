CREATE TABLE IF NOT EXISTS ks_tsc.tb_allarmi(
	id_allarme varchar,
	id_prova varchar,
	ab_codi varchar,
	evento varchar,
	data_arrivo timestamp,
	user varchar,
	esito varchar,
	data_esito timestamp,
	conclusioni varchar,
	data_chiuso timestamp,
  	update_user varchar,
  	update_date timestamp,
  	PRIMARY KEY (id_allarme)
);

--DROP TABLE IF EXISTS ks_tsc.allarmi;


