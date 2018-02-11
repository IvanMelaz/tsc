CREATE KEYSPACE IF NOT EXISTS ks_tsc
  WITH REPLICATION = 
  	{ 'class' : 'SimpleStrategy', 
  	'replication_factor' : 2 }
  AND DURABLE_WRITES = true;