CREATE TABLE IF NOT EXISTS ks_tsc.tb_allarmi(
	id_allarme text,
	id_prova text,
	ab_codi text,
	evento text,
	data_arrivo timestamp,
	user text,
	esito text,
	data_esito timestamp,
	conclusioni text,
	data_chiuso timestamp,
  	update_user text,
  	update_date timestamp,
  	PRIMARY KEY (id_allarme)
);

--DROP TABLE IF EXISTS ks_tsc.allarmi;


