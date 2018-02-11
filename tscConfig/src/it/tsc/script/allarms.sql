CREATE TABLE ks_tsc.tb_allarms(
  data_arrivo timestamp,
  id_allarme text,
  evento text,
  ab_codi text,
  matricola text,
  tel text,
  user text,
  PRIMARY KEY (id_allarme)
);

DROP TABLE IF EXISTS ks_tsc.tb_allarms;

SELECT * FROM ks_tsc.tb_allarms;

TRUNCATE TABLE ks_tsc.tb_allarms;

CREATE MATERIALIZED VIEW ks_tsc.vw_allarms AS
       SELECT data_arrivo,id_allarme,evento,ab_codi,matricola,tel,user FROM ks_tsc.tb_allarms
       WHERE data_arrivo IS NOT NULL AND id_allarme IS NOT NULL
       PRIMARY KEY (id_allarme,data_arrivo)
       WITH CLUSTERING ORDER BY (data_arrivo DESC);
       
DROP MATERIALIZED VIEW IF EXISTS ks_tsc.vw_allarms; 

SELECT * FROM ks_tsc.vw_allarms;
       
       
       